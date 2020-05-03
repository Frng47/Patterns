package eckel.generics;

import java.lang.reflect.Method;
import java.util.*;

public class ContainerMethodDifferences {
    public static Set<String> methodSet(Class<?> type){
        Set<String> result=new TreeSet();
        for(Method m:type.getMethods())
            result.add(m.getName());
        System.out.println("methods of class "+
                type.getSimpleName()+": "+result);
        return result;
    }
    public static Set<String> interfaces(Class<?> type){
        Set<String> result=new TreeSet();
        for(Class<?> i:type.getInterfaces())
            result.add(i.getName());
        System.out.println("Interfaces of class "+
                type.getSimpleName()+": "+result);
        return result;
    }
    static void difference(Class<?> superset,Class<?> subset){
        System.out.println(UnionIntersectionDifference.difference(methodSet(superset),methodSet(subset)));
    }

    public static void main(String[] args) {
        difference(HashMap.class,Map.class);
    }
}
