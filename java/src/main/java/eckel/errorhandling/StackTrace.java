package eckel.errorhandling;

public class StackTrace {
    static void f()  {
        try{
        throw new Exception();}
        catch (Exception e){
            for(StackTraceElement element:e.getStackTrace()) System.out.println(element.getMethodName());
        }
    }
    public static void main(String[] args) {
        f();
    }
}
