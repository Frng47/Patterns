package eckel.typeinfo;

public class Ex11 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class d=Class.forName("eckel.typeinfo.D");


    }
    public Ex11() throws ClassNotFoundException {
    }

}
class D{
    static{
        System.out.println("Initialisation of D");
    }
}