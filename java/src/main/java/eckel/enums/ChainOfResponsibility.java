package eckel.enums;

import java.util.Iterator;

public class ChainOfResponsibility {
enum ObjHandler{
    ACHECK{boolean handle(Obj o){
        switch (o.A){
            case YES:
                System.out.println("A is YES");return true;
            default:return false;
        }
    }},
    BCHECK{boolean handle(Obj o){
        switch (o.B){
            case YES:
                System.out.println("B is YES");return true;
            default:return false;
        }
    }},
    CCHECK{boolean handle(Obj o){
        switch (o.C){
            case YES:
                System.out.println("C is YES");return true;
            default:return false;
        }
    }}
    ;
    abstract boolean handle(Obj o);
    }
    static void handle(Obj o){
    for (ObjHandler item:ObjHandler.values()){
        item.handle(o);
    }
    }

    public static void main(String[] args) {
        for(Obj o:Obj.generator(10)){
           handle(o);
            System.out.println("****************");
        }
    }
}


class Obj{
    enum PropertyA {YES,NO;}
    enum PropertyB {YES,NO;}
    enum PropertyC {YES,NO;}
    PropertyA A;
    PropertyB B;
    PropertyC C;
    static long counter=0;
    long id=counter++;
    public String toString(){
       return "Obj "+id+"\nPropertyA: "+A+ "\nPropertyB: "+B+ "\nPropertyC: "+C;
    }
   static Obj randomObj(){
        Obj o=new Obj();
        o.A=Enums.random(PropertyA.class);
        o.B=Enums.random(PropertyB.class);
        o.C=Enums.random(PropertyC.class);
        return o;
    }
    public static Iterable<Obj> generator(final int count){
        return new Iterable<Obj>() {
            int n=count;
            public Iterator<Obj> iterator() {
                return new Iterator<Obj>() {
                    public boolean hasNext() {
                        return n-->0;
                    }

                    public Obj next() {
                        return randomObj();
                    }
                };
            }
        };
    }
}