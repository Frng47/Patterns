package eckel.collections;

import java.util.*;

public class Ex2 {
    public static void main(String[] args) {
        Random random=new Random();
        /*Collection<Integer> c = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++)
            c.add(i); // Autoboxing
        for (Integer i : c)
            System.out.print(i + ", ");*/

        Set<Integer> s=new HashSet<>();
        for (int i = 0; i <10 ; i++) {
            s.add(5-i);
        }
        System.out.println(s);
    }

}
