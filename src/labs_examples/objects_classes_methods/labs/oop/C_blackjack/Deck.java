package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;

public class Deck {
    //(POJO - this will hold deck data)
    private Card[] deck = new Card[52];
    private ArrayList<Integer> usedCards = new ArrayList<>();
    private static int freshDecksLoaded;

    public Deck() {
        loadFreshDeck();
        freshDecksLoaded++;
    }

    private void loadFreshDeck() {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                deck[count] = new Card(i, j);
                count++;
            }
        }
    }

    public Card[] getDeck() {
        return deck;
    }

    public void setDeck(Card[] deck) {
        this.deck = deck;
    }

    public ArrayList<Integer> getUsedCards() {
        return usedCards;
    }

    public void setUsedCards(ArrayList<Integer> usedCards) {
        this.usedCards = usedCards;
    }

    public static int getFreshDecksLoaded() {
        return freshDecksLoaded;
    }

    public static void setFreshDecksLoaded(int freshDecksLoaded) {
        Deck.freshDecksLoaded = freshDecksLoaded;
    }

    public boolean isCardUsed(int n) {
        if (usedCards.contains(n)){
            return true;
        } else {
            return false;
        }
    }

    public Card getCardAt(int randomCard) {
        return deck[randomCard];
    }
}
