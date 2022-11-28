package labs_examples.objects_classes_methods.labs.oop.C2_blackjack;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Players {
    // Instance variables
    private String playerName;
    private ArrayList<Cards2> playersCards = new ArrayList<>();
    private int playersCardsValue = 0;
    private int playersChips;
    private int playersCurrentBet;
    private boolean enableSplitPlayer = false;
    private int gamesWon = 0;

    // Constructors
    public Players() {
        System.out.print("What's your name my friend? ");
        Scanner scanner = new Scanner(System.in);
        this.playerName = scanner.nextLine();
        System.out.printf("How many chips are you starting with %s? ", this.playerName);
        this.playersChips = scanner.nextInt();
    }

    public Players(String playerName) {
        this.playerName = playerName;
        this.playersChips = 0;
    }

    public Players(String playerName, ArrayList<Cards2> playersCards, int playersChips, int playersCurrentBet) {
        this.playerName = playerName;
        this.playersCards = playersCards;
        this.playersChips = (int) playersChips;
        this.playersCurrentBet = playersCurrentBet;
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

    public int getPlayersChips() {
        return playersChips;
    }

    public void setPlayersChips(int playersChips) {
        this.playersChips = playersChips;
    }

    public boolean isEnableSplitPlayer() {
        return enableSplitPlayer;
    }

    public void setEnableSplitPlayer(boolean enableSplitPlayer) {
        this.enableSplitPlayer = enableSplitPlayer;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
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
//        ArrayList<Cards2> playersCards1 = this.getPlayersCards();
        do {
//            userActionInvalid = false;
            if (!enableSplitPlayer && playersCards.get(0).getCardValue() == playersCards.get(1).getCardValue() & playersCards.size() < 3) {
                if (playersCardsValue < 12 & (playersChips - playersCurrentBet * 2) > -1) {
                    System.out.printf("%n%s, do you want to (h)it, (s)tand, (d)ouble down, or s(p)it? ", this.playerName);
                } else {
                    System.out.printf("%n%s, do you want to (h)it, (s)tand, or s(p)it? ", this.playerName);
                }
            } else if (this.getPlayersCardsValue() == 21) {
                System.out.println("\nBlackjack!");
                return;
            } else if (this.getPlayersCardsValue() > 21) {
                System.out.println("\nBust!");
                return;
            } else if (this.playersCardsValue < 12 & (playersChips - playersCurrentBet * 2) > -1) {
                System.out.printf("%n%s, do you want to (h)it, (s)tand, or (d)ouble down? ", playerName);
            } else {
                System.out.printf("%n%s, do you want to (h)it or (s)tand? ", playerName);
            }
            Scanner scanner = new Scanner(System.in);
            char userAction = scanner.next().charAt(0);
            switch (userAction) {
                case 'h':
                    deck2.dealOneCard(this);
                    break;
                case 's':
                    System.out.printf("%s stands with %d.", playerName, this.getPlayersCardsValue());
                    return;
                case 'd':
                    playersCurrentBet = playersCurrentBet * 2;
                    System.out.printf("%s doubles his bet to %d.%n", playerName, playersCurrentBet);
                    deck2.dealOneCard(this);
                    return;
                case 'p':
                    ArrayList<Cards2> splitHand = new ArrayList<>();  // Temp array list
                    splitHand.add(this.getPlayersCards().get(0));  // Add the split card
                    this.setPlayersCards(splitHand);  // Set hand for player1
                    this.setEnableSplitPlayer(true);
                    // Play continues for player1
                    break;
                default:
//                    userActionInvalid = true;
                    System.out.println("That's not a valid input!");
            }
        } while (true);
    }

    public void dealersTurn(Deck2 deck2) {
        System.out.print("\nDealer has ");
        for (Cards2 card : this.playersCards) {
            System.out.printf("%s, ", card.customToString());
        }
        System.out.printf("(value: %d)", this.playersCardsValue);
        do {
            if (this.playersCardsValue > 21) {
                System.out.println("\nDealer busts!");
                return;
            } else if (this.playersCardsValue < 17) {
                System.out.println("\nDealer hits.");
                deck2.dealOneCard(this);
            } else {
                System.out.println("\nDealer stands.");
                return;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (true);
    }
    public void WinnerWinner() {
        gamesWon++;
    }

    @Override
    public String toString() {
        return "Players{" +
                "playerName='" + playerName + '\'' +
                ", playersChips=" + playersChips +
                '}';
    }

    public void calculateHandValue(Players player) {
        // Check for Aces
        int numberOfAces = 0;
        for (Cards2 playersCard : this.playersCards) {
            if (Objects.equals(playersCard.getCardName(), "Ace")) {
                numberOfAces++;
            }
        }

        // Calculate hand value
        // If there are any Aces, need to change value.
        int handValue = 0;
        for (Cards2 playersCard : playersCards) {
            handValue += playersCard.getCardValue();  // Recalculate the score each time for accuracy.
        }
        if (player.getPlayersCardsValue() > 21 & numberOfAces > 0) {
            handValue -= (numberOfAces * 10);  // Subtract 10 to turn Ace value into 1.
        }
        player.setPlayersCardsValue(handValue);
    }
}
