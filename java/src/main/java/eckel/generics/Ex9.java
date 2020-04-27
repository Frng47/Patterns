/**
 * Modify GenericMethods.java so that f( ) accepts three arguments, all
 * of which are of a different parameterized type.
 */
package eckel.generics;

public class Ex9 {
    static <A,B,C> void f(A a,B b,C c){
        System.out.println(a.getClass().getSimpleName()+'\n'+b.getClass().getSimpleName()+'\n'+c.getClass().getSimpleName());
        System.out.println();
    }

    public static void main(String[] args) {
        f("a",5,5.0);
    }
}
