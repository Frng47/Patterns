package eckel.string;

import java.util.regex.Pattern;

public class Ex6 {
    private int i=55;
    private long l=1000;
    private float f=0;
    private double d;

    public String toString(){

        return String.format("int i=%x, long l=%05d, float f=%05f",i,l,f);

    }

    public static void main(String[] args) {
        String s="^[A-Z].*[\\.]$";
        String s1="Hello!";
        String s2="Hello.";
        String s3="hello.";
        String s4="Hello and bay.";
        System.out.println( s1.matches(s));
        System.out.println( s2.matches(s));
        System.out.println( s3.matches(s));
        System.out.println( s4.matches(s));

    }
}
