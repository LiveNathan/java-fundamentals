package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.Scanner;

public class Player {
    // Player info
    private String name;
    private Hand hand;
    private int playerMoney; //(the amount of money they have)
    private int bet;


    public Player() {
        initializeNewUser();
    }
    public Player(String name, int potValue) {
        this.name = name;
        this.playerMoney = potValue;
    }

    public Player(String name, Hand hand, int potValue) {
        this.name = name;
        this.hand = hand;
        this.playerMoney = potValue;
    }

    private void initializeNewUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi, what's your name?");
        this.name = scanner.next();
        System.out.printf("Thanks %s. How much $$ to start?", this.name);
        this.playerMoney = scanner.nextInt();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public int getPlayerMoney() {
        return playerMoney;
    }

    public void setPlayerMoney(int playerMoney) {
        this.playerMoney = playerMoney;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }
}
