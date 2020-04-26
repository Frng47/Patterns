package eckel.typeinfo;

import java.lang.reflect.Field;

public class Ex9 {
    public static void hierarchy(Object o)  {
        if(o.getClass().getSuperclass()!=null){
            Field[] fields=o.getClass().getDeclaredFields();
            System.out.println("Class "+o.getClass().getSimpleName()+" is a subclass of "+o.getClass().getSuperclass());
            if(fields.length!=0){
                for(Field field:fields)
                    System.out.println(field);
            }
            try{hierarchy(o.getClass().getSuperclass().newInstance());}
            catch (IllegalAccessException e){
                System.err.println("IllegalAccessException");
            }
            catch (InstantiationException e){
                System.err.println("IllegalAccessException");
            }
        }

    }

    public static void main(String[] args) {
        hierarchy(new C());
    }
}
