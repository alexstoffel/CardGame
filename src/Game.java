import java.util.ArrayList;
import java.util.Scanner;
public class Game {
    private Deck deck;
    private ArrayList<Player> players;
    private Player player;
    private Player computer;
    private String[] cards = {"Ace","2","3","4","5","6","7","8","9","10", "jack","queen","king"};
    private String[] suits = {"Hearts","Spades","Diamonds","Clubs"};
    private int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10,};

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

        // add player to the artist of players:
        players.add(computer);
        players.add(player);
    }

    // print instructions method
    public static void printInstructions(){
        System.out.println("");
    }
    // Can add a player to the game
    public void playGame(){
        deck.shuffle();
        Scanner input = new Scanner(System.in);


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
        System.out.println("hit or stay?");

        // while player still wants to hit
        while (input.nextLine().equals("hit") && player.getPoints() < 22){
            // deal the player a card
            player.addCard(deck.deal());
            player.updateScore();

            // print out player and computer hands;
            System.out.println(player);
            System.out.println(computer);
            System.out.println("hit or stay?");
        }

        // check to see if player busted:
        if (player.getPoints() > 21){
            System.out.println("You Busted! Computer wins :(");
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
            System.out.println("Computer busted! You win!");
            return;
        }else if(computer.getPoints() < player.getPoints()){
            System.out.println("You win!");
            return;
        }else if(computer.getPoints() > player.getPoints()){
            System.out.println("computer wins!");
            return;
        }else{
            System.out.println("Tie!");
            return;
        }



    }
    public static void main(String[] args) {
        Game main = new Game();
        // Add both of the players to the game

        // Play Game
        main.playGame();


    }
}
