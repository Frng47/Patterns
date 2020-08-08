/**
 * a stream is not a data structure
 * that stores elements; instead, they carry values from a source (which could be a data structure, a
 * generator, an IO channel, etc.) through a pipeline of computational operations.
 * The common built-in aggregate operations are filter, map, and forEach.
 * A filter allows you to
 * pass in an expression to filter elements and returns a new Stream containing the selected items.
 * The map operation converts (or maps) each element to another type and returns a new Stream
 * containing items of the mapped type. For instance, you may want to map Integer values to
 * String values of a stream. A forEach operation allows you to pass in a lambda expression to
 * process each element in the stream.
 */

package eckel.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ExplStream {
    public static void main(String[] args) {
        List<Integer> values=Arrays.asList(1,2,3,4,5,6,7,88,99,0);
        System.out.println("values: " + values.toString());
        // nonlocal variable to be used in lambda expression.
        int threshold = 5;
        System.out.println("Values greater than " + threshold + " converted to hex:");
        values.stream()
                .filter(val -> val > threshold) // Predicate functional interface
                .sorted()
                .map(dec -> Integer.toHexString(dec).toUpperCase() ) // Consumer functional interface
                .forEach(val -> System.out.println(val)); // each output values.
        Stream<Integer> stream =values.stream();
    }
}
/**
 * The first operation is a filter that receives a lambda expression to filter elements (integers) greater
 * than 54 (val > threshold). The next operation is the sorted() method, which sorts elements that
 * were returned from the filter method stream. Continuing the method chaining, notice the map
 * operation. The map() method operation is able to map each element in the stream from one data
 * type to another.
 * In this scenario the stream elements are Integer objects, which are mapped to String objects. The
 * map() method returns another stream, containing elements of type Stream<String>. In this example
 * the string elements are hexadecimal values. Finally, the forEach() operation iterates over each
 * element in the stream of string (hex) elements to be printed.
 * You’ll notice that as each aggregate function is called, the return type is a Stream object, which
 * allows you to method-chain operations in a way very similar to the builder pattern. To clarify, the idea
 * of method chaining actually comes from the fluent interface pattern for API design.
 */
