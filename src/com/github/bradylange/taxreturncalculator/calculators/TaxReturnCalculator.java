/*
 * Developer: Brady Lange
 * Course: CSIS 161 - Programming I
 * Institution: University of Wisconsin-River Falls
 * Class: TaxReturnCalculator
 * Development Language: Java
 * Copyright Notice: MIT License, Copyright (c) 2019 Brady Lange
 */

package com.github.bradylange.taxreturncalculator.calculators;

// Import util library - console scanner
import java.util.Scanner;

/**
 * <p>
 * 		Calculates the bill of a tax return service.
 * 		Contains the {@link #main} method which instantiates and sets up the 
 * 		program.
 * </p>
 *
 * @author  Brady Lange - <a href = "https://www.linkedin.com/in/brady-lange/" 
 *                           target = "_blank">LinkedIn</a>
 * @version  1.0.1, 01/08/2019
 * @since  1.0, 12/15/2016
 */
public class TaxReturnCalculator
{ 
	// ------------------------------------------------------------------------
	// Instance Variables
	// ------------------------------------------------------------------------
	/**
	 * Console scanner. <br>
	 * (Variable is kept in memory)
	 */
	static Scanner console = new Scanner(System.in); 			
	/**
	 * Proceed with the program. <br>
	 * (Variable never changes and is kept in memory)
	 */
	static final String CONTINUE = "continue"; 	
	/**
	 * End the program.
	 * (Variable never changes and is kept in memory)
	 */
	static final String STOP = "stop"; 	
	
	// ========================================================================
	// Main Method
	// ========================================================================
	/**
	 * Instantiates and sets up the program using the methods
	 * {@link #printGreeting}, {@link #printOutput}, 
	 * {@link #printBye}, {@link #getOption}, {@link #getIncome},
	 * {@link #getRate}, {@link #getConsultingTime}, and {@link #getBilling}.
	 * 
	 * @param args  the array of command line arguments to be passed
	 * 
	 * @version  1.0.1, 01/08/2019
	 * @since  1.0, 12/15/2016
	 */
	public static void main(String[] args) 
	{ 
		// Yearly income
		double yearlyIncome = 0;
		// Consulting time 
		double consultTime = 0;	
		// Hourly pay rate
		double hourlyRate = 0;	
		// Billing total
		double billing = 0; 
		// Input of 'continue' or 'stop'
		String input = "";											
		
		System.out.println("************************************************");
		System.out.println("Tax Return Service Calculator:");
		System.out.println("************************************************");
		// Print greeting message
		printGreeting(); 	
		// Ask and retrieve continuation status
		input = getOption();								
		
		// Continue until input is 'stop'
		while (input.equalsIgnoreCase(CONTINUE)) 							
		{ 
			// Ask and retrieve yearly income
			yearlyIncome = getIncome();	
			// Ask and retrieve hourly rate
			hourlyRate = getRate();	
			// Ask and retrieve consulting time used
			consultTime = getConsultingTime();	
			// Calculate the billing amount
			billing = getBilling(yearlyIncome, hourlyRate, consultTime);	
			System.out.println("\n******************************************");
			System.out.println("Tax Return Service Bill Summary:");
			System.out.println("*******************************************");
			// Print tax return bill
			printOutput(yearlyIncome, hourlyRate, consultTime, billing);	
			System.out.println("******************************************\n");
			// Ask and retrieve continuation status
			input = getOption(); 							
		} 	
		// End the program when input is 'stop'
		if (input.equalsIgnoreCase(STOP))								
		{
			// Print goodbye message
			printBye();									
		}
		// Invalid input 
		else 														
		{
			System.out.println("There has been an error with what you have " 
			                   + "typed. Sorry please try again!");
		}
	} 
	
	// ========================================================================
	// Print Greeting Method
	// ========================================================================
	/**
	 * Prints a greeting message.
	 * 
	 * @version  1.0.1, 01/08/2019
	 * @since  1.0, 12/15/2016
	 */
	public static void printGreeting() 
	{ 
		// Entry statement of program 
		System.out.println("Hello there valued customer! Welcome to B & L "
	                       + "Accounting.\nWe are glad you chose us to help "
	                       + "you with your tax returns!");
		// Return nothing
		return;														
	} 
	
	// ========================================================================
	// Print Output Method
	// ========================================================================
	/**
	 * Prints the final calculated tax return service bill and data of the 
	 * customer.
	 * 
	 * @param yrIncome  the yearly rate of monetary income
	 * @param hrRate  the hourly rate of monetary income
	 * @param conTime  the consulting time in minutes
	 * @param bill  the service bill
	 * 
	 * @version  1.0.1, 01/08/2019
	 * @since  1.0, 12/15/2016
	 */
	public static void printOutput(double yrIncome, double hrRate, 
	                               double conTime, double bill) 
	{ 
		// Format bill to two decimal places 
		String billFrm = String.format("%.2f", bill);		
		// Format yearly income to two decimal places
		String incomeFrm = String.format("%.2f", yrIncome);
		// Format hourly wage to decimal places
		String rateFrm = String.format("%.2f", hrRate);			
		
		// Print billing and customer information
		System.out.println("Your billing amount is $" + billFrm);
		System.out.println("Based off of making $" + incomeFrm + " with " 
		                   + conTime + " minutes of help and rate of $" 
		                   + rateFrm + " per hour.");
		// Return nothing
		return; 													
	} 
	
