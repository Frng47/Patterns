package eckel.innerclass.ex9;



public class Ex9 {
    InterEx9 ref() {
         class Inner implements InterEx9 {
            public void hello() {
                System.out.println("Hello, I'm an interface");
            }
        }

        return new Inner();
    }

    public static void main(String[] args) {
        Ex9 exmpl=new Ex9();
        InterEx9 inter=exmpl.ref();
        inter.hello();
    }
}

    interface InterEx9 {
         void hello();
    }