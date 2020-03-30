package eckel.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex9  {
    private List<Object> list=new ArrayList<>();
    private int next=0;
    public void add(Object x){
        list.add(x);
    }
    Iterator iterator(){
        return  list.iterator();
    }
    /*public Ex9(List<Object> list){
        this.list=list;
    }*/

    public static void main(String[] args) {
        Ex9 seq=new Ex9();
        seq.add("a");
        seq.add("b");
        Iterator it=seq.iterator();
        while (it.hasNext()){
            System.out.println((String)it.next());
        }
    }
}
