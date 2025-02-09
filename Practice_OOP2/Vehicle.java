package PracticeOOP2;

import java.util.ArrayList;

public class Vehicle {
    //static data members
    private static int counter = 0;  
    
    //instance data members
    private int ID;
    private int weightCapacity;
    private int cost;
    private int currentWeight;
    private ArrayList<Item> items;

    //constructor
    public Vehicle()
    {
        counter++;
        ID = counter;
        weightCapacity = 100;
        cost = 100;
        currentWeight = 0;
        items = new ArrayList<Item>();
    }

    //getters
    public int getID()
    {
        return ID;
    }

    public int getWeightCapacity()
    {
        return weightCapacity;
    }

    public int getCost()
    {
        return cost;
    }

    public int getCurrentWeight()
    {
        return currentWeight;
    }

    public ArrayList<Item> getItems()
    {
        return items;
    }


    //setters
    public void setCounter(int newCounter)
    {
        counter = newCounter;
    }

    public void setCurrentWeight(int newCurrentWeight)
    {
        if(newCurrentWeight >= 0)
        {
            currentWeight = newCurrentWeight;
        }
    }

    public void setItems(ArrayList<Item> newItems)
    {
        items = newItems;
    }

    //service methods
    public void addItem(Item item)
    {
        items.add(item);
    }

    public int findRemainingCapacity()
    {
        return weightCapacity - currentWeight;
    }

    //override methods
    public String toString()
    {
        String vehicle;

        vehicle = "Vehicle " + ID + ":\n\tRemaining Capacity: " + findRemainingCapacity() + "\n\tShipping Cost: " + cost + "\n\tCurrent Weight: " + currentWeight + "\nItems:\n ";

        for(int n = 0; n < items.size(); n++)
        {
            vehicle += items.get(n) + "\n";
        }

        return vehicle;
    }
}
