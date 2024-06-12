package Practices;
public class practice10 
{
    public static void main(String[] args)
    {
        String[] words = {"abc","car","ada","racecar","cool"};

        System.out.println(findPalindrome(words));
    }
    
    public static String findPalindrome(String[] words)
    {
        boolean isPalindrome;

        for(int n = 0; n < words.length; n++)
        {
            isPalindrome = true;

            for(int k = 0, j = words[n].length() - 1; k < words[n].length() / 2; k++, j--)
            {
                if(words[n].charAt(k) != words[n].charAt(j))
                {
                    isPalindrome = false;
                }  
            }

            if(isPalindrome)
            {
                return words[n];
            }
        }

        return "";
    }
}
