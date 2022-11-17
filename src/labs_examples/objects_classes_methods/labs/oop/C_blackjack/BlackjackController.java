package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BlackjackController {
    public static void main(String[] args) {
//The player whose hand value is closest to 21 without going over at the end of the game will win.
// It will not ask for bets. The user and the computer will each start with a small pot and bets will be taken automatically.
        int pot = 100;
        Deck deck;
        Player computer = new Player("Computer", pot);
        Player user = new Player();
        do {
            deck = new Deck();
            System.out.printf("%n Game # %d.", Deck.getFreshDecksLoaded());
            System.out.println("Let's play some BlackJack!");
            deal(computer, deck);
            deal(user, deck);
            deal(computer, deck);
            deal(user, deck);
            handleBets(user);
        } while (true);
    }

    private static void deal(Player player, Deck deck) {
        int randomCard = getRandomCard(deck);
        Card card = deck.getCardAt(randomCard);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(card);
        Hand hand = new Hand(cards);
        player.setHand(hand);
        System.out.printf("Your card is %s.", player.getHand().toString());
    }

    private static int getRandomCard(Deck deck) {
        Random random = new Random();
        int n = random.nextInt(51);
        while (deck.isCardUsed(n)){
            n = random.nextInt(51);
        }
        deck.getUsedCards().add(n);
        return n;
    }

    public static void handleBets(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nHow much do you want to be?");
        System.out.printf("You are currently holding $%d.", player.getPlayerMoney());
        int bet = scanner.nextInt();
        if (bet <= player.getPlayerMoney()) {
            player.setBet(bet);
        } else {
            do {
                System.out.printf("%nYou can't bet more than you have and you only have %d.", player.getPlayerMoney());
                System.out.printf("%nHow much would you like to bet?");
                bet = scanner.nextInt();
            } while (bet> player.getPlayerMoney());
            player.setBet(bet);
        }

    }

}
