package eckel.collections;

import java.util.Collection;
import java.util.Iterator;

public class Ex30 {
}

class CollectionSequence implements Collection{

    private Rodent[] arr=new Rodents().createArray(8);



    public int size() {
        return arr.length;
    }

    public boolean isEmpty() {
        return arr.length==0?true:false;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator iterator() {
        return null;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public boolean add(Object o) {
        return false;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean addAll(Collection c) {
        return false;
    }

    public void clear() {

    }

    public boolean retainAll(Collection c) {
        return false;
    }

    public boolean removeAll(Collection c) {
        return false;
    }

    public boolean containsAll(Collection c) {
        return false;
    }

    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}

