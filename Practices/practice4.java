package Practices;
import java.util.Scanner;

public class practice4 
{
    public static void main(String[] args) 
    { 
        String firstWord;
        String secondWord;
        boolean isAnagram;
        
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter first word: ");
        firstWord = in.next();

        System.out.print("Enter second word: ");
        secondWord = in.next();

        isAnagram = isAnagram(firstWord, secondWord);

        System.out.println(isAnagram);

        in.close();
    
    }

    public static boolean isAnagram(String firstWord, String secondWord)
    {
        String reversedWord;

        reversedWord = "";

        for(int n = secondWord.length() - 1; n >= 0; n--)
        {
            reversedWord += secondWord.charAt(n);
        }

        return firstWord.equals(reversedWord);
    }
}
