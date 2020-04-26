package eckel.typeinfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex6 {
    static void mark(Shapes shape){
        shape.flag=true;
    }
    public static void main(String[] args) {
        List<Shapes> list=new ArrayList<>(Arrays.asList(new Circle(),new Rhomboid(),new Triangle()));
        for(Shapes shape:list)
            shape.draw();
        for(Shapes shape:list)
            mark(shape);
        for(Shapes shape:list)
            System.err.println(shape.toString());
    }
}
