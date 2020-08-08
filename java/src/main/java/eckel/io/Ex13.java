/**
 * Exercise 13: (3) Modify BasicFileOutput.java so that it uses LineNumberReader
 * to keep track of the line count. Note that it’s much easier to just keep track programmatically.
 */
package eckel.io;
import eckel.trash.BufferedInputFile;
import java.io.*;

public class Ex13 {
    static String file = "BasicFileOutput.out";
    public static void main(String[] args)
            throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("BasicFileOutput.java")));
        PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;
        while((s = in.readLine()) != null )
            out.println(lineCount++ + ": " + s);
        out.close();
// Show the stored file:
        System.out.println(BufferedInputFile.read(file));
    }

}
