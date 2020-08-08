package patterns.creational.FactoryMethod;

public class CarBuilder {
    public static void main(String[] args) {
        System.out.println(CarFactory.build(Car.CarType.SEDAN));
    }
}

abstract class Car{
    public enum CarType{
        SEDAN,
        HATCHBACK,
        WAGON
    }
    CarType model=null;
    public Car(CarType name){
        this.model=name;

    }
    private void arrangeParts(){
        //one time processing
        System.out.println("This is a car object");
    };
    //// Do subclass level processing in this method
    protected abstract void construct();
}

class Sedan extends Car{

    public Sedan() {
        super(CarType.SEDAN);
        construct();

    }

    @Override
    protected void construct() {
        System.out.println("This is SEDAN");
    }
}

class CarFactory{
    public static Car build(Car.CarType model){
        Car car=null;
        switch (model) {
            case SEDAN:
                car = new Sedan();
                break;
        }
        return car;


    }
}