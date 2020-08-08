package eckel.innerclass;

import java.util.Random;

public class Ex17 {
    static void getGame(GameFactory factory){
        System.out.println(factory.getGame().throwShirt());
    }

    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            getGame(Coin.factory);
        }
        for (int i = 0; i <10 ; i++) {
            getGame(Dice.factory);
        }
    }
}
interface Game{
    int throwShirt();
}
interface GameFactory{
    Game getGame();
}

class Dice implements Game{
    private Dice(){};
    Random rand=new Random();
    public int throwShirt() {

        return rand.nextInt(6)+1;
         }
    static GameFactory factory=new GameFactory() {
        public Game getGame() {
            return new Dice();
        }
    };
}
class Coin implements Game{
    private Coin(){};
    Random rand=new Random();
    public int throwShirt() {
        return rand.nextInt(2);
    }
    static GameFactory factory=new GameFactory() {
        public Game getGame() {
            return new Coin();
        }
    };
}