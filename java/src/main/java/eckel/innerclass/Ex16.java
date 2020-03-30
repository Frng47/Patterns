package eckel.innerclass;

public class Ex16 {
    static void getService(FactoryEx18 factory){
        factory.getCycle().method();
    }
    public static void main(String[] args) {
    getService(Bicycle.factoryBicycle);
    getService(Tricycle.factoryTricycle);
    }
}
interface Cycle{
   void method();
}
interface FactoryEx18{
    Cycle getCycle();
}
class Bicycle implements Cycle{
    Bicycle(){};
    public void method() {
        System.out.println("This is a bicycle");
    }
    static FactoryEx18 factoryBicycle=new FactoryEx18() {
        public Cycle getCycle() {
            return new Bicycle();
        }
    };
}
class Tricycle implements Cycle{
    Tricycle(){};
    public void method() {
        System.out.println("This is a Tricycle");
    }
    static FactoryEx18 factoryTricycle=new FactoryEx18() {
        public Cycle getCycle() {
            return new Tricycle();
        }
    };
}