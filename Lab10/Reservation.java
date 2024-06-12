package Lab10;

import java.time.LocalDateTime;

public class Reservation 
{
    //data members
    private LocalDateTime reservation;
    private Customer customer;
    
    //constructor
    public Reservation(LocalDateTime reservation, Customer customer)
    {
        this.reservation = reservation;
        this.customer = customer;
    }

    //getters
    public LocalDateTime getReservation()
    {
        return reservation;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    //setters
    public void setReservation(LocalDateTime newReservation)
    {
        reservation = newReservation;
    }

    public void setCustomer(Customer newCustomer)
    {
        customer = newCustomer;
    }

    //overloading the toString method
    public String toString()
    {
        String minute;

        if(reservation.getMinute() == 0)
        {
            minute = "00";
        }
        else
        {
            minute = reservation.getMinute() + "";
        }

        return customer + "" + reservation.getDayOfMonth() + " " + reservation.getMonth() + " " + reservation.getHour() + ":" + minute;
    }
}
