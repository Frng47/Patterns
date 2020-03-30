package eckel.errorhandling;

public class Ex2 {


    public static void main(String[] args) {
        Integer a=null;
        Integer b=null;
        try {
            System.out.println(a + b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
