/**
 * Exercise 2: (2) Create a class called SortedDirList with a constructor that takes a File
 * object and builds a sorted directory list from the files at that File. Add to this class two
 * overloaded list( ) methods: the first produces the whole list, and the second produces the
 * subset of the list that matches its argument (which is a regular expression).
 */

package eckel.io;

import com.sun.javaws.IconUtil;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Ex2 {

    public static void main(String[] args) {
        File path=new File("C:\\Users\\m.gladikov\\Desktop\\Files");
      SortedDirList dirList=new SortedDirList(path);
        System.out.println(dirList.list("(.*txt.?)"));
    }

}
class SortedDirList{
    private File path;
   public SortedDirList(File path){
       this.path=path;
   }
   public List<String> list(){
    return Arrays.asList(path.list());
   }
   public List<String> list(String regex){
    return Arrays.asList(path.list(new FilenameFilter() {
        Pattern pattern=Pattern.compile(regex);
        public boolean accept(File dir, String name) {
            return pattern.matcher(name).matches();
        }
    }));
   }
}
class Test{
  private static FilenameFilter filter(final String regex){
       Pattern pattern=Pattern.compile(regex);
      return new FilenameFilter(){
          public boolean accept(File dir, String name) {
              return pattern.matcher(name).matches();
          }
      };
  }
    public static void main(String[] args) {
        File file=new File("C:\\Users\\m.gladikov\\Desktop\\Files");
        String[] list;
        list=file.list(filter("(.*txt$)"));
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.asList(list));
    }
}
class TestTwo{
    public static void main(String[] args) {
        File file=new File("C:\\Users\\m.gladikov\\Desktop\\Files");

        System.out.println(file.length());;
        String regex="(.*txt$)";
        String[] list=file.list(new FilenameFilter() {
            Pattern pattern=Pattern.compile(regex);
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        }
        );
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.asList(list));

        File[] listOfFiles=file.listFiles(new FilenameFilter() {
            Pattern pattern=Pattern.compile(regex);
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        int totalSize=0;
        for(File item:listOfFiles){
            System.out.print(item.getName()+": "+item.length()+'\n');
            totalSize+=item.length();
        }
        System.out.println(totalSize);
        System.out.println("Total size is "+file.getTotalSpace());
    }
}
