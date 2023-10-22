import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Menu {
    private final AppData appData;
    public Menu(AppData appData) throws InterruptedException {
        this.appData = appData;
        Scanner scanner = new Scanner(System.in);
        showEnterPrompt();
        Client client = getUserInfo();

        while(true){
            System.out.println("Choose one of the following viewings by entering its id: ");
            int i=0;
            for(Viewing viewing: appData.getViewingRepo().getAllData()){
                System.out.println(i+". " +viewing);
                i++;
            }
            int viewingId = scanner.nextInt();
            Optional<Viewing> viewing = appData.viewingRepo.findById(viewingId);
            if(viewing.isEmpty()){
                System.out.println("enter correct viewing id in range of shown viewings");
                break;
            }
            List<Seat<Character,Integer>> chosenSeats = enterSeats(viewing.get());
            System.out.println("chosen seats are as follows: ");
            for(Seat<Character,Integer> seat: chosenSeats){
                System.out.println(seat);
            }
            Ticket ticket = new Ticket(viewing.get(),client,chosenSeats);
            appData.getTicketRepo().addData(ticket);
            System.out.println("Ticket successfully created: ");
            System.out.println(ticket);
            System.out.println("Would you like to stop buying tickets?");
            String resp;
            scanner.nextLine();
            while(true){
                System.out.println("enter 'Yes' to buy more tickets or 'quit' to stop");
                //System.out.flush();
                Thread.sleep(1000);
                resp = scanner.nextLine();
                if(!(resp.equalsIgnoreCase("yes") || resp.equalsIgnoreCase("quit"))){
                    System.out.println("please enter 'yes' or 'quit'");
                    continue;
                }
                break;
            }
            if(resp.equalsIgnoreCase("yes")) continue;
            if(resp.equalsIgnoreCase("quit")) break;
        }
        saveData();
    }

    private List<Seat<Character,Integer>> enterSeats(Viewing viewing) throws InterruptedException {
        List<Seat<Character,Integer>> chosenSeats = new ArrayList<>();
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Chosen viewing seats: ");
            viewing.printSeats();
            System.out.println("please enter seat row (Characters indicate rows - A,B,C etc., only first character in a string matters): ");
            String input = scanner.nextLine();
            Character row = input.charAt(0);
            System.out.println("please enter seat number: ");
            Integer number = scanner.nextInt();
            if(!viewing.checkIfViewingHasGivenSeat(row,number)){
                System.out.println("viewing has no seats with entered seat");
                continue;
            }
            if(viewing.checkIfSeatTaken(row,number)){
                System.out.println("chosen seat is already taken");
                continue;
            }
            chosenSeats.add(new Seat<>(row,number));
            viewing.reserveSeat(row,number);
            System.out.println("seat successfully reserved. Would you like to reserve more seats?");
            String resp;
            scanner.nextLine();
            while(true){
                System.out.println("enter 'Yes' to enter more seats or 'quit' to stop reserving");
                System.out.flush();
                Thread.sleep(1000);
                resp = scanner.nextLine();
                if(!(resp.equalsIgnoreCase("yes") || resp.equalsIgnoreCase("quit"))){
                    System.out.println("please enter 'yes' or 'quit'");
                    continue;
                }
                break;
            }
            if(resp.equalsIgnoreCase("yes")) continue;
            if(resp.equalsIgnoreCase("quit")) break;
        }
        return chosenSeats;
    }
    private void saveData(){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("appData.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(appData);
            objectOutputStream.flush();
            objectOutputStream.close();
        }catch(IOException e){
            System.out.println("saving file failed");
            e.printStackTrace();
        }
    }
    private void showEnterPrompt(){
        System.out.println("Welcome to the cinema ticket buying service");
        System.out.println("Please enter your name: ");
    }

    private Client getUserInfo(){
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            System.out.println("Enter your surname: ");
            String surname = scanner.nextLine();
            System.out.println("Enter your email address: ");
            String mail = scanner.nextLine();
            System.out.println("Enter your phone number: ");
            String phoneNumber = scanner.nextLine();
            Client client = new Client(name,surname,mail,phoneNumber);
            appData.getClientsRepo().addData(client);
            System.out.println("your info saved successfully to the system");
        return client;
    }

}

