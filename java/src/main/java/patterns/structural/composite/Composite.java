package patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite {
    public static void main(String[] args) {
        Square square=new Square();
        Square square1=new Square();
        Square square2=new Square();
        Triangle triangle=new Triangle();
        Triangle triangle1=new Triangle();
        Triangle triangle12=new Triangle();
        CompositeExp composite=new CompositeExp();
        CompositeExp compositeSq=new CompositeExp();
        CompositeExp compositeTr=new CompositeExp();
        compositeSq.addComponent(square1);
        compositeSq.addComponent(square);
        compositeSq.addComponent(square2);
        compositeTr.addComponent(triangle);
        compositeTr.addComponent(triangle1);
        compositeTr.addComponent(triangle12);
        composite.addComponent(compositeSq);
        composite.addComponent(compositeTr);
        composite.draw();
    }
}
interface Shape{
    void draw();
}

class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Square");
    }
}
class Triangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Triangle");
    }
}
class CompositeExp implements Shape{
private List<Shape> components=new ArrayList<>();

public void addComponent(Shape component){
components.add(component);
}

public void removeComponent(Shape component){
    components.remove(component);
}



    @Override
    public void draw() {
        for (Shape component : components) {
        component.draw();
        }
    }
}