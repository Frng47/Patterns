package eckel.errorhandling;

import java.util.Random;

public class Ex5 {
    public static void main(String[] args) {
        Random random=new Random();
        int x=0;
        while(true){
            try {
                System.out.println(5/x);
                break;
            }catch (ArithmeticException e){
                System.err.println("Division by zero");
                e.printStackTrace();
                x=random.nextInt(2);
            }
            finally {
                System.out.println("Are we doen yet?");
            }
        }
        System.out.println("Now we're done");
    }
}
