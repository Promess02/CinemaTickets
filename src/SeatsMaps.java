import java.util.ArrayList;
import java.util.HashMap;

public class SeatsMaps {
    static final HashMap<Character, HashMap<Integer, Boolean>> seatsA = new HashMap<>();
    static final HashMap<Character, HashMap<Integer, Boolean>> seatsB = new HashMap<>();
    static final HashMap<Character, HashMap<Integer, Boolean>> seatsC = new HashMap<>();
    static final HashMap<Character, HashMap<Integer, Boolean>> seatsD = new HashMap<>();
    static final HashMap<Character, HashMap<Integer, Boolean>> seatsE = new HashMap<>();
    static ArrayList<Character> rowNames = new ArrayList<>() {
        {
            add('A');add('B'); add('C');add('D');add('E');add('F');
            add('G');add('H'); add('I');add('J');add('K');add('L');
        }
    };
    static {
        //roomA - 96 seats 
        for(int i=0;i<8;i++){
            Character row = rowNames.get(i);
            seatsA.put(row,new HashMap<>());
            for(int j=0; j<12;j++){
                seatsA.get(row).put(j, false);
            }
        }
        // roomB - 90 seats 
        for(int i=0;i<9;i++){
            Character row = rowNames.get(i);
            seatsB.put(row,new HashMap<>());
            for(int j=0; j<10;j++){
                seatsB.get(row).put(j, false);
            }
        }
        // roomC - 64 seats 
        for(int i=0;i<8;i++){
            Character row = rowNames.get(i);
            seatsC.put(row,new HashMap<>());
            for(int j=0; j<8;j++){
                seatsC.get(row).put(j, false);
            }
        }

        // roomD - 81 seats 
        for(int i=0;i<9;i++){
            Character row = rowNames.get(i);
            seatsD.put(row,new HashMap<>());
            for(int j=0; j<9;j++){
                seatsD.get(row).put(j, false);
            }
        }

        // roomE - 96 seats 
        for(int i=0;i<12;i++){
            Character row = rowNames.get(i);
            seatsE.put(row,new HashMap<>());
            for(int j=0; j<8;j++){
                seatsE.get(row).put(j, false);
            }
        }

    }
}
 

 

 

 