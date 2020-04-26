/**
 * Implement a rotate(Shape) method in Shapes.java, such that it
 * checks to see if it is rotating a Circle (and, if so, doesn’t perform the operation).
 */
package eckel.typeinfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex5 {
    static void rotate(Shapes s){
        if(!(s instanceof Circle))
            System.out.println(s+" has been rotated");
        else
            System.out.println("This is fucking circle, man!");
    }
    public static void main(String[] args) {
        List<Shapes> list=new ArrayList<>(Arrays.asList(new Circle(),new Rhomboid()));
        for(Shapes shape:list)
                        shape.rotate();
        for(Shapes shape:list)
            rotate(shape);

    }
}
