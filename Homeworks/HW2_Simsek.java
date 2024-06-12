package Homeworks;

public class HW2_Simsek 
{
    public static void main(String[] args)
    {
        //variables
        int size;
        long start;
        long end;
        long elapsedTime;
        
        //initial size of the array
        size = 10;

        //the loop continues until the size of the array reaches its maximum limit
        while(size <= 100000)
        {
            //an array with fixed size is created through the createArray method
            int[] list = createArray(size);

            //the elapsed time is found for Algorithm B
            start = System.nanoTime();
            findLeastCommonB(list);
            end = System.nanoTime();
            elapsedTime = end - start;

            System.out.print("For the randomly created array that has the size of " + size + ": Algorithm B took " + elapsedTime + " nanoseconds, ");

            //the elapsed time is found for Algorithm A
            start = System.nanoTime();
            findLeastCommonA(list);
            end = System.nanoTime();
            elapsedTime = end - start;

            System.out.println("Algorithm A took " + elapsedTime + " nanoseconds." );

            //size of the array is increased
            size *= 100;
        }
    }

    /**
     * Finds the least occurring number in the array by comparing the element found at index "n" with the element found at index "n + 1"
     * @param list (array that contains randomly generated numbers between 1 and 10)
     */
    public static void findLeastCommonA(int[] list)
    {
        //variables
        int counter;
        int minCounter;
        //since the aim of this method is to find the elapsed time, it does not return an int value
        @SuppressWarnings("unused")
        int leastOccurredNumber;

        //sorting the array in increasing order
        mergeSort(list);

        //assigning the values
        counter = 1;
        minCounter = list.length + 1;
        leastOccurredNumber = -1;

        //a loop that finds the least occurring number in the array
        for(int n = 1; n < list.length; n++)
        {
            //checking if the previous element is same with the next element to update the counter 
            if(list[n - 1] == list[n])
            {
                counter++;
            }
            else
            {
                //updating the minimum counter in order to find the least occurring number in the array
                if(counter < minCounter)
                {
                    minCounter = counter;
                    leastOccurredNumber = list[n - 1]; 
                }

                //resetting the counter
                counter = 1;
            }
        }

         //checking whether the the least occurring number is the last element(s) of the list
         if(counter < minCounter)
         {
             leastOccurredNumber = list[list.length - 1];
         }
    }

    /**
     * Finds the least occurring element by traversing the array for each element and counting how many other elements are equal to it
     * @param list (array that contains randomly generated numbers between 1 and 10)
     */
    public static void findLeastCommonB(int[] list)
    {
         //variables
         int counter;
         int minCounter;
         //since the aim of this method is to find the elapsed time, it does not return an int value
         @SuppressWarnings("unused")
         int leastOccurredNumber;
 
         //assigning the values
         counter = 0;
         minCounter = list.length + 1;
         leastOccurredNumber = -1;
 
          //a loop that gets the element to be compared with every element in the list
         for(int n = 0; n < list.length; n++)
         {
             //a loop that gets the every element in the list to be compared with the element that is got by the previous loop
             for(int k = 0; k < list.length; k++)
             {
                 //updating the counter if the element at index n is same with the element at index k
                 if(list[n] == list[k])
                 {
                     counter++;
                 }
             }
 
             //updating the minimum counter in order to find the least occurring number in the array
             if(counter < minCounter)
             {
                 minCounter = counter;
                 leastOccurredNumber = list[n];
             }
 
             //resetting the counter
             counter = 0;
        }
    }

    /**
     * Creates an array of given size that contains numbers between 1 and 10
     * @param size (length of the array)
     * @return Array that contains numbers between 1 and 10 with the given size
     */
    public static int[] createArray(int size)
    {
        //creating the array with the given size
        int[] list = new int[size];

        //a loop that adds random numbers between 1 and 10 to the array
        for(int n = 0; n < size; n++)
        {
            list[n] = (int)(Math.random() * 10 + 1);
        }

        return list;
    }
    
    public static void mergeSort(int[] arr) 
    {
        if (arr == null || arr.length <= 1) {
            return; // Array is already sorted or empty
        }

        int n = arr.length;
        int[] temp = new int[n]; // Temporary array for merging

        mergeSortRecursive(arr, temp, 0, n - 1);
    }

    private static void mergeSortRecursive(int[] arr, int[] temp, int left, int right) 
    {
        if (left >= right) {
            return; // Base case: array has 0 or 1 element
        }

        int mid = left + (right - left) / 2; // Calculate the middle index

        mergeSortRecursive(arr, temp, left, mid); // Sort left half
        mergeSortRecursive(arr, temp, mid + 1, right); // Sort right half

        merge(arr, temp, left, mid, right); // Merge the two sorted halves
    }
    private static void merge(int[] arr, int[] temp, int left, int mid, int right) 
    {
        // Copy elements to the temporary array
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left; // Pointer for the left half
        int j = mid + 1; // Pointer for the right half
        int k = left; // Pointer for the merged array

        // Merge the two halves by comparing the elements
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements from the left half, if any
        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }

        // Copy the remaining elements from the right half, if any
        while (j <= right) {
            arr[k] = temp[j];
            j++;
            k++;
        }
    }  
}
