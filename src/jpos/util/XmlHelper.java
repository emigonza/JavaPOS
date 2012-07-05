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

import java.io.*;
import java.util.*;

import jpos.util.tracing.Tracer;
import jpos.util.tracing.TracerFactory;

/**
 * Simple helper class for XML related activities
 * @since 1.3 (SF 2K meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public class XmlHelper extends Object
{
    //-------------------------------------------------------------------------
    // Public methods
    //

	/** @return the current DTD file name */
	public String getDtdFileName() { return dtdFileName; }

	/** @return the current DTD file path */
	public String getDtdFilePath() { return dtdFilePath; }

	/**
	 * Sets the DTD file name that should be extracted by this helper
	 * @param fileName the XML file name
	 */
	public void setDtdFileName( String fileName ) { dtdFileName = fileName; }

	/**
	 * Sets the DTD file path that should be extracted by this helper
	 * @param filePath the XML file name
	 */
	public void setDtdFilePath( String filePath ) 
	{ 
		dtdFilePath = ( filePath.endsWith( File.separator ) ?
						filePath :
						filePath + File.separator ); 
	}

    /**
     * Checks if the dtdFile is available in the DTD path specified if not 
	 * then creates it extracting it from the JAR file
     */
    public void checkAndCreateTempDtd()
    {
        createdTempDTD = false;
        createdTempDir = false;
        InputStream is = null;

		dtdJarFullFileName = dtdFilePath + dtdFileName;

        try
        {
            File dtdPath = new File( dtdFilePath );
            File dtdFile = new File( dtdJarFullFileName );

            if( dtdFile.exists() )
				return;            
            
            if( !dtdPath.exists() )
            {
                dtdPath.mkdirs();

                createdTempDir = true;

				tracer.println( "DTD file PATH does not exist.  Created path " + 
								dtdFilePath );
            }
            
            is = ClassLoader.getSystemClassLoader().getResourceAsStream( dtdJarFullFileName );

			tracer.println( "Got DTD InputStream from current ClassLoader" );

            if( is != null )
				readAndCreateTempDtdFile( is );
        }
        catch( IOException ioe )
        { 
        	tracer.println( "Error creating DTD file: Exception.message = " + 
        	  			    ioe.getMessage() ); 
        }
        finally
        {
            try{ if( is != null ) is.close(); }
            catch( IOException ioe ) 
            {
	        	tracer.println( "Error while closing streams:" +
	        					" Exception.message = " + 
    	    	  			    ioe.getMessage() );             	
            }
        }
    }

    /** Removes the DTD path if it was created */
    public void removeTempDtd()
    {			
        try
        {
            if( createdTempDTD )
            {
                File dtdFile = new File( dtdJarFullFileName );
                dtdFile.delete();

				if( createdTempDir )
					removeDirs( dtdFilePath );
					
				tracer.println( "Removed temp directory with DTD OK" );
            }
        }
        catch( Exception e )
        { 
        	tracer.println( "Error removing temporary DTD file: " +
        	  				"Exception.msg = " + e.getMessage() ); 
       	}
    }

    //-------------------------------------------------------------------------
    // Private methods
    //

	/**
	 * Reads the DTD file from the InputStream provided and creates a temp
	 * @exception java.io.IOException if anything goes wrong
	 */
	private void readAndCreateTempDtdFile( InputStream is ) throws IOException
	{
		File dtdFile = new File( dtdJarFullFileName );
		
		FileOutputStream fos = new FileOutputStream( dtdFile );
		OutputStreamWriter osw = new OutputStreamWriter( fos );

		StringBuffer sb = new StringBuffer();

		while( is.available() > 0 )
		{
			byte[] buffer = new byte[ is.available() ];

			is.read( buffer );

			sb.append( new String( buffer ) );
		}

		osw.write( sb.toString().trim() );

		createdTempDTD = true;

		try
		{ 
			if( osw != null ) osw.close(); 
			if( fos != null ) fos.close(); 
		}
		catch( IOException ioe ) 
		{
			tracer.println( "Error while closing streams: IOExeption.msg=" +
							ioe.getMessage() );
		}

		tracer.println( "Read and created temp " + dtdFilePath + dtdFileName );
	}

	/**
	 * @return a Vector of the different directories from a directory string
	 * @param originalDirName the full directory name
	 */
	private Vector getSubdirNames( String originalDirName )
	{
		String dirName = originalDirName.
						 replace( "\\".charAt( 0 ), "/".charAt( 0 ) );

		if( !dirName.endsWith( "/" ) ) dirName = dirName + "/";

		Vector dirs = new Vector();
		String s = dirName;

		while( s.indexOf( "/" ) != -1 )
		{
			dirs.add( s.substring( 0, s.indexOf( "/" ) ) );
			s = s.substring( s.indexOf( "/" ) + 1 );
		}

		return dirs;
	}

    //-------------------------------------------------------------------------
    // Package methods
    //

	/**
	 * Removes the directory specified by this dirName (including any sub-dirs)
	 * @param dirName the directory name to remove
	 * @exception java.io.IOException if something goes wrong
	 */
	void removeDirs( String dirName ) throws IOException
	{
		Vector subdirNames = getSubdirNames( dirName );

		while( subdirNames.size() > 0 )
		{
			Vector v = (Vector)subdirNames.clone();

			String subdirName = "";
			for( int i = 0; i < subdirNames.size(); ++i )
				subdirName += (String)subdirNames.elementAt( i ) + 
							  File.separator;
		
			File subdirFile = new File( subdirName );
			
			if( subdirFile.list() != null &&
				subdirFile.list().length == 0 )
				subdirFile.delete();

			if( subdirNames.size() > 0 )
				subdirNames.removeElementAt( subdirNames.size() - 1 );
		}
	}

    //-------------------------------------------------------------------------
    // Private instance variables
    //

	private String dtdFileName = DEFAULT_DTD_FILE_NAME;
	private String dtdFilePath = DEFAULT_DTD_FILE_PATH;
	private String dtdJarFullFileName = dtdFilePath + File.separator + 
										 dtdFileName;
    
	private boolean createdTempDTD = false;
    private boolean createdTempDir = false;

	private Tracer tracer = TracerFactory.getInstance().
							 createTracer( "XmlHelper" );

	//-------------------------------------------------------------------------
	// Class constants
	//

	public static final String DEFAULT_DTD_FILE_NAME = "jcl.dtd";
    public static final String DEFAULT_DTD_FILE_PATH = "jpos" + 
    													 File.separator + 
    													 "res" + File.separator;
}