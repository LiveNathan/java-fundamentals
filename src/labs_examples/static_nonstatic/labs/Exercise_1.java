package labs_examples.static_nonstatic.labs;

public class Exercise_1 {
    public static void main(String[] args) {
        A.StaticCallingStatic();
    }
}

class A {
    public static void StaticCallingStatic() {
        System.out.println("This static method calls another static method in the same class.");
        StaticCallingNonStatic();
        System.out.println("But let's also demonstrate calling a static method in another class.");
        B.StaticMethod();
    }

    public static void StaticCallingNonStatic() {
        System.out.println("This static method calls a non-static method in the same class.");
        A a = new A();
        a.NonStaticCallingNonStatic();
        System.out.println("Now let's demonstrate calling a non-static method in another class.");
        B b = new B();
        b.NonStaticMethod();
    }

    public void NonStaticCallingNonStatic() {
        System.out.println("This non-static method calls a non-static method in the same class.");
        NonStaticCallingStatic();
        System.out.println("Now let's demonstrate calling a non-static method in another class.");
        B c = new B();
        c.NonStaticMethod();
    }

    public void NonStaticCallingStatic() {
        System.out.println("This non-static method calls a static method in the same class.");
        StaticCallingStatic();
        System.out.println("Now let's demonstrate calling a static method in another class.");
        B.StaticMethod();
    }
}
class B {
    public static void StaticMethod() {
        System.out.println("I am a static method in class B.");
    }
    public void NonStaticMethod() {
        System.out.println("I am a non-static method.");
    }
}