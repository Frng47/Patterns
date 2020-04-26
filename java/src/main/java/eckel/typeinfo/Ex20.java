package eckel.typeinfo;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class Ex20 {
   static Class c;
   static Pattern p=Pattern.compile("\\w+\\.|public|final|native");

    static void test(String s){
        try {
            c=Class.forName(s);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method[] methods=c.getMethods();
        for (Method m:methods
             ) {
            //System.out.println(c.getSimpleName());
            //System.out.println(m.toString());
            System.out.println(p.matcher(m.toString()).replaceAll(""));

        }
    }

    public static void main(String[] args) {
    test("eckel.typeinfo.Ex20Test");
    }

}

class Ex20Test {
    public void one(){}
    void two(){}
}
