package Practices;
import java.util.Arrays;

public class practice12 
{
    public static void main(String[] args) 
    {
        int[] arr1 = {5, 3, 1, 4, 2};
        System.out.println("Before sorting: " + Arrays.toString(arr1));
        sortArray(arr1);
        System.out.println("After sorting: " + Arrays.toString(arr1));
        
        int[] arr2 = {5, 3, 1, 4, 2};
        System.out.println("Before sorting: " + Arrays.toString(arr2));
        sortArray(arr2, 3);
        System.out.println("After sorting: " + Arrays.toString(arr2));     
    }

    public static void sortArray(int[] list)
    {
        int temporary;
        
        for(int n = 0; n < list.length - 1; n++)
        {
            for(int k = n + 1; k < list.length; k++)
            {
                if(list[k] < list[n])
                {
                    temporary = list[n];
                    list[n] = list[k];
                    list[k] = temporary;
                }
            }
        }
    }

    public static void sortArray(int[] list, int sortTillThisIndex)
    {
        int temporary;
        
        for(int n = 0; n < sortTillThisIndex - 1; n++)
        {
            for(int k = n + 1; k < sortTillThisIndex; k++)
            {
                if(list[k] < list[n])
                {
                    temporary = list[n];
                    list[n] = list[k];
                    list[k] = temporary;
                }
            }
        }   
    }
}
