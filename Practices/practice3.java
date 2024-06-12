package Practices;
public class practice3 
{
    public static void main(String[] args)
    {
        int[] array = {1, 4, 0, 5, 0, 6};
        moveZeroes(array);
        System.out.println(createArrayAsString(array));
    }
    
    public static void moveZeroes(int[] array)
    {
        int cursorForNonzero;

        cursorForNonzero = 0;

        for(int cursor = 0; cursor < array.length; cursor++)
        {
            if(array[cursor] != 0)
            {
                array[cursorForNonzero] = array[cursor];
                cursorForNonzero++;
            }
        }
        
        for(int cursor = cursorForNonzero + 1; cursor < array.length; cursor++)
        {
            array[cursor] = 0;
        }
    }

    public static String createArrayAsString(int[] array)
    {
        String printedArray;

        printedArray = "";

        for(int firstCursor = 0; firstCursor < array.length; firstCursor++)
        {
            printedArray += array[firstCursor] + ", ";
        }

        printedArray = printedArray.substring(0, printedArray.length() - 2);

        return printedArray;
    }
    
}
