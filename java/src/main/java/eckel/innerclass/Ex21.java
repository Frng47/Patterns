package eckel.innerclass;

public class Ex21 implements In {
   String s;
   Ex21(String s){
       this.s=s;
   }
    public String foo() {
        return s;
    }

    public static void main(String[] args) {
        Ex21 ex=new Ex21("sasads");
        Nested.show(ex);
    }
}
interface In{
    String foo();
    class Nested {



        static void show(In i){
            System.out.println(i.foo());
        }
    }
}

