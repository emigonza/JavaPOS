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

import java.util.*;

/**
 * Defines an interface for JavaPOS device categories
 * @since 1.3 (SF 2K meeting)
 * @author E. Michael Maximilien (maxim@us.ibm.com)
 */
public class JposDevCats extends Object
{
	//-------------------------------------------------------------------------
	// Private class constants
	//

	private static final Hashtable DEVCAT_TABLE = new Hashtable();

	//-------------------------------------------------------------------------
	// Class constants
	//

	public static final DevCat UNKNOWN_DEVCAT = 
								 JposDevCats.Unknown.getInstance();
	
	public static final DevCat BUMPBAR_DEVCAT = 
								 JposDevCats.BumpBar.getInstance();

	public static final DevCat CASHCHANGER_DEVCAT = 
								 JposDevCats.CashChanger.getInstance();
	
	public static final DevCat CASHDRAWER_DEVCAT = 
								 JposDevCats.CashDrawer.getInstance();
	
	public static final DevCat CHECKSCANNER_DEVCAT = 
								 JposDevCats.CheckScanner.getInstance();

	public static final DevCat CAT_DEVCAT = 
								 JposDevCats.CAT.getInstance();
	
	public static final DevCat COINDISPENSER_DEVCAT = 
								 JposDevCats.CoinDispenser.getInstance();
	
	public static final DevCat FISCALPRINTER_DEVCAT = 
								 JposDevCats.FiscalPrinter.getInstance();
	
	public static final DevCat HARDTOTALS_DEVCAT = 
								 JposDevCats.HardTotals.getInstance();
	
	public static final DevCat KEYLOCK_DEVCAT = 
								 JposDevCats.Keylock.getInstance();
	
	public static final DevCat LINEDISPLAY_DEVCAT = 
								 JposDevCats.LineDisplay.getInstance();
	
	public static final DevCat MICR_DEVCAT = 
								 JposDevCats.MICR.getInstance();
	
	public static final DevCat MOTIONSENSOR_DEVCAT = 
								 JposDevCats.MotionSensor.getInstance();	
	
	public static final DevCat MSR_DEVCAT = 
								 JposDevCats.MSR.getInstance();
	
	public static final DevCat PINPAD_DEVCAT = 
								 JposDevCats.Pinpad.getInstance();

	public static final DevCat POINTCARDRW_DEVCAT = 
								 JposDevCats.PointCardRW.getInstance();
	
	public static final DevCat POSKEYBOARD_DEVCAT = 
								 JposDevCats.POSKeyboard.getInstance();
	
	public static final DevCat POSPOWER_DEVCAT = 
								 JposDevCats.POSPower.getInstance();
	
	public static final DevCat POSPRINTER_DEVCAT = 
								 JposDevCats.POSPrinter.getInstance();
	
	public static final DevCat REMOTEORDERDISPLAY_DEVCAT = 
								 JposDevCats.RemoteOrderDisplay.getInstance();
	
	public static final DevCat SCANNER_DEVCAT = 
								 JposDevCats.Scanner.getInstance();
	
	public static final DevCat SCALE_DEVCAT = 
								 JposDevCats.Scale.getInstance();	
	
	public static final DevCat SIGNATURECAPTURE_DEVCAT = 
								 JposDevCats.SignatureCapture.getInstance();
	
	public static final DevCat TONEINDICATOR_DEVCAT = 
								 JposDevCats.ToneIndicator.getInstance();


	//-------------------------------------------------------------------------
	// Class constants
	//

	/** An array of all of the JavaPOS DevCat */
	public static final DevCat[] DEVCAT_ARRAY = 
								   { BUMPBAR_DEVCAT, CASHCHANGER_DEVCAT,
								   	 CASHDRAWER_DEVCAT, CHECKSCANNER_DEVCAT,
								   	 CAT_DEVCAT, COINDISPENSER_DEVCAT, 
								   	 FISCALPRINTER_DEVCAT, HARDTOTALS_DEVCAT,
									 KEYLOCK_DEVCAT, LINEDISPLAY_DEVCAT, 
									 MICR_DEVCAT, MOTIONSENSOR_DEVCAT,
									 MSR_DEVCAT, PINPAD_DEVCAT, 
									 POSKEYBOARD_DEVCAT, POSPOWER_DEVCAT, 
									 POSPRINTER_DEVCAT, 
									 REMOTEORDERDISPLAY_DEVCAT, SCANNER_DEVCAT,
									 SCALE_DEVCAT, SIGNATURECAPTURE_DEVCAT, 
									 TONEINDICATOR_DEVCAT,
									 POINTCARDRW_DEVCAT };

