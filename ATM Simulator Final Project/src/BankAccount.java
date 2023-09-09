import java.util.Scanner;

/**
 * A class that has the validatePin, withdrawl, and deposit method
 * @author ckalyssa
 */
public class BankAccount
{
    //instance variables
    private double balance;
    private String pin;

    /**
     * Constructor
     * @param password a 4 digit pin as a String
     * @param accBal a double value that represents the account's balance
     */

    public BankAccount(String password, double accBal)
    {
        pin = password;
        balance = accBal;
    }

    /**
     * method that validates if the input pin is the same as the pin the account was created with
     * @param givenPin is the pin given by the user
     * @return access returns if the pin is valid or not with a boolean
     * allows user to try 5 different inputs, or else it locks the account
     * checks if the given pin is the same as the original pin given for the account
     */
    public boolean validatePin(String givenPin)
    {
        boolean access = false;
        for (int counter = 4; counter >= 0; counter--)
        {
            //checks if they are the same pin
            if (pin.equals(givenPin))
            {
                access = true;
            }
            //checks to see how many attempts the user has left and has attempted
            else if (counter > 0)
            {
                System.out.println("Wrong pin. Try again. You have " + counter + " more attempts.");
                System.out.println("Enter in the 4 digit pin: ");
                Scanner pinScan = new Scanner(System.in);
                givenPin = pinScan.next();
            }
            //ends the simulation if the wrong pin has been entered 5 times
            else
            {
                System.out.println("You have been denied access to the bank account. The account is now locked. The simulation has ended.");
                access = false;
            }
        }
        return access;
    }

    /**
     * @param withdrawlAmount the amount the user wants to withdrawl
     * updates the balance if the account has sufficient funds
     * checks to see if the withdrawl amount is greater than the account balance
     */
    public void withdrawl(double withdrawlAmount)
    {
        //updates the balance
        if (withdrawlAmount <= balance)
        {
            balance = balance - withdrawlAmount;
            System.out.println("You have successfully withdrawled $" + withdrawlAmount);
            System.out.println("Your account balance is now $" + balance);
        }
        //checks to see if the withdrawla mount is greater than the account balance
        else if (withdrawlAmount > balance)
        {
            System.out.println("Insufficient funds. You are not able to withdrawl this amount. You do not want to go into debt!");
        }
    }

    /**
     * @param depositAmount the amount the user wants to deposit
     * updates the account balance
     */
    public void deposit(double depositAmount)
    {
        balance = balance + depositAmount;
        System.out.println("You have successfully deposited $" + depositAmount);
        System.out.println("Your account balance is now $" + balance);
    }
}