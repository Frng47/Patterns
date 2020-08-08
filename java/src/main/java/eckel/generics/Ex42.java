package eckel.generics;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Create two separate classes, with nothing in common. Each class should
 * hold a value, and at least have methods that produce that value and perform a modification
 * upon that value. Modify Functional.java so that it performs functional operations on
 * collections of your classes (these operations do not have to be arithmetic as they are in
 * Functional.java
 */
public class Ex42 {
}


class Food {
    private String foodName = "";
    public Food() { foodName = ""; }
    public Food(String name) { foodName = name; }
    public void set(String name) { foodName = name; }
    public String get() { return foodName; }
    public void eat() { foodName = ""; }
    public String toString() { return "Food: " + foodName; }
}

class Drink {
    private String drinkName = "";
    public Drink() { drinkName= ""; }
    public Drink(String name) { drinkName = name; }
    public void set(String name) { drinkName = name; }
    public String get() { return drinkName; }
    public void eat() { drinkName = ""; }
    public String toString() { return "Drink: " + drinkName; }
}

 class Functional42 {
    // Calls the Combiner object on each element to combine
    // it with a running result, whch is finally returned:
    public static <T> T
    reduce(Iterable<T> seq, Combiner<T> combiner) {
        Iterator<T> it = seq.iterator();
        if(it.hasNext()) {
            T result = it.next();
            while(it.hasNext())
                result = combiner.combine(result, it.next());
            return result;
        }
        // If seq is the empty list:
        return null; // Or throw exception
    }
    // Take a function object and call it on each object in
    // the list, ignoring the return value. The function 
    // object may act as a collecting parameter, so it is 
    // returned at the end.
    public static <T> Collector<T>
    forEach(Iterable<T> seq, Collector<T> func) {
        for(T t : seq) func.function(t);
        return func;
    }
    static class MealMaker implements Combiner<Food> {
        public Food combine(Food f1, Food f2) {
            return new Food(f1.get() + " " + f2.get());
        }
    }
    static class DrinkMaker implements Combiner<Drink> {
        public Drink combine(Drink d1, Drink d2) {
            return new Drink(d1.get() + " " + d2.get());
        }
    }
    static class CookedMeal
            implements Collector<Food> {
        private Food f = new Food("");
        public Food function(Food x) {
            f = new Food(f.get() + " " + x.get());
            return f;
        }
        public Food result() { return new Food("cooked " + f.get()); }
    }
    public static void main(String[] args) {
        List<Food> lf = Arrays.asList(new Food("bread"),
                new Food("ham"), new Food("cheese"));
        Food meal = reduce(lf, new MealMaker());
        System.out.println(meal);
        List<Drink> ld = Arrays.asList(new Drink("water"),
                new Drink("orange juice"), new Drink("lemon"));
        Drink drink = reduce(ld, new DrinkMaker());
        System.out.println(drink);
        System.out.print(forEach(lf, new CookedMeal()).result());


    }
}

class Cat42{
    private static int count=0;
    private final int id;
    private String name;
    private Sex sex;

    public Cat42(String name, Sex sex) {
        id = count++;
        this.name = name;
        this.sex = sex;
    }
}
class Boxer{
    private static int counter=0;
     static List<String> listOfNames=new ArrayList(Arrays.asList("Ali","Fraser","Forman","Tyson"));
    private final int id;
    private final String name;
    public Boxer(String name){
        this.name=name;
        id=counter++;
    }
    public String toString(){
        return name;
    }
}
class Functional42Main{
    public static void main(String[] args) throws ClassNotFoundException {
//        Class cls=Class.forName("eckel.generics.Boxer");
//        System.out.println(cls.getSimpleName());
        List<Boxer> boxers=new ArrayList<>();
        Generators.fill(boxers, new Generator<Boxer>() {
            public Boxer next() {
                Random random=new Random(47);
               try{
                   return (Boxer) Class.forName("eckel.generics.Boxer").getConstructor("Name".getClass()).newInstance(Boxer.listOfNames.get(random.nextInt(Boxer.listOfNames.size())));
//                   return (Boxer) Class.forName("eckel.generics.Boxer").getConstructor("Name".getClass()).newInstance("Name");
               }catch (Exception e){
                   throw new RuntimeException(e);
               }
            }
        },
                4);
        System.out.println(boxers);
    }
}