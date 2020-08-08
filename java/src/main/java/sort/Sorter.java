/*
package sort;

import java.util.List;
interface BinaryPredicate<T>{boolean process(T x,T y);}
public class Sorter {
        public static <T>void sortMax(List<T> list){
            int stop=1;
            long time=System.nanoTime();
            while(stop!=list.size()-1){
                for (int i = 0; i <list.size()-stop ; i++) {
                    if(true) {
                        Aux.swapA(list,i,i+1);
                    }
                }
                stop++;
            }
            time=System.nanoTime()-time;
            Double dTime= ((Number) time).doubleValue()/1000000;
            System.out.println("BubbleMax:  "+dTime+" ms");
        }




    public static boolean process(T x, T y) {
        return false;
    }
}
*/
