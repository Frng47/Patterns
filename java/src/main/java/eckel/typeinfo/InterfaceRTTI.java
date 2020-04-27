package eckel.typeinfo;

public class InterfaceRTTI {
}
interface AA {
    void f();
} ///:~
//: typeinfo/InterfaceViolation.java
// Sneaking around an interface.

class BB implements AA {
    public void f() {}
    public void g() {}
}
class InterfaceViolation {
    public static void main(String[] args) {
        AA a = new BB();
        a.f();
// a.g(); // Compile error
        System.out.println(a.getClass().getName());
        if(a instanceof B) {
            BB b = (BB)a;
            b.g();
        }
    }
}
