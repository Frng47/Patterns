/**
 * Exercise 1: (2) Implement a Runnable. Inside run( ), print a message, and then call
 * yield( ). Repeat this three times, and then return from run( ). Put a startup message in the
 * constructor and a shutdown message when the task terminates. Create a number of these
 * tasks and drive them using threads.
 */
package eckel.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex1 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Rnbl("HELLO","Buy")).start();
        }
    }
}

class Rnbl implements Runnable{
    private final String shutDownMassage;
    private final String startUpMassage;
    private static int counter=0;
    private final int id=counter++;
    public Rnbl(String startUpMassage,String shutDownMassage) {
        this.startUpMassage=startUpMassage;
        this.shutDownMassage=shutDownMassage;
    }
    public void run() {
        System.out.println(id+" "+startUpMassage);
        Thread.yield();
        System.out.println(id+" "+shutDownMassage);
        Thread.yield();
        return;
    }
}
/**
 * Exercise 3: (1) Repeat Exercise 1 using the different types of executors shown in this
 * section.
 */
class Ex3{
    public static void main(String[] args) {

        ExecutorService executor=Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            //new Thread(new Rnbl("Hello","Buy")).start();
            executor.execute(new Rnbl("Hello","Buy"));
        }
        executor.shutdown();
        System.out.println("***********************");
        executor=Executors.newCachedThreadPool();
        for (int i = 0; i <5 ; i++) {
            executor.execute(new Rnbl("Hello","Buy"));
        }
        executor.shutdown();
    }
}
