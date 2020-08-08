package eckel.innerclass.ex7;

public class Ex7Base {
    private int i=0;
    private void foo(){
        System.out.println("fooOuter");
    };

    void testInner(){
    Inner inner=new Inner();
    inner.modify();
    }
    class Inner{
        void modify(){
            i=1;
            foo();
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Ex7Base base=new Ex7Base();
        base.new Inner().modify();
    }
}
