package Lab10;

import java.util.ArrayList;
import java.util.Scanner;

public class ReservationApplication 
{
    public static void main(String[] args)
    {
        //variables
        int choice;
        boolean isDone;

        //objects
        Scanner in = new Scanner(System.in);
        ArrayList<Reservation> reservations = new ArrayList<Reservation>();
        
        //filling the array list with random reservations that contain customer information with the usage of "ReservationGenerator" class
        reservations = ReservationGenerator.getRandomReservationList(10, "APRIL", 2, 29);

        isDone = false;

        //a loop that continues until the user enters "5"
        while(!isDone)
        {
            System.out.println("1) Search reservations by date\n2) Cancel Reservation\n3) Display all reservations\n4) Sort Reservations\n5) Exit");

            System.out.print("Enter choice: ");
            choice = in.nextInt();
            
            //finding the reservations that are on the given date
            if(choice == 1)
            {
                findReservations(reservations);
            }

            //cancelling the reservation if the information given regarding the name and phone number of the customer are found
            if(choice == 2)
            {
               cancelReservation(reservations);
            }

            //printing the reservations
            if(choice == 3)
            {
                printReservations(reservations);
            }

            //sorting the reservations in increasing order by their dates
            if(choice == 4)
            {
                bubbleSort(reservations);
            }

            //exiting the loop
            if(choice == 5)
            {
                isDone = true;
            }

            System.out.println();
        }

        in.close();
    }

    /**
     * Prints each reservation date with the attached customer information that includes customer name and customer phone number
     * @param reservations (an array list of reservations)
     */
    public static void printReservations(ArrayList<Reservation> reservations)
    {
        System.out.println("ALL RESERVATIONS\n--------------------");

        //printing out each reservation date and customer information
        for(int n = 0; n < reservations.size(); n++)
        {
            System.out.println(reservations.get(n));  
        } 
    }

    /**
     * Cancels the reservation if the given parameters regarding the name and the phone number of the customer can be found
     * @param reservations (an array list of reservations)
     */
    public static void cancelReservation(ArrayList<Reservation> reservations)
    {
        //variables
        String name;
        String phoneNumber;
        int prevSize;

        //objects
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);

        //getting input regarding the name and phone number of the customer
        System.out.print("Enter name of customer: ");
        name = in.nextLine();

        System.out.print("Enter phone number of customer: ");
        phoneNumber = in.nextLine();

        //getting the size of reservations list so that we can find out if the size of this list is changed which means a customer with given information was found and removed
        prevSize = reservations.size();

        //finding if the given name and the phone number exists in the list; if it does, it is removed
        for(int n = 0; n < reservations.size(); n++)
        {
            if(reservations.get(n).getCustomer().getName().equals(name) && reservations.get(n).getCustomer().getPhoneNum().equals(phoneNumber))
            {
                reservations.remove(n);
            }
        }

        //checking if a reservation was removed from the list
        if(prevSize == reservations.size())
        {
            System.out.println("Reservation not found...");
        }
        else
        {
            System.out.println("Reservation cancelled...");
        }
    }

    /**
     * Finds reservations that are on the given date
     * @param reservations (an array list of reservations)
     */
    public static void findReservations(ArrayList<Reservation> reservations)
    {
        //variables
        int date;

        //objects
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);

        //getting input regarding the date to search
        System.out.print("Enter date to search: ");
        date = in.nextInt();

        System.out.println("Reservations on April " + date);

        //finding the reservations that are on the given date
        for(int n = 0; n < reservations.size(); n++)
        {
            if(reservations.get(n).getReservation().getDayOfMonth() == date)
            {
                System.out.println(reservations.get(n));
            }
        }  
    }

    /**
     * Sorts the reservations in increasing order by their dates
     * @param reservations (an array list of reservations)
     */
    public static void bubbleSort(ArrayList<Reservation> reservations)
    {
        //variables
        Reservation temporary;
        boolean isSorted;

        isSorted = false;

        //a loop that gets each element one by one
        for(int n = 0; n < reservations.size() && !isSorted; n++)
        {
            isSorted = true;
            //a loop that gets every element that comes after the element that is got by the previous loop
            for(int k = 1; k < reservations.size() - n; k++)
            {
                //checking if the reservation that is found by the second loop is before the reservation that is found by the first loop 
                if(reservations.get(k).getReservation().isBefore(reservations.get(k - 1).getReservation()))
                {
                    isSorted = false;
                    //swapping the indexes of these two reservations with each other
                    temporary = reservations.get(k - 1);
                    reservations.set(k - 1, reservations.get(k));
                    reservations.set(k, temporary); 
                }
            }
        }
    }
}
