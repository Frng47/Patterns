//Rewrite SplitDemo using String.split( ).
package eckel.string;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Ex14 {
    public static void main(String[] args) {
        String input =
                "This!!unusual use!!of exclamation!!points";
        System.out.println(Arrays.toString(
                Pattern.compile("!!").split(input)));
// Only do the first three:
        System.out.println(Arrays.toString(
                Pattern.compile("!!").split(input, 2)));
        System.out.println(Arrays.toString(input.split("!!")));
    }
}