/**
 * Write a method that takes an object and recursively prints all the classes
 * in that object’s hierarchy.
 */

package eckel.typeinfo;

public class Ex8 {
    static void printClassRecursion(Class c){
        if(null!=c.getSuperclass()) {
            System.out.println(c.getSimpleName());
            System.out.println(c.getDeclaredFields());
            printClassRecursion(c.getSuperclass());
        }
        else{
            System.out.println(c.getSimpleName());
                        return;}

    }

    public static void main(String[] args) {
        printClassRecursion(new C().getClass());
    }
}
class A{
    public static int a=1;
}
class B extends A{
    int b=2;
    int b2=2;
}
class C extends B{}
