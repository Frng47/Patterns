package eckel.generics;

import com.sun.javaws.IconUtil;

import java.util.HashMap;
import java.util.Map;

public class Ex21 {
}
class ClassTypeCapture<T>{
    Class<T> kind;
    Map<String,Class<?>> map=new HashMap<>();
    void add(String typeName,Class<?> type){
        map.put(typeName,type);
    }
    Object createNew(String typeName){
        if(map.containsKey(typeName)) {
            try {
                return map.get(typeName).newInstance();
            } catch (Exception e) {
                System.out.println("An Error has been ocured");
            }
        }
        System.out.println("There's no such class");
        return null;
    }
    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }
    boolean f(Object arg){
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
        ClassTypeCapture<House> house=new ClassTypeCapture<>(House.class);
        house.add("Building",Building.class);
        house.add("House",House.class);
        Object h=house.createNew("House");
        ((House) h).f();
        ;
        System.out.println(house.f(house.createNew("Building")));
    }

}
class House{
    void f(){
        System.out.println("This is a House");
    }
}
class Building extends House{void f(){
    System.out.println("This is a building");
}}