package eckel.innerclass.ex26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Clouser {
    public static void main(String[] args) {
        Collection<A> list=new ArrayList<>();
        list.addAll(Arrays.asList(new A(),new Aa()));
        System.out.println(list);
    }
}

class A{};
class Aa extends A{};