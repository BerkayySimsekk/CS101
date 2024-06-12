package Lab02;
import java.util.Scanner;

public class Lab02_Q2_Simsek 
{
    public static void main(String[] args) 
    {
        //Variables
        String number;
        String removedSpace;
        String countryCode;
        String cityCode;
        String phoneNumber;

        Scanner in = new Scanner(System.in);

        //User input
        System.out.print("Enter phone number: ");
        number = in.nextLine();

        //Modifying the user input
        removedSpace = number.replaceAll(" ", "");
        countryCode = removedSpace.substring(1, 3);
        cityCode = removedSpace.substring(4, 7);
        phoneNumber = removedSpace.substring(8, 11) + " - " + removedSpace.substring(12, 14) + " " + removedSpace.substring(14);

        //Printing the modified version
        System.out.print("Country Code: " + countryCode + "\nCity\\Area Code: " + cityCode + "\nPhone Number: " + phoneNumber);

        in.close();
    }
}
