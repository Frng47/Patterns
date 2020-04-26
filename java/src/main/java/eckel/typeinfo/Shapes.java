package eckel.typeinfo;

public abstract class Shapes {
    public void draw(){
        System.out.println(this+" draw()");
    };
     public abstract String toString();
     boolean flag=false;
     public void rotate()  {
         if(this instanceof Circle)
             System.out.println(this+" are not rotatable");
         else{
             System.out.println("rotate "+this);
         }
     }
}
class Circle extends Shapes{
    @Override
    public String toString() {
        return (flag?"flag ":"")+"Circle";
    }

}

class Triangle extends Shapes implements Rotatable{

    public String toString() {
        return (flag?"flag ":"")+ "Triangle";
    }
}

class Rhomboid extends Shapes implements Rotatable{
    public String toString() {
        return (flag?"flag ":"")+"Rhomboid";
    }
}
interface Rotatable{}

class NotRotatable extends Exception{

}