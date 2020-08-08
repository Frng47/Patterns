package additional;

public class Apply {
    public static void main(String[] args) {
     Sequence sequence=new Sequence(3);
        for (int j = 0; j <3 ; j++) {
            sequence.add(new Outer(new Integer(j).toString()));
           }
        Selector selector=sequence.selector();
        while (!selector.end()){
            System.out.print(((Outer) selector.current()).toStringt()+" ");
            selector.next();
        }
        OuterTwo obj=new OuterTwo("String of obj");
        OuterTwo.Inner inner=obj.new Inner();
        System.out.println(inner.toString());
        sequence.selector().ref();

    }
}
class OuterTwo{
    private String s;
    OuterTwo(String s){
        this.s=s;
    }
    void hello(){
        System.out.println("Hello from Outer class");
    }
    class Inner{
        public String toString(){return s;}
    }
}

class Outer{
     String s="";
     public Outer(String input){
         s=input;
     }
    String toStringt(){return s;}
    class Inner{}
  }

class Sequence {
    private Object[] items;
    private int next = 0;
    Sequence(int size) {
        items = new Object[size];
    }
    public void add(Object x) {
        if (next < items.length)
            items[next++] = x;
    }
    void print(){
        System.out.println(items.length);
    }
    public SequenceSelector selector(){return new SequenceSelector();}

    public class SequenceSelector implements Selector {
        private int i;
        public Object current() {
            return items[i];
        }
        public void next() {if (i < items.length) i++;}
        public Boolean end() {return i == items.length;}
        public void ref(){Sequence.this.print();}
    }
}

interface Selector{
    Object current();
    void next();
     Boolean end();
}