package labs_examples.generics.labs;

public class playgroundGenericClass {
    public static void main(String[] args) {

        // Step 1) Create an object of the Generic class below and call the print() method on it
        MyGeneric<String, String> myGenericString = new MyGeneric<>("MyGeneric String", "and another value");
        myGenericString.print();

        // Step 2) Create another object of the Generic class below using a different data type and call the print() method on it
        MyGeneric<Integer, String> myGenericInteger = new MyGeneric<>(42, "is the answer");
        myGenericInteger.print();

        // Step 3) modify the class below to require two generic types - then modify your objects above, so it still works
    }
}

class MyGeneric<T, U> {
    T val;
    U val2;
    public MyGeneric(T val, U val2) {
        this.val = val;
        this.val2 = val2;
    }
    public void print() {
        System.out.println(val);
        System.out.println(val2);
    }
}
