package jpos.util;

///////////////////////////////////////////////////////////////////////////////
//
// This software is provided "AS IS".  The JavaPOS working group (including
// each of the Corporate members, contributors and individuals)  MAKES NO
// REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE,
// EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED 
// WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
// NON-INFRINGEMENT. The JavaPOS working group shall not be liable for
// any damages suffered as a result of using, modifying or distributing this
// software or its derivatives. Permission to use, copy, modify, and distribute
// the software and its documentation for any purpose is hereby granted. 
//
// The JavaPOS Config/Loader (aka JCL) is now under the CPL license, which 
// is an OSS Apache-like license.  The complete license is located at:
//    http://oss.software.ibm.com/developerworks/opensource/license-cpl.html
//
///////////////////////////////////////////////////////////////////////////////

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.List;
import java.util.LinkedList;
import java.util.Enumeration;
import java.util.StringTokenizer;

import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import jpos.util.tracing.Tracer;
import jpos.util.tracing.TracerFactory;

/**
 * Utility class for various File related actions and methods
 * @author E. Michael Maximilien
 * @version 0.0.1
 * @since 2.1.0
 */
public class FileUtil extends Object
{	
    //-------------------------------------------------------------------------
    // Ctor(s)
    //
	
	/** Make ctor protected to avoid contruction but allows subclassing */
	protected FileUtil() {}

    //-------------------------------------------------------------------------
    // Private/protected static methods
    //

	protected synchronized static List getCpDirList()
	{
		String classpath = System.getProperty( "java.class.path" );								
		
		List cpDirList = new LinkedList();
		
		StringTokenizer st = new StringTokenizer( classpath, File.pathSeparator );
		while( st.hasMoreTokens() )
		{
			String cpEntry = st.nextToken();
			
			if( cpEntry.toLowerCase().endsWith( "jar" ) ||
			    cpEntry.toLowerCase().endsWith( "zip" ) )
			    cpDirList.add( cpEntry.
			    			   substring( 0, cpEntry.
			    			   				 lastIndexOf( File.separator ) ) );
			else
				cpDirList.add( cpEntry );
		}

		return cpDirList;
	}
	
	protected synchronized static List getJarList()
	{
		String classpath = System.getProperty( "java.class.path" );
								
		List cpJarFilesList = new LinkedList();
		
		StringTokenizer st = new StringTokenizer( classpath, File.pathSeparator );
		while( st.hasMoreTokens() )
		{
			String cpEntry = st.nextToken();
			
			if( cpEntry.toLowerCase().endsWith( "jar" ) ||
			    cpEntry.toLowerCase().endsWith( "zip" ) )
			    cpJarFilesList.add( cpEntry );
		}

		return cpJarFilesList;		
	}
	
	protected synchronized static JarEntry getJarEntry( JarFile jarFile, String fileName )
	{
		tracer.println( "<getJarEntry jarFile=" + jarFile + " fileName=" + 
						fileName + ">" );
		
		if( jarFile == null ) return null;
		
		Enumeration entries = jarFile.entries();
		while( entries.hasMoreElements() )
		{
			JarEntry jarEntry = (JarEntry)entries.nextElement();
									
			if( jarEntry.getName().equals( fileName ) ) 
			{
				tracer.println( "jarEntry.getName()=" + jarEntry.getName() );
				return jarEntry;
			}
		}

		tracer.println( "<message>Could not find JarEntry with fileName=" + 
						 fileName +"</message>" );		
		tracer.println( "</getJarEntry>" );
		
		return null;
	}
    	
