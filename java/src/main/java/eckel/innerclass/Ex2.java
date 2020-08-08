/*
package eckel.innerclass;

public class Ex2 {}
interface ReverseSelector extends SelectorEx2{
    void prev();
}
public interface SelectorEx2 {
    boolean end();
    Object current();
    void next();
}
public class SequenceEx2 {
    private Object[] items;
    private int next = 0;
    public SequenceEx2(int size) { items = new Object[size]; }
    public void add(Object x) {
        if(next < items.length)
            items[next++] = x;
    }
    private class ReverseSequenceSelector implements ReverseSelector{
        private int j = items.length-1;
        public void prev() {if(j>0) j--;}
        public boolean end() {return j==0;}
        public Object current() {return items[j];}
        public void next() {}
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
    public ReverseSelector rSelector() {
        return new ReverseSequenceSelector();
    }
    public static void main(String[] args) {
        SequenceEx2 sequence = new SequenceEx2(10);
        for(int i = 0; i < 10; i++)
            sequence.add(new StringHolder("string number "+Integer.toString(i)));
        SelectorEx2 selector = sequence.selector();
        while(!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }
        ReverseSelector rs=sequence.rSelector();
        while (!rs.end()){
            System.out.println(rs.current());
            rs.prev();
        }
    }
}
class StringHolder{
    StringHolder(String s){
        this.s=s;
    }
    private String s;
    public String toString(){
        //System.out.println(s);
        return s;
    }
}*/
