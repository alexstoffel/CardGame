import java.util.ArrayList;
import java.util.Scanner;
public class Game {
    private final Deck deck;
    private final ArrayList<Player> players;
    private final Player player;
    private final Player computer;
    private final String[] cards = {"Ace","2","3","4","5","6","7","8","9","10", "jack","queen","king"};
    private final String[] suits = {"Hearts","Spades","Diamonds","Clubs"};
    private final int[] values = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10,};
    private int pot;

    // Constructor for game
    public Game(){
        // initialize a new scanner
        Scanner input = new Scanner(System.in);

        // initialize all the new player and instance variables
        players = new ArrayList<Player>();
        deck = new Deck(cards, suits, values);
        computer = new Player("computer");

        // get user name
        System.out.print("What is your Name?: ");
        player = new Player(input.nextLine());

        // add player to the arr list of players:
        players.add(computer);
        players.add(player);

        // set the pot to zero
        this.pot  = 0;
    }

    // print instructions method
    public static void printInstructions(){
        System.out.println("This is BlackJack! YBlackjack is a card game where players aim to get a hand that is closer" +
                " to 21 than the computer’s hand, without going over 21. Each card is worth its face value, with face" +
                "cards (Jack, Queen, King) worth 10 and Aces worth either 1 or 11. ");
    }

    // this method control all the bets
    public void doBets(){
        // initialize a scanner
        Scanner input = new Scanner(System.in);

        // do the betting
        int bet = 10000;
        System.out.println("how much would you like to bet? (Current Total: " + player.getMoney() + ")");

        // get a valid bet
        while (bet > player.getMoney() || bet < 0){
            bet = input.nextInt();
            input.nextLine();

            if (bet > player.getMoney() || bet < 0){
                System.out.println("Enter a valid bet");
            }
        }

        // change the pot and everything
        this.pot += bet * 2;
        player.updateMoney(bet * (-1));
    }

    // Can add a player to the game
    public void playGame(){
        deck.shuffle();
        Scanner input = new Scanner(System.in);

        // print instructions
        this.printInstructions();


        // first hands are dealt
        player.addCard(deck.deal());
        player.addCard(deck.deal());
        computer.addCard(deck.deal());
        computer.addCard(deck.deal());

        // edit points of the players
        computer.updateScore();
        player.updateScore();

        // print out player & computer hands
        System.out.println(player);
        System.out.println(computer);

        // do a round of betting and ask if they want to hit or stay
        this.doBets();
        System.out.println("hit or stay?");

        // while player still wants to hit & making bets
        while (input.nextLine().equals("hit") && player.getPoints() < 22 && player.getMoney() >= 0){
            // deal the player a card
            player.addCard(deck.deal());
            player.updateScore();

            // if player busted
            if (player.getPoints() > 21){
                break;
            }

            // print out player and computer hands;
            System.out.println(player);
            System.out.println(computer);
            this.doBets();
            System.out.println("hit or stay?");
        }

        // check to see if player busted:
        if (player.getPoints() > 21){
            System.out.println("You Busted! Computer wins. Final money: " + player.getMoney());

            // reset the pot
            this.pot = 0;
            return;
        }

        // deal out the rest of the dealer's hands
        while (computer.getPoints() < 17){
            // deal dealer a card
            computer.addCard(deck.deal());
            computer.updateScore();

            // print out the scores
            System.out.println(player);
            System.out.println("computer has " + computer.getPoints() + " points");
        }

        // check who won
        if (computer.getPoints() > 21){
            player.updateMoney(pot);
            System.out.println("Computer busted! You win! Final money: " + player.getMoney());
            pot = 0;
        }else if(computer.getPoints() < player.getPoints()){
            player.updateMoney(pot);
            System.out.println("You win! Final money: " + player.getMoney());
            pot = 0;
        }else if(computer.getPoints() > player.getPoints()){
            pot = 0;
            System.out.println("computer wins! Final money: " + player.getMoney());
        }else{
            player.updateMoney(pot / 2);
            System.out.println("Tie! Final money: " + player.getMoney());
        }
    }
    public static void main(String[] args) {
        Game main = new Game();
        // Add both of the players to the game

        // Play Game
        main.playGame();
    }
}
