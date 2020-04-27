/**
 * Modify the previous exercise so that one of f( )’s arguments is non-
 * parameterized.
 */
package eckel.generics;

public class Ex10 {
    static <A,B> void f(A a,B b,int c){
        System.out.println(a.getClass().getSimpleName()+'\n'+
                b.getClass().getSimpleName()+'\n'+
                c);
    }

    public static void main(String[] args) {
        f("",5.0,7);
    }
}
