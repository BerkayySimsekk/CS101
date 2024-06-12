package Practices;
public class practice9 
{
    public static void main(String[] args)
    {
        int[] nums = {1,15,6,3};

        System.out.println(differenceOfSum(nums));
    }
    
    public static int differenceOfSum(int[] nums)
    {
        int num;
        int digit;
        int regularSum;
        int digitSum;

        regularSum = 0;
        digitSum = 0;

        for(int n = 0; n < nums.length; n++)
        {
            num = nums[n];
            regularSum += num;

            while(num >= 1)
            {
                digit = num % 10; 
                digitSum += digit;
                num /= 10;
            }
        }

        return Math.abs(regularSum - digitSum);
    }

}
