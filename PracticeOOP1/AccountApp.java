package PracticeOOP1;
public class AccountApp 
{
    public static void main(String[] args) 
    {
        Account account1 = new Account("Personal", "John Goodman", "01-01-2013");
        Account account2 = new Account("Investment", "Kaan Goodman", "08-04-2017");
        Account account3 = new Account("Student", "Rose Goodwoman", "11-02-2022");
        account1.cashDeposit(1000);
        account1.cashWithdrawal(500);
        account1.deactivate();
        account2.cashDeposit(2400);
        account2.cashWithdrawal(2500);
        
        System.out.println("Account1 Status: " + account1.isActive());
        System.out.println("Account1 balance: " + account1.getBalance());
        System.out.println("Account2 balance: " + account2.getBalance());
        
        account3.cashDeposit(2400);
        account1.transaction(account3, 1200);
        account1.activate();
        account1.cashDeposit(500);
        account1.transaction(account3, 1200);
        double hasDebt = account1.getDebt();
        System.out.println("Account1 debt amount: " + hasDebt);
        System.out.println("Account1 balance: " + account1.getBalance());
        System.out.println("Account3 balance: " + account3.getBalance());
        System.out.println(account1);
        System.out.println(account2);
        System.out.println(account3);

        
    }   
}
