/**
 * Following the form of the Coffee example, create a hierarchy of
 * StoryCharacters from your favorite movie, dividing them into GoodGuys and BadGuys.
 * Create a generator for StoryCharacters, following the form of CoffeeGenerator.
 */
package eckel.generics;

import java.util.Iterator;
import java.util.Random;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Ex8 {
}
class DarkNightChar{
    private static long counter=0;
    private final long id=counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName()+" "+id;
    }
}
class Batman extends DarkNightChar{}
class Joker extends DarkNightChar{}
class Attorney extends DarkNightChar{}

class CharacterGen implements Iterable<DarkNightChar>{
    private Class[] types={Batman.class,Joker.class,Attorney.class};
    private static Random random=new Random(58);
    private int size;
    private int count=0;

    public CharacterGen(int sz){size=sz;}
    public Iterator<DarkNightChar> iterator() {
        return new Iterator<DarkNightChar>() {
            public boolean hasNext() {
                return count<size;
            }
            public DarkNightChar next() {
                try {
                    count++;
                    return (DarkNightChar) types[random.nextInt(types.length)].newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);}
            }
        };
    }
    public void forEach(Consumer<? super DarkNightChar> action) {

    }
    public Spliterator<DarkNightChar> spliterator() {
        return null;
    }

    public static void main(String[] args) {
        CharacterGen gen=new CharacterGen(5);
        Iterator iter=gen.iterator();
        while(iter.hasNext())
            System.out.println(iter.next()+" ");
    }
}
