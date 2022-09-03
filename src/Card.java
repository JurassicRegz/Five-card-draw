public class Card {
    private String rank;
    private String suit;
    private int value;

    public Card(String rank, String suit, int val){
        this.rank = rank;
        this.suit = suit;
        this.value = val;
    }

    public void printCard(){
        System.out.print(this.rank + this.suit + " ");
    }

    public String getCardRank(){
        return this.rank;
    }

    public String getCardSuit(){
        return this.suit;
    }

    public int getCardVal(){
        return this.value;
    }
}
