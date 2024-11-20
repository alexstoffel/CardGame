import java.util.ArrayList;
import java.util.Scanner;
public class Game {
    private Deck deck;
    private ArrayList<Player> players;
    private Player player;
    private Player computer;

    // Constructor for game
    public Game(){
        // initialize a new scanner
        Scanner input = new Scanner(System.in);

        // initialize all the new player and instance variables
        players = new ArrayList<Player>();
        deck = new Deck();
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
        for (int i = 0; i < 5; i++) {
            System.out.println(deck.deal());
        }

    }
    public static void main(String[] args) {
        Game main = new Game();
        // Add both of the players to the game

        // Play Game
        main.playGame();


    }
}
