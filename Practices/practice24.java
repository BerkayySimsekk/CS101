package Practices;

public class practice24 {
    public static void main(String[] args) {
        int[] num = {5,5,5,5};
        
        System.out.println(findMaxAverage(num, 4));
    }
    
    public static double findMaxAverage(int[] array, int length) {
        double average;
        double maxAverage;
        double sum;

        maxAverage = -1;
        sum = 0;

        if(length >= array.length) {
            for(int n = 0; n < array.length; n++) {  
                sum += array[n];
            }

            maxAverage = sum / array.length;
        }
        else {
            for(int n = 0; n < array.length - length + 1; n++) {
                for(int k = length - 1; k >= 0; k--) {
                    sum += array[n + k];
                }

                average = sum / length;

                if(average > maxAverage) {
                    maxAverage = average;
                }

                sum = 0;
            }
        }

        return maxAverage;
    }
}
