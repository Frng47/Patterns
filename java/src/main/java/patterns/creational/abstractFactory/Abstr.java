package patterns.creational.abstractFactory;

public class Abstr {
    public static void main(String[] args) {
        Animals obj=AnimalFactory.choose(Animals.AnType.BIRD);
        //obj.construct();
    }
}

abstract class Animals{
    public enum AnType {
        BIRD,
        FISH,
        MAMMAL
    }
    AnType anType =null;

    public  Animals(AnType name){
        this.initiate();
        this.anType = name;
    }

    private void initiate(){
        System.out.println("This is an animal");
    }

    protected abstract void construct();

}

class Birds extends Animals{

    public Birds() {

        super(AnType.BIRD);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("I'm a bird too");
    }
}

class Fishes extends Animals{

    public Fishes() {

        super(AnType.FISH);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("I'm a fish too");
    }
}

class AnimalFactory {


    public static Animals choose(Animals.AnType name){
        switch ( name){
            case BIRD: return new Birds();

            default:return new Fishes();
        }
    }
}