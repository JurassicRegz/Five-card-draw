import java.util.ArrayList;

public class Deck {
    private int size;
    private ArrayList<Card> deck;
    private PokerOps helperAlgos;

    private String[] Rank = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    private enum Suit{
        HEART, DIAMOND, CLUB, SPADE
    }

    public Deck(){
        this.deck = new ArrayList<>();
        this.helperAlgos = new PokerOps();
        this.buildDeck();
    }

    public int getDeckSize(){
        return this.size;
    }

    public ArrayList<Card> getDeck(){
        return this.deck;
    }

    public void shuffle(){
        this.helperAlgos.shuffle(this);
    }

    public void buildDeck(){
        String s;
        int cardVal, helperVal;

        for(Suit suit: Suit.values()){
            helperVal = 0;
            for (String rank: Rank){
                helperVal++;
                cardVal = 0;

                switch (suit){
                    case CLUB : {
                        s = "\u2667";
                        break;
                    }
                    case HEART : {
                        s = "\u2661";
                        break;
                    }
                    case SPADE : {
                        s = "\u2664";
                        break;
                    }
                    case DIAMOND : {
                        s = "\u2662";
                        break;
                    }
                    default : s = "";
                }

                if(rank.equals("A")) cardVal = 14;
                if(rank.equals("J")) cardVal = 11;
                if(rank.equals("Q")) cardVal = 12;
                if(rank.equals("K")) cardVal = 13;
                if (cardVal == 0){
                    cardVal = helperVal;
                }

                this.deck.add(new Card(rank, s, cardVal));
            }
        }

        this.size = this.deck.size();
        this.shuffle();
    }

    public ArrayList<Card> dealCards(){
        return this.helperAlgos.dealCards(5, this.deck);
    }

}
