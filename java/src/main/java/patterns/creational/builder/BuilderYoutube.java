package patterns.creational.builder;

public class BuilderYoutube {
    public static void main(String[] args) {
       /* Car car=new CarBuilder()
                .buildManufacturer("Mercedes")
                .buildTrance(Transmission.AUTO)
                .build();
        System.out.println(car.toString());*/
       Director dir=new Director();
        dir.setBuilder(new FordBuilder());
        Car car=dir.buildCar();
        System.out.println(car.toString()); ;
    }


}
class Car{
    String manufacturer;
    Transmission transmission;
    public String toString(){
        return manufacturer+" "+transmission;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
}

enum Transmission{
    MANUAL,AUTO
}
abstract class CarBuilder{
   public Car car;
    void createCar(){
        car=new Car();
    }
    abstract void buildManufacturer();
    abstract void buildTransmission();
    Car getCar(){
        return car;
    }
}
class FordBuilder extends CarBuilder{

    @Override
    void buildManufacturer() {
    car.setManufacturer("Ford");
    }

    @Override
    void buildTransmission() {
    car.setTransmission(Transmission.AUTO);
    }
}

class HondaBuilder extends CarBuilder{

    @Override
    void buildManufacturer() {
        car.setManufacturer("Honda");
    }

    @Override
    void buildTransmission() {
        car.setTransmission(Transmission.MANUAL);
    }
}

class Director{
    CarBuilder builder;
    void setBuilder(CarBuilder b){builder=b;}
    Car buildCar(){
        builder.createCar();
        builder.buildManufacturer();
        builder.buildTransmission();
        Car car=builder.getCar();
        return car;
    }
}

/*
class CarBuilder {
    String manufacturer = "DEFAULT";
    Transmission t = Transmission.AUTO;

    CarBuilder buildManufacturer(String name) {
        this.manufacturer = name;
        return this;
    }

    CarBuilder buildTrance(Transmission t) {
        this.t = t;
        return this;
    }

    Car build() {
        Car car = new Car();
        car.setManufacturer(manufacturer);
        car.setTransmission(t);
        return car;
    }

}

 */