/**
 * Adding methods to an enum
 */

package eckel.enums;
import eckel.generics.Generator;
import eckel.io.OSExecute;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import static eckel.enums.RedYellowGreen.*;
public class Ex2 {
}
enum AlphaBet{
    // Instances must be defined first, before methods:
    A (" the first letter in the alphabet" ),
    B (" the second letter in the alphabet" );

    private String description;
    private AlphaBet(String description){
        this.description=description;
    }
    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for(AlphaBet i:AlphaBet.values())
           System.out.println(i+i.description);
    }



}

/**
 * Overriding enum methods
 */
enum SpaceShip {
    SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;

    /**
     * The toString( ) method gets the Spaceship name by calling name( ), and modifies the
     * result so that only the first letter is capitalized.
     * @return
     */
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }
    public static void main(String[] args) {
        for(SpaceShip s : values()) {
          System.out.println(s);
        }
    }
}
/**
 * enums in switch statements
 */
// Define an enum type:
enum Signal { GREEN, YELLOW, RED, }

class TrafficLight {
    Signal color = Signal.RED;
    public void change() {
        switch(color) {
// Note that you don’t have to say Signal.RED
// in the case statement:
            case RED: color = Signal.GREEN;
                break;
            case GREEN: color = Signal.YELLOW;
                break;
            case YELLOW: color = Signal.RED;
                break;
        }
    }
    public String toString() {
        return "The traffic light is " + color;
    }
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for(int i = 0; i < 7; i++) {
            System.out.println(t);
            t.change();
        }
    }
}
/**
 * Exercise 1: (2) Use a static import to modify TrafficLight.java so you don’t have to
 * qualify the enum instances.
 */
 class Ex1TrafficLight{
    RedYellowGreen light;

    public RedYellowGreen getLight() {
        return light;
    }

    private Ex1TrafficLight(RedYellowGreen light) {
        this.light = light;
    }
    public static Ex1TrafficLight getInstance(RedYellowGreen light){

        return new Ex1TrafficLight(light);
    }

    void change(){

         switch (light){
             case RED:light=YELLOW;break;
             case YELLOW:light=GREEN;break;
             case GREEN:light=RED;break;
         }


     }
    public static void main(String[] args) {
        Ex1TrafficLight tl=Ex1TrafficLight.getInstance(RED);
        for (int i = 0; i < 10; i++) {
            System.out.println(tl.getLight());
            tl.change();
        }
    }
}
/**
 * The mystery of values()
 */


 class Reflection {
    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println("----- Analyzing " + enumClass + " -----");
        System.out.println("Interfaces:");
        for(Type t : enumClass.getGenericInterfaces())
            System.out.println(t);
        System.out.println("Base: " + enumClass.getSuperclass());
        System.out.println("Methods: ");
        Set<String> methods = new TreeSet<String>();
        for(Method m : enumClass.getMethods())
            methods.add(m.getName());
        System.out.println(methods);
        return methods;
    }
    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        System.out.println("Explore.containsAll(Enum)? " +
                exploreMethods.containsAll(enumMethods));
        System.out.println("Explore.removeAll(Enum): ");
        exploreMethods.removeAll(enumMethods);
        System.out.println(exploreMethods);
// Decompile the code for the enum:
        OSExecute.command("javap D:\\dev\\Idea\\Patterns\\java\\target\\classes\\eckel\\enums\\Explore.class");
    }
}

enum Search { HITHER, YON }
class UpcastEnum {
    public static void main(String[] args) {
        Search[] vals = Search.values();
        Enum e = Search.HITHER; // Upcast
// e.values(); // No values() in Enum
        for(Enum en : e.getClass().getEnumConstants())
            System.out.println(en);
    }
}

class NonEnum {
    public static void main(String[] args) {
        Class<Integer> intClass = Integer.class;
        try {
            for(Object en : intClass.getEnumConstants())
                System.out.println(en);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}

/**
 * Exercise 2: (2) Instead of implementing an interface, make next( ) a static method.
 * What are the benefits and drawbacks of this approach?
 */


//enam generator
enum Digits implements Generator<Digits>{
     NULL,ONE,TWO,THREE;

    @Override
    public Digits next() {
        Random random=new Random();
        return values()[random.nextInt(values().length)];
    }

    public static void main(String[] args) {
        Digits digits=Digits.NULL;
        for (int i = 0; i < 5; i++) {
            System.out.println(digits.next());
        }

    }
}