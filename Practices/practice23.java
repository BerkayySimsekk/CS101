package Practices;

import java.util.ArrayList;

public class practice23 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0); list.add(2);list.add(1);list.add(-6);list.add(6);list.add(-7);list.add(9);list.add(1);list.add(2);list.add(0); list.add(1);

        System.out.println(canThreePartsEqualSum(list));
    }

    public static boolean canThreePartsEqualSum(ArrayList<Integer> list) {
        int sum;

        sum = 0;

        for(int n = 0; n < list.size(); n++) {
            sum += list.get(n);
        }

        return sum % 3 == 0;
    }      
}


