/**************************************************************************************************/
/* 
 *  ############################### MUST READ #############################################
 *  
 * DO NOT ADD NEW PACKAGES OR MODIFY THE EXISTING PACKAGE DECLARATIONS
 * 
 * DO NOT CREATE DEPENDENT CLASSES
 * 
 * DO NOT CHANGE THE VISIBILITY / ACCESS SPECIFIERS OF THE CLASSES
 * 
 * DO NOT DELETE THE EHMSMain.java UNDER DEFAULT PACKAGE; DO NOT DELETE THE MAIN METHOD UNDER THIS CLASS
 * 
 * YOU CAN TEST YOUR APPLICATION FROM THIS MAIN METHOD 
 * 
 * DO NOT DELETE:
 * 		EmergeHMSConfig.java
 * 		applicationcontext.xml
 * 
 * DO NOT MODIFY or DELETE:
 * 		mysql.properties
 * 		emergeBenefits.properties
 * 
 * DO NOT CREATE ANY NEW PACKAGES OR MODIFY ANY PACKAGE NAMES
 *  
 * DO NOT MODIFY: 
 * 		ACCESS SPECIFIERS, RETURN TYPES OR DATA TYPES, EXCEPTION CLAUSES, PACKAGE NAMES,
 * 	    CLASS OR METHOD NAMES IN THE SKELETON
 * 
 * CONFIGURE YOUR DATABASE BY RUNNING THE EHMS_DBSCRIPT.BAT AVAILABLE INSIDE SKELETON FILE
 * PATH: /DBSCRIPTS/EHMS_DBSCRIPT.BAT. Open the location in Windows explorer and double click the .BAT file. * 
 * PLEASE NOTE, .SQL FILE MUST RESIDE IN THE SAME PATH WHERE THE .BAT FILE RESIDES.
 *  
 *  IF YOU WANT TO CONFIGURE BEANS IN XML WAYS, USE ONLY applicationcontext.xml
 *  
 *  IF YOU WANT TO CONFIGURE BEANS USING ANNOTATIONS, configure in EmergeHMSConfig.java 
 *  (inside the package com.spring.healthcare.config). 
 *  
 *  YOU CAN CONFIGURE BEANS IN BOTH XML AND ANNOTATION WAYS FOR ANY REQUIREMENT
 *  
 *  YOU MUST CODE ON THE SAME PROJECT MAPPED IN EBOX VIEW THROUGHOUT THE ASSESSMENT
 *  CLICK ON 'Preview Saved Project' BUTTON TO SEE THE PROJECT SAVED IN EBOX
 *  
 *  YOU MUST CLICK ON 'SAVE PROJECT' BUTTON EVERY 10 MINUTES TO PERIODICALLY SAVE 
 *  CTRL + S ALONE, WILL NOT BE SUFFICIENT TO SAVE YOUR CODE IN EBOX
 *  CLICKING ON 'SAVE PROJECT' ENSURES NO LOSS OF CODE 
 * 
 *  REACH OUT TO PROCTORS FOR ANY QUERIES
 *  
 * Skeleton Version 2.0
 * Date Modified: 11-Oct-2016 
 */
/*************************************************************************************************/

package com.iup.exception;

/*
 * NoDataFoundException will be raised when the user provides an invalid data
 * 
 */
public class NoDataFoundException extends Exception {

	private static final long serialVersionUID = 3639259170454508160L;

	/**
	 * @param message
	 */
	public NoDataFoundException(String message) {
		super(message);
	}

}
