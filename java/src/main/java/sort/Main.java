package sort;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list=Aux.fillInt(10,10);
        System.out.println(list);
        Bubble.sortMax(list);
        System.out.println(list);
        Bubble.sortMin(list);
        System.out.println(list);
    }
}
