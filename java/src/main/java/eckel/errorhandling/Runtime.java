package eckel.errorhandling;

public class Runtime {
    void f(){
        System.out.println("Runtime start");
        throw new RuntimeException();
    }
    void g(){
        try{
            f();
        }catch(RuntimeException e){
            System.out.println("caught");
        }
    }

    public static void main(String[] args) {
        new Runtime().g();
    }
}
