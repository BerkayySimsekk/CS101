package Practices;

import java.util.Arrays;

public class practice17 
{
    //https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/description/
    public static void main(String[] args) 
    {
        int[] list = {1,2,3,2,5};

        System.out.println(findSmallestMissingInteger(list));
    }

    public static int findSmallestMissingInteger(int[] list)
    {
        int sum;

        sum = findSum(list);

        if(findGreatestNum(list) >= sum)
        {
            return findGreatestNum(list) + 1;
        }
        else
        {
            return sum;
        }
    }

    public static int findGreatestNum(int[] list)
    {
        int greatestNum;

        greatestNum = -1;

        for(int n = 0; n < list.length; n++)
        {
            if(list[n] > greatestNum)
            {
                greatestNum = list[n];
            }
        }

        return greatestNum;
    }

    public static int findSum(int[] list)
    {
        int longestLength;
        int length;
        int sum;
        int sumOfArrayWithLongestLength;
        
        //we do this to prevent the loop from skipping certain scenarios
        int[] newList = Arrays.copyOf(list, list.length + 1);

        //if nothing is found by the loop, the size of longest sequential array would be automatically 1
        length = 1;
        //if nothing is found by the loop, the sum can be any one of the elements of the array, element at index 0 is chosen by default if that is the case
        sumOfArrayWithLongestLength = list[0];
        longestLength = -1;
        sum = 0;

        for(int n = 0; n < newList.length - 1; n++)
        {
            if(newList[n] + 1 == newList[n + 1])
            {
                sum += newList[n + 1];
                length++;
            }
            else
            {
                //we add the first element of the sequential array
                sum += newList[n - length + 1];
                
                if(length > longestLength)
                {
                    sumOfArrayWithLongestLength = sum;
                    longestLength = length;
                }

                length = 1;
                sum = 0;
            }       
        }

        return sumOfArrayWithLongestLength;
    }
}

