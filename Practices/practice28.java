package Practices;

import java.util.Arrays;

public class practice28 {
    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};
        sortByIncreasingOrder(nums);
        
        System.out.println(findNumbers(nums));
        System.out.println(Arrays.toString(nums));
    }
    
    public static int findNumbers(int[] nums) {
        int amountOfNumbersWithEvenNumberOfDigits;
        int numberOfDigits;
        int num;

        numberOfDigits = 0;
        amountOfNumbersWithEvenNumberOfDigits = 0;

        for(int n = 0; n < nums.length; n++) {
            num = nums[n];

            while(num != 0) {
                num /= 10;
                numberOfDigits++;
            }

            if(numberOfDigits % 2 == 0) {
                amountOfNumbersWithEvenNumberOfDigits++;
            }

            numberOfDigits = 0;
        }

        return amountOfNumbersWithEvenNumberOfDigits;
    }

    public static void sortByIncreasingOrder(int[] nums) {
        int temporary;

        for(int n = 0; n < nums.length; n++) {
            for(int k = n + 1; k < nums.length; k++) {
                if(nums[n] > nums[k]) {
                    temporary = nums[n];
                    nums[n] = nums[k];
                    nums[k] = temporary;
                }
            }
        }
    }
}