	//-------------------------------------------------------------------------
	// Static initializer
	//
	
	static
	{
		DEVCAT_TABLE.put( BUMPBAR_DEVCAT.toString(), BUMPBAR_DEVCAT );
		DEVCAT_TABLE.put( CASHCHANGER_DEVCAT.toString(), CASHCHANGER_DEVCAT );		
		DEVCAT_TABLE.put( CASHDRAWER_DEVCAT.toString(), CASHDRAWER_DEVCAT );
		DEVCAT_TABLE.put( CHECKSCANNER_DEVCAT.toString(), CHECKSCANNER_DEVCAT );
		DEVCAT_TABLE.put( CAT_DEVCAT.toString(), CAT_DEVCAT );
		DEVCAT_TABLE.put( COINDISPENSER_DEVCAT.toString(), 
						  COINDISPENSER_DEVCAT );
		DEVCAT_TABLE.put( FISCALPRINTER_DEVCAT.toString(), 
						  FISCALPRINTER_DEVCAT );
		DEVCAT_TABLE.put( HARDTOTALS_DEVCAT.toString(), HARDTOTALS_DEVCAT );
		DEVCAT_TABLE.put( KEYLOCK_DEVCAT.toString(), KEYLOCK_DEVCAT );
		DEVCAT_TABLE.put( LINEDISPLAY_DEVCAT.toString(), LINEDISPLAY_DEVCAT );
		DEVCAT_TABLE.put( MICR_DEVCAT.toString(), MICR_DEVCAT );
		DEVCAT_TABLE.put( MOTIONSENSOR_DEVCAT.toString(), MOTIONSENSOR_DEVCAT );		
		DEVCAT_TABLE.put( MSR_DEVCAT.toString(), MSR_DEVCAT );           
		DEVCAT_TABLE.put( PINPAD_DEVCAT.toString(), PINPAD_DEVCAT );
		DEVCAT_TABLE.put( POINTCARDRW_DEVCAT.toString(), 
						  POINTCARDRW_DEVCAT );		
		DEVCAT_TABLE.put( POSKEYBOARD_DEVCAT.toString(), POSKEYBOARD_DEVCAT );
		DEVCAT_TABLE.put( POSPOWER_DEVCAT.toString(), POSPOWER_DEVCAT );
		DEVCAT_TABLE.put( POSPRINTER_DEVCAT.toString(), POSPRINTER_DEVCAT );
		DEVCAT_TABLE.put( REMOTEORDERDISPLAY_DEVCAT.toString(), 
						  REMOTEORDERDISPLAY_DEVCAT );
		DEVCAT_TABLE.put( SCANNER_DEVCAT.toString(), SCANNER_DEVCAT );
		DEVCAT_TABLE.put( SCALE_DEVCAT.toString(), SCALE_DEVCAT );		
		DEVCAT_TABLE.put( SIGNATURECAPTURE_DEVCAT.toString(), 
						  SIGNATURECAPTURE_DEVCAT );
		DEVCAT_TABLE.put( TONEINDICATOR_DEVCAT.toString(), 
						  TONEINDICATOR_DEVCAT );
	}

	//-------------------------------------------------------------------------
	// Class methods
	//

	/**
	 * @return the DevCat for the String name passed
	 * @param devCatString the String name for this DevCat
	 */
	public static DevCat getDevCatForName( String devCatName )
	{
		if( DEVCAT_TABLE.containsKey( devCatName ) )
			return (DevCat)DEVCAT_TABLE.get( devCatName );

		return UNKNOWN_DEVCAT;
	}

	//-------------------------------------------------------------------------
	// Inner classes
	//

	/**
	 * Defines the super class for all DevCat
	 * @since 1.3 (SF 2K meeting)
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 */
	public static abstract class AbstractDevCat extends Object 
	implements DevCat 
	{
	    //---------------------------------------------------------------------
	    // Public overriden methods
	    //

	    /** @return the String representation of this DevCat */
	    public abstract String toString();

		/** 
		 * @return true if these two DevCat are the same JavaPOS device 
		 * category 
		 * @param obj the other object to compare to
		 */
		public boolean equals( Object obj )
		{
			if( obj == null ) return false;

			if( !( obj instanceof DevCat ) ) return false;

			return toString().equals( obj.toString() );
		}
	}

