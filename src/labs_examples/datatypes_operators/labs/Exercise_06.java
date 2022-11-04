package labs_examples.datatypes_operators.labs;

/**
 * Fundamentals Exercise 4: Volume and Surface Area
 * <p>
 * Write the necessary code to calculate the volume and surface area of a cylinder
 * with a radius of 3.14 and a height of 5. Print out the result.
 */

public class Exercise_06 {

    public static void main(String[] args) {

        double radius = Math.PI;
        int height = 5;
        double cylinderVolume = Math.PI * radius * 2 * height;
        double cylinderSurfaceArea = (2 * Math.PI * radius * height) + (2 * Math.PI * Math.pow(radius, 2));

        System.out.printf("A cylinder with a radius of %f and height of %d has a volume of %f and a surface area of %f.", radius, height, cylinderVolume, cylinderSurfaceArea);

    }
}