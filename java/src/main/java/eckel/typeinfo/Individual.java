package eckel.typeinfo;

import java.util.*;

public class Individual {
    private String name;
    private static long count=0;
    private  long id;

    public Individual(String name) {
        this.name = name;
        id=count++;
    }
    public Individual() {
        id=count++;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    //String toString(){}
}
class Person extends Individual {
    public Person(String name) { super(name); }
}
class Pet extends Individual {
    public Pet(String name) { super(name); }
    public Pet() { super(); }
}
class Dog extends Pet {
    public Dog(String name) { super(name); }
    public Dog() { super(); }
} ///:~
class Mutt extends Dog {
    public Mutt(String name) { super(name); }
    public Mutt() { super(); }
} ///:~
class Pug extends Dog {
    public Pug(String name) { super(name); }
    public Pug() { super(); }
}
class Cat extends Pet {
    public Cat(String name) { super(name); }
    public Cat() { super(); }
}
class EgyptianMau extends Cat {
    public EgyptianMau(String name) { super(name); }
    public EgyptianMau() { super(); }
}
class Manx extends Cat {
    public Manx(String name) { super(name); }
    public Manx() { super(); }
}
class Cymric extends Manx {
    public Cymric(String name) { super(name); }
    public Cymric() { super(); }
}
class Rodent extends Pet {
    public Rodent(String name) { super(name); }
    public Rodent() { super(); }
}
class Rat extends Rodent {
    public Rat(String name) { super(name); }
    public Rat() { super(); }
}
class Mouse extends Rodent {
    public Mouse(String name) { super(name); }
    public Mouse() { super(); }
}
class Hamster extends Rodent {
    public Hamster(String name) { super(name); }
    public Hamster() { super(); }
}
class Gebril extends Rodent {
    public Gebril(String name) { super(name); }
    public Gebril() { super(); }
}
//***************************************\\
// Creates random sequences of Pets.
abstract class PetCreator {
    private Random rand = new Random(47);
    // The List of the different types of Pet to create:
    public abstract List<Class<? extends Pet>> types();
    public Pet randomPet() { // Create one random Pet
        int n = rand.nextInt(types().size());
        try {
            return types().get(n).newInstance();
        } catch(InstantiationException e) {
            throw new RuntimeException(e);
        } catch(IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    public Pet[] createArray(int size) {
        Pet[] result = new Pet[size];
        for(int i = 0; i < size; i++)
            result[i] = randomPet();
        return result;
    }
    public ArrayList<Pet> arrayList(int size) {
        ArrayList<Pet> result = new ArrayList<Pet>();
        Collections.addAll(result, createArray(size));
        return result;
    }
}
//************************************\\
class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types =
            new ArrayList();
    // Types that you want to be randomly created:
    private static String[] typeNames = {
            "eckel.typeinfo.Mutt",
            "eckel.typeinfo.Pug",
            "eckel.typeinfo.EgyptianMau",
            "eckel.typeinfo.Manx",
            "eckel.typeinfo.Cymric",
            "eckel.typeinfo.Rat",
            "eckel.typeinfo.Mouse",
            "eckel.typeinfo.Hamster",
            "eckel.typeinfo.Gebril"
    };
    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for(String name : typeNames)
                types.add(
                        (Class<? extends Pet>)Class.forName(name));
        } catch(ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    static { loader(); }
    public List<Class<? extends Pet>> types() {return types;}
}
//***************************************************************
class LiteralPetCreator extends PetCreator {
    // No try block needed.
    @SuppressWarnings("unchecked")
    public static final List<Class<? extends Pet>> allTypes =
            Collections.unmodifiableList(Arrays.asList(
                    Pet.class, Dog.class, Cat.class, Rodent.class,
                    Mutt.class, Pug.class, EgyptianMau.class, Manx.class,
                    Cymric.class, Rat.class, Mouse.class,Hamster.class));
    // Types for random creation:
    private static final List<Class<? extends Pet>> types =
            allTypes.subList(allTypes.indexOf(Mutt.class),
                    allTypes.size());
    public List<Class<? extends Pet>> types() {
        return types;
    }
    public static void main(String[] args) {
        System.out.println(types);
    }

}
//***************************************************************
class PetCount {
    static class PetCounter extends HashMap<String,Integer> {
        public void count(String type) {
            Integer quantity = get(type);
            if(quantity == null)
                put(type, 1);
            else
                put(type, quantity + 1);
        }
    }
    public static void
    countPets(PetCreator creator) {
        PetCounter counter= new PetCounter();
        for(Pet pet : creator.createArray(20)) {
// List each individual pet:
            System.out.println(pet.getClass().getSimpleName() + " ");
            if(pet instanceof Pet)
                counter.count("Pet");
            if(pet instanceof Dog)
                counter.count("Dog");
            if(pet instanceof Mutt)
                counter.count("Mutt");
            if(pet instanceof Pug)
                counter.count("Pug");
            if(pet instanceof Cat)
                counter.count("Cat");
            if(pet instanceof Manx)
                counter.count("EgyptianMau");
            if(pet instanceof Manx)
                counter.count("Manx");
            if(pet instanceof Manx)
                counter.count("Cymric");
            if(pet instanceof Rodent)
                counter.count("Rodent");
            if(pet instanceof Rat)
                counter.count("Rat");
            if(pet instanceof Mouse)
                counter.count("Mouse");
            if(pet instanceof Hamster)
                counter.count("Hamster");
        }
// Show the counts:
        System.out.println();
        System.out.println(counter);
    }
    public static void main(String[] args) {
        countPets(new ForNameCreator());
    }
}

//********************************

class Pets {
    public static final PetCreator creator =
            new LiteralPetCreator();
    public static Pet randomPet() {
        return creator.randomPet();
    }
    public static Pet[] createArray(int size) {
        return creator.createArray(size);
    }
    public static ArrayList<Pet> arrayList(int size) {
        return creator.arrayList(size);
    }
}

class PetCount2 {
    public static void main(String[] args) {
        PetCount.countPets(Pets.creator);
    }
}
//********************************
/*class PetCount3 {
    static class PetCounter
            extends LinkedHashMap<Class<? extends Pet>,Integer> {
        public PetCounter() {
            super(MapData.map(LiteralPetCreator.allTypes, 0));
        }
        public void count(Pet pet) {
// Class.isInstance() eliminates instanceofs:
            for(Map.Entry<Class<? extends Pet>,Integer> pair
                    : entrySet())
                if(pair.getKey().isInstance(pet))
                    put(pair.getKey(), pair.getValue() + 1);
        }
        public String toString() {
            StringBuilder result = new StringBuilder("{");
            for(Map.Entry<Class<? extends Pet>,Integer> pair
                    : entrySet()) {
                result.append(pair.getKey().getSimpleName());
                result.append("=");
                result.append(pair.getValue());
                result.append(", ");
            }
            result.delete(result.length()-2, result.length());
            result.append("}");
            return result.toString();
        }
    }
    public static void main(String[] args) {
        PetCounter petCount = new PetCounter();
        for(Pet pet : Pets.createArray(20)) {
            System.out.println(pet.getClass().getSimpleName() + " ");
            petCount.count(pet);
        }
        System.out.println();
        System.out.print(petCount);
    }
}
 class MapData<T>{
     Class<T> type;
    public static Map map(Class<? extends Pet> it,int number){

        Map<Iterable,Integer> map=new HashMap<>();
//        for(Class<? extends Pet> pet: map)
        return map;
    }
 }*/
 //************************************
class TypeCounter extends HashMap<Class<?>,Integer>{
     private Class<?> baseType;
     public  TypeCounter(Class<?> baseType) {
         this.baseType = baseType;
     }
     public void count(Object obj) {
         Class<?> type = obj.getClass();
         if(!baseType.isAssignableFrom(type))
             throw new RuntimeException(obj + " incorrect type: "
                     + type + ", should be type or subtype of "
                     + baseType);
         countClass(type);
     }
     private void countClass(Class<?> type) {
         Integer quantity = get(type);
         put(type, quantity == null ? 1 : quantity + 1);
         Class<?> superClass = type.getSuperclass();
         if(superClass != null &&
                 baseType.isAssignableFrom(superClass))
             countClass(superClass);
     }
     public String toString() {
         StringBuilder result = new StringBuilder("{");
         for(Map.Entry<Class<?>,Integer> pair : entrySet()) {
             result.append(pair.getKey().getSimpleName());
             result.append("=");
             result.append(pair.getValue());
             result.append(", ");
         }
         result.delete(result.length()-2, result.length());
         result.append("}");
         return result.toString();
     }
 }
 class Tester{
     public String toString() {
         return getClass().getSimpleName();
     }

