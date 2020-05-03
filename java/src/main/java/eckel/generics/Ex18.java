/**
 * Following the form of BankTeller.java, create an example where
 * BigFish eat LittleFish in the Ocean.
 */
package eckel.generics;

import java.util.*;

public class Ex18 {
}
class BigFish{
    private static long counter=0;
    private final long id=counter++;
    private BigFish(){}
    public String toString() {return "BigFish " +id;}
    public static Generator<BigFish> generator() {
        return new Generator<BigFish>() {
            public BigFish next() {
                return new BigFish();
            }
        };
    }
}

class SmallFish{
    private static long counter=0;
    private final long id=counter++;
    private SmallFish(){}
    public String toString() {return "SmallFish " +id;}
    public static Generator<SmallFish> generator() {
        return new Generator<SmallFish>() {
            public SmallFish next() {
                return new SmallFish();
            }
        };
    }
}

class Hunt{
    static void start(BigFish big,SmallFish small){
        System.out.println(big+" eat "+small);
    }
    public static void main(String[] args) {
        Random random=new Random(851);
        Queue<SmallFish> line=new LinkedList<>();
        Generators.fill(line,SmallFish.generator(),15);
        List<BigFish> eaters=new ArrayList<>();
        Generators.fill(eaters,BigFish.generator(),4);
        for (SmallFish f:line){
            start(eaters.get(random.nextInt(eaters.size())),f);
        }
    }
}