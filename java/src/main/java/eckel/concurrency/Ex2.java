/**
 * Exercise 2: (2) Following the form of generics/Fibonacci.java, create a task that
 * produces a sequence of n Fibonacci numbers, where n is provided to the constructor of the
 * task. Create a number of these tasks and drive them using threads.
 */
package eckel.concurrency;

import eckel.generics.Generator;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Ex2 {
    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            new Thread(new Fibonacci(i)).start();
        }
    }
}

class Fibonacci implements Generator<Integer>,Runnable, Callable<Integer> {
    private int count = 0;
    private final int n;
    public Fibonacci(int n){
        this.n=n;
    }
    private int fib(int n) {
        if (n < 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public Integer next() {
        return fib(count++);
    }


    public void run() {
        eckel.generics.Fibonacci f = new eckel.generics.Fibonacci();
        for (int i = 0; i < n; i++) {
            System.out.print(f.next() + " ");
        }
        System.out.println();
    }

    public Integer call() throws Exception {
        return n>2?fib(n - 1) + fib(n - 2):1;
    }
}
/**
 * Exercise 5: (2) Modify Exercise 2 so that the task is a Callable that sums the values of
 * all the Fibonacci numbers. Create several tasks and display the results.
 */
class Ex5{
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor=Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> result=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            result.add(executor.submit(new FibonacciCallable(i)));
        }
        executor.shutdown();
        Thread.sleep(1000);
        for (int i = 0; i < result.size(); i++) {
            if(result.get(i).isDone())
                System.out.println(i+" "+result.get(i).get());
        }

    }
}
class FibonacciCallable implements  Callable<Integer> {
    private int count = 0;
    private final int n;
    public FibonacciCallable(int n){
        this.n=n;
    }
    private int fib(int n) {
        if (n < 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public Integer next() {
        return fib(count++);
    }




    public Integer call() throws Exception {
        return n>2?fib(n - 1) + fib(n - 2):1;
    }
}