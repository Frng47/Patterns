package patterns.creational.singlton;

/**
 *This is a design pattern where an instance of a class is created much before it is actually required.
 * Mostly it is done on system startup. In an eager initialization singleton pattern, the singleton instance is created irrespective
 * of whether any other class actually asked for its instance or not.
 */
public class EagerSingleton {
    private static volatile EagerSingleton instance=null; ;//= new EagerSingleton();
public static int counter=0;
    // private constructor
    private EagerSingleton() {
        //System.out.println("object has been created");
        counter++;
    }

    public static EagerSingleton getInstance() {
        if(instance==null)  instance=new EagerSingleton();
        return instance;
    }
}
class Test{

}
class  Main{
    public static void main(String[] args) {
        EagerSingleton s;
        for (int i = 0; i <1000 ; i++) {
            s=EagerSingleton.getInstance();
        }

        System.out.println("counter="+EagerSingleton.counter);
    }
}