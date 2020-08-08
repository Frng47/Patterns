package eckel.enums;
import static eckel.enums.Spiciness.*;
public  class Ex1 {
    public static void main(String[] args) {
        for(List item:List.values()){
            //System.out.println(item.compareTo(List.B));
            //System.out.println(item==List.B);
            //System.out.println(item.name());
            //System.out.println(item.equals(List.A));
            System.out.println(item.getDeclaringClass());
        }
    }
}


enum List{
    A,B,C,D
}

/**
 * Using static imports with enums
 */


class Burrito {
    Spiciness degree;
    public Burrito(Spiciness degree) { this.degree = degree;}
    public String toString() { return "Burrito is "+ degree;}
    public static void main(String[] args) {
        System.out.println(new Burrito(NOT));
        System.out.println(new Burrito(MEDIUM));
        System.out.println(new Burrito(HOT));
    }
}