package Lab10;

public class Customer 
{
    //data members
    private String name;
    private String phoneNum;
    
    //constructor
    public Customer(String name, String phoneNum)
    {
        this.name = name;
        this.phoneNum = phoneNum;
    }

    //getters
    public String getName()
    {
        return name;
    }

    public String getPhoneNum()
    {
        return phoneNum;
    }

    //setters
    public void setName(String newName)
    {
        name = newName;
    }

    public void setPhoneNum(String newPhoneNum)
    {
        phoneNum = newPhoneNum;
    }

    //overloading the toString method
    public String toString()
    {
        return name + " " + phoneNum + ": ";
    }
}
