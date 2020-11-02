/**
 * Exercise 6: (2) Create a task that sleeps for a random amount of time between 1 and 10
 * seconds, then displays its sleep time and exits. Create and run a quantity (given on the
 * command line) of these tasks.
 */
package eckel.concurrency;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ex6 {
    private static Random random=new Random(58);
    public static void main(String[] args) {
       /* ExecutorService exe= Executors.newCachedThreadPool();
        for()
        exe.submit();
        exe.shutdown();*/
       ExecutorService exeRun=Executors.newCachedThreadPool();
        for (int i = 0; i <5 ; i++) {
            exeRun.submit(new SleepRun2());
        }
        exeRun.shutdown();
    }

}
/*class SleepCall implements Callable<Integer> {
    public Integer call() throws InterruptedException {
        long start=System.currentTimeMillis();
        TimeUnit.MILLISECONDS.sleep();
        long finish=System.currentTimeMillis();
    }
}*/
class SleepRun implements Runnable {
    private int countDown=10;
    private static int counter=0;
    private final int id;
    public SleepRun(int countDown){
        this.countDown=countDown;
        id=counter++;
    }
    public void run() {
        while (!(countDown==-1)){
            if(countDown==0){
                System.out.println("#"+id+" "+"LiftOff!");
                return;
            }
            System.out.println("#"+id+" "+countDown--);
        }
    }
}
class SleepRun2 implements Runnable {
    private static Random random=new Random(58);
    private int countDown=10;
    private static int counter=0;
    private final int id;
    public SleepRun2(){
        id=counter++;
    }
    public void run() {
                long start=System.currentTimeMillis();
                try {
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(10)*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long finish=System.currentTimeMillis();
                long time=(finish-start)/1000;
                System.out.println("#"+id+" "+time);
                return;
        }
    }

