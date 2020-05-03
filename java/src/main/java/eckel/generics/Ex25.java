/**
 * Create two interfaces and a class that implements both. Create two
 * generic methods, one whose argument parameter is bounded by the first interface and one
 * whose argument parameter is bounded by the second interface. Create an instance of the
 * class that implements both interfaces, and show that it can be used with both generic
 * methods.
 */
package eckel.generics;

import java.util.ArrayList;
import java.util.List;

public class Ex25 {
    static <T extends A>void one(T a){}
    static <T extends B>void two(T b){}

    public static void main(String[] args) {
        C c=new C();
        one(c);
        two(c);
    }
}

interface A{}
interface B{}
class C implements A,B{}