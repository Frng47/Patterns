/**
 * Exercise 4: (2) Use Directory.walk( ) to sum the sizes of all files in a directory tree
 * whose names match a particular regular expression.
 */
package eckel.io;

import eckel.util.Print;
import eckel.util.io.DirInfo;

import java.io.File;

public class Ex4 {
    public static void main(String[] args) {
        String path="C:\\Users\\m.gladikov\\Desktop\\Files";
        String ext=".*txt$";
        long sum=0;
        for(File item: DirInfo.walk(path,ext)){
            sum+=item.length();
        }
        Print.print((Long.toString(sum)));


    }
}
