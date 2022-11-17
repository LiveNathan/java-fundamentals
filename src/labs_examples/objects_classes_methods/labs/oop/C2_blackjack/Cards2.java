package labs_examples.objects_classes_methods.labs.oop.C2_blackjack;

import java.util.Arrays;

public class Cards2 {
    // Instance variables
    private char[] suitSymbolsArray = {'♠', '♦', '♥', '♣'};
    private char suitSymbol;
    private String[] suitNameArray = {"spade", "diamond", "heart", "club"};
    private String suitName;
    private String cardName;
    private int cardValue;
    private int cardIndex;

    // Constructors
    public Cards2(int suitSymbolIndex, int cardNumber, int cardIndex) {
        this.suitSymbol = suitSymbolsArray[suitSymbolIndex];
        this.suitName = suitNameArray[suitSymbolIndex];
        switch (cardNumber){
            case 0:
                this.cardName = "Ace";
                this.cardValue = 11;
                break;
            case 11:
                this.cardName = "Jack";
                this.cardValue = 10;
                break;
            case 12:
                this.cardName = "Queen";
                this.cardValue = 10;
                break;
            case 13:
                this.cardName = "King";
                this.cardValue = 10;
                break;
            default:
                this.cardName = Integer.toString(cardNumber);
                this.cardValue = cardNumber;
        }
        this.cardIndex = cardIndex;
    }

    // Getters & Setters
    public int getCardValue() {
        return cardValue;
    }

    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }

    @Override
    public String toString() {
        return "cardIndex=" + cardIndex +
                ", " + cardName +
                " of " + suitSymbol + " " + suitName +
                ", cardValue=" + cardValue;
    }

    public Object customToString() {
        return cardName + " of " + suitSymbol + " " + suitName;
    }
}
