package labs_examples.enumerations.labs;

/* Enumerations Exercise 1:
 *      1) Create an enumeration. Use a controller class to demonstrate the use of the enum from a seperate class.
 *      2) Create a parameterized enumeration that passes one or more values to its constructor. Demonstrate the use
 *      of this enum from a seperate class.
 */

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Exercise_01 {
    public static void main(String[] args) {
        ShoppingBasket shoppingBasket1 = new ShoppingBasket();
        shoppingBasket1.getFruits().add(Fruits.BANANA);
        shoppingBasket1.getFruits().add(Fruits.ORANGE);
        System.out.println("Contents: " + shoppingBasket1.toString());
        System.out.println("Total $" + shoppingBasket1.BasketTotal());
    }
}

enum Fruits {
    APPLE(1.5), ORANGE(1.7), BANANA(1.3);
    private final double fruitPrice;

    Fruits(double fruitPrice) {
        this.fruitPrice = fruitPrice;
    }

    public double getFruitPrice() {
        return fruitPrice;
    }
}

class ShoppingBasket {
    private ArrayList<Fruits> fruits = new ArrayList<>();

    // Constructors
    public ShoppingBasket() {
    }

    public ShoppingBasket(ArrayList<Fruits> fruits) {
        this.fruits = fruits;
    }

    // Getters & Setters
    public ArrayList<Fruits> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<Fruits> fruits) {
        this.fruits = fruits;
    }

    // Other methods
    public double BasketTotal() {
        double sum = 0;
        for (Fruits fruit : fruits) {
            sum += fruit.getFruitPrice();
        }
        return sum;
    }

    // toString

    @Override
    public String toString() {
        return "ShoppingBasket{" +
                "fruits=" + fruits +
                '}';
    }
}