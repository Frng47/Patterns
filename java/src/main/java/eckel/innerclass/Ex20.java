package eckel.innerclass;

public interface Ex20 {
    void foo();
    class Nested implements Ex20{
        public static void main(String[] args) {
           Ex20.Nested n=new Nested();
           n.foo();
        }

        @Override
        public void foo() {
            System.out.println("foo");
        }
    }
}
