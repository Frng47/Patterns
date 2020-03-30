package eckel.errorhandling;

public class Ex1 {
    public static void main(String[] args) {
        try{
    throw new MyException("Yu're a fagot");
        } catch(MyException e){
            e.printStackTrace();
            System.out.println("I was here");
        }
    }
}

class MyException extends Exception{
    public MyException(String msg){
        super(msg);
    }
}