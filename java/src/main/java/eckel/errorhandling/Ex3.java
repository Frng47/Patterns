package eckel.errorhandling;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class Ex3 {
    private static Logger logger= Logger.getLogger("Ex7 exception");
    static void logException(Exception e){
        StringWriter trace=new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
    public static void main(String[] args) {
        int[] arr=new int[2];
        try{
            arr[2]=5;
        } catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Out of bound");
            e.printStackTrace();
            logException(e);
        }
    }
}
