import java.util.HashMap;

public enum Rooms {
    ROOM_A('A'), ROOM_B('B'), ROOM_C('C'), ROOM_D('D'), ROOM_E('E');
    final private Character name;
    private HashMap<Character, HashMap<Integer, Boolean>> seats;
    Rooms(Character name) {
        this.name = name;
        setSeats();
    }

    private void setSeats(){
        switch (name){
            case 'A':
                seats = SeatsMaps.seatsA;
                break;
            case 'B':
                seats = SeatsMaps.seatsB;
                break;
            case 'C':
                seats = SeatsMaps.seatsC;
                break;
            case 'D':
                seats = SeatsMaps.seatsD;
                break;
            case 'E':
                seats = SeatsMaps.seatsE;
                break;
            default:
                throw new RuntimeException("no room with name: " + name + "found");
        }
    }

    public HashMap<Character, HashMap<Integer, Boolean>> getSeats() {
        return seats;
    }

    public Character getName() {
        return name;
    }
} 
 