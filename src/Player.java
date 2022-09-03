import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand;
    private Deck deck;
    private Ranking rank;

    public Player(){
        this.deck = new Deck();
        this.rank = new Ranking();
    }

    public void printHand(){
        for (Card c: this.hand){
            c.printCard();
        }
        System.out.println();
    }

    public void evaluate(){
        rank.evaluateHand(this.hand);
        rank.printRank();
    }

    public void drawCards(){
        deck.shuffle();
        this.hand = this.deck.dealCards();
    }
}
