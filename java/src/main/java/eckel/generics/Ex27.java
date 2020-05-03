package eckel.generics;

import java.util.ArrayList;
import java.util.List;

public class Ex27 {
    public static void main(String[] args) {
        List<Integer> integers=new ArrayList<Integer>();
        for (int i = 0; i <5 ; i++) {
            integers.add(i);
        }
        List<? extends Number> numbers=integers;
        //covariance is read only
        for (int i = 0; i <numbers.size() ; i++) {
            System.out.println(numbers.get(i));
            //numbers.add(i); forbidden action
        }
    }
}
