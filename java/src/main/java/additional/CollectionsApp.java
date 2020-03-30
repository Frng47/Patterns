package additional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static java.util.Arrays.asList;

public class CollectionsApp {
    public static void main(String[] args) {
        List<String> list
               = new ArrayList<>(asList("A","C","A","B"));
        System.out.println(list);
        ArrayList<String> list2=new ArrayList<>(new HashSet<>(list));
        System.out.println(list2);
        Collections.sort(list2);
        System.out.println(list2);

    }
}
class Vararg<T>{
    T var;

   /* public T concatenate(T... arr) {
        T sum = null;
        for (int i=0;i<arr.length;i++) {
sum+=arr[i];
        }
    }*/

        }