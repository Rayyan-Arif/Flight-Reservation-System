package AdminFlights;
import java.io.*;
import java.util.*;
public class Flight{
    private String FlightNum;
    private String destination ,departure , arrival;
    public int NoOfSeats;
    private String priceOfTicket;
    private String date , departure_point;

    public void addFlight() throws IOException , InterruptedException
    {
        Scanner TakeInput = new Scanner(System.in);
        FileWriter OpenFile = new FileWriter("Flights.txt",true);
        BufferedWriter writeInFile = new BufferedWriter(OpenFile);
        System.out.print("Enter flight number: ");
        FlightNum = TakeInput.nextLine();
        if(checkDuplicateFlight(FlightNum))
        {
            System.out.println("Flight cannot be added!\n");
            writeInFile.close();
            System.out.println("Returning to menu.......");
            clearScreen();
            return;
        }
        System.out.print("Enter Departure Point: ");
        departure_point = TakeInput.nextLine();
        System.out.print("Enter Destination: ");
        destination = TakeInput.nextLine();
        System.out.print("Enter Date of Flight: ");
        date = TakeInput.nextLine();
        System.out.print("Enter Departure Time: ");
        departure = TakeInput.nextLine();
        System.out.print("Enter Arrival Time: ");
        arrival = TakeInput.nextLine();
        System.out.print("Enter Available Seats: ");
        NoOfSeats = Integer.parseInt(TakeInput.nextLine());
        System.out.print("Enter Price of Ticket: ");
        priceOfTicket = TakeInput.nextLine();
        writeInFile.write(FlightNum+"\n");
        writeInFile.write(departure_point+"\n");
        writeInFile.write(destination+"\n");
        writeInFile.write(date+"\n");
        writeInFile.write(departure+"\n");
        writeInFile.write(arrival+"\n");
        writeInFile.write(NoOfSeats+"\n");
        writeInFile.write(priceOfTicket+"\n\n");
        writeInFile.close();
        System.out.println("Flight Added Succesfully!\n");
        System.out.println("Returning to menu.......");
        clearScreen();
    }

    public void DisplayAllFlights() throws IOException , InterruptedException
    {
        File checkFile = new File("Flights.txt");
        if(checkFile.exists() == false)
        {
            System.out.println("No Flights Available!\n");
            return;
        }
        FileReader openFile = new FileReader("Flights.txt");
        BufferedReader readFile = new BufferedReader(openFile);
        System.out.println("ALL FLIGHT DETAILS!\n\n");
        while((FlightNum = readFile.readLine())!=null)
        {
            if(FlightNum.length() == 0)
                continue;
            System.out.println("Flight Number:   "+FlightNum);
            departure_point = readFile.readLine();
            System.out.println("Departure Point:   "+departure_point);
            destination = readFile.readLine();
            System.out.println("Destination:   "+destination);
            date = readFile.readLine();
            System.out.println("Destination:   "+date);
            departure = readFile.readLine();
            System.out.println("Departure Time:   "+departure);
            arrival = readFile.readLine();
            System.out.println("Arrival Time:   "+arrival);
            NoOfSeats = Integer.parseInt(readFile.readLine());
            System.out.println("Available Seats:   "+NoOfSeats);
            priceOfTicket = readFile.readLine();
            System.out.println("Price Of Ticket:   "+priceOfTicket+"\n\n");
        }
        readFile.close();
        System.out.println("Returning to menu after 10 seconds.......");
        Thread.sleep(5000);
        clearScreen();
    }

    public void RemoveFlight() throws IOException, InterruptedException
    {
        File checkFile = new File("Flights.txt");
        if(checkFile.exists() == false)
        {
            System.out.println("No Flights Available!\n");
            return;
        }
        Scanner TakeInput = new Scanner(System.in);
        FileReader openFile = new FileReader("Flights.txt");
        BufferedReader readFile = new BufferedReader(openFile);
        FileWriter openTempFile = new FileWriter("TempFile.txt");
        BufferedWriter writeInFile = new BufferedWriter(openTempFile);
        System.out.print("Enter the flight number: ");
        String FindFlight = TakeInput.nextLine();
        boolean removeFlight = false;
        while((FlightNum = readFile.readLine())!=null)
        {
            if(FlightNum.length() == 0)
                continue;
            departure_point = readFile.readLine();
            destination = readFile.readLine();
            date = readFile.readLine();
            departure = readFile.readLine();
            arrival = readFile.readLine();
            NoOfSeats = Integer.parseInt(readFile.readLine());
            priceOfTicket = readFile.readLine();
            if(FlightNum.equals(FindFlight))
            {
                FindFlight(FlightNum);
                removeFlight = true;
                System.out.println("\nRemoving Flight.........");
                clearScreen();
                continue;
            }
            writeInFile.write(FlightNum+"\n");
            writeInFile.write(departure_point+"\n");
            writeInFile.write(destination+"\n");
            writeInFile.write(date+"\n");
            writeInFile.write(departure+"\n");
            writeInFile.write(arrival+"\n");
            writeInFile.write(NoOfSeats+"\n");
            writeInFile.write(priceOfTicket+"\n\n");
        }
        writeInFile.close();
        readFile.close();
        File f1 = new File("Flights.txt");
        File f2 = new File("TempFile.txt");
        f1.delete();
        f2.renameTo(f1);
        if(removeFlight)
        {
            System.out.println("Flight removed Successfully!\n");
        }
        else    
            System.out.println("Flight not Found!");
        System.out.println("Returning to menu.......");
        clearScreen();
    }

