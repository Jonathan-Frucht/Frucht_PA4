package Frucht_PA3_2_Package;
public class SavingsAccount {

    static private double annualInterestRate;
    private  double savingBalance;


    public SavingsAccount(double savingBalance)
    {
        this.savingBalance = savingBalance;
    }
    public double getSavingBalance()
    {
        return this.savingBalance;
    }
    public static void modifyInterestRate(double newInterestRate)
    {
        annualInterestRate=newInterestRate;
    }
    public void calculateMonthlyInterest()
    {
        double monthlyInterest;
        monthlyInterest= (this.savingBalance*annualInterestRate/12);
        this.savingBalance+=monthlyInterest;
    }



    public static void main(String[] args) {
        // Instantiating two SavingsAccount objects
        SavingsAccount saver1, saver2;
        // Creating test balances
        double balance1 = 2000.0;
        double balance2 = 3000.0;
        // Creating test interest rates
        double newInterestRate1 = .04;   // First test Interest rate is 4%
        double newInterestRate2 = .05;   // Second test Interest rate is 5%
        // Initializing SavingsAccount variables
        saver1 = new SavingsAccount (balance1);
        saver2 = new SavingsAccount (balance2);

        int i;
        //Setting the annual interest rate to 4%
        SavingsAccount.modifyInterestRate (newInterestRate1);

        System.out.println("\nAnnual interest rate is 4%\nPrinting Balance for Saver 1\n");
        for(i = 1; i <= 12; ++i) {
            //Calculating the monthly interest for the first test case
            saver1.calculateMonthlyInterest();
            System.out.println("Month " + i + " : "+ String.format("%.2f",saver1.getSavingBalance()));
        }
        System.out.println("\nPrinting Balance for Saver 2\n");
        for(i = 1; i <= 12; ++i) {
            saver2.calculateMonthlyInterest();
            System.out.println("Month " + i + " : "+ String.format("%.2f",saver2.getSavingBalance()));
        }


        //Setting the annual interest rate to 5%
        SavingsAccount.modifyInterestRate(newInterestRate2);
        System.out.println("\n Annual interest rate changed to 5% \nPrinting Balance for Saver 1\n");
        for(i = 1; i <= 12; ++i) {
            //Calculating the monthly interest for the second test case
            saver1.calculateMonthlyInterest();
            System.out.println("Month " + i + " : " + String.format("%.2f",saver1.getSavingBalance()));
        }
        System.out.println("\nPrinting Balance for Saver 2\n");
        for(i = 1; i <= 12; ++i) {
            saver2.calculateMonthlyInterest();
            System.out.println("Month " + i + " : " + String.format("%.2f",saver2.getSavingBalance()));
        }

    }
}



