import java.util.ArrayList;
public class Game {
    private int round;
    private ArrayList<Player> players;

    // Constructor for game
    public Game(){
        players = new ArrayList<Player>();
    }
    // Can add a player to the game
    public void add(Player player){
        players.add(player);
    }

    public void playGame(){
        Deck deck = new Deck();

    }
    public static void main(String[] args) {
        Game main = new Game();
        Player p1 = new Player("Alex");
        Player computer = new Player("Computer");
        // Add both of the players to the game
        main.add(p1);
        main.add(computer);

        // Play Game
        main.playGame();


    }
}
