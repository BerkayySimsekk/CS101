package Practices;

public class practice21 {
    public static void main(String[] args) {
        int[] nums = {5,6,6,3,2,7,8,9,4};
        
        System.out.println(thirdMaxNum(nums));
    }

    public static int thirdMaxNum(int[] nums) {
        int firstMax, secondMax, thirdMax;

        firstMax = Integer.MIN_VALUE;
        secondMax = Integer.MIN_VALUE;
        thirdMax = Integer.MIN_VALUE;

        for(int n = 0; n < nums.length; n++) {
            if(nums[n] > firstMax && nums[n] > secondMax && nums[n] > thirdMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[n];
            }
            else if(nums[n] < firstMax && nums[n] > secondMax) {
                thirdMax = secondMax;
                secondMax = nums[n];
            }
            else if(nums[n] < secondMax && nums[n] > thirdMax) {
                thirdMax = nums[n];
            }
        }

        if(thirdMax != Integer.MIN_VALUE) {
            return thirdMax;
        }
        else {
            return firstMax;
        }
    }
}
