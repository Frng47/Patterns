package patterns.creational.prototype;

public class PrototypeApp {
    public static void main(String[] args) {
        Human original=new Human(33, "Max");
        original.toString();
        Human copy=(Human)original.Copy();
        System.out.println(copy.toString());;

        HumanFactory factory=new HumanFactory(copy);
        Human h1=factory.makeCopy();
        System.out.println(h1.toString());
    }
}
interface Copyable{
    Object Copy();
}
class Human implements Copyable{
    int age;

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public Object Copy() {
        Human human=new Human(age,name);
        return human;
    }
}

class HumanFactory{
    Human human;

    public HumanFactory(Human human){
        setPrototype(human);
    }
    public void setPrototype(Human human){
        this.human=human;
    }
    Human makeCopy(){
        return (Human)human.Copy();
    }
}