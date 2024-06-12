package Lab05;
import java.util.Scanner;

public class Lab05_Q3_Simsek 
{
    public static void main(String[] args) 
    {
        //Variables
        String sequence;
        String encodedSequence;
        int counter;

        //Scanner object
        Scanner in = new Scanner(System.in);

        //Input for sequence
        System.out.print("Enter a nucleic acid sequence: ");
        sequence = in.next();

        //Default values
        counter = 1;
        encodedSequence = "";
        //Ensuring the loop that encodes the sequence doesn't skip the last repeating character
        sequence += "*";

        //Encoding the sequence
        for(int index = 1; index < sequence.length(); index++)
        {
            if(sequence.charAt(index - 1) == sequence.charAt(index))
            {
                counter++;
            }

            if(sequence.charAt(index - 1) != sequence.charAt(index))
            {
                encodedSequence += sequence.charAt(index - 1);
                encodedSequence += counter;
                counter = 1;
            }
            
        }

        System.out.print("Encoded Sequence: " + encodedSequence);

        in.close();
    }    
}
