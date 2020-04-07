package eckel.errorhandling;

public class Ex10 {
    void g() throws ExcA {
        throw new ExcA("Hello");
    }
    void f() throws ExcA, ExcB {
        try{
            g();
        }catch (ExcA e){
            System.out.println("ExcA has been caught");
            throw new ExcB("Exception B" +
                    "" +
                    "" +
                    "" +
                    "" +
                    "" +
                    "" +
                    "" +
                    "");
        }
    }

    public static void main(String[] args) throws ExcB, ExcA {
        new Ex10().f();
    }
}

class ExcA extends Throwable {
    public ExcA(String s){
        super(s);
        System.out.println("This is Exception A");
    }
}
class ExcB extends Throwable {
    public ExcB(String s){
        super(s);
        System.out.println("This is Exception B");
    }
}