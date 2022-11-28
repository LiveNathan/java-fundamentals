package labs_examples.packages.labs.choco;

import labs_examples.packages.labs.taco.Tuxedo;

public class BrownTabby {
    public void isHeAsleep() {
        System.out.println("Is Choco asleep");
    }

    protected void whereIsTheCatVomit() {
        System.out.println("Where is the cat vomit?");
    }

    public static void main(String[] args) {
        Tuxedo taco = new Tuxedo();
        taco.isSheMad();
//        taco.whereIsTacoHiding();  // Not available from this class.
    }
}
