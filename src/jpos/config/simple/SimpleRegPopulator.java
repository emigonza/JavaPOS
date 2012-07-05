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

import jpos.util.tracing.Tracer;
import jpos.util.tracing.TracerFactory;
import jpos.config.*;
import jpos.config.simple.AbstractRegPopulator;

/**
 * Simple implementation of the JposRegPopulator loading and saving from a
 * serialized set of entries
 * <p>
 * <b>NOTE</b>: this class must define a public no-argument ctor so that it may be created 
 * via reflection when its defined in the jpos.properties as 
 * the jpos.config.regPopulatorClass
 * </p>
 * @see jpos.util.JposProperties#JPOS_REG_POPULATOR_CLASS_PROP_NAME
 * @since 1.2 (NY 2K 99 meeting)
 * @author E. Michael Maximilien  (maxim@us.ibm.com)
 */
public class SimpleRegPopulator extends AbstractRegPopulator
{
    //-------------------------------------------------------------------------
    // Ctor(s)
    //

    /**
     * Default ctor
     * @since 1.2 (NY 2K meeting)
     */
    public SimpleRegPopulator() 
    { super( SimpleRegPopulator.class.getName() ); }

    /**
     * 1-arg ctor that takes the unique ID string
	 * @param s the unique ID string
     * @since 1.3 (Washington DC 2001 meeting)
     */
    public SimpleRegPopulator( String s ) { super( s ); }

    //-------------------------------------------------------------------------
    // Public methods
    //

	/**
	 * @return the fully qualified class name implementing the 
	 * JposRegPopulator interface
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public String getClassName() 
	{ return SimpleRegPopulator.class.getName(); }

    /**
     * Tell the populator to save the current entries 
     * @param entries an enumeration of JposEntry objects
     * @since 1.2 (NY 2K meeting)
     * @throws java.lang.Exception if any error occurs while saving
     */
    public void save( Enumeration entries ) throws Exception
    {
        saveJposEntries( entries );
    }

    /**
     * Tell the populator to save the current entries in the file specified 
     * @param entries an enumeration of JposEntry objects
     * @param fileName the file name to save entries
     * @since 1.3 (SF 2K meeting)
     * @throws java.lang.Exception if any error occurs while saving
     */
    public void save( Enumeration entries, String fileName ) throws Exception
    {
		File file = new File( fileName );
		FileOutputStream fos = new FileOutputStream( file );

        saveJposEntries( entries, fos );

		fos.close();
    }

    /**
     * Tell the populator to load the entries 
     * @since 1.2 (NY 2K meeting)
     */
    public void load()
    {
        getJposEntries().clear();
        Enumeration entries = readJposEntries();
      
        while( entries.hasMoreElements() ) 
        {
            try
            {
                JposEntry entry = (JposEntry)entries.nextElement();
                String logicalName = logicalName = (String)entry.
                getPropertyValue( JposEntry.LOGICAL_NAME_PROP_NAME );

                if( logicalName != null )
                    getJposEntries().put( logicalName, entry );

				lastLoadException = null;
            }
            catch( Exception e ) 
            {
				lastLoadException = e;
				tracer.println( "Error loading serialized JposEntry file: " + 
				                "Exception.message= " + e.getMessage() ); 
			}
        }
    }

    /**
     * Loads the entries specified in the fileName
     * @param fileName the entries file name
     * @since 1.3 (SF 2K meeting)
     */
    public void load( String fileName )
    {
        try
        {
            getJposEntries().clear();
            Enumeration entries = readJposEntries( new FileInputStream( fileName ) );

            while( entries.hasMoreElements() ) 
            {
                JposEntry entry = (JposEntry)entries.nextElement();
                String logicalName = (String)entry.
                getPropertyValue( JposEntry.LOGICAL_NAME_PROP_NAME );

                if( logicalName != null )
                    getJposEntries().put( logicalName, entry );
            }

			lastLoadException = null;
        }
        catch( Exception e ) 
        {
			lastLoadException = e;
			tracer.println( "Error loading serialized JposEntry file: " + 
			                "Exception.message=" + e.getMessage() ); 
		}
    }

    /**
     * @return the URL pointing to the entries file loaded or saved
     * @since 1.2 (NY 2K meeting)
     */
    public URL getEntriesURL() 
    {
        URL url = null;

        if( serInZipFile )
            url = createURLFromFile( zipSerFile );
        else
            url = createURLFromFile( serFile );

        return url;
    }