     public static void main(String[] args) {
         System.out.println(new Tester().toString());
     }
 }



 class PetCreator2{
    static List<Class<? extends Pet>> listOfClasses=new ArrayList<>();
    static {
        listOfClasses.add(Mouse.class);
        listOfClasses.add(Hamster.class);
    }
     static Random random=new Random();
     static Pet createRandom(){
         int num=random.nextInt(listOfClasses.size());
         try {
             return listOfClasses.get(num).newInstance();
         } catch (InstantiationException e) {
             throw new RuntimeException();
         } catch (IllegalAccessException e) {
             throw new RuntimeException();
         }
     }
     static List<Pet> CreateListOfPets(int size){
          List<Pet> listOfPets=new ArrayList<>();
          for(int i=0;i<size;i++)
              listOfPets.add(createRandom());
          return listOfPets;
     }

      static class Counter extends HashMap<Pet,Integer>{
         List<Pet> list;
         public Counter(List<Pet> list){
             this.list=list;
         }
         String count(){
             for(Pet pet:list)
                 put(pet,get(pet)==null?1:get(pet)+1);
             return toString();
         }
     }

     public static void main(String[] args) {
//         CreateListOfPets(5);
         Counter counter=new PetCreator2.Counter(PetCreator2.CreateListOfPets(5));
//         counter.count();
         System.out.println(counter.count());;
//         new Counter(PetCreator2.CreateListOfPets(5)).count();
//         System.out.println();
     }

 }