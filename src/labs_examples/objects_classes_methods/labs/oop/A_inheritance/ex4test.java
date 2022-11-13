package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

public class ex4test {
    public static void main(String[] args)
    {
        Parent2 c = new Child2();
        c.doSomething();
    }
}

class Parent
{
    public void doSomething()
    {
        System.err.println("Parent called");
    }
}

class Child extends Parent2
{
    public void doSomething()
    {
        System.err.println("Child called");
    }
}
