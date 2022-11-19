package labs_examples.objects_classes_methods.labs.oop.C2_blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackController2 {
    public static void main(String[] args) {
        /* SET UP GAME */
        // Create the deck
        Deck2 deck2 = new Deck2();
        //deck2.customPrintDeck();  // Verify deck

        // Create the players
        Players dealer = new Players("Dealer");
        Players player1 = new Players();
//        Players player1SplitHand = null;
        // System.out.println(player1.toString());  // Verify Player

        /* PLAY GAME */
        char playAgain = 'n';
        do {
            // Shuffle deck
            deck2.shuffleDeck();
            //deck2.customPrintDeck();  // Verify deck

            // Player bets
            player1.bet();
            // System.out.printf("%s bet %d.", player1.getPlayerName(), player1.getPlayersCurrentBet());  // Verify the bet

            // Deal
            deck2.dealFirstTwoCards(player1, dealer);

            // Check score
            if (player1.getPlayersCardsValue() == 21 & dealer.getPlayersCardsValue() != 21) {
                System.out.printf("%nYou won %s!", player1.getPlayerName());
            } else if (dealer.getPlayersCardsValue() == 21) {
                System.out.printf("%nDealer has blackjack. Dealer wins!");
            } else {
                // Player hit, stand, split, double down
                player1.hitStandSplitDoubleDown(deck2);
            }

            // Handle split player
            if (player1.isEnableSplitPlayer()) {
                // Make a new player called Players Split Hand with matched bet amount and card
                String splitPlayerName = player1.getPlayerName() + "'s Split";   // New Name
                ArrayList<Cards2> splitHand = new ArrayList<>();  // Temp array list
                splitHand.add(player1.getPlayersCards().get(0));  // Add the split card
                int splitPlayerChips = (int) (player1.getPlayersChips() - player1.getPlayersCurrentBet()); // Give the split player chips
                Players player1SplitHand = new Players(splitPlayerName, splitHand, splitPlayerChips, player1.getPlayersCurrentBet());  // Create player
                player1SplitHand.setEnableSplitPlayer(true);  // Make sure they won't be offered to split in next line.
                player1SplitHand.hitStandSplitDoubleDown(deck2);
            }

            // Dealer play
            if (player1.getPlayersCardsValue() < 22) {
                dealer.dealersTurn(deck2);
            }

            // Select winner, Award chips
            System.out.printf("The final scores are %d for %s and %d for the Dealer.", player1.getPlayersCardsValue(), player1.getPlayerName(), dealer.getPlayersCardsValue());
            if (player1.getPlayersCardsValue() == dealer.getPlayersCardsValue()) {
                System.out.println("\nPush. No winner.");
            } else if (player1.getPlayersCardsValue() > dealer.getPlayersCardsValue() & player1.getPlayersCardsValue() < 22) {
                System.out.printf("%n%s wins!", player1.getPlayerName());
                if (player1.getPlayersCardsValue() == 21) {
                    player1.setPlayersChips((int) (player1.getPlayersChips() + Math.round(player1.getPlayersCurrentBet() * 1.5)));
                } else {
                    player1.setPlayersChips(player1.getPlayersChips() + player1.getPlayersCurrentBet());
                }
            } else if (dealer.getPlayersCardsValue() > 21 & player1.getPlayersCardsValue() < 22) {
                System.out.printf("%n%s wins!", player1.getPlayerName());
                player1.setPlayersChips(player1.getPlayersChips() + player1.getPlayersCurrentBet());
            } else if (dealer.getPlayersCardsValue() < 22) {
                System.out.printf("%nDealer wins!");
                player1.setPlayersChips(player1.getPlayersChips() - player1.getPlayersCurrentBet());
            } else {
                System.out.println("%nNo winner.");
            }
            System.out.printf("%n%s you have %d worth of chips.", player1.getPlayerName(), player1.getPlayersChips());

            // Play again?
            Scanner scanner = new Scanner(System.in);
            if (player1.getPlayersChips() < 1) {
                System.out.printf("%nLooks like you're out of chips %s. Would you like to buy more?", player1.getPlayerName());
                char buyMore = scanner.next().charAt(0);
                if (buyMore == 'y'){
                    System.out.println("Great. How much?");
                    int chips = scanner.nextInt();
                    player1.setPlayersChips(player1.getPlayersChips() + chips);
                    System.out.printf("Ok, %s. Here's your %d chips giving you a total of %d.", player1.getPlayerName(), chips, player1.getPlayersChips());
                } else {
                    playAgain = 'n';
                }
            }
            if (player1.getPlayersChips() > 0) {
                System.out.printf("%nAnother round %s? (y/n) ", player1.getPlayerName());
                playAgain = scanner.next().charAt(0);
            }
        } while (playAgain == 'y');

    }
}
