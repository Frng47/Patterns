/*Add Rhomboid to Shapes.java. Create a Rhomboid, upcast it to a
 *Shape, then downcast it back to a Rhomboid. Try downcasting to a Circle and see what
 *happens.*/
package eckel.typeinfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex3 {
    public static void main(String[] args) {
        List<Shapes> list=new ArrayList<>(Arrays.asList(new Circle(),new Rhomboid()));
        ((Circle) list.get(1)).draw();
    }

}