    /** 
     * @return the File object if found otherwise returns null
	 * @param fileName the relative fileName to search for
	 * @param searchInClassPath if true the file will be searched in all 
	 * directories specified by CLASSPATH
     */
    protected synchronized static JarFile lookForFileInJars( String fileName )
	{
		try
		{
			tracer.println( "<lookForFileInJars fileName="+fileName +">" );
			
			String classpath = System.getProperty( "java.class.path" );

			tracer.println( "classpath="+classpath );
						
			List cpJarFilesList = getJarList();
			List cpDirList = getCpDirList();
						
			for( int i = 0; i < cpJarFilesList.size(); ++i )
			{
				String jarFileName = (String)cpJarFilesList.get( i );
				
				tracer.println( "jarFileName=" + jarFileName );
		
				JarFile jarFile = new JarFile( new File( jarFileName ) );

				JarEntry jarEntry = getJarEntry( jarFile, fileName );
				
				if( jarEntry != null ) return jarFile;
			}
						
			return null;
		}
		catch( Exception ioe ) { return null; }
		finally
		{
			tracer.println( "</lookForFileInJars>" );
		}
	}	
	
    //-------------------------------------------------------------------------
    // Public static methods
    //

	/**
	 * @return true if the File passed by name below could be located by
	 * searching the classpath and or JAR files in CLASSPATH
	 * @param fileName the relative fileName to search for
	 * @param searchInClassPath if true the file will be searched in all 
	 * directories specified by CLASSPATH
	 * @param searchInJarFile if true the file will be searched in all the JAR
	 * files that are located in CLASSPATH
	 */
	public synchronized static boolean 
	locateFile( String fileName, boolean searchInClassPath, 
	            boolean searchInJarFile )
	{
		File file = findFile( fileName, searchInClassPath );
		
		if( file != null ) return true;
		
		if( searchInJarFile )
		{
			JarFile jarFile = lookForFileInJars( fileName );
			
			if( jarFile != null ) return true;
		}
		
		return false;
	}

    /** 
     * @return the File object if found otherwise returns null
	 * @param fileName the relative fileName to search for
	 * @param searchInClassPath if true the file will be searched in all 
	 * directories specified by CLASSPATH
     */
    public synchronized static File findFile( String fileName, 
    											 boolean searchInClassPath )
	{
		try
		{
			File file = new File( fileName );
			if( file.exists() ) return file;
			
			List cpJarFilesList = getJarList();
			List cpDirList = getCpDirList();
						
			if( searchInClassPath )
				for( int i = 0; i < cpDirList.size(); ++i )
				{
					String path = (String)cpDirList.get( i );
					File file2 = new File( path + File.separator + fileName );
	
					if( file2.exists() ) return file2;
				}
						
			return null;
		}
		catch( Exception ioe ) { return null; }
	}	                                            

	/**
	 * @return a FileIOStream object for the file passed by name below could 
	 * be located by searching the classpath and or JAR files in CLASSPATH
	 * @param fileName the relative fileName to search for
	 * @param searchInClassPath if true the file will be searched in all 
	 * directories specified by CLASSPATH
	 * @param searchInJarFile if true the file will be searched in all the JAR
	 * files that are located in CLASSPATH
	 * @throws java.io.FileNotFoundException if the file could not be found
	 * @throws java.io.IOException if an error occurred while loading file
	 */
	public synchronized static InputStream 
	loadFile( String fileName, boolean searchInClassPath, 
	          boolean searchInJarFile ) 
	throws FileNotFoundException, IOException
	{	    
		tracer.println( "<loadFile fileName=" + fileName + " searchInClassPath=" + 
						searchInClassPath + " searchInJarFile=" + 
						searchInJarFile + ">" );
		
		File locatedFile = findFile( fileName, searchInClassPath );
		
		if( locatedFile != null ) return new FileInputStream( locatedFile );

		if( locatedFile == null && searchInJarFile == false ) 
			throw new FileNotFoundException( "Could not find file: " + fileName );
		
		JarFile locatedJarFile = lookForFileInJars( fileName );
		
		if( locatedJarFile == null ) 
			throw new FileNotFoundException( "Could not find file: " + fileName );
		
		JarEntry locatedJarEntry = getJarEntry( locatedJarFile, fileName );

		if( locatedJarEntry != null )
			return locatedJarFile.getInputStream( locatedJarEntry );
		
		throw new FileNotFoundException( "Could not find file: " + fileName );
	}
	
	//-------------------------------------------------------------------------
	// Class variables
	//
	
	private static Tracer tracer = TracerFactory.getInstance().
									 createTracer( "FileUtil" );
}