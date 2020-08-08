package eckel.collections;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class Ex14 {
    static void middle(LinkedList<Integer> list,Integer[] arr){
        for(Integer i:arr) {
            ListIterator<Integer> it = list.listIterator(list.size() / 2);
            it.add(i);
            System.out.println(list);
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList<>(Arrays.asList(1,2,3,4,5));
        Integer[] arr={10,11,12,13,14};
        Ex14.middle(list,arr);
    }
}
