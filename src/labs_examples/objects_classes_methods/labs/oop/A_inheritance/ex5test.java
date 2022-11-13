package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

public class ex5test {
    public static void main(String[] args)
    {
        Parent2 c = new Child2();
    }
}
class Parent2
{
    public Parent2()
    {
        System.err.println("Parent called");
    }
}

class Child2 extends Parent2
{
    public Child2()
    {
        System.err.println("Child called");
    }
}
