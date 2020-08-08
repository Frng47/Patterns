/**
 * Exercise 5: (1) Modify ProcessFiles.java so that it matches a regular expression rather
 * than a fixed extension.
 */
package eckel.io;

import eckel.util.Print;
import eckel.util.io.DirInfo;
import eckel.util.io.ProcessFiles;

import java.io.File;
import java.io.IOException;

public class Ex5  {
    interface Strategy{public void process(File file);}
    private Strategy strategy;
    private String regex;

    public Ex5(Strategy strategy, String regex) {
        this.strategy = strategy;
        this.regex = regex;
    }

    public void start(String[] args){
        if(args.length==0)
            Print.print("[]");
        else{
            for(String item:args){
                File fileArgs=new File(item);
                processDirectoryTree(fileArgs);
            }
        }
    }
    void processDirectoryTree(File file){
        for(File item: DirInfo.walk(file.getAbsolutePath(),regex)){
            strategy.process(item);
        }
    }

    public static void main(String[] args) {
        String[] arr={"C:\\Users\\m.gladikov\\Desktop\\Files"};
        new Ex5(new Strategy() {
            public void process(File file) {
                Print.print(file.getName());
            }
        },".*txt$").start(arr);
    }
}
