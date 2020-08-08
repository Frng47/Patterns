/**
 * Exercise 6: (5) Use ProcessFiles to find all the Java source-code files in a particular
 * directory subtree that have been modified after a particular date.
 */

package eckel.io;

import eckel.util.io.ProcessFiles;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex6 {
    private static String path="C:\\Users\\m.gladikov\\Desktop\\Files";
    private static int year=2020;
    private static int month=5;
    private static int date=17;
    private static int hours=10;
    private static int min=50;
    public static void main(String[] args) {

    File file=new File(path);

        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yy HH:mm:ss");
       /* System.out.println(file.lastModified());
        System.out.println(file.getAbsolutePath());*/
        Date modD=new Date(year,month,date,hours,min);
        System.out.println();
        System.out.println(modD);
        new ProcessFiles(new ProcessFiles.Strategy() {
            public void process(File file) {
              try{if(modD.before(sdf.parse(sdf.format(file.lastModified()))))
                  System.out.println(file.getAbsolutePath());}
              catch (ParseException e){
                  System.err.println(e.getMessage());
              }
            }
        },"txt").startExt(path);
        /*System.out.println(modDate.after());
        System.out.println(sdf.format(file.lastModified()));*/
    }
}
