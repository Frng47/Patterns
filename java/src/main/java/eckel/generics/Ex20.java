/**
 * Create an interface with two methods, and a class that implements that
 * interface and adds another method. In another class, create a generic method with an
 * argument type that is bounded by the interface, and show that the methods in the interface
 * are callable inside this generic method. In main( ), pass an instance of the implementing
 * class to the generic method.
 */
package eckel.generics;

public class Ex20 implements Ex20I{
    public void one() {
        System.out.println("one");
    }
    public void two() {
        System.out.println("two");
    }
    void three(){
        two();
        one();
    }
}

interface Ex20I{
    void one();
    void two();
}
class Another {
    <T extends Ex20I>void four(T t ){
        t.one();
        t.two();
    }

    public static void main(String[] args) {
        Ex20 ex20=new Ex20();
        new Another().four(ex20);
    }
}