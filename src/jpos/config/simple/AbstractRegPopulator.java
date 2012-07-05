package jpos.config.simple;

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
import java.util.zip.*;
import java.net.URL;

import jpos.config.*;
import jpos.loader.JposServiceLoader;
import jpos.util.JposProperties;
import jpos.util.tracing.Tracer;
import jpos.util.tracing.TracerFactory;

/**
 * Common abstract superclass to help in the implementation of the 
 * JposRegPopulator
 * @see jpos.util.JposProperties#JPOS_REG_POPULATOR_CLASS_PROP_NAME
 * @since 1.2 (NY 2K 99 meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public abstract class AbstractRegPopulator extends Object 
											 implements JposRegPopulator 
{
    //-------------------------------------------------------------------------
    // Ctor(s)
    //

	/**
	 * Creates a AbstractRegPopulator and sets the uniqueId with the string 
	 * passed
	 * @param id the String ID
	 * @since 1.3 (Washington DC 20001)
	 */
	public AbstractRegPopulator( String id ) { setUniqueId( id ); }

    //-------------------------------------------------------------------------
    // Public abstract methods
    //

    /**
     * Tell the populator to save the current entries 
     * @param entries an enumeration of JposEntry objects
     * @since 1.2 (NY 2K meeting)
     * @throws java.lang.Exception if any error occurs while saving
     */
    public abstract void save( Enumeration entries ) throws Exception;

    /**
     * Tell the populator to save the current entries in the file specified 
     * @param entries an enumeration of JposEntry objects
     * @param fileName the file name to save entries
     * @since 1.3 (SF 2K meeting)
     * @throws java.lang.Exception if any error occurs while saving
     */
    public abstract void save( Enumeration entries, String fileName ) 
    				  throws Exception;

    /**
     * Tell the populator to load the entries 
     * @since 1.2 (NY 2K meeting)
     */
    public abstract void load();


    /**
     * Loads the entries specified in the fileName
     * @param fileName the entries file name
     * @since 1.3 (SF 2K meeting)
     */
    public abstract void load( String fileName );

    /**
     * @return the URL pointing to the entries file loaded or saved
     * @since 1.2 (NY 2K meeting)
     */
    public abstract URL getEntriesURL();

	/**
	 * @return the name of this populator.  This should be a short descriptive 
	 * name
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public abstract String getName();

    //-------------------------------------------------------------------------
    // Public methods
    //

	/**
	 * @return a unique String ID for this JposRegPopulator instance
	 * Can be implemented in terms of the getClassName() method
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public String getUniqueId() 
	{ return ( uniqueId.equals( "" ) ? getClassName() : uniqueId ); }

    /**
     * @return an Enumeration of JposEntry objects
     * @since 1.2 (NY 2K meeting)
     */
    public Enumeration getEntries() 
	{
		Vector vector = new Vector();
		Enumeration entries = jposEntries.elements(); 

		while( entries.hasMoreElements() )
			vector.addElement( entries.nextElement() );

		return vector.elements();
	}

	/**
	 * @retun true if this populator is a composite populator or false otherwise
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public boolean isComposite() { return false; }

	/**
	 * @return a String representation of this JposRegPopulator
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public String toString() { return getName(); }

	/**
	 * @return the last exception (if any) during the last load or null if no 
	 * exception occurred
	 * @since 2.0.0
	 */
	public Exception getLastLoadException() { return lastLoadException; }

    //--------------------------------------------------------------------------
    // Protected methods
    //

    /**
     * @return a URL pointing to the entries file
     * @param file the File that this URL will point to
     * @since 1.2 (NY 2K meeting)
     */
    protected URL createURLFromFile( File file )
    {
        URL url = null;

        try
        { url = new URL( "file", "", file.getAbsolutePath() ); }
        catch( Exception e ) 
        {
        	tracer.println( "Error creating URL: Exception.message=" +
        					e.getMessage() );        	
        }

        return url;
    }

    /**
     * @return a URL pointing to the entries file
     * @param zipFile the ZipFile that this URL will point to
     * @since 1.2 (NY 2K meeting)
     */
    protected URL createURLFromFile( ZipFile zipFile )
    {
        URL url = null;
        
        try
        { 
			url = new URL( "jar", "", ( new File( zipFile.getName() ) ).
        							  getAbsolutePath() ); 
        }
        catch( Exception e ) 
        {
        	tracer.println( "Error creating URL: Exception.message=" +
        					e.getMessage() ); 
        }

        return url;
    }

    /**
     * @return the jposEntries Hashtable to allow access to subclasses
     * @since 1.2 (NY 2K meeting)
     */
    protected Hashtable getJposEntries() { return jposEntries; }

    /**
     * @return true if a populator file (or URL) is defined
     * @since 1.2 (NY 2K meeting)
     */
    protected boolean isPopulatorFileDefined()
    {
        boolean defined = false;
        JposProperties jposProperties = 
        			   JposServiceLoader.getManager().getProperties();

        if( jposProperties.
        	isPropertyDefined( JposProperties.JPOS_POPULATOR_FILE_PROP_NAME ) )
            defined = true;
        else
        if( jposProperties.
        	isPropertyDefined( JposProperties.
        					   JPOS_POPULATOR_FILE_URL_PROP_NAME ) )
            defined = true;

        return defined;
    }

    /**
     * @return an InputStream object to the populator file
     * (multiple calls will return a new stream each time)
     * @since 1.2 (NY 2K meeting)
     * @throws java.lang.Exception if an error ocurs while getting the 
     * InputStream object
     */
    protected InputStream getPopulatorFileIS() throws Exception
    {
        JposProperties jposProperties = JposServiceLoader.
        								getManager().getProperties();

        if( jposProperties.isPropertyDefined( JposProperties.
        									  JPOS_POPULATOR_FILE_PROP_NAME ) )
        {
            populatorFileName = jposProperties.
            					getPropertyString( JposProperties.
            									   JPOS_POPULATOR_FILE_PROP_NAME );

			tracer.println( "getPopulatorFileIS(): populatorFileName=" + 
							populatorFileName );

            populatorIS = new FileInputStream( populatorFileName );
        }
        else
        if( jposProperties.
        	isPropertyDefined( JposProperties.
        					   JPOS_POPULATOR_FILE_URL_PROP_NAME ) )
        {
            populatorFileURL = jposProperties.
            				   getPropertyString( JposProperties.
            				   JPOS_POPULATOR_FILE_URL_PROP_NAME );

            URL url = new URL( populatorFileURL );

            populatorIS = url.openStream();
            
			tracer.println( "getPopulatorFileIS(): populatorFileURL=" + 
							populatorFileURL );            
        }
        else
        {
        	String msg = "jpos.config.populatorFile OR " +
        				 " jpos.config.populatorFileURL properties not defined";
			
			tracer.println( msg );        				 
        				 
            throw new Exception( msg );
        }

        return populatorIS;
    }

    /**
     * @return an OutputStream object to the populator file 
     * (multiple calls will return a new stream each time)
     * @since 1.2 (NY 2K meeting)
     * @throws java.lang.Exception if an error ocurs while getting the 
     * InputStream object
     */
    protected OutputStream getPopulatorFileOS() throws Exception
    {
        JposProperties jposProperties = JposServiceLoader.
        								getManager().getProperties();

        if( jposProperties.
        	isPropertyDefined( JposProperties.JPOS_POPULATOR_FILE_PROP_NAME ) )
        {
            populatorFileName = jposProperties.
            					getPropertyString( JposProperties.
            					JPOS_POPULATOR_FILE_PROP_NAME );
            
            populatorOS = new FileOutputStream( populatorFileName );
        }
        else
        if( jposProperties.
        	isPropertyDefined( JposProperties.
        					   JPOS_POPULATOR_FILE_URL_PROP_NAME ) )
        {
            populatorFileURL = jposProperties.
            				   getPropertyString( JposProperties.
            				   JPOS_POPULATOR_FILE_URL_PROP_NAME );

            URL url = new URL( populatorFileURL );

            populatorOS = url.openConnection().getOutputStream();
        }
        else
        {
        	String msg = "jpos.config.populatorFile OR " + 
        				 "jpos.config.populatorFileURL properties not defined";
        
        	tracer.println( msg );
        	
            throw new Exception( msg );
        }
        
        return populatorOS;
    }

    /**
     * @return the populatorFile names property value 
     * (returns "" if not defined)
     * @since 1.2 (NY 2K meeting)
     */
    protected String getPopulatorFileName() { return populatorFileName; }

    /**
     * @return the populatorURLFile names property value 
     * (returns "" if not defined)
     * @since 1.2 (NY 2K meeting)
     */
    protected String getPopulatorFileURL() { return populatorFileURL; }

	/**
	 * Sets the unique ID for this populator
	 * @param s the String object.  Needs to be unique
	 * @since 1.3 (Washington DC 2001)
	 */
	protected void setUniqueId( String s ) { uniqueId = s; }

    /**
     * Finds the first file matching the fileName in the CLASSPATH 
     * directory or each
	 * JAR or Zip file in the CLASSPATH
     * <b>NOTE:</b>Decorated the FileInputStream with a BufferedInputStream to
     * improve load time...
     * @param fileName the fileName to find
     * @since 2.0 (Long Beach 2001)
	 */
    protected InputStream findFileInClasspath( String fileName )
    {
        String classpath = System.getProperty( "java.class.path" );
        String pathSeparator = System.getProperty( "path.separator" );
        String fileSeparator = System.getProperty( "file.separator" );

        InputStream is = null;

		if( fileName.startsWith( "." ) || fileName.startsWith( fileSeparator ) )
		{
			try
			{ is = new BufferedInputStream( new FileInputStream( fileName ) ); }
			catch( IOException ioe ) 
			{ 
				is = null; 
				
				tracer.println( "findFileInClasspath: IOException.msg=" +
								ioe.getMessage() );
			}

			return is;
		}

        String path = "";

		Vector jarZipFilesVector = new Vector();

        for( StringTokenizer st = new StringTokenizer( classpath, 
        												pathSeparator, false ); 
             st.hasMoreTokens(); )
        {
            try 
            {
                path = st.nextToken().trim();
                if( path.equals("") ) continue;

                if( ( path.length() > 4 ) && 
                    ( path.endsWith( ".zip" ) || path.endsWith( ".jar" ) ) )
                    jarZipFilesVector.addElement( path );  
                else 
                {
					String absoluteFileName = path + 
					( ( fileName.startsWith( fileSeparator ) || 
					path.endsWith( fileSeparator ) )  ? "" : fileSeparator )  + 
					fileName;

                    is = new BufferedInputStream( new FileInputStream( 
                    							  absoluteFileName ) );
                    break;
                }
            }
            catch( Exception e ) { continue; }
        }

		if( is == null ) 
			return findFileInJarZipFiles( fileName, jarZipFilesVector );

        return is;
    }

    /**
     * Finds the occurrence of the fileName in the JAR or Zip files
	 * @param fileName the file to find
     * @param jarFilesVector a vector of JAR/Zip file names
     * @since 2.0 (Long Beach 2001)
     */
    protected InputStream findFileInJarZipFiles( String fileName, 
    											  Vector jarZipFilesVector )
    {
        InputStream is = null;

        for( int i = 0; i < jarZipFilesVector.size(); ++i )
        {
            String jarZipFileName = (String)jarZipFilesVector.elementAt( i );

            try
            {
                ZipFile zipFile = new ZipFile( jarZipFileName );
                Enumeration zipEntries = zipFile.entries();

                while( zipEntries.hasMoreElements() )
                {
                    ZipEntry zipEntry = (ZipEntry)zipEntries.nextElement();
                    String entryName = zipEntry.getName();
                    
					if( entryName.endsWith( fileName ) )
                    {
                        is = new BufferedInputStream( zipFile.
                        	 getInputStream( zipEntry ) );
                        break;
                    }
                }
            }
            catch( Exception e ) 
            {
            	tracer.println( "findInJarZipFiles: Exception.message=" +
            					e.getMessage() );
            }

            if( is != null ) break;
        }

        return is;
    }

    //--------------------------------------------------------------------------
    // Instance variables
    //

    private Hashtable jposEntries = new Hashtable();

    private InputStream populatorIS = null;
    private OutputStream populatorOS = null;

    private String populatorFileName = "";
    private String populatorFileURL = "";

	private String uniqueId = "";

	protected Exception lastLoadException = null;
	
	private Tracer tracer = TracerFactory.getInstance().
							 createTracer( "AbstractRegPopulator" );
}
