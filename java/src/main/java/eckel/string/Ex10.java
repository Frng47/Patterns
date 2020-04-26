package eckel.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex10 {
    static String[] arr={"^ Java","\\Breg.*","n.w\\s+h(a|i)s","s?","s*","s+","s{4}","S{1}","s{0,3}"};
    static String s="Java now has regular expressions";
    static String s1="^ Java";
    static String s2="\\Breg.*";
    static String s3="n.w\\s+h(a|i)s";


    public static void main(String[] args) {
        System.out.println(s);
        for(int i=0;i<arr.length;i++){
        Pattern p=Pattern.compile(arr[i]);
        Matcher m=p.matcher(s);
        System.out.println(arr[i]+": "+m.find());
    }
}
}
