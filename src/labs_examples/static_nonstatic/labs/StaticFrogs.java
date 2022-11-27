package labs_examples.static_nonstatic.labs;

public class StaticFrogs {
    public static void main(String[] args) {
        // create at least 3 distinct frogs below
        Frog frogTrueToad = new Frog("True toad", "everywhere except Australia and Antarctica");
        Frog frogBullfrog = new Frog("American bullfrog", "large permanent water bodies such as swamps, ponds, and lakes");
        Frog frogHorned = new Frog("South American horned frogs", "a very moist environment such as the rainforest");

        // once all are created, call the toString() on each
        System.out.println(frogTrueToad.toString());
        System.out.println(frogBullfrog.toString());
        System.out.println(frogHorned.toString());

        // what printed for numFrogs? why?
        /*
        Frog{name='True toad', habitat='everywhere except Australia and Antarctica', numFrogs= 3'}
        Frog{name='American bullfrog', habitat='large permanent water bodies such as swamps, ponds, and lakes', numFrogs= 3'}
        Frog{name='South American horned frogs', habitat='a very moist environment such as the rainforest', numFrogs= 3'}
        numFrogs is static.
         */

    }
}

class Frog {
    String name;
    String habitat;
    static int numFrogs;

    public Frog(String name, String habitat) {
        this.name = name;
        this.habitat = habitat;
        numFrogs++;
    }

    @Override
    public String toString() {
        return "Frog{" +
                "name='" + name + '\'' +
                ", habitat='" + habitat + '\'' +
                ", numFrogs= " + numFrogs + '\'' +
                '}';
    }
}

