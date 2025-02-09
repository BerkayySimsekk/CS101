package PracticeOOP1;
public class Account 
{
    //static data members
    private static int noOfAccounts = 0;
    
    //instance data members
    private int maxDebtLimit;
    private String type;
    private int ID;
    private String owner;
    private int balance;
    private String creationDate;;
    private int debt;
    private boolean isActive;

    //constructor
    public Account(String type, String owner, String creationDate)
    {
        noOfAccounts++;
        this.type = type;
        this.owner = owner;
        this.creationDate = creationDate.replace("-", "/");
        this.ID = noOfAccounts;
        balance = 0;
        debt = 0;
        isActive = true;

        if(type.equals("Student"))
        {
            maxDebtLimit = 2000;
        }

        if(type.equals("Personal"))
        {
            maxDebtLimit = 1000;
        }

        if(type.equals("Business"))
        {
            maxDebtLimit = 50000;
        }

        if(type.equals("Investment"))
        {
            maxDebtLimit = 5000;
        }
    }

    //getters
    public int getMaxDebtLimit()
    {
        return maxDebtLimit;
    }

    public int getNoOfAccounts()
    {
        return noOfAccounts;
    }

    public String getType()
    {
        return type;
    }

    public int getID()
    {
        return ID;
    }

    public String getOwner()
    {
        return owner;
    }

    public int getBalance()
    {
        return balance;
    }

    public String getCreationDate()
    {
        return creationDate;
    }

    public int getDebt()
    {
        return debt;
    }

    public String isActive()
    {
        if(isActive)
        {
            return "Active";
        }
        else
        {
            return "Not active";
        }
    }

    //public setters
    public void cashWithdrawal(int amount)
    {
        if(isActive().equals("Active"))
        {
            if(balance >= amount)
            {
                System.out.println("Cash withdrawal of $" + amount+ " from account " + ID);
                balance -= amount;
            }
            else
            {
                debt += amount - balance;

                if(debt > maxDebtLimit)
                {
                    System.out.println("Request denied. Debt can't exceed maximum debt limit.");
                    debt -= amount - balance;
                }
                else
                {
                    System.out.println("Cash withdrawal of $" + amount+ " from account " + ID);
                    balance = 0;
                }    
            }      
        }
        else
        {
            System.out.println("Cash withdrawal failed. Account is inactive.");
        } 
    }

    public void cashDeposit(int amount)
    {
        if(isActive().equals("Active"))
        {
            System.out.println("Cash deposit of $" + amount + " into account " + ID);

            if(debt > 0 && debt >= amount)
            {
                debt -= amount;
            }
            
            if(debt > 0 && debt < amount)
            {
                balance += amount - debt;
                debt = 0;
            }

            if(debt == 0)
            {
                balance += amount;
            }  
        }
        else
        {
            System.out.println("Cash deposit failed. Account is inactive.");
        }      
    }

    public void deactivate()
    {
        System.out.println("Account " + ID + " has been deactivated.");
        isActive = false;
    }

    public void activate()
    {
        System.out.println("Account " + ID + " has been activated.");
        isActive = true;
    }

    //private setters
    private void setDebt(int newDebt)
    {
        debt = newDebt;
    }

    private void setBalance(int newBalance)
    {
        balance = newBalance;
    }

    //service methods
    public String hasDebt()
    {
        if(debt > 0)
        {
            return "Account " + ID + " has a debt of " + debt + ".";
        }
        else
        {
            return "Account " + ID + " does not have any debt.";
        }
    }

    public void transaction (Account destAccount, int amount)
    {
        boolean isSufficient;

        isSufficient = true;

        if(isActive().equals("Active") && destAccount.isActive().equals("Active"))
        {
            if(balance >= amount)
            {
                balance -= amount;
            }
            else
            {
                debt += amount - balance;

                if(debt > maxDebtLimit)
                {
                    debt -= amount - balance;
                    isSufficient = false;
                    System.out.println("Transaction failed. Account " + ID + " does not have enough balance and maximum debt limit.");
                }
                else
                {
                    balance = 0;
                }    
            }

            if(isSufficient)
            {
                if(destAccount.getDebt() > 0 && destAccount.getDebt() >= amount)
                {
                    destAccount.setDebt(destAccount.getDebt() - amount);
                }
                
                if(destAccount.getDebt() > 0 && destAccount.getDebt() < amount)
                {
                    destAccount.setBalance(destAccount.getBalance() + amount - destAccount.getDebt());
                    destAccount.setDebt(0);
                }

                if(destAccount.getDebt() == 0)
                {
                    destAccount.setBalance(destAccount.getBalance() + amount);
                }

                System.out.println("Transferred $" + amount + " from account " + ID + " to account " + destAccount.getID());
            }
        }
        else
        {
            System.out.println("Transaction failed. One or both accounts are inactive.");   
        }      
    }

    //override methods
    public String toString()
    {
       return "*************************************************" + "\nAccount Information: " + "\nID: " + ID + "\nType: " + type + "\nOwner: " + owner + "\nBalance: "+ balance + "\nMax Debt Limit: " + maxDebtLimit + "\nCreation Date: " + creationDate +  "\nDebt: " + debt + "\nStatus: " + isActive() + "\n*************************************************";
    }
}
