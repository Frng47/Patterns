package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Aux {
    public static void swap(List<Integer> list, int first, int second){
        Integer tmp;
        tmp=list.get(first);
        list.set(first,list.get(second));
        list.set(second,tmp);
    }
    public  static List<Integer> fillInt(int sz,int diap){
        Random random=new Random();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<sz;i++){
            list.add(random.nextInt(diap));
        }
        return list;
    }
}