	/**
	 * Defines an Unknown DevCat
	 * @since 1.3 (SF 2K meeting)
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 */
	public static class Unknown extends AbstractDevCat implements DevCat 
	{
		//---------------------------------------------------------------------
		// Ctor(s)
		//

		/** Make ctor package to avoid ctor */
		Unknown() {}

		//---------------------------------------------------------------------
		// Class methods
		//

		/** @return the unique instance of this class (create if necessary) */
		public static DevCat getInstance()
		{
			if( instance == null )
				instance = new JposDevCats.Unknown();

			return instance;
		}

		//---------------------------------------------------------------------
		// Public methods
		//

		/** @return the String representation of this DevCat */
		public String toString() { return "Unknown"; }

		/**
		 * Accepts a DevCat Visitor object
		 * @param visitor the DevCat Visitor object
		 */
		public void accept( DevCatVisitor visitor ) {}

		//---------------------------------------------------------------------
		// Class instance
		//

		private static DevCat instance = null;
	}
	
	/**
	 * Defines the DevCat for BumpBar
	 * @since 1.3 (SF 2K meeting)
	 * @author E. Michael Maximilien
	 */
	public static class BumpBar extends AbstractDevCat implements DevCat 
	{
		//---------------------------------------------------------------------
		// Ctor(s)
		//

		/** Make ctor package to avoid ctor */
		BumpBar() {}

		//---------------------------------------------------------------------
		// Class methods
		//

		/** @return the unique instance of this class (create if necessary) */
		public static DevCat getInstance()
		{
			if( instance == null )
				instance = new JposDevCats.BumpBar();

			return instance;
		}

		//---------------------------------------------------------------------
		// Public methods
		//

		/** @return the String representation of this DevCat */
		public String toString() { return "BumpBar"; }

		/**
		 * Accepts a DevCat Visitor object
		 * @param visitor the DevCat Visitor object
		 */
		public void accept( DevCatVisitor visitor ) 
		{ visitor.visitBumpBar( this ); }

		//---------------------------------------------------------------------
		// Class instance
		//

		private static DevCat instance = null;
	}

	/**
	 * Defines the DevCat for CashChanger
	 * @since 1.3 (SF 2K meeting)
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 */
	public static class CashChanger extends AbstractDevCat implements DevCat 
	{
		//---------------------------------------------------------------------
		// Ctor(s)
		//

		/** Make ctor package to avoid ctor */
		CashChanger() {}

		//---------------------------------------------------------------------
		// Class methods
		//

		/** @return the unique instance of this class (create if necessary) */
		public static DevCat getInstance()
		{
			if( instance == null )
				instance = new JposDevCats.CashChanger();

			return instance;
		}

		//---------------------------------------------------------------------
		// Public methods
		//

		/** @return the String representation of this DevCat */
		public String toString() { return "CashChanger"; }

		/**
		 * Accepts a DevCat Visitor object
		 * @param visitor the DevCat Visitor object
		 */
		public void accept( DevCatVisitor visitor ) 
		{ visitor.visitCashChanger( this ); }

		//---------------------------------------------------------------------
		// Class instance
		//

		private static DevCat instance = null;
	}

	/**
	 * Defines the DevCat for CashDrawer
	 * @since 1.3 (SF 2K meeting)
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 */
	public static class CashDrawer extends AbstractDevCat implements DevCat 
	{
		//---------------------------------------------------------------------
		// Ctor(s)
		//

		/** Make ctor package to avoid ctor */
		CashDrawer() {}

		//---------------------------------------------------------------------
		// Class methods
		//

		/** @return the unique instance of this class (create if necessary) */
		public static DevCat getInstance()
		{
			if( instance == null )
				instance = new JposDevCats.CashDrawer();

			return instance;
		}

		//---------------------------------------------------------------------
		// Public methods
		//

		/** @return the String representation of this DevCat */
		public String toString() { return "CashDrawer"; }

		/**
		 * Accepts a DevCat Visitor object
		 * @param visitor the DevCat Visitor object
		 */
		public void accept( DevCatVisitor visitor ) 
		{ visitor.visitCashDrawer( this ); }

