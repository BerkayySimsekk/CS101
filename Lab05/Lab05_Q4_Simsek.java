package Lab05;
import java.util.Scanner;

public class Lab05_Q4_Simsek 
{
    public static void main(String[] args) 
    {
        //Variables
        int numberOfGuesses;
        int correctDigits;
        int correctPlaces;
        int randomNumber;
        int initialRandomNumber;
        int randomNumberDigit;
        int input;
        int initialInput;
        int firstDigitinput;
        int secondDigitinput;
        int thirdDigitinput;

        //Scanner object
        Scanner in = new Scanner(System.in);

        //Generating the random three-digit number
        randomNumber = (int)(Math.random()*900 + 100);

        initialRandomNumber = randomNumber;
        
        //Starting the loop that gets guesses until the correct guess is given
        correctDigits = 0;
        correctPlaces = 0;
        numberOfGuesses = 0;

        do
        {
            //Getting the value of guess as an input
            System.out.print("Your guess: ");
            input = in.nextInt();
            initialInput = input;

            //Ensuring the input is a three-digit number
            if(input < 100 || input > 999)
            {
                System.out.println("Please enter a three-digit number");
            }
            else
            {
                //Initializing the digit variables of the input number to be checked later
                firstDigitinput = input % 10;
                input /= 10;

                secondDigitinput = input % 10;
                input /= 10;

                thirdDigitinput = input % 10;

                //Checks if each digit of random number can be found in input number
                for(int i = 0; i < 3; i++)
                {
                    randomNumberDigit = randomNumber % 10;
                    randomNumber /= 10;

                    if(randomNumberDigit == firstDigitinput)
                    {
                        correctDigits++;

                        if(i == 0)
                        {
                            correctPlaces++;
                        }
                    }
                    if(randomNumberDigit == secondDigitinput)
                    {
                        correctDigits++;

                        if(i == 1)
                        {
                            correctPlaces++;
                        }
                    }
                    if(randomNumberDigit == thirdDigitinput)
                    {
                        correctDigits++;

                        if(i == 2)
                        {
                            correctPlaces++;
                        }
                    }

                    //These "if" clauses ensures that if the input and random number have 2 or more same digits at the same time, the correct version of "correctDigits" is shown
                    if(randomNumberDigit == firstDigitinput && randomNumberDigit == secondDigitinput)
                    {
                        correctDigits--;
                    }
                    if(randomNumberDigit == firstDigitinput && randomNumberDigit == thirdDigitinput)
                    {
                        correctDigits--;
                    }
                    if(randomNumberDigit == secondDigitinput && randomNumberDigit == thirdDigitinput)
                    {
                        correctDigits--;
                    }
                    if(randomNumberDigit == firstDigitinput && randomNumberDigit == secondDigitinput && randomNumberDigit == thirdDigitinput)
                    {
                        correctDigits++;
                    }

                }

                //Random number is changed by the for loop; so, it is changed to initial random number to be checked again if the guess is incorrect
                randomNumber = initialRandomNumber;

                if(initialInput != initialRandomNumber)
                {
                    System.out.println("Correct digits: " + correctDigits + "   Correct places: " + correctPlaces);
                }

                //Counting every guess and resetting the variables
                numberOfGuesses++;
                correctDigits = 0;
                correctPlaces = 0;
            }
                
        }
        while(initialInput != initialRandomNumber);

        System.out.println("Correctly guessed in " + numberOfGuesses + " tries");

        in.close();
    }
}    

