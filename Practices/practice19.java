package Practices;

public class practice19 
{
    public static void main(String[] args) 
    {
        int[][] nums = {{1,2,3}, {5,17,7}, {9,11,10}};
        
        System.out.println(findGreatestDiagonalPrime(nums));
    }

    public static int findGreatestDiagonalPrime(int[][] nums)
    {
        int greatestDiagonalPrime;
        
        greatestDiagonalPrime = -1;

        for(int n = 0, k = nums.length - 1; n < nums.length; n++, k--)
        {
            if(nums[n][n] > greatestDiagonalPrime)
            {
                greatestDiagonalPrime = nums[n][n];
            }
            
            if(nums[n][k] > greatestDiagonalPrime)
            {
                greatestDiagonalPrime = nums[n][k];
            }
        }

        return greatestDiagonalPrime;
    }
}


