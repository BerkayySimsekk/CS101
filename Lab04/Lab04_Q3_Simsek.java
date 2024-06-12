package Lab04;
import java.util.Scanner;

public class Lab04_Q3_Simsek 
{
    public static void main(String[] args) 
    {
        //Variables
        String word;
        String initialWord;
        char letter;
        boolean isPair;
        int firstCursor;
        int secondCursor;
        int letterCounter;

        //Creating a scanner object
        Scanner in = new Scanner(System.in);

        //Using the scanner object to get input
        System.out.print("Enter a word: ");
        word = in.next();

        //The program is not case-sensitive so all of the letters of the inital word are turned into lower case
        initialWord = word;
        word = word.toLowerCase();

        //Initiliazing the variables that will be used in the next loop
        firstCursor = 0;
        secondCursor = 0;
        letterCounter = 0;
        isPair = true;

        //A while loop which initializes variables that are the letters of the word 
        while(firstCursor < word.length())
        {
            letter = word.charAt(firstCursor);

            //A while loop which checks how many times the previously initialized variable(the letters of the word) is used in the word 
            while(secondCursor < word.length())
            {
                if(word.charAt(secondCursor) == letter)
                {
                    letterCounter++;
                }
                
                secondCursor++;
            }
            
            //If the letter is used more or less than 2 times, the word is not pair
            if(letterCounter != 2)
            {
                isPair = false;
            }

            //Resetting the variables
            letterCounter = 0;
            secondCursor = 0;

            firstCursor++;
        }

        if(isPair)
        {
            System.out.println(initialWord + " is a pair-word!");
        }
        else
        {
            System.out.println(initialWord + " is not a pair-word!");
        }

        in.close();
    }    
}
