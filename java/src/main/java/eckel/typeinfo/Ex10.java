package eckel.typeinfo;

public class Ex10 {
    public static void main(String[] args) {
        char[] arr=new char[10];
        System.out.println(arr.getClass().getSuperclass());
        System.out.println(arr instanceof Object);
    }


}
