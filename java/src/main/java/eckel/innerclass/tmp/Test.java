
package eckel.innerclass.tmp;

public class Test {

    public static void main(String[] args) {
        A.print(A.a);
        A a=new A();
        A.print(a.b);

    }
}
class A{
    static String a="static A";
     String b="non static B";

    public static void setA(String a) {
        A.a = a;
    }

    public void setB(String b) {
        this.b = b;
    }

    static void print(String s){
        System.out.println(s);
    }
}
