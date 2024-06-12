package Practices;

public class practice16 
{
    //https://leetcode.com/problems/longest-even-odd-subarray-with-threshold/description/
    public static void main(String[] args) 
    {
        int[] list = {1, 3, 2, 4, 5};
        
        System.out.println(longestAlternatingSubarray(list, 5));
    }
    
    public static int longestAlternatingSubarray(int[] list, int threshold)
    {
        int longestLength;
        int length;

        length = 0;
        longestLength = -1;
        
        for(int n = 0; n < list.length; n++)
        {
            if(list[n] % 2 == 0 && list[n] <= threshold)
            {
                length = 1;

                for(int k = n; k < list.length - 1; k++)
                {
                    if(list[k] % 2 != list[k + 1] % 2 && list[k] <= threshold && list[k + 1] <= threshold)
                    {
                        length++;
                    }
                }
                
                if(n == list.length - 1)
                {
                    length = 1;
                }
            }

            if(length >= longestLength)
            {
                longestLength = length;
            }

            length = 0;
        }

        return longestLength;
    }
}


