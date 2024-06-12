package Practices;
import java.util.Scanner;

public class practice6 
{
    public static void main(String[] args)
    {
        String word;
        String initialWord;
        boolean isDone;

        Scanner in = new Scanner(System.in);

        System.out.print("Enter the word: ");
        word = in.next();

        if(isPalindrome(word))
        {
            System.out.println("This word is palindrome");
        }
        else
        {
            initialWord = word;
            isDone = false;

            for(int n = 0; n < word.length() && !isDone; n++)
            {
                word = word.substring(0, n) + word.substring(n + 1);

                if(isPalindrome(word))
                {
                    System.out.println("This word is palindrome if the letter at index " + n + " is removed");
                    isDone = true;
                }
                else
                {
                    word = initialWord;
                }
            }
        }

        in.close();

    }
    
    public static boolean isPalindrome(String word)
    {
        int firstCursor;
        int secondCursor;

        firstCursor = 0;
        secondCursor = word.length() - 1;

        while(firstCursor < word.length() / 2)
        {
            if(word.charAt(firstCursor) != word.charAt(secondCursor))
            {
                return false;
            }

            firstCursor++;
            secondCursor--;
        }

        return true;
    }
}