    public void updateFlight() throws IOException, InterruptedException
    {
        File checkFile = new File("Flights.txt");
        if(checkFile.exists() == false)
        {
            System.out.println("No Flights Available!\n");
            return;
        }
        Scanner TakeInput = new Scanner(System.in);
        FileReader openFile = new FileReader("Flights.txt");
        BufferedReader readFile = new BufferedReader(openFile);
        FileWriter openTempFile = new FileWriter("TempFile.txt");
        BufferedWriter writeInFile = new BufferedWriter(openTempFile);
        System.out.print("Enter the Flight number: ");
        String findFlight = TakeInput.nextLine();
        boolean update = false;
        while((FlightNum = readFile.readLine())!=null)
        {
            if(FlightNum.length() == 0)
                continue;
            if(FlightNum.equals(findFlight))
            {
                update = true;
                FindFlight(FlightNum);
                departure_point = readFile.readLine();
                destination = readFile.readLine();
                date = readFile.readLine();
                departure = readFile.readLine();
                arrival = readFile.readLine();
                NoOfSeats = Integer.parseInt(readFile.readLine());
                priceOfTicket = readFile.readLine();
                System.out.println("Enter new details of Flight "+FlightNum+": ");
                System.out.print("Enter Departure Point: ");
                departure_point = TakeInput.nextLine();
                System.out.print("Enter Destination: ");
                destination = TakeInput.nextLine();
                System.out.print("Enter Date of Flight: ");
                date = TakeInput.nextLine();
                System.out.print("Enter Departure Time: ");
                departure = TakeInput.nextLine();
                System.out.print("Enter Arrival Time: ");
                arrival = TakeInput.nextLine();
                System.out.print("Enter Available Seats: ");
                NoOfSeats = Integer.parseInt(TakeInput.nextLine());
                System.out.print("Enter Price of Ticket: ");
                priceOfTicket = TakeInput.nextLine();
                System.out.println("\nUpdating Flight Details.........");
                clearScreen();
                writeInFile.write(FlightNum+"\n");
                writeInFile.write(departure_point+"\n");
                writeInFile.write(destination+"\n");
                writeInFile.write(date+"\n");
                writeInFile.write(departure+"\n");
                writeInFile.write(arrival+"\n");
                writeInFile.write(NoOfSeats+"\n");
                writeInFile.write(priceOfTicket+"\n\n");
            }
            else
            {
                departure_point = readFile.readLine();
                destination = readFile.readLine();
                date = readFile.readLine();
                departure = readFile.readLine();
                arrival = readFile.readLine();
                NoOfSeats = Integer.parseInt(readFile.readLine());
                priceOfTicket = readFile.readLine();
                writeInFile.write(FlightNum+"\n");
                writeInFile.write(departure_point+"\n");
                writeInFile.write(destination+"\n");
                writeInFile.write(date+"\n");
                writeInFile.write(departure+"\n");
                writeInFile.write(arrival+"\n");
                writeInFile.write(NoOfSeats+"\n");
                writeInFile.write(priceOfTicket+"\n\n");
            }
        }
        readFile.close();
        writeInFile.close();
        File f1 = new File("Flights.txt");
        File f2 = new File("TempFile.txt");
        f1.delete();
        f2.renameTo(f1);
        if(update)
        {
            System.out.println("Flight details have been updated!\n");
        }
        else
            System.out.println("Flight Not Found!\n");
        System.out.println("Returning to menu.......");
        clearScreen();
    }

