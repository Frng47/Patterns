package eckel.concurrency;

public class App1 implements Runnable {
    private static int counter=0;
    public  int id=counter++;

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            counter++;
        }
        System.out.println(counter);
        Thread.yield();
    }
}
class Main{
    public static void main(String[] args) {
        new App1().run();
    }
}

