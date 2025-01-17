package UI;
import java.util.Scanner;
public class UserInterface{
    public int MainMenu() throws InterruptedException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t\t------WELCOME TO THE AIRLINE------\n");
        System.out.println("1. Enter As Admin");
        System.out.println("2. Enter As User");
        System.out.println("3. Exit");
        int choice;
        while(true)
        {
            System.out.print("Select your operation (1/2/3): ");
            choice = scanner.nextInt();
            if(choice<1 || choice>3)
            {
                System.out.println("Invalid Input!");
            }
            else
                break;
        }
        System.out.println("Processing.......");
        clearScreen();
        return choice;
    }

    public int UserMenu() throws InterruptedException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("WELCOME USER!");
        System.out.println("1. Book A Flight");
        System.out.println("2. Cancel A Flight");
        System.out.println("3. Check Flight Details");
        System.out.println("4. Exit");
        int choice;
        while(true)
        {
            System.out.print("Select your operation (1/2/3/4): ");
            choice = scanner.nextInt();
            if(choice<1 || choice>4)
            {
                System.out.println("Invalid Input!");
            }
            else
                break;
        }
        System.out.println("Processing.......");
        clearScreen();
        return choice;
    }

    public int AdminMenu() throws InterruptedException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("WELCOME ADMIN!");
        System.out.println("1. Add A Flight");
        System.out.println("2. Remove A Flight");
        System.out.println("3. Update Flight Details");
        System.out.println("4. Display All Available Flights");
        System.out.println("5. Exit");
        int choice;
        while(true)
        {
            System.out.print("Select your operation (1/2/3/4/5): ");
            choice = scanner.nextInt();
            if(choice<1 || choice>5)
            {
                System.out.println("Invalid Input!");
            }
            else
                break;
        }
        System.out.println("Processing.......");
        clearScreen();
        return choice;
    }

    public void clearScreen() throws InterruptedException
    {
        Thread.sleep(3000);
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}