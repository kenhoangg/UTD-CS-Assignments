/**
 *	@author Kenny Hoang
 *	Class: CS2336 - Computer Science II
 *	Section: 001	
 *	Semester: Fall 2016
 *
 *	Assignment: Homework 2
 *	Program Description: This program calculates and displays the name 
 *	of the day of the week given the year, month, and day of the month.
 **/

//	Import statements
import java.util.Scanner;


public class DayOfWeek
{
	public static void main(String [] args)
	{
		int year = 0, month = 0, day = 0, numInWeek = 0;
		Scanner input = new Scanner(System.in);
		// For input validation use Scanner class hasNextXXX methods with if loop
		// Input validation for year entered
		do
		{
			System.out.print("Enter year: (e.g., 2008): ");
			while(!input.hasNextInt())
			{
				String str = input.nextLine();
				System.out.printf("%s is invalid input! Please enter a year in the form yyyy: ", str);
			}
			if(input.hasNextInt())
			{
				year = input.nextInt();
				input.nextLine();
			}
			year = validYear(year);
		}while(year <= 0);
		
		// Input validation for month
		do
		{
			System.out.print("Enter month: 1-12: ");
			while(!input.hasNextInt())
			{
				String str = input.nextLine();
				System.out.printf("%s is invalid input! Please enter a month 1-12: ", str);
			}
			if(input.hasNextInt())
			{
				month = input.nextInt();
				input.nextLine();
			}
			month = validMonth(month);
		}while(month <= 0 || month > 13);
		
		// Input validation for day of the month
		do
		{
			System.out.print("Enter the day of the month: 1-31: ");
			while(!input.hasNextInt())
			{
				String str = input.nextLine();
				System.out.printf("%s is invalid input! Please enter a day of month 1-31: ", str);
			}
			if(input.hasNextInt())
			{
				day = input.nextInt();
				input.nextLine();
			}
			day = validDayMonth(day, month, year);
		}while(day <= 0 || day > 31);
		
		input.close();
		numInWeek = calcDay(day, month, year);
		printDay(numInWeek);
	}
	
	public static int validYear(int checkYear)
	{
		if(checkYear <= 0)
		{
			System.out.printf("%d is not a valid year.\n", checkYear);
			return -1;
		}
		else
			return checkYear;
	}
	
	public static int validMonth(int checkMonth)
	{
		if(checkMonth <= 0 || checkMonth > 13)
		{
			System.out.printf("%d is not a valid month.\n", checkMonth);
			return -1;
		}
		else
			return checkMonth;
	}
	
	public static int validDayMonth(int checkDayMonth, int checkMonth, int checkYear)
	{
		if((checkMonth == 4) && checkDayMonth > 30)
		{
			System.out.printf("%d is not a valid day of the month. April only has 30 days.\n", checkDayMonth);
			return -1;
		}
		if((checkMonth == 6) && checkDayMonth > 30)
		{
			System.out.printf("%d is not a valid day of the month. June only has 30 days.\n", checkDayMonth);
			return -1;
		}
		if((checkMonth == 9) && checkDayMonth > 30)
		{
			System.out.printf("%d is not a valid day of the month. September only has 30 days.\n", checkDayMonth);
			return -1;
		}
		if((checkMonth == 11) && checkDayMonth > 30)
		{
			System.out.printf("%d is not a valid day of the month. November only has 30 days.\n", checkDayMonth);
			return -1;
		}
		else if(checkMonth == 2)
		{
			System.out.println(isLeapYear(checkYear));
			if(isLeapYear(checkYear) && checkDayMonth > 29)
			{
				System.out.printf("%d is not a valid day of the month. February only has 29 days "
						+ "during leap years.\n", checkDayMonth);
				return -1;
			}
			else if(!isLeapYear(checkYear) & checkDayMonth > 28)
			{
				System.out.printf("%d is not a valid day of the month. February only has 28 days.\n", checkDayMonth);
				return -1;
			}
		}
		
		if(checkDayMonth <= 0 || checkDayMonth > 31)
		{
			System.out.printf("%d is not a valid day of the month.\n", checkDayMonth);
		}
		return checkDayMonth;
	}
	
	public static boolean isLeapYear(int year) 
	{
		  if (year % 4 != 0) 
			  return false;
		  else if (year % 400 == 0) 
			  return true;
		  else if (year % 100 == 0) 
			  return false;
		  else
			  return true;
	}
	
	public static int calcDay(int dayMonth, int numMonth, int numYear)
	{
		int century, yearCentury;
		if(numMonth == 1)
		{
			numMonth = 13;
			--numYear;
		}
		else if(numMonth == 2)
		{
			numMonth = 14;
			--numYear;
		}
		century = numYear / 100;
		yearCentury = numYear % 100;
		return (dayMonth + ((26 * (numMonth + 1)) / 10) + yearCentury + (yearCentury / 4) + (century / 4) + (5 * century)) % 7;
	}
	
	public static void printDay(int numDayWeek)
	{
		String dayString = "";
		switch(numDayWeek)
		{
			case 0:	dayString = "Saturday";
					break;
			case 1: dayString = "Sunday";
					break;
			case 2: dayString = "Monday";
					break;
			case 3: dayString = "Tuesday";
					break;
			case 4: dayString = "Wednesday";
					break;
			case 5: dayString = "Thursday";
					break;
			case 6: dayString = "Friday";
					break;
		}
		System.out.printf("Day of the week is %s \n", dayString);
	}
}