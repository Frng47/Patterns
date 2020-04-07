package eckel.errorhandling;
/*Modify Exercise 4 so that the custom exception class
inherits from
RuntimeException, and show that the compiler allows
 you to leave out the try block.
*/
public class Ex28 {
    public static void main(String[] args) {
        try{
//            throw new Exception1("the massage");
        }catch (CustomException1 e){
            e.print();
        }
    }
    
}


class CustomException1 extends RuntimeException{
    String msg;
    CustomException1(String msg){
        this.msg=msg;
    }
    void print(){
        System.out.println(msg);
    }
}