		//---------------------------------------------------------------------
		// Class instance
		//

		private static DevCat instance = null;
	}

	/**
	 * Defines the DevCat for CheckScanner
	 * @since 1.3 (SF 2K meeting)
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 */
	public static class CheckScanner extends AbstractDevCat 
									   implements DevCat 
	{
		//---------------------------------------------------------------------
		// Ctor(s)
		//

		/** Make ctor package to avoid ctor */
		CheckScanner() {}

		//---------------------------------------------------------------------
		// Class methods
		//

		/** @return the unique instance of this class (create if necessary) */
		public static DevCat getInstance()
		{
			if( instance == null )
				instance = new JposDevCats.CheckScanner();

			return instance;
		}

		//---------------------------------------------------------------------
		// Public methods
		//

		/** @return the String representation of this DevCat */
		public String toString() { return "CheckScanner"; }

		/**
		 * Accepts a DevCat Visitor object
		 * @param visitor the DevCat Visitor object
		 */
		public void accept( DevCatVisitor visitor ) 
		{ visitor.visitCheckScanner( this ); }

		//---------------------------------------------------------------------
		// Class instance
		//

		private static DevCat instance = null;
	}

	/**
	 * Defines the DevCat for CAT
	 * @since 1.3 (SF 2K meeting)
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 */
	public static class CAT extends AbstractDevCat implements DevCat 
	{
		//---------------------------------------------------------------------
		// Ctor(s)
		//

		/** Make ctor package to avoid ctor */
		CAT() {}

		//---------------------------------------------------------------------
		// Class methods
		//

		/** @return the unique instance of this class (create if necessary) */
		public static DevCat getInstance()
		{
			if( instance == null )
				instance = new JposDevCats.CAT();

			return instance;
		}

		//---------------------------------------------------------------------
		// Public methods
		//

		/** @return the String representation of this DevCat */
		public String toString() { return "CAT"; }

		/**
		 * Accepts a DevCat Visitor object
		 * @param visitor the DevCat Visitor object
		 */
		public void accept( DevCatVisitor visitor ) 
		{ visitor.visitCAT( this ); }

		//---------------------------------------------------------------------
		// Class instance
		//

		private static DevCat instance = null;
	}

	/**
	 * Defines the DevCat for CoinDispenser
	 * @since 1.3 (SF 2K meeting)
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 */
	public static class CoinDispenser extends AbstractDevCat 
										implements DevCat 
	{
		//---------------------------------------------------------------------
		// Ctor(s)
		//

		/** Make ctor package to avoid ctor */
		CoinDispenser() {}

		//---------------------------------------------------------------------
		// Class methods
		//

		/** @return the unique instance of this class (create if necessary) */
		public static DevCat getInstance()
		{
			if( instance == null )
				instance = new JposDevCats.CoinDispenser();

			return instance;
		}

		//---------------------------------------------------------------------
		// Public methods
		//

		/** @return the String representation of this DevCat */
		public String toString() { return "CoinDispenser"; }

		/**
		 * Accepts a DevCat Visitor object
		 * @param visitor the DevCat Visitor object
		 */
		public void accept( DevCatVisitor visitor ) 
		{ visitor.visitCoinDispenser( this ); }

		//---------------------------------------------------------------------
		// Class instance
		//

		private static DevCat instance = null;
	}

	/**
	 * Defines the DevCat for FiscalPrinter
	 * @since 1.3 (SF 2K meeting)
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 */
	public static class FiscalPrinter extends AbstractDevCat 
										implements DevCat 
	{
		//---------------------------------------------------------------------
		// Ctor(s)
		//

		/** Make ctor package to avoid ctor */
		FiscalPrinter() {}

		//---------------------------------------------------------------------
		// Class methods
		//

		/** @return the unique instance of this class (create if necessary) */
		public static DevCat getInstance()
		{
			if( instance == null )
				instance = new JposDevCats.FiscalPrinter();

			return instance;
		}

		//---------------------------------------------------------------------
		// Public methods
		//

		/** @return the String representation of this DevCat */
		public String toString() { return "FiscalPrinter"; }

		/**
		 * Accepts a DevCat Visitor object
		 * @param visitor the DevCat Visitor object
		 */
		public void accept( DevCatVisitor visitor ) 
		{ visitor.visitFiscalPrinter( this ); }

		//---------------------------------------------------------------------
		// Class instance
		//

		private static DevCat instance = null;
	}

