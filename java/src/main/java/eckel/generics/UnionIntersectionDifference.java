package eckel.generics;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import static eckel.generics.Watercolors.*;

public class UnionIntersectionDifference {
    public static <T> Set<T> union(Set<T> a,Set<T> b){
        Set<T> result=new HashSet<>(a);
        result.addAll(b);
        return result;
    }
    public static <T> Set<T> difference(Set<T> a,Set<T> b){
        Set<T> result=new HashSet<>(a);
        result.removeAll(b);
        return result;
    }
    public static <T> Set<T> intersection(Set<T> a,Set<T> b){
        Set<T> result=new HashSet<>(a);
        result.retainAll(b);
        return result;
    }
}
class Test1{
    public static void main(String[] args) {
        Set<Watercolors> set1= EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
        Set<Watercolors> set2= EnumSet.range(ZINC, ULTRAMARINE);
        System.out.println(UnionIntersectionDifference.difference(set1,set2));
    }
}
