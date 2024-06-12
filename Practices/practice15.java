package Practices;

public class practice15 
{
    public static void main(String[] args) 
    {
        int[] list = {1, 1, 1};
        
        System.out.println(canBeIncreasingOrder(list));
    }

    public static boolean canBeIncreasingOrder(int[] list)
    {
        int indexForNewList;
        int initialNum;

        int[] newList = new int[list.length - 1];

        for(int n = 0; n < list.length; n++)
        {
            initialNum = list[n];
            list[n] = -1;
            indexForNewList = 0;
            
            for(int k = 0; k < list.length; k++)
            {
                if(list[k] != -1)
                {
                    newList[indexForNewList] = list[k];
                    indexForNewList++;
                }
            }

            list[n] = initialNum;

            if(isIncreasingOrder(newList))
            {
                return true;
            }
        }

        return false;
    }

    public static boolean isIncreasingOrder(int[] list)
    {
        for(int n = 1; n < list.length; n++)
        {
            if(list[n - 1] >= list[n])
            {
                return false;  
            }
        }

        return true;
    }
}
