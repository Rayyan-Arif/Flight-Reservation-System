package Passenger;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Scanner;
import AdminFlights.*;

public class UserAccess{
    private String contact;
    private String CNIC;
    private String passengerName;
    private String Flight_number;

    public void BookFlight() throws IOException , InterruptedException
    {
        Scanner TakeInput = new Scanner(System.in);
        Flight f = new Flight();
        File checkFile = new File("Flights.txt");
        if(checkFile.exists() == false)
        {
            System.out.println("No Flights Available!\n");
            return;
        }
        System.out.print("Enter your full Name: ");
        passengerName = TakeInput.nextLine();
        System.out.print("Enter your contact: ");
        contact = TakeInput.nextLine();
        if(checkContact(contact))
        {
            System.out.println("Please enter valid Contact Number!\n");
            return;
        }
        System.out.print("Enter your CNIC (without dashes): ");
        CNIC =  TakeInput.nextLine();
        if(checkCNIC(CNIC))
        {
            System.out.println("Please enter valid CNIC!\n");
            return;
        }
        System.out.print("Enter Flight Number: ");
        Flight_number = TakeInput.nextLine();
        if(f.FindFlight(Flight_number))
        {
            if(f.BookAndCancelFlight(Flight_number, 1))
            {
                System.out.println("Flight has been completely Booked!\n");
                return;
            }
            FileWriter openFile = new FileWriter("BookedFlights.txt" , true);
            BufferedWriter writeFile = new BufferedWriter(openFile);
            System.out.println("\nFlight has been booked........");
            clearScreen();
            writeFile.write(passengerName+"\n");
            writeFile.write(contact+"\n");
            writeFile.write(CNIC+"\n");
            writeFile.write(Flight_number+"\n\n");
            writeFile.close();
        }
    }

    public void CancelFlight() throws IOException , InterruptedException
    {
        int counter = 0;
        Scanner TakeInput = new Scanner(System.in);
        Flight f = new Flight();
        File checkFile = new File("Flights.txt");
        if(checkFile.exists() == false)
        {
            System.out.println("No Flights Available!\n");
            return;
        }
        File BookedFile = new File("BookedFlights.txt");
        if(BookedFile.exists() == false)
        {
            System.out.println("Flight Not booked yet!\n");
            return;
        }
        FileReader openFile = new FileReader("BookedFlights.txt");
        BufferedReader readFile = new BufferedReader(openFile);
        System.out.print("Enter your CNIC (without dashes): ");
        String checkCNIC =  TakeInput.nextLine();
        System.out.print("Enter Flight Number: ");
        String checkFlight = TakeInput.nextLine();
        if(f.FindFlight(checkFlight))
        {
            while((passengerName = readFile.readLine())!=null)
            {
                if(passengerName.length() == 0)
                    continue;
                contact = readFile.readLine();
                CNIC = readFile.readLine();
                Flight_number = readFile.readLine();
                if(checkCNIC.equals(CNIC) && checkFlight.equals(Flight_number))
                {
                    System.out.println("Your Details: \n");
                    System.out.println("Name: "+passengerName);
                    System.out.println("Contact: "+contact);
                    System.out.println("CNIC: "+CNIC);
                    System.out.println("Flight: "+Flight_number+" \n");
                    f.BookAndCancelFlight(Flight_number, 2);
                    System.out.println("\nFlight has been cancelled........");
                    counter++;
                    readFile.close();
                    clearScreen();
                    FileReader OpenFile = new FileReader("BookedFlights.txt");
                    BufferedReader ReadFile = new BufferedReader(OpenFile);
                    FileWriter OpenTempFile = new FileWriter("TempFile.txt");
                    BufferedWriter writeInFile = new BufferedWriter(OpenTempFile);
                    while((passengerName = ReadFile.readLine())!=null)
                    {
                        if(passengerName.length() == 0)
                        continue;
                        contact = ReadFile.readLine();
                        CNIC = ReadFile.readLine();
                        Flight_number = ReadFile.readLine();
                        if(CNIC.equals(checkCNIC) && Flight_number.equals(checkFlight))
                        {
                            continue;
                        }
                        writeInFile.write(passengerName+"\n");
                        writeInFile.write(contact+"\n");
                        writeInFile.write(CNIC+"\n");
                        writeInFile.write(Flight_number+"\n\n");
                    }
                    writeInFile.close();
                    ReadFile.close();
                    File f1 = new File("BookedFlights.txt");
                    File f2 = new File("TempFile.txt");
                    f1.delete();
                    f2.renameTo(f1);
                    break;
                }
            }
            
        }
        if(counter==0)
        {
            System.out.println("You have not booked this flight!\n");
            readFile.close();
            return;
        }
    }

    public void checkFlightStatus() throws IOException , InterruptedException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter flight number: ");
        Flight_number = scanner.nextLine();
        Flight f = new Flight();
        f.FindFlight(Flight_number);
        System.out.println("Returning to menu.......");
        clearScreen();
    }

    public void clearScreen() throws InterruptedException
    {
        Thread.sleep(5000);
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public boolean checkCNIC(String checkCNIC){
        if(checkCNIC.length() != 13)
            return true;
        return false;
    }

    public boolean checkContact(String checkContact){
        if(checkContact.length() != 11)
            return true;
        return false;
    }
}