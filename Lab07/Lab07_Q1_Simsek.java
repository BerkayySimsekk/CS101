package Lab07;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab07_Q1_Simsek 
{
    public static void main(String[] args)
    {
        //variables
        int choice;
        boolean isDone;
        int date;
        String name;
        String phoneNumber;

        //objects
        Scanner in = new Scanner(System.in);
        ArrayList<LocalDateTime> reservations = new ArrayList<LocalDateTime>();
        ArrayList<String> customerNames = new ArrayList<String>();
        ArrayList<String> customerPhones = new ArrayList<String>();
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        
        //filling the array list objects randomly with the usage of "ReservationGenerator" class
        customerNames = ReservationGenerator.getRandomNameList(10);
        customerPhones = ReservationGenerator.getRandomNumberList(10);
        reservations = ReservationGenerator.getRandomReservationList(10, "APRIL", 2, 29);

        isDone = false;

        //a loop that continues until the user enters "4"
        while(!isDone)
        {
            System.out.println("1) Search reservations by date\n2) Cancel Reservation\n3) Display all reservations\n4) Exit");

            System.out.print("Enter choice: ");
            choice = in.nextInt();

            //finding the reservations with a specific date
            if(choice == 1)
            {
                System.out.print("Enter date to search: ");
                date = in.nextInt();

                indexes = findReservations(date, reservations);

                if(indexes.isEmpty())
                {
                    System.out.println("No reservations found...");
                }
                else
                {
                    System.out.println("Reservation on April " + date);
                    printReservations(indexes, reservations, customerNames, customerPhones);
                }
            }

            //canceling the reservation of a specific customer if his/her information is found inside the array lists of "customerNames" and "customerPhones"
            if(choice == 2)
            {
                in.nextLine();

                System.out.print("Enter the name of the customer: ");
                name = in.nextLine();
                
                System.out.print("Enter the phone number of the customer: ");
                phoneNumber = in.nextLine();

                if(cancelReservation(name, phoneNumber, reservations, customerNames, customerPhones))
                {
                    System.out.println("Reservation cancelled...");
                }
                else
                {
                    System.out.println("Reservation not found...");
                }
            }

            //printing every reservation available
            if(choice == 3)
            {
                printReservations(null, reservations, customerNames, customerPhones);  
            }

            //exiting the loop
            if(choice == 4)
            {
                isDone = true;
            }

            System.out.println();
        }

        in.close();
    }
    
    /**
     * @param firstDate (this date is checked if it comes before second date)
     * @param secondDate (this date is checked if it is between first and third date)
     * @param thirdDate (this date is checked if it comes after second date)
     * @return boolean regarding if the second date is between first and third date.
     */
    public static boolean isBetween(LocalDateTime firstDate, LocalDateTime secondDate, LocalDateTime thirdDate)
    {
        return firstDate.isBefore(secondDate) && thirdDate.isAfter(secondDate);   
    }

    /**
     * @param date (the day of the reservations that we want to find)
     * @param reservations (An array list that consists of local date time objects regarding reservations)
     * @return ArrayList<Integer> that includes the indexes that is found according to the parameters "date" and "reservations"
     */
    public static ArrayList<Integer> findReservations(int date, ArrayList<LocalDateTime> reservations)
    {
        //variables
        int currentYear;
        LocalDateTime lowestPossibleDate;
        LocalDateTime highestPossibleDate;
        Month month;

        //objects
        ArrayList<Integer> indexes = new ArrayList<Integer>();

        //initiliazing the variables
        month =  Month.valueOf("APRIL");
        currentYear = LocalDateTime.now().getYear();
        lowestPossibleDate = LocalDateTime.of(currentYear, month, 1, 17, 59);
        highestPossibleDate = LocalDateTime.of(currentYear, month, 30, 22, 1);

        //finding the reservations with a specific date
        for(int n = 0; n < reservations.size(); n++)
        {
            if(reservations.get(n).getDayOfMonth() == date && isBetween(lowestPossibleDate, reservations.get(n), highestPossibleDate))
            {
                indexes.add(n);
            }
        }

        return indexes;
    }

    /**
     * @param name (name of the customer)
     * @param phoneNumber (phone number of the customer)
     * @param reservations (an array list of local date time objects)
     * @param names (an array list of names of customer)
     * @param phoneNumbers (an array list of phone numbers of customers)
     * @return boolean regarding if the parameters "name" and "phoneNumber" can be found inside the parameters "names" and "phoneNumbers"
     */
    public static boolean cancelReservation(String name, String phoneNumber, ArrayList<LocalDateTime> reservations, ArrayList<String> names, ArrayList<String> phoneNumbers)
    {
        //variables
        boolean isFound;

        //initiliazing the variables
        isFound = false;

        //canceling the reservation if the phone number and the name is found at the same time
        for(int n = 0; n < names.size(); n++)
        {
            if(names.get(n).equals(name) && phoneNumbers.get(n).equals(phoneNumber))
            {
                reservations.remove(n);
                names.remove(n);
                phoneNumbers.remove(n);
                isFound = true;
            }
        }

        return isFound;
    }

    /**
     * @param indexes (an array list that contains the index of specific day of month for the local date time objects inside the array list of reservations)
     * @param reservations (an array list that contains reservations as local date time objects)
     * @param names (an array list that contains customer names)
     * @param phoneNumbers (an array list that contains phone numbers of customers)
     */
    public static void printReservations(ArrayList<Integer> indexes, ArrayList<LocalDateTime> reservations, ArrayList<String> names, ArrayList<String> phoneNumbers)
    {
        //variables
        String name;
        String phoneNumber;
        Month month;
        int date;
        int hour;
        int minute;
        String minuteAsString;
        
        //printing every reservation available
        if(indexes == null)
        {
            for(int n = 0; n < names.size(); n++)
            {
                name = names.get(n);
                phoneNumber = phoneNumbers.get(n);
                month = reservations.get(n).getMonth();
                date = reservations.get(n).getDayOfMonth();
                hour = reservations.get(n).getHour();
                minute = reservations.get(n).getMinute();

                if(minute == 0)
                {
                    minuteAsString = "00";
                    System.out.printf("%10s\t%s%10s,%4d%4d:%s%n", name, phoneNumber, month, date, hour, minuteAsString);
                }
                else
                {
                    System.out.printf("%10s\t%s%10s,%4d%4d:%d%n", name, phoneNumber, month, date, hour, minute);
                }
            }
        }
        //printing the reservations that includes a specific date
        else
        {
            for(int n = 0; n < indexes.size(); n++)
            {
                name = names.get(indexes.get(n));
                phoneNumber = phoneNumbers.get(indexes.get(n));
                month = reservations.get(indexes.get(n)).getMonth();
                date = reservations.get(indexes.get(n)).getDayOfMonth();
                hour = reservations.get(indexes.get(n)).getHour();
                minute = reservations.get(indexes.get(n)).getMinute();

                if(minute == 0)
                {
                    minuteAsString = "00";
                    System.out.printf("%10s%10s%10s,%4d%4d:%s%n", name, phoneNumber, month, date, hour, minuteAsString);
                }
                else
                {
                    System.out.printf("%10s%10s%10s,%4d%4d:%d%n", name, phoneNumber, month, date, hour, minute);
                }
            }
        }
    }
}
