import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.HashMap;

public class Viewing implements Serializable {

    private String Title;
    private DayOfWeek day;
    private LocalDateTime date;
    private AgeRequirement ageRequirement;
    private Rooms room;
    private Double ticketPrice;

    // map of seats like "A6 - true" true - seat taken, false - seat free 
    private HashMap<Character,HashMap<Integer, Boolean>> seats;

    public Viewing(String title, DayOfWeek day, LocalDateTime date, AgeRequirement ageRequirement, Double ticketPrice, Rooms room) {
        Title = title;
        this.day = day;
        this.date = date;
        this.ageRequirement = ageRequirement;
        this.ticketPrice = ticketPrice;
        this.room = room;
        seats = room.getSeats();
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public AgeRequirement getAgeRequirement() {
        return ageRequirement;
    }

    public void setAgeRequirement(AgeRequirement ageRequirement) {
        this.ageRequirement = ageRequirement;
    }

    public HashMap<Character, HashMap<Integer, Boolean>> getSeats() {
        return seats;
    }

    public void setSeats(HashMap<Character, HashMap<Integer, Boolean>> seats) {
        this.seats = seats;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public boolean checkIfSeatTaken(Character row, Integer seat){
        return seats.get(row).get(seat);
    }

    public boolean checkIfViewingHasGivenSeat(Character row, Integer seat){
        if(!seats.containsKey(row)) return false;
        return seats.get(row).containsKey(seat);
    }

    public void reserveSeat(Character row, Integer seat){
        seats.put(row, new HashMap<>());
        seats.get(row).put(seat, true);
    }

    @Override
    public String toString() {
        return "Viewing{" +
                "Title='" + Title + '\'' +
                ", day=" + day.toString() +
                ", date=" + date +
                ", ageRequirement=" + ageRequirement.getName() +
                ", room=" + room.getName() +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
 