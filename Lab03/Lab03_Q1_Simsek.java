package Lab03;
import java.util.Scanner;

public class Lab03_Q1_Simsek 
{
    public static void main(String[] args)
    {
        //Variables
        int firstNumber;
        int secondNumber;
        int initialFirstNumber;
        int initialSecondNumber;
        int sum;

        Scanner in = new Scanner(System.in);

        //Getting input for the numbers
        System.out.print("Enter 2 numbers: ");
        firstNumber = in.nextInt();
        secondNumber = in.nextInt();

        //Keeping track of the first unchanged numbers to print them out later
        initialFirstNumber = firstNumber;
        initialSecondNumber = secondNumber;

        //Rounding the first value to the multiple of 10
        if(firstNumber % 10 < 5)
        {
            firstNumber = firstNumber / 10 * 10;
        }
        else
        {
            firstNumber = (firstNumber / 10 + 1) * 10;
        }
        
        //Rounding the second value to the multiple of 10 if the rounded value of the first number is not divisible by 3
        if(firstNumber % 3 != 0)
        {
            if(secondNumber % 10 < 5)
            {
                secondNumber = secondNumber / 10 * 10;
            }
            else
            {
                secondNumber = (secondNumber / 10 + 1) * 10;
            }
        }

        sum = firstNumber + secondNumber;

        System.out.print("The sum of rounded values of " + initialFirstNumber + " and " + initialSecondNumber + ": " + sum);

        in.close();
    }    
}
