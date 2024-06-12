package Practices;

public class practice26 {
    public static void main(String[] args) {
        int[] nums = {1,5,2,3,4};
        
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int product;
        int maxProduct;

        maxProduct = Integer.MIN_VALUE;

        for(int n = 0; n < nums.length - 2; n++) {
            for(int k = n + 1; k < nums.length - 1; k++) {
                for(int j = k + 1; j < nums.length; j++) {
                    product = nums[n] * nums[k] * nums[j]; 

                    if(product > maxProduct) {
                        maxProduct = product;
                    }
                }
            }
        }

        return maxProduct;
    }
}
