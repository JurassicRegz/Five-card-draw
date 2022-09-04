public class Card {
    private String rank;
    private String suit;
    private int value;

    /**
     * Constructor to instantiate a card object. 
     * 
     * @param rank string representing the rank of a card.
     * @param suit string representing the suit of a card.
     * @param val int representing the value associated with the card's rank.
     */
    public Card(String rank, String suit, int val) {
        this.rank = rank;
        this.suit = suit;
        this.value = val;
    }

    /**
     * print the card's rank and suit.
     */
    public void printCard() {
        System.out.print(this.rank + this.suit + " ");
    }

    /**
     * 
     * @return private rank member of a card object.
     */
    public String getCardRank() {
        return this.rank;
    }

    /**
     * 
     * @return private suit member of card object.
     */
    public String getCardSuit() {
        return this.suit;
    }

    /**
     * 
     * @return private value member of card object.
     */
    public int getCardVal() {
        return this.value;
    }
}
