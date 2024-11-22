import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck;
    private int cardsLeft;

    // Constructor
    public Deck(String[] cards, String[] suits, int[] values){
        deck = new ArrayList<Card>();
        // Add all of the cards to the deck
        cardsLeft = 52;
        int value;

        for (String type: suits){
            for (int i = 0; i < cards.length; i++){
                // Add card to the deck
                deck.add(new Card(cards[i], type, values[i]));
            }
        }
    }

    // Deal Card
    public Card deal(){
        return deck.get(--cardsLeft);
    }

    // Returns cards Left
    public int getCardsLeft(){
        return cardsLeft;
    }

    // Shuffle Deck
    public void shuffle(){
        this.cardsLeft = 52;
        Card card;
        int randomNum;
        // Shuffle the deck
        for (int i  = 51; i > 0; i--){
            randomNum = (int)(Math.random() * i);
            deck.set(i, deck.set(randomNum, deck.get(i)));
        }
    }

    // Is Empty
    public boolean isEmpty(){
        return deck.isEmpty();
    }
}
