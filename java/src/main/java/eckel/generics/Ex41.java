package eckel.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Modify Fill2.java to use the classes in typeinfo.pets instead of the
 * Coffee classes.
 */

public class Ex41 {
    public static void main(String[] args) {
        List<PetEx40> pets=new ArrayList<>();
        //Addable<PetEx40> addablePets=Adapter.collectionAdapter(pets);
        Fill2.fill(new AddableCollectionAdapter<>(pets),Cat.class,2);

        for (PetEx40 pet:pets) {
            System.out.println(pet);
        }
    }
}
interface Addable<T>{
    void add(T t);
}
class Fill2 {
    // Classtoken version:
    public static <T> void fill(Addable<T> addable,
                                Class<? extends T> classToken, int size) {
        for(int i = 0; i < size; i++)
            try {
                addable.add(classToken.newInstance());
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
    }
    // Generator version:
    public static <T> void fill(Addable<T> addable,
                                Generator<T> generator, int size) {
        for(int i = 0; i < size; i++)
            addable.add(generator.next());
    }
}
// To adapt a base type, you must use composition.
// Make any Collection Addable using composition:
class AddableCollectionAdapter<T> implements Addable<T> {
    private Collection<T> c;
    public AddableCollectionAdapter(Collection<T> c) {
        this.c = c;
    }
    public void add(T item) { c.add(item); }
}
// A Helper to capture the type automatically:
class Adapter {
    public static <T>
    Addable<T> collectionAdapter(Collection<T> c) {
        return new AddableCollectionAdapter<T>(c);
    }
   }
// To adapt a specific type, you can use inheritance.
// Make a SimpleQueue Addable using inheritance:
