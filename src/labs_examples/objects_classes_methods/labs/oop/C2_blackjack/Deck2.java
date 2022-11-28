package labs_examples.objects_classes_methods.labs.oop.C2_blackjack;

import java.util.*;

public class Deck2 {
    // Instance variables
    private Cards2[] deckOfCards = new Cards2[52];  // every time Deck2 is called, it builds a new array of Cards.
    private int nextCardIndex = -1;
    private static int numberOfGamesPlayed = 0;

    // Constructors
    public Deck2() {
        int count = 0;  // Index of card
        for (int i = 0; i < 4; i++) {  // Card suit
            for (int j = 0; j < 13; j++) {  // Card number
                this.deckOfCards[count] = new Cards2(i, j, count);
                count++;
            }
        }
    }

    // Getters & setters
    public Cards2[] getDeckOfCards() {
        return deckOfCards;
    }

    public void setDeckOfCards(Cards2[] deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    public static int getNumberOfGamesPlayed() {
        return numberOfGamesPlayed;
    }

    public static void setNumberOfGamesPlayed(int numberOfGamesPlayed) {
        Deck2.numberOfGamesPlayed = numberOfGamesPlayed;
    }

    // Other methods
    // custom print function to verify the deck creation
    public void customPrintDeck() {
        System.out.println("Here's the new deck.");
        for (Cards2 deckOfCard : deckOfCards) {
            System.out.println(deckOfCard.toString());
        }
    }

    public void shuffleDeck() {
        List<Cards2> cards2List = Arrays.asList(deckOfCards);
        Collections.shuffle(cards2List);
        cards2List.toArray(deckOfCards);
        numberOfGamesPlayed++;
    }

    public int getNextCardIndex() {
        nextCardIndex++;
        return nextCardIndex;
    }

    public void dealFirstTwoCards(Players player1, Players dealer) {

        // Add new cards to the Player's hands
        player1.getPlayersCards().clear();
        Collections.addAll(player1.getPlayersCards(), deckOfCards[getNextCardIndex()], deckOfCards[getNextCardIndex()]);
        dealer.getPlayersCards().clear();
        Collections.addAll(dealer.getPlayersCards(), deckOfCards[getNextCardIndex()], deckOfCards[getNextCardIndex()]);

        // Update hand value
//        player1.setPlayersCardsValue(player1.getPlayersCards().get(0).getCardValue() + player1.getPlayersCards().get(1).getCardValue());
        player1.calculateHandValue(player1);
//        dealer.setPlayersCardsValue(dealer.getPlayersCards().get(0).getCardValue() + dealer.getPlayersCards().get(1).getCardValue());
        dealer.calculateHandValue(dealer);

        // Print results
        System.out.printf("%s has: %s, %s. (value: %d)", player1.getPlayerName(), player1.getPlayersCards().get(0).customToString(), player1.getPlayersCards().get(1).customToString(), player1.getPlayersCardsValue());
        System.out.printf("%nDealer has: %s, <face down>", dealer.getPlayersCards().get(0).customToString());
    }

    public void dealOneCard(Players player) {
        // Get the next card
        Cards2 nextCard = deckOfCards[getNextCardIndex()];

        // Add card to player's hand
        player.getPlayersCards().add(nextCard);

        // Update hand value
        player.setPlayersCardsValue(player.getPlayersCardsValue() + nextCard.getCardValue());
        player.calculateHandValue(player);

        // Print results
        System.out.printf("%s now has: ", player.getPlayerName());
        for (Cards2 card : player.getPlayersCards()) {
            System.out.printf("%s, ", card.customToString());
        }
        System.out.printf("(value: %d)", player.getPlayersCardsValue());
    }
}
