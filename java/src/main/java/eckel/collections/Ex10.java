package eckel.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

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

    public static void main(String[] args) {
        List<Rodent> rodents=new ArrayList<>();
        Ex10.fill(10,rodents);
        Iterator it=rodents.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
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