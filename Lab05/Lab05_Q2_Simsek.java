package Lab05;
public class Lab05_Q2_Simsek 
{
    public static void main(String[] args) 
    {
        //Variables
        int numberForChecking;
        int number;
        int sumOfDigits;
        int sumOfNumbers;

        //Default values
        sumOfDigits = 0;
        sumOfNumbers = 0;

        //The loop that checks for three-digit narcissistic numbers
        for(number = 100; number < 1000; number++)
        {
            numberForChecking = number;
            
            //Checking for narcissistic numbers
            do
            {
                sumOfDigits += (numberForChecking % 10) * (numberForChecking % 10) * (numberForChecking % 10);
                numberForChecking /= 10;
            }
            while(numberForChecking >= 1);

            if(sumOfDigits == number)
            {
                sumOfNumbers += number;
                System.out.println(number + " is a narcissistic number");
            }
            
            //Resetting the variable to check the next number
            sumOfDigits = 0;
        }

        System.out.print("Sum of three-digit narcissistic numbers: " + sumOfNumbers);
    }    
}
