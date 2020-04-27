/**
 * Use composition instead of inheritance to adapt Fibonacci to make it
 * Iterable
 */
package eckel.generics;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Ex7 implements Iterable<Integer>{
    public Ex7(int count){n=count;}
        private int n;
    private Fibonacci fib=new Fibonacci();
    int next(){return fib.next();}
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            public boolean hasNext() {return n>0;}
            public Integer next() {
                n--;
                return fib.next();
            }
        };
    }
    public void forEach(Consumer<? super Integer> action) {

    }
    public Spliterator<Integer> spliterator() {
        return null;
    }

    public static void main(String[] args) {
        Ex7 fb=new Ex7(10);
        Iterator iter=fb.iterator();
        while (iter.hasNext())
            System.out.println(iter.next()+" ");
    }
}
