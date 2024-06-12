package Practices;

public class practice20 
{
    public static void main(String[] args) 
    {
        int[] nums = {2,3,4,3,4};

        System.out.println(alternatingSubarray(nums));
    }
    
    public static int alternatingSubarray(int[] nums)
    {
        int length, longestLength;

        length = 0;
        longestLength = 0;

        for(int n = 0; n < nums.length - 2; n++)
        {
            if(nums[n] + 1 == nums[n + 1] && nums[n + 1] == nums[n + 2] + 1)
            {
                length = 3;
                
                for(int k = n + 3; k < nums.length; k++)
                {
                    if(nums[k] == nums[k - 2])
                    {
                        length++;
                    }
                }
            }
            else if(nums[n] + 1 == nums[n + 1])
            {
                length = 2;
            }
            
            if(length > longestLength)
            {
                longestLength = length;
            }
        }

        return longestLength;
    }
}
