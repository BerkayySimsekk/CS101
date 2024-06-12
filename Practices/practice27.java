package Practices;

public class practice27 {
    public static void main(String[] args) {
        int[] nums = {20,14,21,10};
        int[] divisors = {5,7,5};
        
        System.out.println(maxDivScore(nums, divisors));
    }
    
    public static int maxDivScore(int[] nums, int[] divisors)
    {
        int maxDivScore;
        int divScore;
        int minDivisor;
        boolean isMoreThanMaxDivScore;


        divScore = 0;
        maxDivScore = 0;
        minDivisor = Integer.MAX_VALUE;
        isMoreThanMaxDivScore = false;

        for(int n = 0; n < divisors.length; n++) {
            for(int k = 0; k < nums.length; k++) {
                if(nums[k] % divisors[n] == 0) {
                    divScore++;
                }
            }

            if(divScore == maxDivScore) {
                isMoreThanMaxDivScore = true;
            }

            if(divisors[n] < minDivisor) {
                minDivisor = divisors[n];
            }

            if(divScore > maxDivScore) {
                maxDivScore = divScore;
            }

            divScore = 0;
        }

        if(isMoreThanMaxDivScore){
            return minDivisor;
        }
        else {
            return maxDivScore;
        }
    }
}
