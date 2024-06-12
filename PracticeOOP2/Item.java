package PracticeOOP2;

public class Item {
    //static data members
    private static int counter = 0;

    //instance data members
    private int count;
    private int ID;
    private int weight;
    private int price;
    private String type;
    
    //constructor
    public Item(int weight, int price, int count, String type)
    {
        counter++;
        ID = counter;
        setWeight(weight);
        setPrice(price);
        setType(type);
        setCount(count);
    }

    //getters
    public int getID()
    {
        return ID;
    }

    public int getWeight()
    {
        return weight;
    }

    public int getPrice()
    {
        return price;
    }

    public int getCount()
    {
        return count;
    }

    public String getType()
    {
        return type;
    }

    //setters
    public void setCounter(int newCounter)
    {
        counter = newCounter;
    }

    public void setWeight(int newWeight)
    {
        if(newWeight > 0)
        {
            weight = newWeight;
        }
    }

    public void setPrice(int newPrice)
    {
        if(newPrice > 0)
        {
            price = newPrice;
        }
    }

    public void setType(String newType)
    {
        if(newType.equals("Book") || newType.equals("Television") || newType.equals("Water") || newType.equals("Milk"))
        {
            type = newType;
        }
    }

    public void setCount(int newCount)
    {
        if(newCount > 0)
        {
            count = newCount;
        }
    }


    //override methods
    public String toString()
    {
        return "Item" + ID + ":\n\tType: " + type + "\n\tCount: " + count + "\n\tWeight: " + weight + "\n\tPrice: " + price;
    }
}
