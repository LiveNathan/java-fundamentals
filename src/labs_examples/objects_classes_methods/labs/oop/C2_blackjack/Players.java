package labs_examples.objects_classes_methods.labs.oop.C2_blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Players {
    // Instance variables
    private String playerName;
    private ArrayList<Cards2> playersCards = new ArrayList<>();
    private int playersCardsValue = 0;
    private int playersChips;
    private int playersCurrentBet;

    // Constructors
    public Players() {
        System.out.print("What's your name my friend? ");
        Scanner scanner = new Scanner(System.in);
        this.playerName = scanner.next();
        System.out.printf("How many chips are you starting with %s? ", this.playerName);
        this.playersChips = scanner.nextInt();
    }

    public Players(String playerName) {
        this.playerName = playerName;
        this.playersChips = 0;
    }

    // Getters & Setters

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public ArrayList<Cards2> getPlayersCards() {
        return playersCards;
    }

    public void setPlayersCards(ArrayList<Cards2> playersCards) {
        this.playersCards = playersCards;
    }

    public int getPlayersCurrentBet() {
        return playersCurrentBet;
    }

    public void setPlayersCurrentBet(int playersCurrentBet) {
        this.playersCurrentBet = playersCurrentBet;
    }

    public int getPlayersCardsValue() {
        return playersCardsValue;
    }

    public void setPlayersCardsValue(int playersCardsValue) {
        this.playersCardsValue = playersCardsValue;
    }

    // Other methods
    public void bet() {
        System.out.printf("How much would you like to bet %s? ", this.playerName);
        Scanner scanner = new Scanner(System.in);
        int requestedBet = scanner.nextInt();
        if (requestedBet <= this.playersChips & requestedBet > 0) {
            setPlayersCurrentBet(requestedBet);
        } else {
            do {
                System.out.print("That's not right. Please bet again. ");
                requestedBet = scanner.nextInt();
            } while (requestedBet > this.playersChips);
            setPlayersCurrentBet(requestedBet);
        }
    }

    public void hitStandSplitDoubleDown(Deck2 deck2) {
        boolean userActionInvalid;
        do {
            userActionInvalid = false;
            System.out.printf("%n%s, do you want to (h)it, (s)tand, or (d)ouble down? ", this.playerName);
            Scanner scanner = new Scanner(System.in);
            char userAction = scanner.next().charAt(0);
            switch (userAction) {
                case 'h':
                    deck2.dealOneCard(this);
                    break;
                case 's':
                    System.out.printf("%n%s stands with %d.", this.playerName, this.getPlayersCardsValue());
                    break;
                case 'd':
                    System.out.println("double down");
                    break;
                default:
                    userActionInvalid = true;
            }
        } while (userActionInvalid);
    }

    @Override
    public String toString() {
        return "Players{" +
                "playerName='" + playerName + '\'' +
                ", playersChips=" + playersChips +
                '}';
    }
}
