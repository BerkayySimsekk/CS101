package Lab04;
import java.util.Scanner;

public class Lab04_Q1_Simsek 
{
    public static void main(String[] args) 
    {
        //Variables
        String nextWord;
        String previousWord;
        String alphabeticallyFirstword;
        String alphabeticallySecondword;
        int wordCounter;

        //Creating a scanner object
        Scanner in = new Scanner(System.in);

        //Using the scanner object to get input 
        System.out.println("Enter strings (exit to stop): ");
        nextWord = in.next();
        nextWord = nextWord.toLowerCase();

        //Initiliazing the variables
        wordCounter = 0;
        alphabeticallyFirstword = nextWord;
        alphabeticallySecondword = "";

        //Continuing the loop until "exit" is entered
        while(!nextWord.equals("exit"))
        {
            //Keeping track of the previous word and getting next word as an input to check if they are the same so that the counter can be updated
            previousWord = nextWord;
            nextWord = in.next();
            nextWord = nextWord.toLowerCase();

            //Updating the counter if the previous word and the next word are the same
            if(!previousWord.equals(nextWord))
            {
                wordCounter++;
            }
            
            //"Exit" should not be part of the words that are checked alphabetically
            if(!nextWord.equals("exit"))
            {
                //Checking if the next word is alphabetically first
                if(nextWord.compareTo(alphabeticallyFirstword) <= 0)
                {
                    alphabeticallySecondword = alphabeticallyFirstword;
                    alphabeticallyFirstword = nextWord;
                }
                //Checking if the next word is alphabetically second
                else if(nextWord.compareTo(alphabeticallySecondword) <= 0)
                {
                    alphabeticallySecondword = nextWord;
                }
            }
        }

        //If the word counter is less than 2, it means there is not enough input to decide the alphabetical order
        if(wordCounter < 2)
        {
            System.out.print("Not enough input data...");
        }
        else
        {
            System.out.print("String that comes second alphabetically: " + alphabeticallySecondword);
        }

        in.close();
    }    
}
