/*Modify the previous exercise so that it uses instanceof to check the type before performing the downcast.*/
/**
 * Modify the previous exercise so that it uses instanceof to check the type
 * before performing the downcast.
 */
package eckel.typeinfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex4 {

    public static void main(String[] args) {
        List<Shapes> list=new ArrayList<>(Arrays.asList(new Circle(),new Rhomboid()));
        for(Shapes shape : list){
            if(shape instanceof Circle)
                ((Circle)(shape)).draw();
        }

    }


}
