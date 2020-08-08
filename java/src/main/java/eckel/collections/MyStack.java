package eckel.collections;

import java.util.LinkedList;

public class MyStack<T>{
    LinkedList<T> list=new LinkedList<>();
    public void push(T v) {list.addFirst(v);}
    public T peek() {return list.getFirst();}
    public T pop() {return list.removeFirst();}
    public boolean empty() {return list.isEmpty();}
    public String toString() {return list.toString(); }
}