package eckel.util.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class DirInfo {
    static File[] local(File path, String regex) {
        return path.listFiles(new FilenameFilter() {
            Pattern pattern = Pattern.compile(regex);

            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
    }
    static File[] local(String pathString, String regex) {
        return local(new File(pathString), regex);
    }

    public static class TreeInfo implements Iterable<File> {
        public List<File> dirs = new ArrayList<>();
        public List<File> files = new ArrayList<>();

        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        public String toString() {
            return "dirs: " + PPrint.pformat(dirs) +
                    "\n\nfiles: " + PPrint.pformat(files);
        }
    }

    public static TreeInfo recurseDir(File startDir, String regex) {
        TreeInfo result = new TreeInfo();
        for (File item : startDir.listFiles()) {
            if (item.isDirectory()) {
                result.dirs.add(item);
                result.addAll(recurseDir(item, regex));
            } else {
                if (item.getName().matches(regex)) {
                    result.files.add(item);
                }
            }
        }
        return result;
    }

    public static TreeInfo walk(String start, String regex) {
        return recurseDir(new File(start), regex);
    }

    /*public static void main(String[] args) {
        System.out.println(walk("C:\\Users\\m.gladikov\\Desktop\\Files", ".*"));
    }*/
}
