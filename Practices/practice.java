package Practices;
import java.util.Scanner;

public class practice 
{
    public static void main(String[] args)
    {
        //Variables
        int choice;
        int counter;
        int randomIndexForSpace;
        int randomDigit;
        int randomIndexForDigit;
        String inputWord;
        String decodedWord;
        String renewedInputWord;

        Scanner in = new Scanner(System.in);

        //Assigning "choice" to zero to enter the loop, assigning the empty strings in case the user decides to choose "Decode message" directly
        choice = 0;
        inputWord = "";
        decodedWord = "";

        while(choice != 3)
        {
            System.out.println("");
            System.out.println("1) Encode message\n2) Decode message\n3) Quit");
            System.out.print("Enter choice: ");
            choice = in.nextInt();

            //Encoding message
            if(choice == 1)
            {
                System.out.println("");
                System.out.print("Enter word to encode: ");
                inputWord = in.next();

                //Making sure the word is longer than or equal to "2" in terms of length
                while(inputWord.length() < 2)
                {
                    System.out.println("Invalid length word - try again");
                    System.out.println("");
                    System.out.print("Enter word to encode: ");
                    inputWord = in.next();
                }

                //A counter to stop the loop after "n" many times random digits are inserted, "n" meaning the length of the word
                counter = 0;
                //Creating a new modifiable variable to proceed with the "encoding" process
                renewedInputWord = inputWord;
                //Keeping track of the initial input word.
                decodedWord = inputWord;

                //Adding random digits to random places
                while(counter < decodedWord.length())
                {
                    randomDigit =(int)(Math.random() * 10);
                    randomIndexForDigit = (int)(Math.random() * inputWord.length());
                    inputWord = renewedInputWord.substring(0, randomIndexForDigit) + randomDigit + renewedInputWord.substring(randomIndexForDigit);
                    renewedInputWord = inputWord;
                    counter++;
                }

                //Adding random space
                randomIndexForSpace = (int)(Math.random() * inputWord.length());
                inputWord = renewedInputWord.substring(0, randomIndexForSpace) + " " + renewedInputWord.substring(randomIndexForSpace);
                renewedInputWord = inputWord;

                //Inversing the parts divided by space
                inputWord = renewedInputWord.substring(randomIndexForSpace + 1) + " " + renewedInputWord.substring(0, randomIndexForSpace);

                //Printing the finalized version
                System.out.println("The encoded message is: " + inputWord);
            }
            //Decoding message
            else if(choice == 2)
            {
                if(inputWord.equals(""))
                {
                    System.out.println("No message to decode...");
                }
                else
                {
                    System.out.println("The decoded message is: " + decodedWord);
                }
            }
            //Making sure user input is valid
            else if(choice != 3)
            {
                System.out.println("Invalid choice - try again ...");
            }
        }

        System.out.println("Thank you, goodbye!");

        in.close();
    }    
}
