package eckel.innerclass.ex8;

public class Base {
    class Inner{
        private String s="inner";
    }
    void foo(){
        System.out.println();
    }

    public static void main(String[] args) {
        Base base=new Base();
        System.out.println(base.new Inner().s);
    }
}
