package eckel.errorhandling;

public class Ex25 {
    public static void main(String[] args) throws Exception {
        A a=new C();
        try{
            new A().f();
        }catch (LevelThree three){
            System.out.println("Three has been caught");
        }
        catch (LevelTwo two){
            System.out.println("Two has been caught");
        }
        catch (LevelOne one){
            System.out.println("One has been caught");
        }
    }



}
class A {
    void f() throws Exception {
        throw new LevelOne();
    }
}
class B extends A {
    void f() throws Exception {
        throw new LevelTwo();
    }
}

class C extends B{
    void f() throws Exception {
        throw new LevelThree();
    }
}

class LevelOne extends Exception{}
class LevelTwo extends LevelOne{}
class LevelThree extends LevelTwo{}