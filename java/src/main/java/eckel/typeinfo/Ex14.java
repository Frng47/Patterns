/**
 * A constructor is a kind of factory method. Modify
 * RegisteredFactories.java so that instead of using an explicit factory, the class object is
 * stored in the List, and newlnstance( ) is used to create each object.
 */
package eckel.typeinfo;

import java.util.*;

public class Ex14 {
    static List<Class<? extends Weapon>> list=new ArrayList();
    static{
        list.add(Sword.class);
        list.add(Shield.class);
    }
    static Random random=new Random();
    static Weapon createRandom(){
        int num=random.nextInt(list.size());
        try {
            return list.get(num).newInstance();
        } catch (InstantiationException e) {
           throw new RuntimeException();
        } catch (IllegalAccessException e) {
            throw new RuntimeException();
        }
    }
}

class Weapon{
    public String toString() {
        return getClass().getSimpleName();
    }
}
class Sword extends Weapon{}
class Shield extends Weapon{}