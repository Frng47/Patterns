package eckel.util;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class Delay {
    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat format=new SimpleDateFormat("hh:mm:ss");
        System.out.println(format.format(System.currentTimeMillis()));
        TimeUnit.SECONDS.sleep(5); // Delay
        System.out.println(format.format(System.currentTimeMillis()));
    }
}