	/**
	 * Defines the DevCat for HardTotals
	 * @since 1.3 (SF 2K meeting)
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 */
	public static class HardTotals extends AbstractDevCat implements DevCat 
	{
		//---------------------------------------------------------------------
		// Ctor(s)
		//

		/** Make ctor package to avoid ctor */
		HardTotals() {}

		//---------------------------------------------------------------------
		// Class methods
		//

		/** @return the unique instance of this class (create if necessary) */
		public static DevCat getInstance()
		{
			if( instance == null )
				instance = new JposDevCats.HardTotals();

			return instance;
		}

		//---------------------------------------------------------------------
		// Public methods
		//

		/** @return the String representation of this DevCat */
		public String toString() { return "HardTotals"; }

		/**
		 * Accepts a DevCat Visitor object
		 * @param visitor the DevCat Visitor object
		 */
		public void accept( DevCatVisitor visitor ) 
		{ visitor.visitHardTotals( this ); }

		//---------------------------------------------------------------------
		// Class instance
		//

		private static DevCat instance = null;
	}

	/**
	 * Defines the DevCat for Keylock
	 * @since 1.3 (SF 2K meeting)
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 */
	public static class Keylock extends AbstractDevCat implements DevCat 
	{
		//---------------------------------------------------------------------
		// Ctor(s)
		//

		/** Make ctor package to avoid ctor */
		Keylock() {}

		//---------------------------------------------------------------------
		// Class methods
		//

		/** @return the unique instance of this class (create if necessary) */
		public static DevCat getInstance()
		{
			if( instance == null )
				instance = new JposDevCats.Keylock();

			return instance;
		}

		//---------------------------------------------------------------------
		// Public methods
		//

		/** @return the String representation of this DevCat */
		public String toString() { return "Keylock"; }

		/**
		 * Accepts a DevCat Visitor object
		 * @param visitor the DevCat Visitor object
		 */
		public void accept( DevCatVisitor visitor ) 
		{ visitor.visitKeylock( this ); }

		//---------------------------------------------------------------------
		// Class instance
		//

		private static DevCat instance = null;
	}

	/**
	 * Defines the DevCat for LineDisplay
	 * @since 1.3 (SF 2K meeting)
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 */
	public static class LineDisplay extends AbstractDevCat implements DevCat 
	{
		//---------------------------------------------------------------------
		// Ctor(s)
		//

		/** Make ctor package to avoid ctor */
		LineDisplay() {}

		//---------------------------------------------------------------------
		// Class methods
		//

		/** @return the unique instance of this class (create if necessary) */
		public static DevCat getInstance()
		{
			if( instance == null )
				instance = new JposDevCats.LineDisplay();

			return instance;
		}

		//---------------------------------------------------------------------
		// Public methods
		//

		/** @return the String representation of this DevCat */
		public String toString() { return "LineDisplay"; }

		/**
		 * Accepts a DevCat Visitor object
		 * @param visitor the DevCat Visitor object
		 */
		public void accept( DevCatVisitor visitor ) 
		{ visitor.visitLineDisplay( this ); }

		//---------------------------------------------------------------------
		// Class instance
		//

		private static DevCat instance = null;
	}

	/**
	 * Defines the DevCat for MICR
	 * @since 1.3 (SF 2K meeting)
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 */
	public static class MICR extends AbstractDevCat implements DevCat 
	{
		//---------------------------------------------------------------------
		// Ctor(s)
		//

		/** Make ctor package to avoid ctor */
		MICR() {}

		//---------------------------------------------------------------------
		// Class methods
		//

		/** @return the unique instance of this class (create if necessary) */
		public static DevCat getInstance()
		{
			if( instance == null )
				instance = new JposDevCats.MICR();

			return instance;
		}
		
		//---------------------------------------------------------------------
		// Public methods
		//

		/** @return the String representation of this DevCat */
		public String toString() { return "MICR"; }

		/**
		 * Accepts a DevCat Visitor object
		 * @param visitor the DevCat Visitor object
		 */
		public void accept( DevCatVisitor visitor ) 
		{ visitor.visitMICR( this ); }

		//---------------------------------------------------------------------
		// Class instance
		//

