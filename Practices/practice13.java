package Practices;
public class practice13 
{
    public static void main(String[] args) 
    {
        int[][] matrix1 = {{1, 2, 3}, {2, 1, 2}, {3, 2, 1}};
        int[][] matrix2 = {{1, 2, 3}, {2, 1, 2}, {4, 5, 6}};
        int[][] matrix3 = {{1, 2}, {3, 4}, {5, 6}};

        System.out.println("Initially matrix 1 is: ");
        printMatrix(matrix1);

        System.out.println("Initially matrix 2 is: ");
        printMatrix(matrix2);

        System.out.println("Initially matrix 3 is: ");
        printMatrix(matrix3);

        System.out.println("After transpose matrix 1 is: ");
        printMatrix(transposeMatrix(matrix1));

        System.out.println("After transpose matrix 2 is: ");
        printMatrix(transposeMatrix(matrix2));

        System.out.println("After transpose matrix 3 is: ");
        printMatrix(transposeMatrix(matrix3));

        System.out.println("Is matrix 1 Symmetric: " + isSymmetric(matrix1));
        System.out.println("Is matrix 2 Symmetric: " + isSymmetric(matrix2));
        System.out.println("Is matrix 3 Symmetric: " + isSymmetric(matrix3));

        System.out.println("Is sum of diagonals of matrix 1 equal: " + isDiagonalSumEqual(matrix1));
        System.out.println("Is sum of diagonals of matrix 2 equal: " + isDiagonalSumEqual(matrix2));   
    }
    
    public static int[][] transposeMatrix(int[][] matrix)
    {
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];

        for(int n = 0; n < transposedMatrix.length; n++)
        {
            for(int k = 0; k < transposedMatrix[0].length; k++)
            {
                transposedMatrix[n][k] = matrix[k][n];
            }
        }
        
        return transposedMatrix;
    }

    public static boolean isSymmetric(int[][] matrix)
    {
        boolean isSymmetric;

        isSymmetric = true;

        if(matrix.length != matrix[0].length)
        {
            return false;
        }

        for(int n = 0; n < matrix.length; n++)
        {
            for(int k = 0; k < matrix[n].length; k++)
            {
                if(matrix[n][k] != matrix[k][n])
                {
                    isSymmetric = false;
                }
            }
        }

        return isSymmetric;
    }

    public static boolean isDiagonalSumEqual(int[][] matrix)
    {
        int firstSum;
        int secondSum;

        firstSum = 0;

        for(int n = 0; n < matrix.length; n++)
        {
            firstSum += matrix[n][n];
        }

        secondSum = 0;

        for(int n = 0, k = matrix.length - 1; n < matrix.length; n++, k--)
        {
            secondSum += matrix[n][k];
        }

        return firstSum == secondSum;
    }

    public static void printMatrix(int[][] matrix)
    {
        for(int n = 0; n < matrix.length; n++)
        {
            for(int k = 0; k < matrix[n].length; k++)
            {
                System.out.print(matrix[n][k] + " ");
            }
            
            System.out.println();
        }
    }
}
