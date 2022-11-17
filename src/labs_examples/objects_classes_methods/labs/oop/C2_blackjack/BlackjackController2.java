package labs_examples.objects_classes_methods.labs.oop.C2_blackjack;

public class BlackjackController2 {
    public static void main(String[] args) {
        /* SET UP GAME */
        // Create the deck
        Deck2 deck2 = new Deck2();
        //deck2.customPrintDeck();  // Verify deck

        // Create the players
        Players dealer = new Players("Dealer");
        Players player1 = new Players();
        // System.out.println(player1.toString());  // Verify Player

        /* PLAY GAME */
        // Shuffle deck
        deck2.shuffleDeck();
        //deck2.customPrintDeck();  // Verify deck

        // Player bets
        player1.bet();
        // System.out.printf("%s bet %d.", player1.getPlayerName(), player1.getPlayersCurrentBet());  // Verify the bet

        // Deal
        deck2.dealFirstTwoCards(player1, dealer);

        // Check score
        if (player1.getPlayersCardsValue() == 21 & dealer.getPlayersCardsValue() != 21){
            System.out.printf("%nYou won %s!", player1.getPlayerName());
            // handlePayout
        } else {
            // Player hit, stand, split, double down
            player1.hitStandSplitDoubleDown(deck2);
        }


        // Dealer play
        // Select winner
        // Award chips
    }
}
