package labs_examples.objects_classes_methods.labs.objects;

public class fourthMan {
    public static void main(String[] args) {
        Cast jeroen = new Cast("Jeroen Krabbé", "Gerard Revé");
        Cast renee = new Cast("Renée Soutendijk", "Christine Halsslag");
        Cast thom = new Cast("Thom Hoffman");
        Cast nathan = new Cast();
        System.out.printf("The movie The Fourth Man includes %s played by %s.", jeroen.name, jeroen.character);
    }
}

class Cast {
    String name;
    String character;

    public Cast() {
    }

    public Cast(String name) {
        this.name = name;
    }

    public Cast(String name, String character) {
        this.name = name;
        this.character = character;
    }
}
