package Practices;

public class practice22 {
    public static void main(String[] args) {
        int[][] dimensions = {{9,3},{8,6},{10,11}};
        
        System.out.println(areaOfMaxDiagonal(dimensions));
    }
    
    public static int areaOfMaxDiagonal(int[][] dimensions) {
        int areaOfMaxDiagonal;
        double maxDiagonal;

        maxDiagonal = -1;
        areaOfMaxDiagonal = 0;

        for(int n = 0; n < dimensions.length; n++) {
            for(int k = 0; k < dimensions[n].length - 1; k++) {
                if(Math.sqrt((dimensions[n][k] * dimensions[n][k]) + (dimensions[n][k + 1] * dimensions[n][k + 1])) > maxDiagonal) {
                    maxDiagonal = Math.sqrt((dimensions[n][k] * dimensions[n][k]) + (dimensions[n][k + 1] * dimensions[n][k + 1]));
                    areaOfMaxDiagonal = dimensions[n][k] * dimensions[n][k + 1];
                }
            }
        }

        return areaOfMaxDiagonal;
    }
}
