import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PokerOps {

    /**
     * method to shuffle a deck object.
     * 
     * @param deck deck object to be shuffled.
     */
    public void shuffle(Deck deck) {
        Random rand = new Random();
        Card temp;
        int size = deck.getDeckSize();
        ArrayList<Card> deckObj = deck.getDeck();

        for (int r, i = 0; i < size; i++) {
            r = i + rand.nextInt(size - i);

            temp = deckObj.get(r);
            deckObj.set(r, deckObj.get(i));
            deckObj.set(i, temp);

        }
    }

    /**
     * method to deal cards to a player's hand.
     * 
     * @param numOfCards amount of cards to be dealt to a player's hand.
     * @param deck deck object from which to draw cards.
     * @return Arraylist of card objects for the player's hand.
     */
    public ArrayList<Card> dealCards(int numOfCards, ArrayList<Card> deck) {
        ArrayList<Card> returnHand = new ArrayList<>();

        for (int i = 0; i < numOfCards; i++) {
            returnHand.add(deck.get(i));
        }

        return returnHand;
    }

    /**
     * method to sort cards in a player's hand.
     * 
     * @param handCards Arraylist of Card objects representing a player's hand cards 
     * @return Arraylist of Card objects that is sorted in Ascending order.
     */
    public ArrayList<Card> sortHandCards(ArrayList<Card> handCards) {
        ArrayList<Card> unsortCards = new ArrayList<>();
        int handSize = handCards.size();

        for (Card card : handCards) {
            unsortCards.add(card);
        }
        handCards = new ArrayList<>();

        ArrayList<Integer> valuesArr = new ArrayList<>();
        for (int i = 0; i < handSize; i++) {
            valuesArr.add(unsortCards.get(i).getCardVal()) ;
        }
        Collections.sort(valuesArr);

        Card tempCard = null;
        for (int cardValue : valuesArr) {
            for (Card card : unsortCards) {
                if (cardValue == card.getCardVal()) {
                    tempCard = card;
                    break;
                }
            }
            handCards.add(tempCard);
            unsortCards.remove(tempCard);
        }

        return handCards;
    }

}
