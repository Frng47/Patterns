package sort;

import java.util.ArrayList;
import java.util.List;

public class Shaker {
    public static void sort(List<Integer> listOriginal){
        ArrayList<Integer> list=new ArrayList<>(listOriginal);
        if(list.size()>1){
            int beg=0;
            int end=list.size()-1;
            boolean b=true;
            long time=System.nanoTime();
            double msTime;
            while(b){
                b=false;
                for(int i=beg;i<end;i++){
                    if(list.get(i)>list.get(i+1))
                        Aux.swap(list,i,i+1); b=true;

                }
                if(b){
                    end--;
                for (int i = end; i >beg ; i--) {
                    if(list.get(i)<list.get(i-1))
                        Aux.swap(list,i,i-1);
                    }
                }
                beg++;
            }
            time=System.nanoTime()-time;
            msTime=((Number)time).doubleValue()/1000000;
            System.out.println(list);
            System.out.println("Execution time: "+msTime+" ms");
        }
    }
}
