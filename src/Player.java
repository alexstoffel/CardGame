import java.util.ArrayList;

public class Player {
    private int points;
    private String name;
    private ArrayList<Card> hand;

    // Constructors
    public Player(String name){
        this.name = name;
        this.points = 0;
        this.hand = new ArrayList<Card>();
    }

    public Player(String name, ArrayList<Card> hand){
        this.name = name;
        this.points = 0;
        this.hand = hand;
    }

    // Get points
    public int getPoints() {
        return points;
    }

    // Get Name
    public String getName(){
        return name;
    }

    //Get Hand
    public ArrayList<Card> getHand(){
        return hand;
    }

    // add points
    public void addPoints(int num) {
        points += num;
    }

    // add Card
    public void addCard(Card card){
        hand.add(card);
    }

    // update score
    public void updateScore(){
        points = 0;
        for(Card card: this.hand){
            points += card.getValue();
        }
    }

    // to String
    public String toString(){
        // if computer, only reveal one of the cards. If player, reveal whole hand
        if (name.equals("computer")){
            return "computer is showing " + hand.get(1).getValue() + " points\n" + name + "is showing a " + hand.get(1);
        }else {
            return name + " has " + points + " points\n" + name + "'s cards: " + hand;
        }
    }
}
