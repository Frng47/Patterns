package eckel.innerclass.ex12;


public class Base {
    private String s = "not modified";
    private void foo() {
        System.out.println(s);
    }
    void createInner(){

       Inner inner= new Inner() {
            public void modify() {
                s = "modified";
                foo();
            }
        };
       inner.modify();
    }


    public static void main(String[] args) {
        Base base=new Base();
        base.foo();
        base.createInner();
    }
}

interface Inner{
    void modify();
}

