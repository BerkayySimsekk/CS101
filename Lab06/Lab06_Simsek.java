package Lab06;
import java.util.Scanner;

public class Lab06_Simsek 
{
    public static void main(String[] args)
    {
        String word;
        String soundex;

        Scanner in = new Scanner(System.in);
        word = "";
    
        while(!word.equals("exit"))
        {
            System.out.print("Enter a string: ");
            word = in.next();

            soundex = getSoundex(word);

            //The method that checks whether the word consists of only letters returns an empty string if it finds a character that is not letter
            if(soundex.equals(""))
            {
                System.out.println("Characters must be alphabetic...");
            }
            else
            {
                System.out.println("Soundex: " + soundex);
            }
        }
        
        System.out.print("\nGoodbye!");

        in.close();
    }
    
    /**
     * @param word A String to be checked
     * @return A boolean variable that reveals if every character in the word is letter
     */
    public static boolean isAlphaWord(String word)
    {
        for(int n = 0; n < word.length(); n++)
        {
            if(!Character.isLetter(word.charAt(n)))
            {
                return false;
            }
        }

        return true;
    }

    /**
     * @param ch A character to find its corresponding value in terms of integer
     * @return A corresponding integer value of the parameter "ch"
     */
    public static int getCode(char ch)
    {
        if(ch == 'B' || ch == 'F' || ch == 'P' || ch == 'V')
        {
            return 1;
        }

        if(ch == 'C' || ch == 'G' || ch == 'J' || ch == 'K' || ch == 'Q' || ch == 'S' || ch == 'X' || ch == 'Z')
        {
            return 2;
        }

        if(ch == 'D' || ch == 'T')
        {
            return 3;
        }

        if(ch == 'L')
        {
            return 4;
        }

        if(ch == 'M' || ch == 'N')
        {
            return 5;
        }

        if(ch == 'R')
        {
            return 6;
        }

        return 0;
    }

    /**
     * @param word A string to be changed according the corresponding integer values of each letter in the string
     * @return The changed version of string that includes the corresponding integer values of each letter
     */
    public static String buildCode(String word)
    {
        String renewedWord;

        renewedWord = "";

        for(int n = 0; n < word.length(); n++)
        {
            renewedWord += getCode(word.charAt(n));
        }

        return renewedWord;
    }

    /**
     * @param word A String to be changed if it includes adjacent duplicates
     * @return A renewed string that does not have adjacent duplicates 
     */
    public static String removeAdjacentDuplicates(String word)
    {
        for(int n = 1; n < word.length(); n++)
        {
            if(word.charAt(n - 1) == word.charAt(n))
            {
                word = word.substring(0, n) + word.substring(n + 1);
                n--;
            }
        }

        return word;
    }

    /**
     * @param word A string to be changed according to the given set of letters
     * @param letters A set of letters to be removed
     * @return A renewed version of the string that does not include the letters given as parameter
     */
    public static String removeLetters(String word, String letters)
    {
        word = word.replaceAll(letters, "");

        return word;
    }

    /**
     * @param word A string to be changed if its length is less than 4 or greater than 4
     * @return A string that has a length of 4, if it had a length of less than 4, zeroes are added; if it had a length of greater than 4, characters after the index of 3 are removed
     */
    public static String padCode(String word)
    {
        if(word.length() < 4)
        {
            while(word.length() != 4)
            {
                word += 0;
            }
        }
        else
        {
            word = word.substring(0, 4);
        }

        return word;
    }

    /**
     * @param word A string to be changed according to the rules of creating a soundex
     * @return A string which is created according the rules of creating a soundex
     */
    public static String getSoundex(String word)
    {
        String soundex;

        soundex = "";

        //Checking if the word contains only letters
        if(!isAlphaWord(word))
        {
            return soundex;
        }
        else
        {
            word = word.toUpperCase();

            //Get the corresponding integer values of each letter
            soundex = buildCode(word);
            //Remove each adjacent duplicates without discriminating
            soundex = removeAdjacentDuplicates(soundex);
            //Add the first letter of the word to the soundex which was changed by the previous methods
            soundex = word.charAt(0) + soundex.substring(1);
            //Remove the integer "0" because this value was created when the letter did not have a corresponding integer value according to the rules of creating a soundex
            soundex = removeLetters(soundex, "0");
            //Add zeroes if the created soundex has length of less than 4, remove excess integers if the created soundex has a length of greater than 4
            soundex = padCode(soundex);

            return soundex;
        }
    }
}
