package additional;

public class Polymorphism {
    public static void main(String[] args) {
        Bird penguinOne=new Penguin();
        penguinOne.fly();//available only fly
        Penguin penguinTwo=new Penguin();
        penguinTwo.fly();
        penguinTwo.swim();
        Bird bird=new Bird();
        test(bird);

        test(penguinOne);
        test(penguinTwo);

    }
   public  static void test(Bird bird){
        bird.fly();
    }


}
class Bird{
    void fly(){
        System.out.println("fly...");
    }
}
class Penguin extends Bird{
    void swim(){
        System.out.println("swim....");
    }
    void fly(){
        System.out.println("penguins don't fly");
    }
}