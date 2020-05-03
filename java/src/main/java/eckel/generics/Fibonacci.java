package eckel.generics;


import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Fibonacci implements Generator<Integer> {
    private int count=0;
    private int fib(int n){
        if(n<2) return 1;
        return fib(n-1)+fib(n-2);
    }
    public Integer next(){return fib(count++);}

    public static void main(String[] args) {
        Fibonacci f=new Fibonacci();
        for (int i = 0; i <10 ; i++) {
            System.out.print(f.next()+" ");

        }
    }
}
//Adapter for use forEach
class IterableFibonacci extends Fibonacci implements Iterable<Integer>{
    private int n;
    public IterableFibonacci(int count){n=count;}
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            public boolean hasNext() {return n>0;}
            public Integer next() {
                n--;
                return IterableFibonacci.super.next();
            }
        };
    }
    public void forEach(Consumer<? super Integer> action) {
        throw new UnsupportedOperationException();
    }
    public Spliterator<Integer> spliterator() {
        return null;
    }

    public static void main(String[] args) {
        for(int i:new IterableFibonacci(10) )
            System.out.print(i+" ");
    }
}
