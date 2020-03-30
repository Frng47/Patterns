package eckel.errorhandling;

public class Ex8 {
    void f() throws Exception1{
        System.out.println("f()");
    }

    public static void main(String[] args) throws Exception1 {

        new Ex8().f();
    }
}
