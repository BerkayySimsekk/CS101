package Practices;

import java.util.Arrays;

public class practice18 
{
    //https://leetcode.com/problems/valid-mountain-array/description/
    public static void main(String[] args) 
    {
        int[] list = {3,5,5};
        
        System.out.println(isValidMountainArray(list));
    }

    public static boolean isValidMountainArray(int[] list)
    {
        int startingIndexForSecondPart;
        int endingIndexForSecondPart;

        int[] firstPart = new int[list.length];
        int[] secondPart = new int[list.length];
        
        //the methods that check if the current array is increasing or not ignores -1
        Arrays.fill(firstPart, -1);
        Arrays.fill(secondPart, -1);

        //these cases are not valid for mountain array
        if(isStrictlyDecreasing(list) || isStrictlyIncreasing(list) || list.length == 0 || list.length == 1 || list.length == 2)
        {
            return false;
        }

        for(startingIndexForSecondPart = 0; startingIndexForSecondPart < list.length && isStrictlyIncreasing(firstPart); startingIndexForSecondPart++)
        {
            firstPart[startingIndexForSecondPart] = list[startingIndexForSecondPart];
        }

        startingIndexForSecondPart--;
        
        for(endingIndexForSecondPart = startingIndexForSecondPart; endingIndexForSecondPart < list.length && isStrictlyDecreasing(secondPart); endingIndexForSecondPart++)
        {
            secondPart[endingIndexForSecondPart] = list[endingIndexForSecondPart];
        }

        //this case is not valid because this means the given array is something like {3,5,5}
        if(findArraySize(secondPart) == 1)
        {
            return false;
        }

        return isStrictlyDecreasing(secondPart);
    }

    //ignores -1
    public static int findArraySize(int[] list)
    {
        int length;

        length = 0;

        for(int n = 0; n < list.length; n++)
        {
            if(list[n] != -1)
            {
                length++;
            }
        }

        return length;
    }

    //ignores -1
    public static boolean isStrictlyIncreasing(int[] list)
    {
        boolean isStrictlyIncreasing;

        isStrictlyIncreasing = true;

        for(int n = 0; n < list.length - 1; n++)
        {
            if(list[n + 1] <= list[n] && list[n + 1] != -1 && list[n] != -1)
            {
                isStrictlyIncreasing = false;
            }
        }

        return isStrictlyIncreasing;
    }

    //ignores -1
    public static boolean isStrictlyDecreasing(int[] list)
    {
        boolean isStrictlyDecreasing;

        isStrictlyDecreasing = true;

        for(int n = 0; n < list.length - 1; n++)
        {
            if(list[n + 1] >= list[n] && list[n + 1] != -1 && list[n] != -1)
            {
                isStrictlyDecreasing = false;
            }
        }

        return isStrictlyDecreasing;
    }
}
