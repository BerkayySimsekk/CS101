package Lab03;
import java.util.Scanner;

public class Lab03_Q3_Simsek 
{
    public static void main(String[] args)
    {
        //Variables
        String sentence;
        int sentenceLength;
        int inputValue;

        Scanner in = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        sentence = in.nextLine();

        //Getting the length first, so that we can check the last index later
        sentenceLength = sentence.length();
        //Removing possible whitespaces
        sentence = sentence.replaceAll(" ", "");

        //Checking if the last index of the sentence after its whitespaces are removed is non-alphabetic
        if(!Character.isLetter(sentence.charAt(sentenceLength - 1)))
        {
            //Removing the non-alphabetic part of the string
            sentence = sentence.substring(0, sentenceLength - 1);
            //Getting the changed length again
            sentenceLength = sentence.length();
        }

        System.out.print("Enter an integer value between 1 and " + sentenceLength + ": ");

        //Checking if the value is integer
        if(in.hasNextInt())
        {
            inputValue = in.nextInt();

            //Checking if the value is longer than the length of the sentence
            if(inputValue > sentenceLength)
            {
               System.out.print("Error - value must be between 1 and " + sentenceLength);
            }
            else
            {
                //Checking if the first and last "n" number of characters are the same, n represents "inputValue"
                if(sentence.substring(0, inputValue).equals(sentence.substring(sentenceLength - inputValue)))
                {
                    System.out.print("First and last " + inputValue + " characters are the same");
                }
                else
                {
                    System.out.print("First and last " + inputValue + " characters are not the same");
                }
            }
        
        } 
        else
        {   
            System.out.print("Error - value must be an integer");   
        }
        
        in.close();
    }
}
