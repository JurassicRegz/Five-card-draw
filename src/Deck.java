import java.util.ArrayList;

public class Deck {
    private int deckSize;
    private ArrayList<Card> deck;
    private PokerOps pokerAlgorithms;
    private int handDealSize = 0;

    /**
     * Array of strings representing the various card ranks.
     */
    private String[] Rank = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    /**
     * enumerator const group of suits to help with readibility when building a deck.
     */
    private enum Suit {
        HEART, DIAMOND, CLUB, SPADE
    }


    /**
     * Constructor to instantiate a deck object to be used. It also builds the deck upon creating a deck object.
     * 
     * @param handDealSize specify the size of hand for which the deck should deal to a player.
     */
    public Deck(int handDealSize) {
        this.handDealSize = handDealSize;
        this.deck = new ArrayList<>();
        this.pokerAlgorithms = new PokerOps();
        this.buildDeck();
    }


    /**
     * method to call a shuffle method on a deck object.
     */
    public void shuffle() {
        this.pokerAlgorithms.shuffle(this);
    }

    /**
     * method to create the card objects to populate the deck. The deck is also shuffled once it is built.
     */
    public void buildDeck() {
        String s;
        int cardValue, nonspecialInc;

        for (Suit suit : Suit.values()) {
            nonspecialInc = 0;
            for (String rank : Rank) {
                nonspecialInc++;

                switch (suit) {
                    case CLUB: {
                        s = "\u2667";
                        break;
                    }
                    case HEART: {
                        s = "\u2661";
                        break;
                    }
                    case SPADE: {
                        s = "\u2664";
                        break;
                    }
                    case DIAMOND: {
                        s = "\u2662";
                        break;
                    }
                    default:
                        s = "";
                }

                switch(rank){
                    case "A":{
                        cardValue = 14;
                        break;
                    }
                    case "J":{
                        cardValue = 11;
                        break;
                    }
                    case "Q":{
                        cardValue = 12;
                        break;
                    }
                    case "K":{
                        cardValue = 13;
                        break;
                    }
                    default:{
                        cardValue = 0;
                    }

                }

                if (cardValue == 0) cardValue = nonspecialInc;
                

                this.deck.add(new Card(rank, s, cardValue));
            }
        }

        this.deckSize = this.deck.size();
        this.shuffle();
    }

    /**
     * method to deal an Arraylist of Cards to the players hand. Takes in the deck object and the specified hand deal size from
     * the constructor.
     * 
     * @return an Arraylist of Card objects.
     */
    public ArrayList<Card> dealCards() {
        return this.pokerAlgorithms.dealCards(this.handDealSize, this.deck);
    }

    public int getHandDealSize(){
        return this.handDealSize;
    }

    public void setHandDealSize(int hds){
        this.handDealSize = hds;
    }

    public int getDeckSize() {
        return this.deckSize;
    }

    public ArrayList<Card> getDeck() {
        return this.deck;
    }

}
