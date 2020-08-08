package eckel.trash;

import eckel.util.Print;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Iteration implements Iterable<File>{
    File startDir;
    List<File> list=new ArrayList<>();
    public Iteration(String path) {
        startDir=new File(path);
        list=Arrays.asList(startDir.listFiles());
    }


    public Iterator<File> iterator() {
        return list.iterator();
    }

    public static void main(String[] args) {
        for(File s:new Iteration("C:\\")){
            Print.print(s.getName());
        }
        String s="1.05";
        Double d=new Double(s);
        System.out.println(d*5);

    }
}
