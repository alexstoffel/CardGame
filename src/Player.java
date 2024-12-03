import java.util.ArrayList;

public class Player {
    private int points;
    private final String name;
    private final ArrayList<Card> hand;
    private int money;

    // Constructors
    public Player(String name){
        this.name = name;
        this.points = 0;
        this.hand = new ArrayList<Card>();
        this.money = 500;
    }

    public Player(String name, ArrayList<Card> hand){
        this.name = name;
        this.points = 0;
        this.hand = hand;
        this.money = 500;
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

        // go through each card
        for(Card card: this.hand){
            points += card.getValue();
        }

        // if there is an ace, can change its value to 1
        for (int i = 0; i < this.hand.size(); i++){
            if (this.hand.get(i).getRank().equals("Ace") && points > 21){
                // change ace value to 1
                points -= 10;
                break;
            }
        }

    }

    // update money
    public void updateMoney(int num){
        money += num;
    }

    // get the money of the player
    public int getMoney(){
        return this.money;
    }

    // to String
    public String toString(){
        // if computer, only reveal one of the cards. If player, reveal whole hand
        if (name.equals("computer")){
            return "computer is showing " + hand.get(1);
        }else {
            return name + "'s cards: " + hand;
        }
    }
}
