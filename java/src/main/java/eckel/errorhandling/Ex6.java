package eckel.errorhandling;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class Ex6 {
    public static void main(String[] args) {
        try{
            throw new Exc1();
        }catch (Exc1 e){
            System.err.println("Caught"+e);
        }
    }
}
class Exc1 extends Exception{
    private static Logger logger=Logger.getLogger("Logging exception");
    Exc1(){
        StringWriter trace=new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

}
