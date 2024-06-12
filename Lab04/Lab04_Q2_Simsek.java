package Lab04;
import java.util.Scanner;

public class Lab04_Q2_Simsek 
{
    public static void main(String[] args) 
    {
        //Constants
        final double COEFFICIENT_OF_TENNIS_BALL = 0.7;
        final double COEFFICIENT_OF_BASKETBALL = 0.75;
        final double COEFFICIENT_OF_SUPERBALL = 0.9;
        final double COEFFICIENT_OF_SOFTBALL = 0.3;

        //Variables
        String ballType;
        int bounceCounter;
        double height;
        double coefficient;
        double metersTravelled;

        //Creating a scanner object
        Scanner in = new Scanner(System.in);

        //Using the scanner object to get input for the ball type
        System.out.print("Enter ball type: ");
        ballType = in.nextLine();

        //Determining the coefficient
        if(ballType.equals("Tennis Ball"))
        {
            coefficient = COEFFICIENT_OF_TENNIS_BALL;
        }
        else if(ballType.equals("Basketball"))
        {
            coefficient = COEFFICIENT_OF_BASKETBALL;
        }
        else if(ballType.equals("Superball"))
        {
            coefficient = COEFFICIENT_OF_SUPERBALL;
        }
        else if(ballType.equals("Softball"))
        {
            coefficient = COEFFICIENT_OF_SOFTBALL;
        }
        else
        {
            coefficient = 0;
        }

        //Checking if the ball type is valid
        if(coefficient == 0)
        {
            System.out.println("Invalid Ball Type - Exiting...");
        }
        else
        {
            //to avoid the complaint given by java "variable might not have been initiliazed"
            height = 0;

            //Checking if the given height is valid
            System.out.print("Enter initial height(m): ");
            while(!in.hasNextDouble())
            {
                System.out.println("Height must be a numeric value...");
                in.next();
                System.out.print("Enter initial height(m): ");
            }
            height = in.nextDouble();

            bounceCounter = 0;
            metersTravelled = 0;

            //Finding the number of bounces and total amount of distance travelled while height is greater than 10 centimeters
            while(height >= 0.1)
            {
                bounceCounter++;
                metersTravelled += height;
                height *= coefficient;
            }

            System.out.println("Number of bounces: " + bounceCounter);
            System.out.printf("Meters travelled: %.2f", metersTravelled);
        }

        in.close();
    }    
}
