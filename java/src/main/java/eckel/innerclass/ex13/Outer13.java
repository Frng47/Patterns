package eckel.innerclass.ex13;

public class Outer13 {
    Inner13 createInner(){
        /*class Inner implements Inner13{

            @Override
            public void foo() {
                System.out.println("foo from Inner");
            }
        }*/
        return new Inner13(){

            @Override
            public void foo() {
                System.out.println("anonymous foo");
            }
        };
    }

    public static void main(String[] args) {
        new Outer13().createInner().foo();
    }
}
interface Inner13{
    void foo();
}