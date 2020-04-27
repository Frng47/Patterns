package sort;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bubble {
    public static void sortMax(List<Integer> list){
        Integer tmp;
        int stop=1;
        long time=System.nanoTime();
        while(stop!=list.size()-1){
            for (int i = 0; i <list.size()-stop ; i++) {
                if(list.get(i)>list.get(i+1)) {
                    Aux.swap(list,i,i+1);
                }
            }
            stop++;
        }
        time=System.nanoTime()-time;
        Double dTime= ((Number) time).doubleValue()/1000000;
        System.out.println("BubbleMax:  "+dTime+" ms");

    }
    public static void sortMin(List<Integer> list){
        Integer tmp;
        int stop=0;
        long time=System.nanoTime();
        while(stop!=list.size()-1){
            for (int i = list.size()-1; i >0+stop ; i--) {
                if(list.get(i)>list.get(i-1)) {
                    Aux.swap(list,i-1,i);
                }
            }
            stop++;
        }
        time=System.nanoTime()-time;
        Double dTime= ((Number) time).doubleValue()/1000000;
        System.out.println("BubbleMin:  "+dTime+" ms");

    }
}
