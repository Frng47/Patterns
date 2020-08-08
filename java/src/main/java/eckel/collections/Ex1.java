package eckel.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

public class Ex1 {
    public static void main(String[] args) {
        Random random=new Random();
        Gebril[] arr={new Gebril(Math.abs(random.nextInt()%9)),new Gebril(Math.abs(random.nextInt()%9))};
        ArrayList<Gebril> list=new ArrayList<>();
        list.addAll(Arrays.asList(arr));
        for(Gebril i:list){
            System.out.println(i.hop());
        }
    }
}
class Gebril  {
    int gebrilNumber;
    Gebril(int number){
        gebrilNumber=number;
    }
    int hop(){return gebrilNumber;}
}
