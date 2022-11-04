package labs_examples.datatypes_operators.labs;

import java.lang.Math;
import java.util.Scanner;


class Main {
    public static void main(String[] args) {

        // please demonstrate the use of all 5 arithmetic operators below (+, -, *, /, %)
        Scanner triangleSides = new Scanner(System.in);
        //float a, b, c;
        System.out.print("right triangle side a: ");
        float a = triangleSides.nextFloat();
        System.out.print("right triangle side b: ");
        float b = triangleSides.nextFloat();
        System.out.print("right triangle side c: ");
        float c = triangleSides.nextFloat();
        if (c == 0.0f)
            c = (float) Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        else if (a == 0.0f)
            a = (float) Math.sqrt(Math.pow(c, 2) - Math.pow(b, 2));
        else if (b == 0.0f)
            b = (float) Math.sqrt(Math.pow(c, 2) - Math.pow(a, 2));

        System.out.printf("%nSides a, b, and c are " + a + ", " + b + ", " + c + ".");


        // please dmonstrate the use of off 5 relational operators below - we'll cover "if-statements" shortly so I'll give you a hint here
        //int a = 10;
        //int b = 11;
        if (a == b | a == c | b == c)
            System.out.printf("%nAn isosceles triangle is a triangle with two congruent sides and one unique side and angle.");

        if (a == b & b == c)
            System.out.printf("%nAn equilateral triangle is a triangle with three congruent sides and three congruent angles.");

        if (a !=b & b != c & c != a)
            System.out.printf("%nA scalene triangle is a triangle with no congruent sides and no congruent angles.");

        float oppositeSide = Math.min(Math.min(a, b), c);
        System.out.printf("%nThe opposite side is " + oppositeSide);

        float hypotenuse = Math.max(Math.max(a, b), c);
        System.out.printf("%nThe hypotenuse is " + hypotenuse);

        if (a != oppositeSide & a != hypotenuse)
            System.out.printf("%nSide a is adjacent.");
        else if (b != oppositeSide & b != hypotenuse)
            System.out.printf("%nSide b is adjacent.");
        else
            System.out.printf("%nSide c is adjacent.");

        // please demonstrate the use of all 4 logical operators below (AND, short-circuit AND, OR, short-circuit OR, XOR (exclusive or), and NOT )
        if (a < 20 & b < 20) {
            System.out.printf("%nboth a & b are less than 20");
        }
        // now your turn :)
        System.out.print("17%3=" + 17%3);

    }
}
