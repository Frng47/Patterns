package eckel.collections;

import java.util.*;

public class Ex8 extends Gebril {
    Ex8(int number) {
        super(number);
    }
    static void display(Iterator<Gebril> it){
    while(it.hasNext()){
        Gebril g=it.next();
        System.out.println(g.hop());
    }
    }
    public static void main(String[] args) {
    Gebril[] arr={new Gebril(0),new Gebril(1),new Gebril(2)};
    List<Gebril> list=new ArrayList(Arrays.asList(arr));
    Ex8.display(list.iterator());
    }
}
