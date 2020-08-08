package additional;
/*
Java core consists of six packages(java.lang java.eckel.io java.util java.net java.math java.text )
 */
/*
S.O.L.I.D is an acronym for the first five object-oriented design(OOD)** principles** by Robert C. Martin, popularly known as Uncle Bob.
S - Single- responsiblity principle
O - Open-closed principle
L - Liskov substitution principle
I - Interface segregation principle
D - Dependency Inversion Principle

 */
/*
Entity - (if one instance of the class is a real object(class Car- instance myCar(myCar is a real object)))
Value object (date, Integer etc)
Manager/Service Validator(registration on a site) There are no attributes only methods
Base/Abstract/Skeleton
Container
 */

/*
polymorphism
***universal*** applied to infinite quantities
1. Overriding through inheritance
2. Generics
***ad hoc*** applied to final quantities
3.OverLoading of methods/operators
4.OverLoading of type
 */

import java.util.ArrayList;

//<T> is a type variable
//Type inference
//arrays are covariant(String<:Object then String[]<:Object[] so Object[] obj=new String[]{"Example"};)
//generics are invariant(by default)(ArrayList<Object> list=new ArrayList<String>() - compile error)
public class Comments {
}
class CopierTestClass {
    public static void main(String[] args) {
        /*ArrayList<Integer> integers=new ArrayList<Integer>(10);
        integers.add(0,new Integer(1));
        ArrayList<Object> objects=new ArrayList<>(10);
        Copier.copyGen(integers,objects);
        Object noCast=objects.get(0);
        //System.out.println(noCast.toString());*/
        String str = "Hello";
        Double d = 1.25;
        System.out.println(Mocker.mock(d));
        //Integer extends Number (Integer<:Number)
        //ArrayList<Number> listZero=new ArrayList<Integer>();//don't work because of invariant of generics
        ArrayList<? extends Number> listOne = new ArrayList<Integer>(); // it's works because we transformed invariance to covariance with the help of wildcard
        Number number = null;
        //listOne.add(number);// you can't add number
        //listOne.add(new Integer(5));// you can't add Integer// you can't add anything anymore except null :). You can read  only.
        ArrayList<? super Integer> listTwo = new ArrayList<Number>(); // it's works because we transformed invariance to contravariance with the help of wildcard

        ArrayList<? extends Integer> listYYY = new ArrayList<Integer>();
        ArrayList<? extends Number> listXXX = new ArrayList<Integer>();
        listXXX = listYYY;//correct statement
        //listYYY=listXXX;//incorrect statement
    }
}