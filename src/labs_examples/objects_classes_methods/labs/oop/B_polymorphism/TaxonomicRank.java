package labs_examples.objects_classes_methods.labs.oop.B_polymorphism;

public class TaxonomicRank {
    public static void main(String[] args) {

    }
}

class Life implements Creation {
    private String planet;

    public Life() {
    }

    public Life(String planet) {
        this.planet = planet;
    }

    public void createLife() {
        System.out.println("Creating life...");
        // do steps to create life
    }

    public void sleep(){
        System.out.println("Going to sleep...");
        //do steps to sleep
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }
}

class Domain extends Life {
    private String nameLife;

    public Domain(String name) {
        this.nameLife = name;
    }

    @Override
    public void createLife() {
        System.out.println("Overriding createLife from Domain.");
        // do steps to create domain
    }

    public String getNameLife() {
        return nameLife;
    }

    public void setNameLife(String nameLife) {
        this.nameLife = nameLife;
    }
}

class Kingdom extends Domain {
    private String nameKingdom;

    public Kingdom(String name, String name1) {
        super(name);
        this.nameKingdom = name1;
    }

    public String getNameKingdom() {
        return nameKingdom;
    }

    public void setNameKingdom(String nameKingdom) {
        this.nameKingdom = nameKingdom;
    }
}

class Phylum extends Kingdom {
    private String namePhylum;

    public Phylum(String name, String name1, String name2) {
        super(name, name1);
        this.namePhylum = name2;
    }

    public String getNamePhylum() {
        return namePhylum;
    }

    public void setNamePhylum(String namePhylum) {
        this.namePhylum = namePhylum;
    }
}

class polymorphExample{
    Creation myCreation;

    public polymorphExample(Creation myCreation) {
        this.myCreation = myCreation;
    }

    public void testCreation(){
        System.out.println("Testing creation...");
        myCreation.createLife();
        myCreation.sleep();
    }
}