		private static DevCat instance = null;
	}

	/**
	 * Defines the DevCat for MotionSensor
	 * @since 1.3 (SF 2K meeting)
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 */
	public static class MotionSensor extends AbstractDevCat 
									   implements DevCat 
	{
		//---------------------------------------------------------------------
		// Ctor(s)
		//

		/** Make ctor package to avoid ctor */
		MotionSensor() {}

		//---------------------------------------------------------------------
		// Class methods
		//

		/** @return the unique instance of this class (create if necessary) */
		public static DevCat getInstance()
		{
			if( instance == null )
				instance = new JposDevCats.MotionSensor();

			return instance;
		}

		//---------------------------------------------------------------------
		// Public methods
		//

		/** @return the String representation of this DevCat */
		public String toString() { return "MotionSensor"; }

		/**
		 * Accepts a DevCat Visitor object
		 * @param visitor the DevCat Visitor object
		 */
		public void accept( DevCatVisitor visitor ) 
		{ visitor.visitMotionSensor( this ); }

		//---------------------------------------------------------------------
		// Class instance
		//

		private static DevCat instance = null;
	}

	/**
	 * Defines the DevCat for MSR
	 * @since 1.3 (SF 2K meeting)
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 */
	public static class MSR extends AbstractDevCat implements DevCat 
	{
		//---------------------------------------------------------------------
		// Ctor(s)
		//

		/** Make ctor package to avoid ctor */
		MSR() {}

		//---------------------------------------------------------------------
		// Class methods
		//

		/** @return the unique instance of this class (create if necessary) */
		public static DevCat getInstance()
		{
			if( instance == null )
				instance = new JposDevCats.MSR();

			return instance;
		}

		//---------------------------------------------------------------------
		// Public methods
		//

		/** @return the String representation of this DevCat */
		public String toString() { return "MSR"; }

		/**
		 * Accepts a DevCat Visitor object
		 * @param visitor the DevCat Visitor object
		 */
		public void accept( DevCatVisitor visitor ) 
		{ visitor.visitMSR( this ); }

		//---------------------------------------------------------------------
		// Class instance
		//

		private static DevCat instance = null;
	}

	/**
	 * Defines the DevCat for Pinpad
	 * @since 1.3 (SF 2K meeting)
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 */
	public static class Pinpad extends AbstractDevCat implements DevCat 
	{
		//---------------------------------------------------------------------
		// Ctor(s)
		//

		/** Make ctor package to avoid ctor */
		Pinpad() {}

		//---------------------------------------------------------------------
		// Class methods
		//

		/** @return the unique instance of this class (create if necessary) */
		public static DevCat getInstance()
		{
			if( instance == null )
				instance = new JposDevCats.Pinpad();

			return instance;
		}

		//---------------------------------------------------------------------
		// Public methods
		//

		/** @return the String representation of this DevCat */
		public String toString() { return "Pinpad"; }

		/**
		 * Accepts a DevCat Visitor object
		 * @param visitor the DevCat Visitor object
		 */
		public void accept( DevCatVisitor visitor ) 
		{ visitor.visitPinpad( this ); }

		//---------------------------------------------------------------------
		// Class instance
		//

		private static DevCat instance = null;
	}

	/**
	 * Defines the DevCat for POSKeyboard
	 * @since 1.3 (SF 2K meeting)
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 */
	public static class POSKeyboard extends AbstractDevCat implements DevCat 
	{
		//---------------------------------------------------------------------
		// Ctor(s)
		//

		/** Make ctor package to avoid ctor */
		POSKeyboard() {}

		//---------------------------------------------------------------------
		// Class methods
		//

		/** @return the unique instance of this class (create if necessary) */
		public static DevCat getInstance()
		{
			if( instance == null )
				instance = new JposDevCats.POSKeyboard();

			return instance;
		}

		//---------------------------------------------------------------------
		// Public methods
		//

		/** @return the String representation of this DevCat */
		public String toString() { return "POSKeyboard"; }

		/**
		 * Accepts a DevCat Visitor object
		 * @param visitor the DevCat Visitor object
		 */
		public void accept( DevCatVisitor visitor ) 
		{ visitor.visitPOSKeyboard( this ); }

		//---------------------------------------------------------------------
		// Class instance
		//

		private static DevCat instance = null;
	}

