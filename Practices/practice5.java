package Practices;
public class practice5 
{
    public static void main(String[] args)
    {
        System.out.println(isSelfDividing(128));
    }
    
    public static boolean isSelfDividing(int number)
    {
        int numberOfDigits;
        int digit;

        numberOfDigits = numberOfDigits(number);

        for(int n = 0; n < numberOfDigits; n++)
        {
            digit = number % 10;

            if(number % digit != 0)
            {
                return false;
            }

            number /= 10;
        }

        return true;
    }

    public static int numberOfDigits(int number)
    {
        int counter;

        counter = 0;

        while(number >= 1)
        {
            number /= 10;
            counter++;
        }

        return counter;
    }
}
