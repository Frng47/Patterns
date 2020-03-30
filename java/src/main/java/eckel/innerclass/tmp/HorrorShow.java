/*
package eckel.innerclass.tmp;

interface Monster {
    void menace();
}
interface DangerousMonster extends Monster {
    void destroy();
}
interface Lethal {
    void kill();
}
class DragonZilla implements DangerousMonster {
    public void menace() {}
    public void destroy() {}
}
interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();
}
class VeryBadVampire implements Vampire {
    public void menace() {}
    public void destroy() {}
    public void kill() {}
    public void drinkBlood() {}
}
public class HorrorShow {
    static void u(Monster b) { b.menace(); }
    DangerousMonster makeMonster(){
        return new DangerousMonster(){
            public void destroy() {
                System.out.println("ex13destroy");
            }
            public void menace() {
                System.out.println("ex13 menace");
            }
        };
    }
    void show(
    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }
    static void w(Lethal l) { l.kill(); }
    public static void main(String[] args) {
        */
/*DangerousMonster barney = new DragonZilla();
        u(barney);
        v(barney);*//*

        DangerousMonster barney=new DangerousMonster() {
            @Override
            public void destroy() {
                System.out.println("destroy");
            }

            @Override
            public void menace() {
                System.out.println("menace");
            }
        };
        u(barney);
        v(barney);
        */
/*Vampire vlad = new VeryBadVampire();
        u(vlad);
        v(vlad);
        w(vlad);*//*

    }
} ///:~
*/
