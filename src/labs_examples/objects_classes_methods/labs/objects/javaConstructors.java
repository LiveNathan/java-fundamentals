package labs_examples.objects_classes_methods.labs.objects;

public class javaConstructors {
    public static void main(String[] args) {
        Person nathan = new Person("nathan", 42);
        Person elis = new Person("elis", 41);
    }

    static class Person {
        String name;
        int age;

        Person(String nameInput, int ageInput) {
            this.name = nameInput;
            this.age = ageInput;
        }
    }
}
