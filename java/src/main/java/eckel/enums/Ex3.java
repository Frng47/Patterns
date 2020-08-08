package eckel.enums;

public class Ex3 {
}


interface Food{
    enum Appetizer implements Food{
        SALAD, SOUP, SPRING_ROLLS;
    }
    enum MainCourse implements Food{
        LASAGNE, BURRITO, PAD_THAI,
        LENTILS, HUMMOUS, VINDALOO;
    }
    enum Dessert implements Food {
        TIRAMISU, GELATO, BLACK_FOREST_CAKE,
        FRUIT, CREME_CARAMEL;
    }
    enum Coffee implements Food {
        BLACK_COFFEE, DECAF_COFFEE, ESPRESSO,
        LATTE, CAPPUCCINO, TEA, HERB_TEA;
    }
}
class TestFood{
    public static void main(String[] args) {
        Food food= Food.Appetizer.SALAD;
        food=Food.MainCourse.BURRITO;
        food=Food.Dessert.BLACK_FOREST_CAKE;
        food=Food.Coffee.CAPPUCCINO;
    }
}
