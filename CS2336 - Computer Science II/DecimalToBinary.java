/**
 *	@author Kenny Hoang
 *	Class: CS2336 - Computer Science II
 *	Section: 001	
 *	Semester: Fall 2016
 *
 *	Assignment: Assignment 3 - Decimal to Binary
 *	Program Description: This program receives a decimal integer as input 
 *	from the console and converts the number to binary and prints the binary number.
 **/

//	Import statements
import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		
		int dec = 0;
		String posBinary = "", negBinary = "", tempStr = "";;
		Scanner input = new Scanner(System.in);
		
		boolean decInput = true;
		do{
			System.out.print("Please enter a decimal integer: ");
			while(!input.hasNextInt()){
				String str = input.nextLine();
				System.out.printf("%s is not valid input. Please enter a decimal integer: ", str);
			}
			if(input.hasNextInt())
			{
				dec = input.nextInt();
				input.nextLine();
				decInput = false;
			}
		}while(decInput); // end do-while
		
		int temp = dec;
		
		boolean isNeg = false;
		if(temp < 0){
			temp = temp * -1;
			isNeg = true;
		}
		while(temp != 0){
			posBinary = temp % 2 + posBinary;
			temp = temp / 2;
		}// end while converting positive decimal integer into binary form
		
		int carry = 1;
		String twosComp = "0";
		if(isNeg){
			// For-loop to do one's complement
			for(int i = 0; i < posBinary.length(); i++){
				if(posBinary.charAt(i) == '0')
					tempStr += "1";
				if(posBinary.charAt(i) == '1')
					tempStr += "0";
			}
			if(tempStr.charAt(tempStr.length() - 1) == '0'){ // Odd negative decimal to binary (add 1 to lowest order bit 2^0)
				negBinary += "1";
				negBinary += tempStr.substring(0, tempStr.length() - 1) + "1";
			}
			else if(tempStr.charAt(tempStr.length() - 1) == '1'){
				boolean check = false;
				int j = tempStr.length() - 2, index = 0, count = 1;
				while(!check){
					if(tempStr.charAt(j - index) == '0' && carry == 1){
						twosComp += "1";
						carry = 0;
						for(int k = j - count; k >= 0; k--){
							index++;
							twosComp += tempStr.charAt(k);
						}
						check = true;
					}
					else if(tempStr.charAt(j - index) == '1' && carry == 1){
						twosComp += "0";
						index++;
						count++;
					}
					else if(tempStr.charAt(j - index) == '0' && carry == 0){
						for(int l = j - index; l >= 0; l--)
							twosComp += tempStr.charAt(l);
						
						check = true;
					}
				}
				// Adding 1 for the negative sign bit
				twosComp += "1";
			}
				// Reversing the binary string for output
				if(negBinary.isEmpty())
					for(int m = twosComp.length() - 1; m >= 0; m--)
						negBinary += twosComp.charAt(m);
		}
		if(!isNeg)
			System.out.printf("The binary form of %d is %s.", dec, posBinary);
		else
			System.out.printf("The binary form of %d is %s.", dec, negBinary);
		input.close();
	}// end main
}
