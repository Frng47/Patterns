package eckel.generics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Add a speak( ) method to all the pets in typeinfo.pets. Modify
 * Apply.java to call the speak( ) method for a heterogeneous collection of Pet.
 */
public class Ex40 {
    public static void main(String[] args) throws Exception {
        List<PetEx40> pets=new ArrayList();
        Generators.fill(pets,
                new Generator<PetEx40>() {
            Random random=new Random();
            List<Class<?>> classList=
                    new ArrayList<>(Arrays.asList(Dog.class,Cat.class));
            public PetEx40 next()  {
                    try {
//                        return Cat.class.getConstructors("Name");
//                        return (PetEx40) new Cat();
                        return (PetEx40) classList.get(random.nextInt(2)).newInstance();
                    }catch (Exception e){throw new RuntimeException(e);}
            }
        },
                5);
        Apply.apply(pets,PetEx40.class.getMethod("speak"));
    }

}
class Apply {
    public static <T, S extends Iterable<? extends T>>
    void apply(S seq, Method f, Object... args) {
        for (T t : seq) {
            try {
                f.invoke(t, args);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
abstract class PetEx40{
    private static int count=0;
    private final int id;
    private String name;
    public PetEx40(){name="default";id=0;}
//    public PetEx40(String name){
//        id=count++;
//        this.name=name;
//    }
    public String toString() {
        return "This is a "+this.getClass().getSimpleName()+
                "it's name is "+name+"it's id is "+id;
    }
    public abstract void speak();
}
class Dog extends PetEx40{
   /* public Dog(String name) {
        super();
    }*/

    public void speak() {
        System.out.println("WOOF WOOF");
    }
}
class Cat extends PetEx40{
    /*public Cat(String name) {
        super();
    }*/

    public void speak() {
        System.out.println("MEOW MEOW");
    }
}

