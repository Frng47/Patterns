package eckel.generics;

import java.util.ArrayList;
import java.util.Random;

public class Ex19 {
}
class Product{
    private final int id;
    private String description;
    private double price;

    public Product(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
    public void priceChange(double change){
        price+=change;
    }
    public static Generator<Product> generator=
            new Generator<Product>() {
        Random rand=new Random(45);
                public Product next() {
                    return new Product(rand.nextInt(1000),
                            "Test",
                            Math.round(rand.nextDouble()*1000.0)+0.99);
                }
            };
}
class Shelf extends ArrayList<Product>{
    public Shelf(int nProducts){
        Generators.fill(this,Product.generator,nProducts);
    }
}
class Container extends ArrayList<Shelf>{
    public Container(int nShelves,int nProducts){
        for (int i = 0; i <nShelves ; i++) {
            add(new Shelf(nProducts));
        }
    }
}
class Office{}
class CheckOutStand{}
class Store extends ArrayList<Container>{
    private ArrayList<CheckOutStand> checkouts=
            new ArrayList<>();
    private Office office=new Office();
    public Store(int nContainers,int nShelves,int nProducts){
        for (int i = 0; i <nContainers ; i++) {
            add(new Container(nShelves,nProducts));
        }
    }

    @Override
    public String toString() {
        StringBuilder result=new StringBuilder();
        for(Container c:this){
            for(Shelf s:c)
                for (Product p:s){
                    result.append(p);
                    result.append("\n");
                }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Store(14,5,10));
    }
}