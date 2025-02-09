package PracticeOOP2;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    //data members
    private ArrayList<Item> items;

    //constructor
    public Inventory()
    {
        this.items = new ArrayList<Item>();   
    }

    //getters
    public ArrayList<Item> getItems()
    {
        return items;
    }

    //filling the inventory
    public void fillInventory()
    {
        int weight;
        int price;
        int count;
        int choice;

        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);

        choice = -1;

        while(choice != 5)
        {
            System.out.println("Type the number of the item you want to add to the inventory\n1) Book, 2) Television, 3) Water, 4) Milk, 5) Exit");
            choice = in.nextInt();
            
            if(choice == 1)
            {
                System.out.println("Enter the weight, price, and count for the Book. Use a whitespace to separate each value.");
                weight = in.nextInt();
                price = in.nextInt();
                count = in.nextInt();

                Item item = new Item(weight, price, count, "Book");
                items.add(item);
            }

            if(choice == 2)
            {
                System.out.println("Enter the weight, price, and count for the Television. Use a whitespace to separate each value.");
                weight = in.nextInt();
                price = in.nextInt();
                count = in.nextInt();

                Item item = new Item(weight, price, count, "Television");
                items.add(item);
            }

            if(choice == 3)
            {
                System.out.println("Enter the weight, price, and count for the Water. Use a whitespace to separate each value.");
                weight = in.nextInt();
                price = in.nextInt();
                count = in.nextInt();

                Item item = new Item(weight, price, count, "Water");
                items.add(item);
            }

            if(choice == 4)
            {
                System.out.println("Enter the weight, price, and count for the Milk. Use a whitespace to separate each value.");
                weight = in.nextInt();
                price = in.nextInt();
                count = in.nextInt();

                Item item = new Item(weight, price, count, "Milk");
                items.add(item);
            }
        }
    }

    //service methods
    public int getTotalPrice()
    {
        int totalPrice;

        totalPrice = 0;

        for(int n = 0; n < items.size(); n++) 
        {
            totalPrice += items.get(n).getPrice() * items.get(n).getCount();
        }
        
        return totalPrice;
    }

    public int getTotalWeight()
    {
        int totalWeight;

        totalWeight = 0;

        for(int n = 0; n < items.size(); n++)
        {
            totalWeight += items.get(n).getWeight() * items.get(n).getCount();
        }

        return totalWeight;
    }

    //displaying the inventory
    public void listInventory()
    {
        for(int n = 0; n < items.size(); n++)
        {
            System.out.println(items.get(n));   
        }   
    }
}
