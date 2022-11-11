package labs_examples.objects_classes_methods.labs.objects;

public class javaObjects {
    public static void main(String[] args) {
        Person nathan = new Person();
        Person elis = new Person();

        nathan.age = 42;
        nathan.name = "Nathan";
        elis.age = 41;
        elis.name = "Elis";

        System.out.printf("The first person is named %s and their age is %d.", nathan.name, nathan.age);
        System.out.printf("%nThe second person is named %s and their age is %d.", elis.name, elis.age);
    }

    static class Person {
        public String name;
        public int age;
    }
}