	/**
	 * @return the name of this populator.  This should be a short descriptive name
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public String getName() { return SIMPLE_REG_POPULATOR_NAME_STRING; }

    //--------------------------------------------------------------------------
    // Protected methods
    //

    /**
     * Tries to save the entries as a ZipEntry in the ZipFile
     * @param entries an Enumeration of JposEntry objects
     * NOTE: if the the serialized entries is in a Sip/JAR file then if must be an
     * entry in the "root" of the Sip/JAR file...
     * Also when saving in a Zip/JAR file could get an error because the Zip/JAR file
     * is being used by a process in Win32 environment
     * @since 1.2 (NY 2K meeting)
     * @throws java.lang.Exception if any problems occurs while saving
     */
    protected void saveSerInZipFile( Enumeration entries ) throws Exception
    {
        ZipOutputStream zos = new ZipOutputStream( new 
        					  FileOutputStream( zipSerFile.getName() + ".temp.jar" ) );

        Enumeration zipEntries = zipSerFile.entries();

        while( zipEntries.hasMoreElements() )
        {
            ZipEntry zipEntry = (ZipEntry)zipEntries.nextElement();

            zos.putNextEntry( zipEntry );

            if( zipEntry.getName() != serFileName )
            {
                InputStream is = zipSerFile.getInputStream( zipEntry );

                while( is.available() > 0 )
                {
                    byte[] byteArray = new byte[ is.available() ];

                    is.read( byteArray );

                    zos.write( byteArray );
                }

                zos.closeEntry();
            }
            else
            {
                ObjectOutputStream oos = new ObjectOutputStream( new 
                						 FileOutputStream( TEMP_SER_FILE_NAME ) );

                while( entries.hasMoreElements() )
                {
                    JposEntry entry = (JposEntry)entries.nextElement();

                    oos.writeObject( entry );
                }

                oos.flush();
                oos.close();

                FileInputStream fis = new FileInputStream( TEMP_SER_FILE_NAME );

                while( fis.available() > 0 )
                {
                    byte[] byteArray = new byte[ fis.available() ];

                    fis.read( byteArray );

                    zos.write( byteArray );
                }

                zos.closeEntry();
            }
        }

        zos.flush();
        zos.close();
    }

    /**
     * Tries to save the entries in the file where they were loaded
     * @param entries an Enumeration of JposEntry objects
     * @since 1.2 (NY 2K meeting)
     * @throws java.lang.Exception if any problems occurs while saving
     */
    protected void saveSerFile( Enumeration entries ) throws Exception
    {
        saveJposEntries( entries, new FileOutputStream( serFileName ) );
    }

    /**
     * Save the JposEntry object to the OutputStream as serialized objects
     * @param entries an enumeration of JposEntry objects
     * @param os the OuputStream to save to
     * @since 1.2 (NY 2K meeting)
     * @throws java.lang.Exception if any error occurs while saving
     */
    protected void saveJposEntries( Enumeration entries, OutputStream os ) 
    throws Exception
    {
        ObjectOutputStream oos = new ObjectOutputStream( os );

        while( entries.hasMoreElements() )
        {
            JposEntry entry = (JposEntry)entries.nextElement();

            oos.writeObject( entry );
        }

        oos.close();
    }

    /**
     * @return an ObjectInputStream of the first serFileName found.  The algorithm is:
     * 1) Goes through the CLASSPATH and get the first serialized file name in the paths in order
     * 2) If no simple ser file is found then looks in the JAR files in order
     * @since 1.2 (NY 2K meeting)
     */
    protected ObjectInputStream findSerOIS()
    {       
        Vector classpathJarFiles = new Vector();

        //Try to find the serialized file in the directory of each path in CLASSPATH
        //As a side effect put each JAR/Zip file in the vector
        ObjectInputStream ois = findSerOISInClasspath( classpathJarFiles );

        //If no serialized file found in the directories of the path in the CLASSPATH then
        //try to open each JAR/Zip file and see if they contain a serialized file
        if( ois == null )
            ois = findSerOISInJar( classpathJarFiles );
        
        return ois;
    }

    /**
     * Finds the first serialized JposEntry file in directory of each classpath
     * <b>NOTE:</b>Decorated the FileInputStream with a BufferedInputStream to
     * improve load time...
     * @param jarZipFilesVector a vector of JAR/Zip file names
     * @since 1.2 (NY 2K meeting)
     */
    protected ObjectInputStream findSerOISInClasspath( Vector jarZipFilesVector )
    {
        ObjectInputStream ois = null;

        String classpath = System.getProperty( "java.class.path" );
        String pathSeparator = System.getProperty( "path.separator" );
        String fileSeparator = System.getProperty( "file.separator" );

        String path = "";

        //Searches for the serialized JposEntry file 
        for( StringTokenizer st = new StringTokenizer( classpath, pathSeparator, false ); 
             st.hasMoreTokens(); )
        {
            try 
            {
                path = st.nextToken().trim();
                if( path.equals("") ) continue;

                if( path.length() > 4 && ( path.endsWith( ".zip" ) || path.endsWith( ".jar" ) ) )
                    jarZipFilesVector.addElement( path );  
                else 
                {
                    absoluteFileName = path + fileSeparator + serFileName;

                    ois = new ObjectInputStream( new BufferedInputStream( new FileInputStream( absoluteFileName ) ) );

                    serFile = new File( absoluteFileName );
                    serInZipFile = false;
                    break;
                }
            }
            catch( Exception e ) { continue; }
        }

        return ois;
    }

