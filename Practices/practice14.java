package Practices;
import java.util.ArrayList;
import java.util.Scanner;

public class practice14 
{
    public static void main(String[] args) 
    {
        String bin;
        String numAsStr;
        String largestBin;
        int lowerBoundOfLargestBin;
        int upperBoundOfLargestBin;
        int numAsInt;
        int lowerBound;
        int upperBound;
        int counter;
        int maxLength;
        boolean isDone;

        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        
        numAsStr = "";
        
        while(!numAsStr.equals("no"))
        {
            System.out.print("Enter numbers (enter 'no' to stop): ");
            numAsStr = in.next();
            
            if(!numAsStr.equals("no"))
            {
                numAsInt = Integer.valueOf(numAsStr);
                
                while(numAsInt < 0 || numAsInt > 99)
                {
                    System.out.println("Invalid number. Please enter a number between 0 and 100.");
                    System.out.print("Enter numbers (enter 'no' to stop): ");
                    numAsStr = in.next(); 
                    numAsInt = Integer.valueOf(numAsStr); 
                }

                list.add(numAsInt);
            }
        }

        //variable to control the loop so that it continues until the bound 90-99
        isDone = false;

        //variables print out how many elements each bin has
        lowerBound = 0;
        upperBound = 9;
        bin = lowerBound + "-" + upperBound + ": ";

        //variables to find the bin that contains the most elements
        largestBin = "";
        lowerBoundOfLargestBin = -1;
        upperBoundOfLargestBin = -1;
        counter = 0;
        maxLength = -1;

        for(int n = 0; n < list.size() && !isDone ; n++)
        {
            if(list.get(n) >= lowerBound && list.get(n) <= upperBound)
            {
                bin += "*";
                counter++;
            }

            if(n == list.size() - 1)
            {
                if(counter > maxLength)
                {
                    maxLength = counter;
    
                    lowerBoundOfLargestBin = lowerBound;
                    upperBoundOfLargestBin = upperBound;
                    largestBin = lowerBoundOfLargestBin + "-" + upperBoundOfLargestBin + ": ";    
                }

                counter = 0;

                System.out.println(bin);

                lowerBound += 10;
                upperBound += 10;
                bin = lowerBound + "-" + upperBound + ": ";

                n = -1;
            }

            if(upperBound == 109)
            {
                isDone = true;
            }
        }

        for(int n = 0; n < list.size(); n++)
        {
            if(list.get(n) >= lowerBoundOfLargestBin && list.get(n) <= upperBoundOfLargestBin) 
            {
                largestBin += list.get(n) + ", ";
            }  
        }

        System.out.println(largestBin.substring(0, largestBin.length() - 2));

        in.close();
    }
}
