package jpos.profile;

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
import java.net.URL;
import java.net.MalformedURLException;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.apache.xerces.parsers.DOMParser;
import org.xml.sax.*;

import jpos.util.XmlHelper;
import jpos.util.tracing.Tracer;
import jpos.util.tracing.TracerFactory;

/**
 * Default implementation of the ProfileFactory interface uses the Apache Xerces
 * XML parser to create profiles from the XML file passed
 * @since 1.3 (SF 2K meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public class XercesProfileFactory extends Object implements ProfileFactory
{
	//-------------------------------------------------------------------------
	// Ctor(s)
	//

	/** Default ctor */
	public XercesProfileFactory() {}

	//-------------------------------------------------------------------------
	// Private methods
	//

	/**
	 * @return a Profile object created from the Document object
	 * @param document the XML document object
	 * @exception jpos.profile.ProfileException if document is not in correct 
	 * format
	 */
	private Profile extractProfile( Document document ) throws ProfileException
	{
		Element profileElement = document.getDocumentElement();

		String name = profileElement.getAttribute( "name" );
		DefaultProfile profile = new DefaultProfile( name );

		NodeList nodeList = profileElement.getElementsByTagName( "ProfileInfo" );

		if( nodeList.getLength() != 1 )
			throw new ProfileException( "Profile does not contain 1 ProfileInfo element" );

		Element profileInfoElement = (Element)nodeList.item( 0 );

		profile.setVersion( profileInfoElement.getAttribute( "version" ) );
		profile.setVendorName( profileInfoElement.getAttribute( "vendorName" ) );

		try
		{
			String vendorUrlString = profileInfoElement.getAttribute( "vendorUrl" );
			profile.setVendorUrl( new URL( vendorUrlString ) );
		}
		catch( MalformedURLException e )
		{ throw new ProfileException( "ProfileInfo contains an invalid vendorUrl string" ); }

		profile.setDescription( profileInfoElement.getAttribute( "description" ) );

		return profile;
	}

	//-------------------------------------------------------------------------
	// Package methods
	//
	
    /**
     * Parses the XML file into a valid XML document for the profile DTD
     * @param xmlFileName the XML file name
	 * @exception jpos.profile.ProfileException if the XML file could not be parsed
     */
	Document parse( String xmlFileName ) throws ProfileException
    {
		XmlHelper xmlHelper = new XmlHelper();

        try
        {
			xmlHelper.setDtdFileName( PROFILE_DTD_FILE_NAME );
			xmlHelper.setDtdFilePath( PROFILE_DTD_FILE_PATH );
            xmlHelper.checkAndCreateTempDtd();

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			docFactory.setNamespaceAware( true );
			docFactory.setValidating( true );

			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			DefaultErrorHandler errorHandler = this.new DefaultErrorHandler();
			docBuilder.setErrorHandler( errorHandler );
            
			Document document = docBuilder.parse( new File( xmlFileName ) );

			if( errorHandler.getErrorList().size() > 0 ||
				errorHandler.getFatalErrorList().size() > 0 )
				{
					String msg = "Error while parsing XML file, set properties"+
					             " jpos.tracing = ON in jpos.properties" + 
					             " file for details";
					throw new ProfileException( msg );					
				}

			return document;
        }
        catch( IOException ioe )
        {
			String msg = "Error loading XML profile file";
			tracer.println( msg + ": Exception.message = " + ioe.getMessage() ); 
			throw new ProfileException( msg, ioe ); 
		}
        catch( SAXException se )
        { 
			String msg = "Error parsing XML profile file";
			tracer.println( msg + ": Exception.message = " + se.getMessage() ); 
			throw new ProfileException( msg, se ); 
		}
		catch( ParserConfigurationException pce )
		{
			String msg = "Error creating XML parser";
			tracer.println( msg + ": Exception.message = " + pce.getMessage() ); 
			throw new ProfileException( msg, pce ); 
		}
		finally
        { xmlHelper.removeTempDtd(); }
    }

    /**
     * Parses the XML file into a valid XML document for the profile Schemas
     * @param xmlFileName the XML file name
	 * @exception jpos.profile.ProfileException if the XML file could not be parsed
     */
	Document parseSchema( String xmlFileName ) throws ProfileException
    {
        try
        {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			docFactory.setNamespaceAware( true );
			docFactory.setValidating( true );

			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			DefaultErrorHandler errorHandler = this.new DefaultErrorHandler();
			docBuilder.setErrorHandler( errorHandler );
            
            Document document = docBuilder.parse( new File( xmlFileName ) ); 

			return document;
        }
        catch( IOException ioe )
        {
			String msg = "Error loading XML profile file";
			tracer.println( msg + ": Excpetion.message = " + ioe.getMessage() ); 
			throw new ProfileException( msg, ioe ); 
		}
        catch( SAXException se )
        { 
			String msg = "Error parsing XML profile file";
			tracer.println( msg + ": Exception.message = " + se.getMessage() ); 

			throw new ProfileException( msg, se ); 
		}
		catch( ParserConfigurationException pce )
		{
			String msg = "Error creating XML parser";
			tracer.println( msg + ": Exception.message = " + pce.getMessage() ); 
			throw new ProfileException( msg, pce ); 
		}
    }

    /**
     * Loads the Profile specified in the xmlFileName as a Profile object
     * @param xmlFileName the XML file name
	 * @exception jpos.profile.ProfileException if the XML file could not be 
	 * parsed and the profile created
     */
	Profile load( String xmlFileName ) throws ProfileException
    {			   
		Document document = parse( xmlFileName );

		return extractProfile( document );
    }

	//-------------------------------------------------------------------------
	// Public methods
	//

	/**
	 * @return a Profile object created parsing the XML file provided
	 * @param xmlProfileFile the XML profile file
	 * @exception jpos.profile.ProfileException if there is an error loading the profile
	 */
	public Profile createProfile( String xmlProfileFileName ) throws ProfileException
	{
		return load( xmlProfileFileName );
	}

	//-------------------------------------------------------------------------
	// Instance variables
	//

	private Profile profile = null;

    private DOMParser domParser = new DOMParser();
	private DefaultErrorHandler errorHandler = this.new DefaultErrorHandler();
	private Tracer tracer = TracerFactory.getInstance().
							 createTracer( "XercesProfileFactory" );

	//-------------------------------------------------------------------------
	// Inner classes
	//

	/**
	 * ErrorHandler inner class used to capture errors while parsing XML document
	 * @since 1.3 (Washington DC 2001 meeting)
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 */
	class DefaultErrorHandler extends Object implements org.xml.sax.ErrorHandler
	{
		//---------------------------------------------------------------------
		// Package methods
		//

		List getErrorList() { return errorList; }

		List getWarningList() { return warningList; }

		List getFatalErrorList() { return fatalErrorList; }

		//---------------------------------------------------------------------
		// Public methods
		//

		public void warning( SAXParseException e ) throws SAXException 
		{
			tracer.println( "Line " + e.getLineNumber() + ": WARNING SAXParseException.message = " + e.getMessage() );
			warningList.add( e );
		}
		
		public void error( SAXParseException e ) throws SAXException 
		{
			tracer.println( "Line " + e.getLineNumber() + ": ERROR SAXParseException.message = " + e.getMessage() );
			errorList.add( e );
		}
		
		public void fatalError( SAXParseException e ) throws SAXException 
		{
			tracer.println( "Line " + e.getLineNumber() + ": FATALERROR SAXParseException.message = " + e.getMessage() );
			fatalErrorList.add( e );
		}

		//---------------------------------------------------------------------
		// Private variables
		//

		private List warningList = new ArrayList();
		private List errorList = new ArrayList();
		private List fatalErrorList = new ArrayList();
	}

	//-------------------------------------------------------------------------
	// Class constants
	//

    public static final String PROFILE_DTD_FILE_NAME = "jcl_profile.dtd";
    public static final String PROFILE_DTD_FILE_PATH = "jpos" + File.separator + "res" + File.separator;
}