    /**
     * Finds the first serialized JposEntry file in the JAR files
     * @param jarFilesVector a vector of JAR/Zip file names
     * @since 1.2 (NY 2K meeting)
     */
    protected ObjectInputStream findSerOISInJar( Vector jarFilesVector )
    {
        ObjectInputStream ois = null;

        for( int i = 0; i < jarFilesVector.size(); ++i )
        {
            String jarFileName = (String)jarFilesVector.elementAt( i );

            try
            {
                ZipFile zipFile = new ZipFile( jarFileName );
                Enumeration zipEntries = zipFile.entries();

                while( zipEntries.hasMoreElements() )
                {
                    ZipEntry zipEntry = (ZipEntry)zipEntries.nextElement();
                    String entryName = zipEntry.getName();
                    if( entryName.endsWith( serFileName ) )
                    {
                        ois = new ObjectInputStream( zipFile.getInputStream( zipEntry ) );
                        zipSerFile = zipFile;
                        serInZipFile = true;
                        break;
                    }
                }
            }
            catch( Exception e ) {}

            if( ois != null ) break;
        }

        return ois;
    }

    /** 
     * Searches the current class path for the serialized file and un-serializes the JposEntry objects
     * @return an Enumeration of JposEntry objects un-serializes from the file specified
     * @param is the InputStream from which to read the serialized entries from
     * @since 1.2 (NY 2K meeting)
     */
    protected Enumeration readJposEntries( InputStream is )
    {
        Vector entries = new Vector();

        try
        {
			//Added in 1.3 (SF-2K meeting) (not elegant since need to do
			//a instanceof operation but works :-)
            ObjectInputStream in = null;

			if( is instanceof ObjectInputStream )
                in = (ObjectInputStream)is;
			else
				if( is != null )
					in = new ObjectInputStream( is );

            if( in == null )
                tracer.println( "Can't find serialized JposEntry file: " + 
                                serFileName );
            else
                while( true )
                    entries.addElement( in.readObject() );

            serFileName = absoluteFileName;
        } 
        catch( EOFException eofe ) {}
        catch( Exception e ) 
        { tracer.println( "ERROR while reading serialized JposEntry file: " + 
        	              serFileName + " Exception.message=" + 
        	              e.getMessage() ); }
        
        return entries.elements();
    }

    /** 
     * @return an Enumeration of JposEntry objects
     * @since 1.2 (NY 2K meeting)
     */
    protected Enumeration readJposEntries()
    {
        Enumeration entries = null;

        if( isPopulatorFileDefined() )
            try { entries = readJposEntries( getPopulatorFileIS() ); }
            catch( Exception e )
            { entries = ( new Vector() ).elements(); }
        else
            entries = readJposEntries( findSerOIS() );

        return entries;
    }

    /**
     *
     * @param entries an enumeration of JposEntry objects
     * @since 1.2 (NY 2K meeting)
     * @throws java.lang.Exception if any error occurs while saving
     */
    protected void saveJposEntries( Enumeration entries ) throws Exception
    {
        if( isPopulatorFileDefined() )
            saveJposEntries( entries, getPopulatorFileOS() );
        else
        {
            if( serInZipFile )
                saveSerInZipFile( entries );
            else
                saveSerFile( entries );
        }
    }

    //--------------------------------------------------------------------------
    // Instance variables
    //

    private File serFile = null;
    private ZipFile zipSerFile = null;

    private boolean serInZipFile = false;

    private String absoluteFileName = "";
    private String serFileName = DEFAULT_JPOS_SER_FILE_NAME;

	private Tracer tracer = TracerFactory.getInstance().
	                         createTracer( "SimpleRegPopulator" );	

    //--------------------------------------------------------------------------
    // Class constants
    //

    /**
     * The default serialized JposEntry file name
     * @since 1.2 (NY 2K meeting)
     */
    public static final String DEFAULT_JPOS_SER_FILE_NAME = "jpos.cfg";

	/**
	 * A tempory file name used for temporary storage
	 * @since 1.2 (NY 2K meeting)
	 */
    public static final String TEMP_SER_FILE_NAME = "__jpos_temp.cfg";
	
	/**
	 * The default name for the SimpleRegPopulator
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public static final String SIMPLE_REG_POPULATOR_NAME_STRING = "JCL Serialized Entries Populator";
}
