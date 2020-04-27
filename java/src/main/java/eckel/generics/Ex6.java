/**
 * Use RandomList with two more types in addition to the one shown in
 * main( ).
 */
package eckel.generics;
import java.util.ArrayList;
import java.util.Random;

import java.util.ArrayList;
import java.util.Random;

public class Ex6 {
    public static void main(String[] args) {
        Random random=new Random(55);
        RandomListEx6<String,Integer> rs = new RandomListEx6();
        for(String s: ("The quick brown fox jumped over " +
                "the lazy brown dog").split(" "))
            rs.addA(s);rs.addB(random.nextInt(10));
        for(int i = 0; i < 11; i++) {
            System.out.print(rs.select().a + " ");
            System.out.print(rs.select().b + " ");
        }
    }
}


class RandomListEx6<A,B> {
    private ArrayList<A> storageA = new ArrayList<A>();
    private ArrayList<B> storageB = new ArrayList<B>();
    private Random rand = new Random(47);
    public void addA(A item) { storageA.add(item); }
    public void addB(B item) { storageB.add(item); }
    public TwoTuple<A,B> select() {
        return new TwoTuple<A,B>(storageA.get(rand.nextInt(storageA.size())),storageB.get(rand.nextInt(storageB.size())));
    }

}

class TwoTuple<A,B>{
    public final A a;
    public final B b;

    public TwoTuple(A a, B b) {
        this.a = a;
        this.b = b;
    }
}

