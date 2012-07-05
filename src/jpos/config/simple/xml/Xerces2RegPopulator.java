package jpos.config.simple.xml;

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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import org.apache.xerces.jaxp.SAXParserFactoryImpl;

import jpos.config.JposEntry;
import jpos.config.JposConfigException;
import jpos.config.simple.SimpleEntry;
import jpos.util.JposEntryUtility;
import jpos.util.tracing.Tracer;
import jpos.util.tracing.TracerFactory;

/**
 * This class implements a SAX parser for the JCL XML DB supporting both:
 * <ol>
 * <li>DTD definition: jpos/res/jcl.dtd</li>
 * <li>XML Schemas: jpos/res/jcl.xsd</li>
 * </ol>
 * <p>
 * <b>NOTE</b>: this class must define a public no-argument ctor so that it may be 
 * created via reflection when its defined in the jpos.properties as the 
 * jpos.config.regPopulatorClass
 * </p>
 * @see jpos.util.JposProperties#JPOS_REG_POPULATOR_CLASS_PROP_NAME
 * @since 2.1.0
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public class Xerces2RegPopulator extends AbstractXercesRegPopulator
{
    //-------------------------------------------------------------------------
    // Ctor(s)
    //

    /**
     * Default ctor
     * @since 1.2 (NY 2K meeting)
     */
    public Xerces2RegPopulator() 
    { super( XercesRegPopulator.class.getName() ); }

    /**
     * 1-arg constructor that takes the unique ID
	 * @param s the unique ID string
     * @since 2.1.0
     */
    public Xerces2RegPopulator( String s ) { super( s ); }

    //-------------------------------------------------------------------------
    // Public methods
    //

	/**
	 * @return the fully qualified class name implementing the 
	 * JposRegPopulator interface
	 * @since 2.1.0
	 */
	public String getClassName() 
	{ return Xerces2RegPopulator.class.getName(); }

    /**
     * Tell the populator to load the entries 
     * @since 2.1.0
     */
    public void load()
    {
    	try
    	{
    		//<temp>NEED TO REPLACE WITH A METHOD THAT FIGURES OUT FILE NAME</temp>
    		//<temp>needed to set file name</temp>
    		InputStream is = getPopulatorFileIS();
    		//<temp/>
    		
    		load( getPopulatorFileName() );    		
    		//<temp/>
    	}
    	catch( Exception e )
    	{
    		tracer.println( "Error while loading populator file Exception.message: " + 
    						e.getMessage() );
    		lastLoadException = e;    		
    	}
    }

    /**
     * Loads the entries specified in the xmlFileName
     * @param xmlFileName the XML file name
     * @since 2.1.0
     */
    public void load( String xmlFileName )
    {
    	Reader reader = null;
    	
    	try
    	{
	    	reader = new FileReader( new File( xmlFileName ) );
			InputSource inputSource = new InputSource( reader );
			
			XMLReader xmlReader = getSAXParser().getXMLReader();
			
			initXMLReader( xmlReader );
						
			xmlReader.setErrorHandler( errorHandler );
			xmlReader.setContentHandler( contentHandler );
			xmlReader.setEntityResolver( entityResolver );
			
			jposEntryList.clear();
			lastLoadException = null;
			
			xmlReader.parse( inputSource );
			
			Iterator entries = jposEntryList.iterator();
			while( entries.hasNext() )
			{
				JposEntry jposEntry = (JposEntry)entries.next();
				getJposEntries().put( jposEntry.getLogicalName(), jposEntry );
			}
    	}
    	catch( FileNotFoundException fne )
    	{    		
    		tracer.println( "Could not find file: " + xmlFileName );
    		lastLoadException = fne;
    	}
    	catch( ParserConfigurationException pce )
    	{
    		tracer.println( "Could not create and configure SAX parser/factory" 
    		                + pce.getMessage() );	
    		lastLoadException = pce;
    	}
    	catch( IOException ioe )
    	{
    		tracer.println( "Error while parsing XML file:IOException.msg=" + 
    		                ioe.getMessage() );	    		
    		lastLoadException = ioe;
    	}
    	catch( SAXException se )
    	{
    		tracer.println( "Error creating or using the SAXParser:" + 
    						"SAXException.message=" + se.getMessage() );	    		
    		lastLoadException = se;
    	}
    	finally
    	{
    		try{ if( reader != null ) reader.close(); }
    		catch( IOException ioe ) 
    		{ 
    			tracer.println( "load( " + xmlFileName + ") IOException.msg=" + 
    			                ioe.getMessage() ); 
    		}
    	}
    }

	/**
	 * @return the name of this populator.  
	 * This should be a short descriptive name
	 * @since 1.3 (Washington DC 2001 meeting)
	 */
	public String getName() { return XERCES2_REG_POPULATOR_NAME_STRING; }

    //--------------------------------------------------------------------------
    // Protected methods
    //
    
    /**
     * @return a SAXParser object creating and initializing SAXParserFactory
     * and necessary objects if they are not yet created
     * @since 2.1.0
     * @throws javax.xml.parsers.ParserConfigurationException if the parser 
     * factory not be properly configured
     * @throws org.xml.sax.SAXException if the SAXParser could not be created
     */
    protected SAXParser getSAXParser() throws ParserConfigurationException,
    											 SAXException
    {
    	if( saxParser == null )
    	{	
    		SAXParserFactory factory = new SAXParserFactoryImpl();
		    saxParser = factory.newSAXParser();
    	}
  		
  		return saxParser;
    }

	/**
	 * Initializes XMLReader instance
	 * @param xmlReader the XMLReader instance
	 * @throws org.xml.sax.SAXException
	 */
	protected void initXMLReader( XMLReader xmlReader ) throws SAXException
	{
		xmlReader.setFeature( "http://xml.org/sax/features/namespaces", true );
		xmlReader.setFeature( "http://xml.org/sax/features/validation", true );			
	}
    
    //--------------------------------------------------------------------------
    // Instance variables
    //

	private XMLReader xmlReader = null;
	private SAXParser saxParser = null;
    
	private ErrorHandler errorHandler = this.new JposErrorHandler();
	private ContentHandler contentHandler = this.new JposContentHandler();
	private EntityResolver entityResolver = this.new JposEntityResolver();
	
	private List jposEntryList = new LinkedList();
	
	private Tracer tracer = TracerFactory.getInstance().
	                         createTracer( "Xerces2RegPopulator", true );
   
    //--------------------------------------------------------------------------
    // Public constants
    //

	public static final String XERCES2_REG_POPULATOR_NAME_STRING = 
	                             "JCL XML Entries Populator 2";
	
	//--------------------------------------------------------------------------
    // Inner classes
    //

    /**
     * SAX XML Handler interface---essentially implements the XML parser/driver
     * @author E. Michael Maximilien
     */
    protected class JposContentHandler extends DefaultHandler 
    									 implements ContentHandler
    {
	    //----------------------------------------------------------------------
	    // Public methods
	    //
	    
	    public void startDocument() throws SAXException
	    {
	    	tracer.println( "<startDocument/>" );
	    }

	    public void endDocument() throws SAXException
	    {
	    	tracer.println( "<endDocument/>" );
	    }
	    
		public void startElement( String namespaceUri, String localName, 
	                               String qName, Attributes attributes ) 
	                 throws SAXException
	    {
	    	tracer.println( "<startElement qName=\"" + qName + "\"/>" );

	    	if( qName.equals( "JposEntries" ) )
	    	{
 				jposEntryList.clear();    	
	    		currentEntry = null;
	    	}
	    	else	    	
	    	if( qName.equals( "JposEntry" ) )
	    		currentEntry = createEntry( attributes );
	    	else
	    	if( qName.equals( "creation" ) )
	    		addCreationProp( currentEntry, attributes );
	    	else
	    	if( qName.equals( "vendor" ) )
	    		addVendorProp( currentEntry, attributes );
	    	else
	    	if( qName.equals( "jpos" ) )
	    		addJposProp( currentEntry, attributes );
	    	else
	    	if( qName.equals( "product" ) )
	    		addProductProp( currentEntry, attributes );
	    	else
	    	if( qName.equals( "prop" ) )
	    		addProp( currentEntry, attributes );
	    	else
	    	{
	    		tracer.println( "Invalid qName=" + qName );
	    		throw new SAXException( "Invalid qName=" + qName );
	    	}

	    }

	    public void endElement( String namespaceUri, String localName, 
	                             String qName ) throws SAXException
	    {
	    	tracer.println( "<endElement qName=\"" + qName + "\"/>" );
	    	
	    	if( qName.equals( "JposEntry" ) )
	    		jposEntryList.add( currentEntry );
	    }

	    //----------------------------------------------------------------------
	    // Protected methods
	    //

	    protected JposEntry createEntry( Attributes attributes )
	    throws SAXException
	    {
	    	String logicalName = attributes.getValue( "logicalName" );
	    	
	    	return new SimpleEntry( logicalName, Xerces2RegPopulator.this );
	    }
	    
	    protected void addCreationProp( JposEntry entry, 
	    								  Attributes attributes )
		throws SAXException
		{
			String factoryClass = attributes.getValue( "factoryClass" );
			String serviceClass = attributes.getValue( "serviceClass" );

			//TODO: Check values
			
			currentEntry.addProperty( JposEntry.SI_FACTORY_CLASS_PROP_NAME, 
									  factoryClass );
			currentEntry.addProperty( JposEntry.SERVICE_CLASS_PROP_NAME, 
									  serviceClass );
		}	    								
		
		protected void addVendorProp( JposEntry entry, 
	    								Attributes attributes )
		throws SAXException
		{
			String factoryClass = attributes.getValue( "name" );
			String serviceClass = attributes.getValue( "url" );

			//TODO: Check values
			
			currentEntry.addProperty( JposEntry.VENDOR_NAME_PROP_NAME, 
									  factoryClass );
									  
			currentEntry.addProperty( JposEntry.VENDOR_URL_PROP_NAME, 
									  serviceClass );			
		}	    								
		
	    protected void addJposProp( JposEntry entry, 
	    							  Attributes attributes ) 
	 	throws SAXException
		{
			String category = attributes.getValue( "category" );
			String version = attributes.getValue( "version" );
			
			//TODO: Check values
			
			currentEntry.addProperty( JposEntry.DEVICE_CATEGORY_PROP_NAME,
									  category );
									  
			currentEntry.addProperty( JposEntry.JPOS_VERSION_PROP_NAME, 
									  version );						
		}
			    								
	    protected void addProductProp( JposEntry entry, 
	    								 Attributes attributes )
		throws SAXException
		{
			String description = attributes.getValue( "description" );
			String name = attributes.getValue( "name" );
			String url = attributes.getValue( "url" );
			
			//TODO: Check values
			
			currentEntry.addProperty( JposEntry.PRODUCT_DESCRIPTION_PROP_NAME,
									  description );
									  
			currentEntry.addProperty( JposEntry.PRODUCT_NAME_PROP_NAME,
									  name );						
			
			currentEntry.addProperty( JposEntry.PRODUCT_URL_PROP_NAME,
						  			  url );						
		}
			    								
	    protected void addProp( JposEntry entry, 
	    					      Attributes attributes )
		throws SAXException
		{
			String name = attributes.getValue( "name" );
			String valueString = attributes.getValue( "value" );
			String typeString = attributes.getValue( "type" );
			
			if( typeString == null || typeString.equals( "" ) )
				typeString = "String";

			try
			{
			
				Class typeClass = JposEntryUtility.
				propTypeFromString( attributes.getValue( "type" ) );
				
				Object value = JposEntryUtility.parsePropValue( valueString, typeClass );
				
				//TODO: Check values
			
				JposEntry.Prop prop = currentEntry.
									  createProp( name, value, typeClass );										      
				currentEntry.add( prop );
			}
			catch( JposConfigException jce )
			{
				String msg = "Invalid prop: name=" + name + ":value=" + 
							 valueString;
				tracer.println( msg );
				throw new SAXException( msg );
			}
		}	    								
	    
	    //----------------------------------------------------------------------
	    // Instance variables
	    //

		private JposEntry currentEntry = null;	    
    }
    
    /**
     * JposEntityResolver to resolve XML schema
     * @author E. Michael Maximilien
     * @version 2.1.0
     */
	public class JposEntityResolver implements EntityResolver 
	{
		/**
		 * @return the XML schema as an InputSource if it is found in a JAR
		 * file in the CLASSPATH otherwise
		 * return null
		 */
		public InputSource resolveEntity( String publicId, String systemId )
   		{
   			tracer.println( "JposEntityResolver:resolveEntity:publicId=" + 
   							publicId );
   							   			
   			tracer.println( "JposEntityResolver:resolveEntity:systemId=" + 
   							systemId );
   		
   			if( publicId.equals( getDoctypeValue() ) )
   			{
				InputStream is = 
				getClass().getResourceAsStream( getDoctypeValue() );
			
				if( is != null ) 
					return new InputSource( new InputStreamReader( is ) );
   			}
   			
   			return null;
     	}
   }
    
    /**
     * SAX XML Handler interface
     * @author E. Michael Maximilien
     */
    protected class JposErrorHandler extends Object implements ErrorHandler
    {
	    //----------------------------------------------------------------------
	    // Private/protected methods
	    //
	    
	    private String createMessage( String header, SAXParseException spe )
	    {
			return header + "parsing XML file:SAXParseException.message = " + 
	    	        spe.getMessage();
	    }
	    
	    //----------------------------------------------------------------------
	    // Public methods
	    //
	    
	    public void error( SAXParseException spe ) throws SAXException
	    {
	    	String message = createMessage( "JposErrorHandler:Error:", spe );
			tracer.print( message );
			
			throw new SAXException( message );	    	
	    }
	    
	    public void fatalError( SAXParseException spe ) throws SAXException
	    {
	    	String message = createMessage( "JposErrorHandler:FatalError:", spe );
			tracer.print( message );
			
			throw new SAXException( message );	    	
	    }
	    
	    public void warning( SAXParseException spe ) throws SAXException
	    {
	    	String message = createMessage( "JposErrorHandler:Warning:", spe );
			tracer.print( message );
			
			throw new SAXException( message );	    	
	    }
    }
}