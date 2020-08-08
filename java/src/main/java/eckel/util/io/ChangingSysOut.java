package eckel.util.io;

import java.io.PrintWriter;

public class ChangingSysOut {
    /*
    It’s important to use the two-argument version of the PrintWriter constructor and to set
    the second argument to true in order to enable automatic flushing; otherwise, you may not
    see the output.
     */
    static PrintWriter out=new PrintWriter(System.out,true);

    public static void main(String[] args) {
        out.println("HELLO!");
    }
}
