package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

public class Card {
    //(POJO - this will hold card data)
    private char[] suitArray = new char[]{'♠', '♦', '♥', '♣'};
    private char suit;
    private int cardValue;
    private String cardName;

    public Card(int suitIndex, int cardValue) {
        this.suit = suitArray[suitIndex];
        this.cardValue = cardValue;
        if (this.cardValue == 0) {
            this.cardName = "Ace";
        } else if (this.cardValue == 11) {
            this.cardName = "Jack";
        } else if (this.cardValue == 12) {
            this.cardName = "Queen";
        } else if (this.cardValue == 13) {
            this.cardName = "King";
        } else {
            this.cardName = Integer.toString(this.cardValue);
        }
    }
}
