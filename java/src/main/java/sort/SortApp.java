package sort;

import java.util.ArrayList;
import java.util.List;

public class SortApp {
    public static void main(String[] args) {
        List<Integer> list= new ArrayList<>();
        list.add(0);
        list.add(5);
        list.add(0);
        Sorters<Integer> srt=new Sorters();
       // srt.sort(list);
    }

}


class Sorters<T>{

   private  void swap(List<T> list, int fst, int scd){
        T tmp=list.get(scd);
        list.set(scd,list.get(fst));
        list.set(fst,tmp);
    }
   /* public  void sort(List<? extends Comparable> list){
        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i).compareTo(list.get(i + 1))>0){
                Comparable tmp=list.get(i+1);
                list.set(i+1,list.get(i));
                list.set(i,tmp);
            };*/



        }
