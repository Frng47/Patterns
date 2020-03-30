package eckel.innerclass;

public class Ex26 {
    public static void main(String[] args) {
        Y y=new Y();
        A inner=new A();
    }
}


class Outer{
    class Inner{

    }
}
class Y{
    class A extends Outer.Inner{

        A(Outer o) {
            o.super();

        }
        void print(){}
    }


}