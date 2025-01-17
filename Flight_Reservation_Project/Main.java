import AdminFlights.*;
import Passenger.*;
import java.io.*;
import java.util.*;
import UI.*;
public class Main {
    public static void main(String[] args) throws IOException , InterruptedException{
        UserAccess user = new UserAccess();
        Flight admin = new Flight();
        UserInterface UI = new UserInterface();
        String AdminPass = "Admin1234";
        while(true){
        int mainChoice = UI.MainMenu();
        if(mainChoice == 1)
        {
            Scanner TakeInput = new Scanner(System.in);
            System.out.print("Enter Admin Password to Login: ");
            String checkPass = TakeInput.nextLine();
            System.out.println("Processing....");
            UI.clearScreen();
            if(AdminPass.equals(checkPass))
            {
                int AdminChoice=0;
                while(AdminChoice!=5)
                {
                    AdminChoice = UI.AdminMenu();
                    switch (AdminChoice) {
                        case 1:
                            admin.addFlight();
                            break;
                    
                        case 2:
                            admin.RemoveFlight();
                            break;
                    
                        case 3:
                            admin.updateFlight();
                            break;

                        case 4:
                            admin.DisplayAllFlights();
                            break;

                        case 5:
                            System.out.println("Returning to main menu......");
                            UI.clearScreen();
                            break;    

                        default:
                            break;
                    }
                }
            }
            else
            {
                System.out.println("Incorrect Password For Admin!\nReturning to Menu......");
                UI.clearScreen();
            }
        }
        else if(mainChoice == 2)
        {
            int userChoice=0;
            while(userChoice!=4)
            {
                userChoice = UI.UserMenu();
                switch (userChoice) {
                    case 1:
                        user.BookFlight();
                        break;

                    case 2:
                        user.CancelFlight();
                        break;

                    case 3:
                        user.checkFlightStatus();
                        break; 
                    
                    case 4:
                        System.out.println("Returning to main menu......");
                        UI.clearScreen();
                        break;

                    default:
                        break;
                }
            }
        }
        else if(mainChoice == 3)
        {
            System.out.println("Exiting the Program......");
            UI.clearScreen();
            System.out.println("Thanks for using the system!");
            return;
        }
    }
    }
}
