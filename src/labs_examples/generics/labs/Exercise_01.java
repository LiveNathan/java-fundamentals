package labs_examples.generics.labs;

/* Generics Exercise 1:
 *
 *      1. Write a generic class with at least two instance variables, a constructor, and getter and setter methods.
 *      2. Create a few objects of your generic class with different data types to demonstrate its dynamic usage.
 */

public class Exercise_01 {
    public static void main(String[] args) {
        GenericClassA<String, String> a = new GenericClassA<>("Hello", "there");
        System.out.println(a.getT() + " " + a.getU());
        GenericClassA<String, Integer> b = new GenericClassA<>("Ola", 7);
        System.out.println(b.getT() + " " + b.getU());
        GenericClassA<Integer, Float> c = new GenericClassA<>(42, 42.42f);
        System.out.println(c.getT() + " " + c.getU());
    }
}

class GenericClassA<T, U> {
    // Instance variables
    private T t;
    private U u;

    // Constructors
    public GenericClassA(T t, U u) {
        this.t = t;
        this.u = u;
    }

    // Getters & Setters
    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public U getU() {
        return u;
    }

    public void setU(U u) {
        this.u = u;
    }
}