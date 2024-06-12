package Practices;

import java.util.ArrayList;

public class practice25 {
    public static void main(String[] args) {

        ArrayList<Integer> nums = new ArrayList<Integer>();
        
        nums.add(-4); nums.add(-2); nums.add(1); nums.add(4); nums.add(8);

        System.out.println(findClosestNumToZero(nums));
    }
    
    public static int findClosestNumToZero(ArrayList<Integer> nums) {

        int closestNum;

        closestNum = Integer.MAX_VALUE;

        for(int n = 0; n < nums.size(); n++) {
            if(Math.abs(nums.get(n)) < Math.abs(closestNum)) {
                closestNum = nums.get(n);
            }
        }

        return closestNum;
    }
}
