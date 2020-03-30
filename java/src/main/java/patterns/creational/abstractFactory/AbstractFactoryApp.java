/**
 * Abstract Factory assumes that you have several families of products,
 * structured into separate class hierarchies (Button/Checkbox). All products of
 * the same family have the common interface.
 *
 * This is the common interface for buttons family.
 */

package patterns.creational.abstractFactory;

public class AbstractFactoryApp {
    public static void main(String[] args) throws Exception {
        String str="Duck";
        ConcreteFactory factory=new ConcreteFactory();
        Animal animal=factory.create(str);
        System.out.println(animal.getAnimal());;
    }

}

interface Animal{
    String getAnimal();
}
class Duck implements Animal{

    public String getAnimal() {
        return "Duck";
    }
}
class Dog implements Animal{
    public String getAnimal() {
        return "Dog";
    }
}

interface AbstrFactory<T> {
    T create(String type) throws Exception;
}

class ConcreteFactory implements AbstrFactory{

    @Override
    public Animal create(String type) throws Exception {
        Animal animal;
        switch (type){
            case "Duck":animal=new Duck();break;
            case "Dog":animal=new Dog();break;
            default:throw new Exception("unsupported type of an animal: " +type);
        }
        return animal;
    }
}