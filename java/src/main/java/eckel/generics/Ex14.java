/**
 * Modify BasicGeneratorDemo.java to use the explicit form of
 * creation for the Generator (that is, use the explicit constructor instead of the generic
 * create( ) method).
 */
package eckel.generics;

public class Ex14 {
}
class BasicGenerator<T> implements Generator<T> {
    private Class<T> type;
    public BasicGenerator(Class<T> type){ this.type = type; }
    public T next() {
        try {
// Assumes type is a public class:
            return type.newInstance();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    // Produce a Default generator given a type token:
    public static <T> Generator<T> create(Class<T> type) {
        return new BasicGenerator<T>(type);
    }
}