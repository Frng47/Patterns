package eckel.typeinfo;



public class Ex2 {
    static void printInfo(Class cc){
        System.out.println("[Class name]: "+cc.getClass());
        System.out.println("[is interface?]: "+cc.isInterface());
        System.out.println("[Simple name]: "+cc.getSimpleName());
        System.out.println("[Canonical name]: "+cc.getCanonicalName());
    }
    public static void main(String[] args) {
        Class info=null;
        try {
            info=Class.forName("eckel.typeinfo.Test");
        }
        catch ( ClassNotFoundException e){
            System.err.println("File not found");
            System.exit(1);
        }
//        printInfo(info);
//        for(Class face: info.getInterfaces())
//            System.out.println(face.getSimpleName());
        Class up=info.getSuperclass();
        Object obj=null;
        try{
            up.newInstance();}
        catch (InstantiationException e){
            System.err.println("ERROR");
            System.exit(1);
        }
        catch (IllegalAccessException e){
            System.err.println("ERROR 2");
            System.exit(1);
        }

    }
}
class Origin{}
class Test  extends Origin implements Inter, Inter2{}
interface Inter{}
interface Inter2{}
