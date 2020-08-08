/**
 * Exercise 21: (1) Write a program that takes standard input and capitalizes all characters,
 * then puts the results on standard output. Redirect the contents of a file into this program
 * (the process of redirection will vary depending on your operating system).
 */
package eckel.io;

import java.io.*;

public class Ex21 {
    public static void main(String[] args) throws IOException {
        File file=new File("D:\\dev\\files\\dest.txt");
        BufferedInputStream in=new BufferedInputStream(new FileInputStream(file));
        System.setIn(in);
        BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=stdin.readLine())!=null)
            System.out.println(s.toUpperCase());
    }
}
//: io/Echo.java
// How to read from standard input.
// {RunByHand}
class Echo {
    public static void main(String[] args)
            throws IOException {
        BufferedReader stdin = new BufferedReader(
                new InputStreamReader(System.in));
        String s;
        while((s = stdin.readLine()) != null && s.length()!= 0)
            System.out.println(s);
// An empty line or Ctrl-Z terminates the program
    }
} ///:~
