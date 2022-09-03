import java.util.ArrayList;
import java.util.Random;

public class PokerOps {

    public void shuffle(Deck deck){
        Random rand = new Random();

        for (int i = 0; i < deck.getDeckSize(); i++)
        {
            int r = i + rand.nextInt(52 - i);

            Card temp = deck.getDeck().get(r);
            deck.getDeck().set(r, deck.getDeck().get(i));
            deck.getDeck().set(i, temp);

        }
    }

    public ArrayList<Card> dealCards(int numOfCards, ArrayList<Card> deck){
        ArrayList<Card> returnHand = new ArrayList<>();

        for (int i = 0; i< numOfCards; i++){
            returnHand.add(deck.get(i));
        }

        return returnHand;
    }
}
