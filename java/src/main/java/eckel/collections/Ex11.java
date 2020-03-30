package eckel.collections;

import java.util.*;

public class Ex11 {
    public static void print(Collection collection){
        Iterator it=collection.iterator();
        while (it.hasNext()){
            System.out.println(it.next().toString());
        }
    }

    public static void main(String[] args) {
        String[] arr={"a","b","c","d"};
        ArrayList<String> arrayList=new ArrayList<>(Arrays.asList(arr));
        Ex11.print(arrayList);
        TreeSet<String> set=new TreeSet<>(arrayList);
        Ex11.print(set);
    }
}
