package Practices;
public class practice2 
{
    public static void main(String[] args)
    {
        int[] array = {1, 4, 0, 5, 0, 6};
        moveZeroes(array);
        printArray(array);
    }
    
    public static void moveZeroes(int[] array)
    {
        int temporary;
        int counter;

        counter = 0;

        for(int firstCursor = 1, secondCursor = 0; firstCursor < array.length && secondCursor < array.length; firstCursor++, secondCursor++)
        {
            if(array[secondCursor] == 0)
            {
                counter++;
            }

            if(array[firstCursor] != 0 && array[firstCursor - 1] == 0)
            {
                temporary = array[firstCursor - 1];
                array[firstCursor - 1] = array[firstCursor];
                array[firstCursor] = temporary;
            }
            
        }

        while(counter > 1)
        {
            for(int firstCursor = 1; firstCursor < array.length; firstCursor++)
            {
                if(array[firstCursor] != 0 && array[firstCursor - 1] == 0)
                {
                    temporary = array[firstCursor - 1];
                    array[firstCursor - 1] = array[firstCursor];
                    array[firstCursor] = temporary;
                }
                
            }
            
            counter--;
        }
    }

    public static void printArray(int[] array)
    {
        for(int firstCursor = 0; firstCursor < array.length; firstCursor++)
        {
            System.out.print(array[firstCursor] + ", ");
        }
    }
}     
