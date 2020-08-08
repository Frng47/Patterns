package eckel.util.io;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class ProcessFiles {
    public interface Strategy {
        void process(File file);
    }
    private Strategy strategy;
    private String ext;
  /*  private String regex;*/

    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }

//************************************
    public void startExt(String path) {
        try {

                    File fileArg = new File(path);
                    if (fileArg.isDirectory())
                        processDirectoryTree(fileArg);
                    else {
// Allow user to leave off extension:
                        if (!path.endsWith("." + ext))
                                path+=ext;
                                 strategy.process(
                                new File(path).getCanonicalFile());
                    }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//********************************************
    public void  processDirectoryTree(File root) throws IOException {
        for (File file : DirInfo.walk(root.getAbsolutePath(), ".*\\." + ext))
            strategy.process(file.getCanonicalFile());
    }
//******************************************
    // Demonstration of how to use it:
    /*public static void main(String[] args) {
        String[] arr={"C:\\Users\\m.gladikov\\Desktop\\Files"};
        new ProcessFiles(new ProcessFiles.Strategy() {
            public void process(File file) {
                System.out.println(file.getName());
            }
        }, "txt").start(arr);
    }*/
}

