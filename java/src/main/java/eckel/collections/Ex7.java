package eckel.collections;

import java.util.*;

public class Ex7 {
    public static void main(String[] args) {
        A[] arr={new A(),new A(),new A()};
        List<A> list=new ArrayList<>(Arrays.asList(arr));
        List<A> subList=list.subList(2,3);
        System.out.println(list);
        System.out.println(subList);
        list.removeAll(subList);
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
    }

}
class A{
    private static int id;
    private int number;
    public A(){
        id++;
        number=id;
    }
    public String toString(){
        return Integer.toString(number);
    }
}