	/**
	 * Defines the DevCat for POSPower
	 * @since 1.3 (SF 2K meeting)
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 */
	public static class POSPower extends AbstractDevCat implements DevCat 
	{
		//---------------------------------------------------------------------
		// Ctor(s)
		//

		/** Make ctor package to avoid ctor */
		POSPower() {}

		//---------------------------------------------------------------------
		// Class methods
		//

		/** @return the unique instance of this class (create if necessary) */
		public static DevCat getInstance()
		{
			if( instance == null )
				instance = new JposDevCats.POSPower();

			return instance;
		}

		//---------------------------------------------------------------------
		// Public methods
		//

		/** @return the String representation of this DevCat */
		public String toString() { return "POSPower"; }

		/**
		 * Accepts a DevCat Visitor object
		 * @param visitor the DevCat Visitor object
		 */
		public void accept( DevCatVisitor visitor ) 
		{ visitor.visitPOSPower( this ); }

		//---------------------------------------------------------------------
		// Class instance
		//

		private static DevCat instance = null;
	}

	/**
	 * Defines the DevCat for POSPrinter
	 * @since 1.3 (SF 2K meeting)
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 */
	public static class POSPrinter extends AbstractDevCat implements DevCat 
	{
		//---------------------------------------------------------------------
		// Ctor(s)
		//

		/** Make ctor package to avoid ctor */
		POSPrinter() {}

		//---------------------------------------------------------------------
		// Class methods
		//

		/** @return the unique instance of this class (create if necessary) */
		public static DevCat getInstance()
		{
			if( instance == null )
				instance = new JposDevCats.POSPrinter();

			return instance;
		}

		//---------------------------------------------------------------------
		// Public methods
		//

		/** @return the String representation of this DevCat */
		public String toString() { return "POSPrinter"; }

		/**
		 * Accepts a DevCat Visitor object
		 * @param visitor the DevCat Visitor object
		 */
		public void accept( DevCatVisitor visitor ) 
		{ visitor.visitPOSPrinter( this ); }

		//---------------------------------------------------------------------
		// Class instance
		//

		private static DevCat instance = null;
	}

	/**
	 * Defines the DevCat for RemoteOrderDisplay
	 * @since 1.3 (SF 2K meeting)
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 */
	public static class RemoteOrderDisplay extends AbstractDevCat 
											 implements DevCat 
	{
		//---------------------------------------------------------------------
		// Ctor(s)
		//

		/** Make ctor package to avoid ctor */
		RemoteOrderDisplay() {}

		//---------------------------------------------------------------------
		// Class methods
		//

		/** @return the unique instance of this class (create if necessary) */
		public static DevCat getInstance()
		{
			if( instance == null )
				instance = new JposDevCats.RemoteOrderDisplay();

			return instance;
		}

		//---------------------------------------------------------------------
		// Public methods
		//

		/** @return the String representation of this DevCat */
		public String toString() { return "RemoteOrderDisplay"; }

		/**
		 * Accepts a DevCat Visitor object
		 * @param visitor the DevCat Visitor object
		 */
		public void accept( DevCatVisitor visitor ) 
		{ visitor.visitRemoteOrderDisplay( this ); }

		//---------------------------------------------------------------------
		// Class instance
		//

		private static DevCat instance = null;
	}

	/**
	 * Defines the DevCat for Scanner
	 * @since 1.3 (SF 2K meeting)
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 */
	public static class Scanner extends AbstractDevCat implements DevCat 
	{
		//---------------------------------------------------------------------
		// Ctor(s)
		//

		/** Make ctor package to avoid ctor */
		Scanner() {}

		//---------------------------------------------------------------------
		// Class methods
		//

		/** @return the unique instance of this class (create if necessary) */
		public static DevCat getInstance()
		{
			if( instance == null )
				instance = new JposDevCats.Scanner();

			return instance;
		}

		//---------------------------------------------------------------------
        // Public methods                                                            
		//

		/** @return the String representation of this DevCat */
		public String toString() { return "Scanner"; }

		/**
		 * Accepts a DevCat Visitor object
		 * @param visitor the DevCat Visitor object
		 */
		public void accept( DevCatVisitor visitor ) 
		{ visitor.visitScanner( this ); }

		//---------------------------------------------------------------------
		// Class instance
		//

		private static DevCat instance = null;
	}

