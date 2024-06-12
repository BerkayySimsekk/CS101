package Practices;
public class practice8 
{
    public static void main(String[] args)
    {
        int[] indices = {4,5,6,7,0,2,1,3};

        System.out.print(shuffleString("codeleet", indices));
    }
    
    public static String shuffleString(String word, int[] indices)
    {
        String formattedWord;
        boolean isDone;
        int index;
    
        formattedWord = "";
        isDone = false;
        index = 0;

        while(!isDone)
        {
            for(int n = 0; n < indices.length; n++)
            {
                if(indices[n] == index)
                {
                    formattedWord += word.charAt(n);
                    index++;
                }
            }

            if(formattedWord.length() == word.length())
            {
                isDone = true;
            }
        }

        return formattedWord;
    }


}
