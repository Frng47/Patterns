package eckel.innerclass.ex11;

import eckel.innerclass.tmp.InterfaceEx10;

public class Base {
    public static void main(String[] args) {
        Test test=new Test();
        test.foo().say();
        //((eckel.innerclass.ex11.Test.Inner)test.foo()).say();
        }
}
class Test{
     private class Inner implements InterfaceEx10 {
        public void say() {
            System.out.println("Private inner class");
        }
    }
    InterfaceEx10 foo(){
        return new Inner();
    }
}
