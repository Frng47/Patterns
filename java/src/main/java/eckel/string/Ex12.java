/*Modify Groups.java to count all of the unique words that do not start
        with a capital letter.*/
package eckel.string;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex12 {
    static public final String POEM =
                    "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";
    public static void main(String[] args) {

        Matcher m=Pattern.compile("^[a-z].*.[a-z]$").matcher(POEM);
        Set<String> words=new TreeSet<String>();
       // List<String> words=new ArrayList<String>();
        while(m.find()){
            words.add(m.group());
            System.out.println(words);
        }
        System.out.println(words.size());
    }
}



