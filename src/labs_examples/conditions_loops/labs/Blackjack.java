package labs_examples.conditions_loops.labs;

/**
 * Complete the hitOrStand method
 * <p>
 * if cardValue is equal or less than 16 - print "Hit"
 * else, it cardValue is equal or more than 17 - print "Stand"
 */

public class Blackjack {


    public void hitOrStand(int cardValue) {

        if (cardValue <= 16) {
            System.out.println("Hit me.");
        } else if (cardValue >= 17) {
            System.out.println("Stand.");
        }


    }


}
