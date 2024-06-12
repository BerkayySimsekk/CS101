package Practices;
public class practice7 
{
    public static void main(String[] args)
    {
        String s = "Hello how are you Contestant";

        System.out.print(truncateSentence(s, 4));
    }

    public static String truncateSentence(String sentence, int lengthOfTruncatedSentence)
    {
        String truncatedSentence;
        boolean isDone;
        int indexForArray;
        int indexForSentence;

        String[] wordsOfTruncatedSentence = new String[lengthOfTruncatedSentence];

        isDone = false;
        indexForArray = 0;
        indexForSentence = 0;

        while(!isDone)
        {
            if(sentence.charAt(indexForSentence) == ' ')
            {
                wordsOfTruncatedSentence[indexForArray] = sentence.substring(0, indexForSentence);
                sentence = sentence.substring(indexForSentence + 1);
                indexForArray++;
                indexForSentence = 0;
            }

            indexForSentence++;

            if(wordsOfTruncatedSentence[lengthOfTruncatedSentence - 1] != null)
            {
                isDone = true;
            }
        }

        truncatedSentence = "";
        
        for(int n = 0; n < lengthOfTruncatedSentence; n++)
        {
            truncatedSentence += wordsOfTruncatedSentence[n] + " ";
        }

        return truncatedSentence.substring(0, truncatedSentence.length() - 1);
    }
}
