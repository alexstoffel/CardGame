import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck;
    private String[] cards = {"Ace","2","3","4","5","6","7","8","9","10", "jack","queen","king"};
    private String[] suits = {"Hearts","Spades","Diamonds","Clubs"};

    // Constructor
    public Deck(){
        deck = new ArrayList<Card>();
        // Add all of the cards to the deck
        int value;

        for (String type: suits){
            for (int i = 0; i < cards.length; i++){
                // Setting the value of the card
                if (cards[i].equals("jack") || cards[i].equals("queen") || cards[i].equals("king")){
                    value = 10;
                }else{
                    value = i + 1;
                }
                // Add card to the deck
                deck.add(new Card(cards[i], type, value));
            }
        }
    }

    // Deal Card
    public Card dealCard(){
        return deck.remove(0);
    }
}