	/**
	 * Defines the DevCat for SignatureCapture
	 * @since 1.3 (SF 2K meeting)
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 */
	public static class SignatureCapture extends AbstractDevCat 
										   implements DevCat 
	{
		//---------------------------------------------------------------------
		// Ctor(s)
		//

		/** Make ctor package to avoid ctor */
		SignatureCapture() {}

		//---------------------------------------------------------------------
		// Class methods
		//

		/** @return the unique instance of this class (create if necessary) */
		public static DevCat getInstance()
		{
			if( instance == null )
				instance = new JposDevCats.SignatureCapture();

			return instance;
		}

		//---------------------------------------------------------------------
		// Public methods
		//

		/** @return the String representation of this DevCat */
		public String toString() { return "SignatureCapture"; }

		/**
		 * Accepts a DevCat Visitor object
		 * @param visitor the DevCat Visitor object
		 */
		public void accept( DevCatVisitor visitor ) 
		{ visitor.visitSignatureCapture( this ); }

		//---------------------------------------------------------------------
		// Class instance
		//

		private static DevCat instance = null;
	}

	/**
	 * Defines the DevCat for Scale
	 * @since 2.1
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 */
	public static class Scale extends AbstractDevCat implements DevCat 
	{
		//---------------------------------------------------------------------
		// Ctor(s)
		//

		/** Make ctor package to avoid ctor */
		Scale() {}

		//---------------------------------------------------------------------
		// Class methods
		//

		/** @return the unique instance of this class (create if necessary) */
		public static DevCat getInstance()
		{
			if( instance == null )
				instance = new JposDevCats.Scale();

			return instance;
		}

		//---------------------------------------------------------------------
		// Public methods
		//

		/** @return the String representation of this DevCat */
		public String toString() { return "Scale"; }

		/**
		 * Accepts a DevCat Visitor object
		 * @param visitor the DevCat Visitor object
		 */
		public void accept( DevCatVisitor visitor ) 
		{ visitor.visitScale( this ); }

		//---------------------------------------------------------------------
		// Class instance
		//

		private static DevCat instance = null;
	}

	/**
	 * Defines the DevCat for ToneIndicator
	 * @since 1.3 (SF 2K meeting)
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 */
	public static class ToneIndicator extends AbstractDevCat 
										implements DevCat 
	{
		//---------------------------------------------------------------------
		// Ctor(s)
		//

		/** Make ctor package to avoid ctor */
		ToneIndicator() {}

		//---------------------------------------------------------------------
		// Class methods
		//

		/** @return the unique instance of this class (create if necessary) */
		public static DevCat getInstance()
		{
			if( instance == null )
				instance = new JposDevCats.ToneIndicator();

			return instance;
		}

		//---------------------------------------------------------------------
		// Public methods
		//

		/** @return the String representation of this DevCat */
		public String toString() { return "ToneIndicator"; }

		/**
		 * Accepts a DevCat Visitor object
		 * @param visitor the DevCat Visitor object
		 */
		public void accept( DevCatVisitor visitor ) 
		{ visitor.visitToneIndicator( this ); }

		//---------------------------------------------------------------------
		// Class instance
		//

		private static DevCat instance = null;
	}
	
	/**
	 * Defines the DevCat for PointCardRW
	 * @since 1.3 (SF 2K meeting)
	 * @author E. Michael Maximilien (maxim@us.ibm.com)
	 */
	public static class PointCardRW extends AbstractDevCat 
	                                            implements DevCat 
	{
		//---------------------------------------------------------------------
		// Ctor(s)
		//

		/** Make ctor package to avoid ctor */
		PointCardRW() {}

		//---------------------------------------------------------------------
		// Class methods
		//

		/** @return the unique instance of this class (create if necessary) */
		public static DevCat getInstance()
		{
			if( instance == null )
				instance = new JposDevCats.PointCardRW();

			return instance;
		}

		//---------------------------------------------------------------------
		// Public methods
		//

		/** @return the String representation of this DevCat */
		public String toString() { return "PointCardRW"; }

		/**
		 * Accepts a DevCat Visitor object
		 * @param visitor the DevCat Visitor object
		 */
		public void accept( DevCatVisitor visitor ) 
		{ visitor.visitPointCardRW( this ); }

		//---------------------------------------------------------------------
		// Class instance
		//

		private static DevCat instance = null;
	}	
}