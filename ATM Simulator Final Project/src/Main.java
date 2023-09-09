import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //introduction
        System.out.println("Welcome to the ATM money simulator.");

        //creating the simulated account
        System.out.println("Enter the amount of money you would like to have in your account($): ");
        Scanner in = new Scanner(System.in);
        double myBal = in.nextDouble();
        System.out.println("Your account needs a pin! Enter a four digit code using only numbers: ");
        String myPin = in.next();
        BankAccount myAcc = new BankAccount(myPin, myBal);
        System.out.println("Your account has been created! Your account balance is $" + myBal);

        //verifies if the user enters the correct pin that was entered before
        System.out.println("You can now withdrawl and deposit money in your account!");
        System.out.println("To verify it is you, enter your 4 digit pin (you have 5 attempts): ");
        String pin = in.next();
        boolean access = myAcc.validatePin(pin);

        //asks the user if they want to withdrawl or deposit money or exit the simulation
        while(access == true)
        {
            //prompts the user to decide to withdrawl money, deposit money, or exit the simulation
            System.out.println("Enter 1 to withdrawl money, 2 to deposit money, or type \"exit\" to exit: ");
            String decision = in.next();

            //for withdrawling money
            if (decision.equals("1"))
            {
                System.out.println("How much money would you like to withdrawl?");
                double amountWith = in.nextDouble();
                myAcc.withdrawl(amountWith);

            }
            //for depositing money
            else if (decision.equals("2"))
            {
                System.out.println("How much money would you like to deposit?");
                double amountDepo = in.nextDouble();
                myAcc.deposit(amountDepo);
            }
            //for exiting the simulation
            else if (decision.equals("exit"))
            {
                System.out.println("You have successfully exited the simulation. Have a nice day!");
                break;
            }
            //if the user provided an input that is not valid
            else
            {
                System.out.println("Invalid input. Try again.");
            }
        }

    }
}