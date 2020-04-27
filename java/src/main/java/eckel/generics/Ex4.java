/**
 * "Generify" innerclasses/Sequence.java.
 */
package eckel.generics;

import java.util.ArrayList;

public class Ex4 {
}

interface Selector {
    boolean end();
    Object current();
    void next();
}
class GenericSequence<T> {
    private ArrayList<T> list= new ArrayList<T>();;
    private int next = 0;
    public GenericSequence() {   }
    public void add(T x) {
        list.add(x);
    }
    private class SequenceSelector implements Selector {
        private int i = 0;
        public boolean end() { return i == list.size(); }
        public Object current() { return list.get(i); }
        public void next() { if(i < list.size()) i++; }
    }
    public Selector selector() {
        return new SequenceSelector();
    }
    public static void main(String[] args) {
        GenericSequence<Integer> sequence = new GenericSequence();
        for(int i = 0; i < 10; i++)
            sequence.add(i);
        Selector selector = sequence.selector();
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}