	// ========================================================================
	// Print Bye Method
	// ========================================================================
	/**
	 * Prints a goodbye message.
	 * 
	 * @version  1.0.1, 01/08/2019
	 * @since  1.0, 12/15/2016
	 */
	public static void printBye() 
	{ 
		// Exit statement for program 
		System.out.println("Thank you for using B & L Accounting Firm."	
		                   + " I hope you liked our service. "
		                   + "Please come again, good bye!");
		// Return nothing
		return; 																											
	} 
	
	// ========================================================================
	// Get Option Method
	// ========================================================================
	/**
	 * Asks the customer for their continuation status and returns their input.
	 * 
	 * @return  the String 'Continue' or 'Stop'
	 * 
	 * @version  1.0.1, 01/08/2019
	 * @since  1.0, 12/15/2016
	 */
	public static String getOption() 
	{
		// Ask for input of 'continue' or 'stop'
		System.out.print("Would you like to continue or stop? ");	
		// Retrieve 'continue' or 'stop' input
		String input = console.next();	
		// Return 'continue' or 'stop' input
		return input; 												 
	} 
	
	// ========================================================================
	// Get Income Method
	// ========================================================================
	/**
	 * Asks the customer for their yearly income and returns their input.
	 * 
	 * @return  the yearly rate of monetary income
	 * 
	 * @version  1.0.1, 01/08/2019
	 * @since  1.0, 12/15/2016
	 */
	public static double getIncome() 
	{ 										
		// Ask for yearly income
		System.out.print("What is your yearly income? ");		
		// Retrieve yearly income
		double yearlyIncome = console.nextDouble();	
		// Return yearly income
		return yearlyIncome;										
	} 
	
	// ========================================================================
	// Get Rate Method
	// ========================================================================
	/**
	 * Asks the customer for their hourly rate of income and returns their 
	 * input.
	 * 
	 * @return  the hourly rate of monetary income
	 * 
	 * @version  1.0.1, 01/08/2019
	 * @since  1.0, 12/15/2016
	 */
	public static double getRate() 
	{ 										
		// Ask for hourly income 
		System.out.print("What is your hourly rate? ");		
		// Retrieve hourly income 
		double hourlyRate = console.nextDouble();
		// Return hourly income
		return hourlyRate;											
	} 
	
	// ========================================================================
	// Get Consulting Time Method
	// ========================================================================
	/**
	 * Asks the customer for their amount of consulting time they used and 
	 * returns their input.
	 * 
	 * @return  the consulting time in minutes
	 * 
	 * @version  1.0.1, 01/08/2019
	 * @since  1.0, 12/15/2016
	 */
	public static double getConsultingTime() 
	{ 										
		// Ask for consulting time
		System.out.print("How much consulting time in minutes did you need? ");	
		// Retrieve consulting time 
		double consultTime = console.nextDouble();
		// Return consulting time
		return consultTime;																								
	} 
	
	// ========================================================================
	// Get Billing Method
	// ========================================================================
	/**
	 * Calculates and returns the customer's tax return service bill.
	 * 
	 * @param yrIncome  the yearly rate of monetary income
	 * @param hrRate  the hourly rate of monetary income
	 * @param conTime  the consulting time in minutes
	 * 
	 * @return  Service bill
	 * 
	 * @version  1.0.1, 01/08/2019
	 * @since  1.0, 12/15/2016
	 */
	public static double getBilling(double yrIncome, double hrRate, 
									double conTime) 
	{ 
		// Tax return service billing amount
		double bill = 0;
		
		// Yearly income greater than $25,000 and consulting time less than 
		// 30 minutes
		if (yrIncome <= 25000 && conTime <= 30)						
		{		
			// No charge
			bill = 0;												 
		}
		// Yearly income less than $25,000 and consulting time greater than
		// 30 minutes
		else if (yrIncome <= 25000 && conTime > 30)					
		{		
			// Calculate charge
			bill = hrRate * 0.4 * ((conTime - 30) / 60);			
		}
		// Yearly income greater than $25,000 and consulting time less than 
		// or equal to 20 minutes
		else if (yrIncome > 25000 && conTime <= 20)					
		{		
			// No charge
			bill = 0;												
		}
		// Yearly income greater than $25,000 and consulting time greater 
		// than 20 minutes
		else if (yrIncome > 25000 && conTime > 20)					
		{					
			// Calculate charge 
			bill = hrRate * 0.7 * ((conTime - 20) / 60);			
		}
		// Return tax return service bill
		return bill;												
	} 
}