package patterns.creational.FactoryMethod;

public class FactoryWiki {
    public static void main(String[] args) {
        Creator[] creators={new ConcreteCreatorA(),new ConcreteCreatorB()};
        for (Creator creator:creators) {
            creator.factoryMethod().say();
        }
    }
}


interface Product{
    void say();
}
class ConcreteProductA implements Product{
    @Override
    public void say(){
        System.out.println("Product A");
    }
}

class ConcreteProductB implements Product{
    @Override
    public void say(){
        System.out.println("Product B");
    }
}

abstract class Creator{
    public  abstract Product  factoryMethod();
}
class ConcreteCreatorA extends Creator{

    @Override
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}

class ConcreteCreatorB extends Creator{

    @Override
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}