    public boolean FindFlight(String Flight_NUMBER) throws IOException , InterruptedException
    {
        File checkFile = new File("Flights.txt");
        if(checkFile.exists() == false)
        {
            System.out.println("No Flights Available!\n");
            return false;
        }
        boolean FlightFound = false;
        FileReader openFile = new FileReader("Flights.txt");
        BufferedReader readFile = new BufferedReader(openFile);
        while((FlightNum = readFile.readLine())!=null)
        {
            if(FlightNum.length() == 0)
                continue;
            if(FlightNum.equals(Flight_NUMBER))
            {
                FlightFound = true;
                departure_point = readFile.readLine();
                destination = readFile.readLine();
                date = readFile.readLine();
                departure = readFile.readLine();
                arrival = readFile.readLine();
                NoOfSeats = Integer.parseInt(readFile.readLine());
                priceOfTicket = readFile.readLine();
                System.out.println("\nFlight Details: \n");
                System.out.println("Flight Number: "+FlightNum);
                System.out.println("Departure Point: "+departure_point);
                System.out.println("Destination: "+destination);
                System.out.println("Departure: "+departure);
                System.out.println("Arrival: "+arrival);
                System.out.println("Available Seats: "+NoOfSeats);
                System.out.println("Price of Ticket: "+priceOfTicket+"\n"); 
                break;
            }
        }
        readFile.close();
        if(FlightFound == false)
        {
            System.out.println("Flight Not Available!\n");
            return false;
        }
        return true;
    }

    public boolean BookAndCancelFlight(String findFlight , int option) throws IOException, InterruptedException
    {
        File checkFile = new File("Flights.txt");
        if(checkFile.exists() == false)
        {
            System.out.println("No Flights Available!\n");
            return true;
        }
        FileReader openFile = new FileReader("Flights.txt");
        BufferedReader readFile = new BufferedReader(openFile);
        FileWriter openTempFile = new FileWriter("TempFile.txt");
        BufferedWriter writeInFile = new BufferedWriter(openTempFile);
        while((FlightNum = readFile.readLine())!=null)
        {
            if(FlightNum.length() == 0)
                continue;
            if(FlightNum.equals(findFlight))
            {
                departure_point = readFile.readLine();
                destination = readFile.readLine();
                date = readFile.readLine();
                departure = readFile.readLine();
                arrival = readFile.readLine();
                NoOfSeats = Integer.parseInt(readFile.readLine());
                priceOfTicket = readFile.readLine();
                if(NoOfSeats == 0)
                {
                    return true;
                }
                if(option == 1)
                    NoOfSeats--;
                else if(option == 2)
                    NoOfSeats++;
                writeInFile.write(FlightNum+"\n");
                writeInFile.write(departure_point+"\n");
                writeInFile.write(destination+"\n");
                writeInFile.write(date+"\n");
                writeInFile.write(departure+"\n");
                writeInFile.write(arrival+"\n");
                writeInFile.write(NoOfSeats+"\n");
                writeInFile.write(priceOfTicket+"\n\n");
            }
            else
            {
                departure_point = readFile.readLine();
                destination = readFile.readLine();
                date = readFile.readLine();
                departure = readFile.readLine();
                arrival = readFile.readLine();
                NoOfSeats = Integer.parseInt(readFile.readLine());
                priceOfTicket = readFile.readLine();
                writeInFile.write(FlightNum+"\n");
                writeInFile.write(departure_point+"\n");
                writeInFile.write(destination+"\n");
                writeInFile.write(date+"\n");
                writeInFile.write(departure+"\n");
                writeInFile.write(arrival+"\n");
                writeInFile.write(NoOfSeats+"\n");
                writeInFile.write(priceOfTicket+"\n\n");
            }
        }
        readFile.close();
        writeInFile.close();
        File f1 = new File("Flights.txt");
        File f2 = new File("TempFile.txt");
        f1.delete();
        f2.renameTo(f1);
        System.out.println("Returning to menu.......");
        clearScreen();
        return false;
    }

    public void clearScreen() throws InterruptedException
    {
        Thread.sleep(5000);
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public boolean checkDuplicateFlight(String flight_num) throws IOException
    {
        String checkDuplicateFlight;
        File checkFile = new File("Flights.txt");
        if(checkFile.exists() == false)
        {
            System.out.println("No Flights Available!\n");
            return false;
        }
        FileReader openFile = new FileReader("Flights.txt");
        BufferedReader readFile = new BufferedReader(openFile);
        while((checkDuplicateFlight = readFile.readLine()) != null)
        {
            if(checkDuplicateFlight.length() == 0)
                continue;
            if(checkDuplicateFlight.equals(flight_num))
            {
                readFile.close();
                return true;
            }
        }
        readFile.close();
        return false;
    }
}