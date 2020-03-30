package additional;

public class AnonymousClass {
    public static void main(String[] args) {
        //new class extended of Car is created and override move method
        Car car=new Car(){
            public void move(){
                System.out.println("The car is moving faster");
            }
        };////////This is an anonymous class
        car.move();
        //second variant
        //create an instance of some class implementing interface
        AbleToMove instance=new AbleToMove() {
            @Override
            public void move() {
                System.out.println("Move through interface");
            }
        };
        instance.move();
    }
}
class Car{
    public void move(){
        System.out.println("the car is moving");
    }
}

interface AbleToMove{
    void move();
}

