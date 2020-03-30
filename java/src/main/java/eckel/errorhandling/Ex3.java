package eckel.errorhandling;

public class Ex3 {
    public static void main(String[] args) {
        int[] arr=new int[2];
        try{
            arr[2]=5;
        } catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Out of bound");
            e.printStackTrace();
        }
    }
}
