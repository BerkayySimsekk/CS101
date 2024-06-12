package Lab05;
import java.util.Scanner;

public class Lab05_Q1_Simsek 
{
    public static void main(String[] args) 
    {
        //Variables
        String sentence;
        int sum;
        int counter;

        //Scanner object
        Scanner in = new Scanner(System.in);

        //Input for sentence
        System.out.print("Enter a sentence: ");
        sentence = in.nextLine();

        //Default values
        counter = 0;
        sum = 0;

        //Checking each index to find digits and finding the sum of them
        for(int index = 0; index < sentence.length(); index++)
        {
            if(Character.isDigit(sentence.charAt(index)))
            {
                counter++;
                sum += Character.getNumericValue(sentence.charAt(index));
            }
        }

        if(counter > 0)
        {
            System.out.print("The sum of the digits is: " + sum);
        }
        else
        {
            System.out.print("No numeric characters exist in the input string.");
        }

        in.close();
    }
}
