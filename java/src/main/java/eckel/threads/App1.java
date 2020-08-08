package eckel.threads;

public class App1 {
    public static void main(String[] args) {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <100 ; i++) {
                    try {
                        Thread.sleep(100);
                        System.out.println("thread: "+i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 100; i >0 ; i--) {
                    try {
                        Thread.sleep(100);
                        System.out.println("threadRevers: "+i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
    }
}
