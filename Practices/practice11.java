package Practices;
import java.util.ArrayList;
import java.util.Scanner;

public class practice11

{
    private static final double APPLE_PRICE = 1;
    private static final double BANANA_PRICE = 0.75;
    private static final double BREAD_PRICE = 1.5;
    private static final double MILK_PRICE = 2.5;
    
    public static void main(String[] args)
    {
        int choice;

        Scanner in = new Scanner(System.in);
        ArrayList<String> cart = new ArrayList<String>();

        choice = 0;

        while(choice != 5)
        {
            System.out.println("\nShopping Cart Menu:\n1. Add an item to the cart\n2. Remove an item from the cart\n3. Print the item with the most occurrences in the cart\n4. Print the total of the cart\n5. Exit");
            System.out.print("Enter your choice: ");
            choice = in.nextInt();

            if(choice == 1)
            {
                addItem(cart);   
            }
            else if(choice == 2)
            {
                removeItem(cart);
            }
            else if(choice == 3)
            {
                findMostOccurrences(cart);
            }
            else if(choice == 4)
            {
                findTotalPrice(cart);
            }
            else if(choice == 5)
            {
                System.out.println("\nExiting the program. Thank you!");
            }
            else
            {
                System.out.println("\nInvalid choice. Please try again.");
            }
        }

        in.close();
    }

    @SuppressWarnings("resource")
    public static void addItem(ArrayList<String> cart)
    {
        int choice;

        Scanner in = new Scanner(System.in);

        System.out.println("\nAvailable grocery items:\n1. Apple - $1.0\n2. Banana - $0.75\n3. Milk - $2.5\n4. Bread - $1.5");
        System.out.print("Enter the number of the item to add to the cart: ");
        choice = in.nextInt();

        if(choice == 1)
        {
            cart.add("Apple");
            System.out.println("\nApple added to the cart.");
        }
        else if(choice == 2)
        {
            cart.add("Banana");
            System.out.println("\nBanana added to the cart.");
        }
        else if(choice == 3)
        {
            cart.add("Milk");
            System.out.println("\nMilk added to the cart.");
        }
        else if(choice == 4)
        {
            cart.add("Bread");
            System.out.println("\nBread added to the cart.");
        }
        else
        {
            System.out.println("\nInvalid choice. Please try again.");
        }
    }

    @SuppressWarnings("resource")
    public static void removeItem(ArrayList<String> cart)
    {
        int choice;

        Scanner in = new Scanner(System.in);

        if(cart.size() == 0)
        {
            System.out.println("\nThe cart is empty. Nothing to remove.");
        }
        else
        {
            System.out.println("\nItems in the cart: ");

            for(int itemNum = 0; itemNum < cart.size(); itemNum++)
            {
                System.out.println((itemNum + 1) + ". " + cart.get(itemNum));
            }

            System.out.print("\nEnter the number of the item to remove from the list: ");
            choice = in.nextInt();

            if(choice > 0 && choice <= cart.size())
            {
                System.out.println("\n" + cart.get(choice - 1) + " removed from the cart.");
                cart.remove(choice - 1);
            }
            else
            {
                System.out.println("\nInvalid item number. Please try again.");
            }
        }
    }

    public static void findMostOccurrences(ArrayList<String> cart)
    {
        String temporary;
        String mostOccurredFruit;
        int counter;
        int maxCounter;

        if(cart.size() == 0)
        {
            System.out.println("\nCart is empty.");
        }
        else
        {
            for(int n = 0; n < cart.size() - 1; n++)
            {
                for(int j = n + 1; j < cart.size(); j++)
                {
                    if(cart.get(j).compareTo(cart.get(n)) < 0)
                    {
                        temporary = cart.get(n);
                        cart.set(n, cart.get(j));
                        cart.set(j, temporary);
                    }
                }
            } 
            
            counter = 1;
            maxCounter = -1;
            mostOccurredFruit = "";

            for(int k = 1; k < cart.size(); k++)
            {
                if(cart.get(k).equals(cart.get(k - 1)))
                {
                    counter++;
                }

                if(k == cart.size() - 1 || !cart.get(k).equals(cart.get(k - 1)))
                {
                    if(counter > maxCounter)
                    {
                        maxCounter = counter;
                        mostOccurredFruit = cart.get(k - 1);
                    }

                    counter = 1;
                }
            }

            System.out.println("\nThe most common item in the cart is: " + mostOccurredFruit);
            
        }
    }

    public static void findTotalPrice(ArrayList<String> cart)
    {
        double price;

        price = 0;

        for(int n = 0; n < cart.size(); n++)
        {
            if(cart.get(n).equals("Apple"))
            {
                price += APPLE_PRICE;
            }

            if(cart.get(n).equals("Banana"))
            {
                price += BANANA_PRICE;
            }

            if(cart.get(n).equals("Bread"))
            {
                price += BREAD_PRICE;
            }

            if(cart.get(n).equals("Milk"))
            {
                price += MILK_PRICE;
            }    
        }

        System.out.println("\nTotal price of the cart: " + price);
    }
}
