/**
 * Demonstrate array covariance using Numbers and Integers.
 */
package eckel.generics;

import java.util.ArrayList;
import java.util.List;

public class Ex26 {
    public static void main(String[] args) {
        //Arrays are covariant(accept subtypes)
        Number[] numbers = new Integer[4];
        numbers[0] = new Integer(0);
        numbers[1] = new Integer(1);
        numbers[2] = new Integer(2);
        numbers[3] = new Double(6.6);
        /*for(Number n:numbers)
            System.out.println(n.getClass().getSimpleName()+": "+n);*/
        try {
            System.out.println(numbers[3].getClass().getSimpleName() + ": " + (Integer) numbers[3]);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

