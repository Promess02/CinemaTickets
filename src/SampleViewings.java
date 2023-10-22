import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class SampleViewings {
    static final List<Viewing> viewings = new ArrayList<>();

    static {
        viewings.add(new Viewing("Shrek", DayOfWeek.THURSDAY, LocalDateTime.of(2023, Month.AUGUST, 24, 12, 23), AgeRequirement.EIGHT_PLUS, 15.8d, Rooms.ROOM_C));
        viewings.add(new Viewing("Avatar", DayOfWeek.MONDAY, LocalDateTime.of(2023, Month.AUGUST, 28, 15, 15), AgeRequirement.TWELVE_PLUS, 25.8d, Rooms.ROOM_D));
        viewings.add(new Viewing("Frozen", DayOfWeek.SATURDAY, LocalDateTime.of(2023, Month.AUGUST, 26, 11, 15), AgeRequirement.THREE_PLUS, 16.45, Rooms.ROOM_E));
        viewings.add(new Viewing("Frozen", DayOfWeek.FRIDAY, LocalDateTime.of(2023, Month.AUGUST, 25, 11, 15), AgeRequirement.THREE_PLUS, 16.45, Rooms.ROOM_E));
        viewings.add(new Viewing("The Lion King", DayOfWeek.SATURDAY, LocalDateTime.of(2023, Month.SEPTEMBER, 2, 14, 30), AgeRequirement.EIGHT_PLUS, 18.00, Rooms.ROOM_A));
        viewings.add(new Viewing("Avengers: Endgame", DayOfWeek.WEDNESDAY, LocalDateTime.of(2023, Month.SEPTEMBER, 6, 19, 45), AgeRequirement.TWELVE_PLUS, 22.00, Rooms.ROOM_B));
        viewings.add(new Viewing("Inception", DayOfWeek.MONDAY, LocalDateTime.of(2023, Month.NOVEMBER, 13, 16, 0), AgeRequirement.SIXTEEN_PLUS, 20.00, Rooms.ROOM_C));
        viewings.add(new Viewing("Joker", DayOfWeek.SATURDAY, LocalDateTime.of(2023, Month.DECEMBER, 9, 21, 30), AgeRequirement.EIGHTEEN_PLUS, 24.00, Rooms.ROOM_D));
    }
}
