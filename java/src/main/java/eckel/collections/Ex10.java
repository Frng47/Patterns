package eckel.collections;

import java.util.*;

public class Ex10 {

    static void fill(int number, List<Rodent> list){
        Random random=new Random();
        for (int i = 0; i <number ; i++) {
            switch (Math.abs(random.nextInt()%3)) {
                case 0:
                    list.add(new GebrilRodent());break;
                case 1:
                    list.add(new Mouse());break;
                case 2:
                    list.add(new Hamster());break;
            }

        }

    }

    public static void main(String[] args) throws Exception {
        /*List<Rodent> rodents=new ArrayList<>();
        Ex10.fill(10,rodents);
        Iterator it=rodents.iterator();
        while (it.hasNext()){
            System.out.println(it.next());*/
        ;
        for(Rodent rod:new Rodents().createArray(10)){
            System.out.println(rod.toString());;
        }
    }

}
abstract class Rodent{
    abstract public String toString();
}
class GebrilRodent extends Rodent{
   public String toString() {
        return "I'm a gebril";
    }
}
class Mouse extends Rodent{
   public String toString() {
        return"I'm a mouse";
    }
}
class Hamster extends Rodent{
    public String toString() {
        return"I'm a Hamster";
    }
}
class Rodents{
    Random random=new Random(47);
    public  Rodent[] createArray(int size){
        Rodent[] arr=new Rodent[size];
        for (int i = 0; i < size; i++) {
switch (random.nextInt(3)){
    case 0: arr[i]=new Mouse();break;
    case 1: arr[i]=new Hamster();break;
    case 2: arr[i]=new GebrilRodent();break;

}
        }
        return arr;
    }
    /*Map<Rodent,Integer> counter(Rodent[] arr){
        Map<Rodent,Integer> map=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Rodent freq=arr[i];
            map(freq,freq==null?)
        }
    }*/
}