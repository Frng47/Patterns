package eckel.lambda;

public class exolDefault {
}
interface Roarable {
    default void roar() {
        System.out.println("Roar!!");
    }
}
interface Purrable {
    default void purr() {
        System.out.println("Purrrrrrr...");
    }
}
interface Meowler {
    default void meow() {
        System.out.println("MeeeeOww!");
    }
}
interface Cat {
    String getCatKind();
    String getFurDescription();
    default void growl() {
        System.out.println("Grrrrowl!!");
    }
    default void walk() {
        System.out.println(getCatKind() + " is walking.");
    }
    default void eat() {
        System.out.println(getCatKind() + " is eating.");
    }
    default void sleep() {
        System.out.println(getCatKind() + " is sleeping.");
    }
}

class Lion implements Cat, Roarable {
    @Override
    public String getCatKind() {
        return getClass().getSimpleName();
    }
    @Override
    public String getFurDescription() {
        return "gold-brown";
    }
}
class Cheetah implements Cat, Purrable {
    @Override
    public String getCatKind() {
        return getClass().getSimpleName();
    }
    @Override
    public String getFurDescription() {
        return "spotted";
    }
}
class HouseCat implements Cat, Purrable, Meowler {
    @Override
    public String getCatKind() {
        return "Domestic Cat";
    }
    @Override
    public String getFurDescription() {
        return "mixed brown and white";
    }
}