import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RepoImplementation<Client> clientsRepo = new RepoImplementation<>();
        RepoImplementation<Viewing> viewingRepo = new RepoImplementation<>();

        Viewing Shrek = new Viewing(
                "Shrek",
                DayOfWeek.MONDAY,
                LocalDateTime.of(2023, Month.AUGUST,24,12,23,0),
                AgeRequirement.EIGHT_PLUS,
                15.8d,
                Rooms.ROOM_C
        );

        Viewing Avatar = new Viewing(
                "Avatar",
                DayOfWeek.TUESDAY,
                LocalDateTime.of(2023, Month.AUGUST,28,15,15,0),
                AgeRequirement.TWELVE_PLUS,
                25.8d,
                Rooms.ROOM_D
        );

        Client clientA = new Client(
                "Stevens",
                "Chris",
                "miko2002@wp.pl",
                "542782128"
        );


        Client clientB = new Client(
                "Michaels",
                "Paul",
                "mikeyPaul@wp.pl",
                "922386178"
        );

        viewingRepo.addData(Shrek);
        viewingRepo.addData(Avatar);
        clientsRepo.addData(clientA);
        clientsRepo.addData(clientB);

        List<Seat<Character, Integer>> list1 = new ArrayList(){
            {
                add(new Seat<Character,Integer>('C',4));
                add(new Seat<Character,Integer>('A',3));
                add(new Seat<Character,Integer>('D',6));
            }
        };

        List<Seat<Character, Integer>> list2 = new ArrayList(){
            {
                add(new Seat<Character,Integer>('B',4));
                add(new Seat<Character,Integer>('C',5));
                add(new Seat<Character,Integer>('A',2));
            }
        };

        Ticket ticket1 = new Ticket(viewingRepo.findById(0).get(), clientsRepo.findById(0).get(),list1);
        //Ticket ticket2 = new Ticket(Avatar, clientB,list2);
        //System.out.println(Shrek.getSeats());
        System.out.println(ticket1);
        //System.out.println(ticket2);



    }
}