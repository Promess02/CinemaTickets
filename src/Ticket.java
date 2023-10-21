import java.io.Serializable;
import java.util.List;

public class Ticket implements Serializable {
    private Viewing viewing;
    private Client client;
    private String ticketCode;
    private Double ticketPrice;
    private List<Seat<Character,Integer>> seats;

    public Ticket(Viewing viewing, Client client, List<Seat<Character,Integer>> seats) {
        this.viewing = viewing;
        this.client = client;
        this.seats = seats;
        for(Seat<Character,Integer> seat: seats){
            if(!viewing.checkIfViewingHasGivenSeat(seat.getKey(),seat.getValue()))
                throw new RuntimeException("tried to reserve a seat that is not present in this viewing");
            if(viewing.checkIfSeatTaken(seat.getKey(), seat.getValue()))
                throw new RuntimeException("tried to reserve seat that is already taken");
            viewing.reserveSeat(seat.getKey(),seat.getValue());
        }
        ticketPrice = viewing.getTicketPrice() * seats.size();
        ticketCode = ticketCodeGenerator.generateTicketCode();
    }

    public Viewing getViewing() {
        return viewing;
    }

    public Client getClient() {
        return client;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public List<Seat<Character,Integer>> getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "viewing=" + viewing +
                ", client=" + client +
                ", ticketCode='" + ticketCode + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", seats=" + seats +
                '}';
    }
}
