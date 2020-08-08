package additional;

import java.util.ArrayList;
import java.util.List;

public class WildCard {
    public static void test(List<? extends Animal>   list){
        for(Animal animal:list){
            System.out.println(animal.toString());
        }
    }
    public static void main(String[] args) {
        List<Animal> listOfAnimals=new ArrayList<>();
        listOfAnimals.add(new Animal(0));
        listOfAnimals.add(new Animal(1));
        test(listOfAnimals);
        List<Dog> listOfDog=new ArrayList<>();
        listOfDog.add(new Dog());

        test(listOfDog);


    }
}
class Animal{
    private int id;
    public Animal(){}

    public Animal(int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                '}';
    }
}
class Dog extends Animal{
public Dog(){


}
}