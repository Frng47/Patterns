package eckel.trash;
import eckel.util.io.DirInfo;

import javax.imageio.stream.ImageInputStream;
import java.io.File;

public class Replica {
    interface Strategy{
        void process(File file);
    }
    Strategy strategy;
    String ext;
    public Replica(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }

    public void start(String[] args){

        if(args.length==0)
            processDirectoryTree(new File("."));
        else
            for(String arg: args){
                File fileArg=new File(arg);
                if(fileArg.isDirectory())
                    processDirectoryTree(fileArg);
                else{
                    if(!arg.endsWith("."+ext));{
                    strategy.process(new File(arg));
                    }
                }
            }
    }

    void processDirectoryTree(File root){
        for(File file: DirInfo.walk(root.getAbsolutePath(),".*")){
            strategy.process(file);
        }
    }

    public static void main(String[] args) {
        String[] arr={"C:\\Users\\m.gladikov\\Desktop\\Files","C:\\Users\\m.gladikov\\Desktop\\Files\\Folder"};
        new Replica(new Strategy() {public void process(File file) {System.out.println(file);}},"txt").start(arr);
    }
}
