package eckel.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

public class Ex3 {
    public static void main(String[] args) {
        Random random=new Random();
        Sequence sequence=new Sequence();

        for (int i = 0; i <10 ; i++) {
            sequence.add(new Integer(Math.abs(random.nextInt()%9)));
        }
        Selector selector=sequence.selector();
        while (selector.end())   {
            System.out.println((Integer) selector.current());
            selector.next();
        }
    }
}
class Test{
    public static void main(String[] args) {
        Collection<Integer> collection= new ArrayList<Integer>(Arrays.asList(1,2));
        Integer[] arr={3,4};
        collection.addAll(Arrays.asList(arr));
        System.out.println(collection);
    }
}
interface Selector{
    Object current();
    void next();
    boolean end();
}

class Sequence{
    private ArrayList<Object> items=new ArrayList<>();
    private int next=0;
    void add(Object x){
        items.add(x);
        next++;
    }
    SequenceSelector selector(){return new SequenceSelector();}
    class SequenceSelector implements Selector{
        private int i=0;
        public Object current() {
            return items.get(i);
        }
        public void next() {i++;}
        public boolean end(){return items.size()!=i+1;}
    }
}
