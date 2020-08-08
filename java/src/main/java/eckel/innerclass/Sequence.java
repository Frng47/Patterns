/*
package eckel.innerclass;



interface Selector {
    boolean end();
    Object current();
    void next();
}
public class Sequence {
    private Object[] items;
    private int next = 0;
    public Sequence(int size) { items = new Object[size]; }
    public void add(Object x) {
        if(next < items.length)
            items[next++] = x;
    }
    private class SequenceSelector implements SelectorEx2 {
        private int i = 0;
        public boolean end() { return i == items.length; }
        public Object current() { return items[i]; }
        public void next() { if(i < items.length) i++; }
    }
    public SelectorEx2 selector() {
        return new SequenceSelector();
    }
    public static void main(String[] args) {
        SequenceEx2 sequence = new SequenceEx2(10);
        for(int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        SelectorEx2 selector = sequence.selector();
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}*/
