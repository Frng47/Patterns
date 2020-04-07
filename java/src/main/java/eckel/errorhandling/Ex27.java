package eckel.errorhandling;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class Ex27 {
    private static Logger logger= Logger.getLogger("Ex7 exception");
    static void logException(Exception e){
        StringWriter trace=new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
    public static void main(String[] args) {
        int[] arr=new int[2];
        try{
            new ThrowRuntime().f();
        } catch (RuntimeException e){
            System.err.println("Out of bound");
            e.printStackTrace();
            logException(e);
            System.out.println("Runtime has been caught");
        }
    }
}


class ThrowRuntime{
    void f(){
        try{
            throw new ArrayIndexOutOfBoundsException();
        }catch (ArrayIndexOutOfBoundsException e){
            throw new RuntimeException();
        }
    }
}