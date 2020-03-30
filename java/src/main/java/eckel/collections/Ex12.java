package eckel.collections;

import java.util.*;

public class Ex12 {
    public static void main(String[] args) {
        Random random=new Random();
        Integer[] arr={0,1,2,3,4,5,6,7,8,9};
        List<Integer> list1=new ArrayList<>(Arrays.asList(arr));
        List<Integer> list2=new ArrayList<>(10);
        ListIterator<Integer> it1=list1.listIterator();
        ListIterator<Integer> it2=list2.listIterator();
        while(it1.hasNext()){
           // System.out.println(it.next());
        }
        System.out.println();
        while(it2.hasNext()){
            it2.next();
            list2.set(it2.nextIndex(),it1.previous());
        }
        System.out.println(list2);

    }


}
