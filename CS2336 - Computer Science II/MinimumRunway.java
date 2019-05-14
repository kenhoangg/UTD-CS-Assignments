/**
 * @author Kenny Hoang (kth140230)
 * Professor Anjum Chida
 * CS2336.001
 * Date: 8/29/2016
 */

import java.util.Scanner;
        
public class MinimumRunway {
    
    public static void main(String[] args) {
        double velocity, acceleration, runwayLength;
        
        // Prompt user to input speed and acceleration
        System.out.print("Enter the speed and acceleration: ");
        
        // Create Scanner object
        Scanner input = new Scanner(System.in);
        
        // Scanner object reads in next two doubles as velocity and acceleration
        velocity = input.nextDouble();
        acceleration = input.nextDouble();
        
        // Calculate runway length using formula length = v^2 / 2a
        runwayLength = Math.pow(velocity, 2) / (2 * acceleration);
                
        System.out.printf("The minimum runway length for this airplane is %.3f", runwayLength);
        System.out.println();
        input.close();
    }
}
