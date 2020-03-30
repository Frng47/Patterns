package eckel.errorhandling;

public class Ex4 {
    public static void main(String[] args) {
        try{
            throw new Exception1("the massage");
        }catch (Exception1 e){
            e.print();
        }
    }

}
class Exception1 extends Exception{
    String msg;
    Exception1(String msg){
        this.msg=msg;
    }
    void print(){
        System.out.println(msg);
    }
}
