package eckel.string;

import java.util.Formatter;

public class Ex3 {

    public static void main(String[] args) {
    Turtle tommy=new Turtle("Tommy",new Formatter(System.out));
    Turtle zommy=new Turtle("Zommy",new Formatter(System.err));
    tommy.move(5,5);
    zommy.move(10,10);
    }
}


class Turtle{
    private String name;
    private Formatter f;

    public Turtle(String name, Formatter f) {
        this.name = name;
        this.f = f;
    }
    public void move(int x,int y){
    f.format("Turtle %s is on [%d,%d]\n",name,x,y);
    }
}
