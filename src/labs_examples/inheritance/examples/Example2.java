package labs_examples.inheritance.examples;

// A subclass of TwoDShape for rectangles.
class Rectangle extends TwoDShape {
    boolean isSquare() {
        return width == height;
    }

    double area() {
        return width * height;
    }
}