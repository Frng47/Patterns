package eckel.collections;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class Next {


    public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        ListIterator<Integer> it=list.listIterator();
        //System.out.println(it.next());
        it.next();
        System.out.println(list);
        it.remove();
        System.out.println(list);
//        it.next();
//        it.remove();
//        System.out.println(list);
    }
}
