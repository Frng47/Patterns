package additional;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.Random;

public class TestApp {
    public static void main(String[] args) {
    }
}

class Processor {
    public String name() {
        return getClass().getSimpleName();
    }
    Object process(Object input) { return input; }
}
class Upcase extends Processor {
    String process(Object input) { // Covariant return
        return ((String)input).toUpperCase();
    }
}
class Downcase extends Processor {
    String process(Object input) {
        return ((String)input).toLowerCase();
    }
}
class Splitter extends Processor {
    String process(Object input) {
// The split() argument divides a String into pieces:
        return Arrays.toString(((String)input).split(" "));
    }
}
class Changer extends Processor{
    String process(Object input) {
        // The swap() argument swap characters  in a String:
        char tmp;
        char[] charArr=((String)input).toCharArray();
        for (int i = 0; i < ((String) input).length()-1; i++) {
            tmp=charArr[i+1];
            charArr[i+1]=charArr[i];
            charArr[i]=tmp;
            i++;
        }
        return new String(charArr);
    }
}
class Apply2 {
    public static void process(Processor p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }
    public static String s =
            "hello man";
    public static void main(String[] args) {
       /* process(new Upcase(), s);
        process(new Downcase(), s);
        process(new Splitter(), s);*/
       process(new Changer(),s);
    }
}
