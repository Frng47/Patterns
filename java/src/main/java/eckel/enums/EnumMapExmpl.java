package eckel.enums;
import static eckel.enums.AlarmPoints.*;

import  java.util.EnumMap;
import java.util.Map;

public class EnumMapExmpl {
    public static void main(String[] args) {
        EnumMap<AlarmPoints,Command> em=
                new EnumMap(AlarmPoints.class);
        em.put(STAIR1, new Command() {
            public void action() {
                System.out.println("STAIR FIRE!!!11");
            }
        });
        em.put(BATHROOM, new Command() {
            public void action() {
                System.out.println("BATH ALERT");
            }
        });
        for(Map.Entry<AlarmPoints,Command> e:em.entrySet()){
            System.out.print(e.getKey()+": ");
            e.getValue().action();
        }

    }
}
interface Command{void action();}

