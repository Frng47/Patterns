package eckel.generics;

import java.util.Collection;
import java.util.List;

public class Generators {
    public static <T>void fill(Collection<T> collection, Generator<T> gen, int sz)  {
        for (int i = 0; i <sz ; i++) {
            collection.add(gen.next());
        }
    }
}
