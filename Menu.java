package ATMINTERFACE;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat =new DecimalFormat("'$'###,##0.00");
    HashMap<Integer,Integer> data = new HashMap<Integer,Integer>();
    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(952141,191904);
                data.put(212212, 212);

                System.out.println("Welcome to the ATM project");
                System.out.println("Enter your customer number");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Enter your pin number");
                setPinNumber(menuInput.nextInt());

            } catch (Exception e) {
                System.out.println("Invalid character, Enter only Number" + "\n");
                x = 2;
            }
            /*
            *for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
            *if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
            *getAccountType();
                }
            }
            */
            int cn = getCustomerNumber();
            int pn = getPinNumber();
            if (data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType();
            } else
                System.out.println("\n" + "Wrong customer number" + "\n");
        }
        while (x == 1);
    }
    //display Account type menu
    public void getAccountType() {
        System.out.println("Select the Account you want to access: ");
        System.out.println(" Type 1 - Checking Balance");
        System.out.println(" Type 2 - Saving Balance");
        System.out.println(" Type 3 - Exit");

        int selection = menuInput.nextInt();

        switch (selection){
            case 1:
                getChecking();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                System.out.println("Thank you for using this ATM, Bye");
                break;

            default:
                System.out.println("Invalid Choice"+"\n");
                getAccountType();
        }
    }
    //Display Checking Account Menu with Selection
    public void getChecking() {
        System.out.println("Checking Account:");
        System.out.println(" Type 1 : View Balance");
        System.out.println(" Type 2 : Withdraw funds");
        System.out.println(" Type 3 : Deposit funds");
        System.out.println(" Type 4 : Exit");
        System.out.println("Choice : ");
        int selection = menuInput.nextInt();

         switch (selection) {
            case 1:
                System.out.println("Checking Account Balance: "+moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;

            case 2:
                getCheckingWithdrawalInput();
                getAccountType();
                break;

            case 3:
                getCheckingDepositInput();
                break;

             case 4:
                 System.out.println("Thank you for using this ATM, bye.");
                 break;

            default:
                System.out.println("\n"+"Invalid Choice"+"\n");
                getChecking();
        }
    }
    //Display Saving Account menu with Selection
    public void getSaving() {
        System.out.println("Saving Account: ");
        System.out.println(" Type 1 - View Balance");
        System.out.println(" Type 2 - Withdraw funds");
        System.out.println(" Type 3 - Deposit funds");
        System.out.println(" Type 4 - Exit");
        System.out.println("Choice -  "+"\n");

        int selection = menuInput.nextInt();

        switch (selection){
            case 1:
                System.out.println("Saving Account Balance: "+moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                break;
            default:
                System.out.println("\n"+"Invalid Choice"+"\n");
                getSaving();
        }
    }
}
