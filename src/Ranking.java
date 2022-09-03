import java.util.ArrayList;
import java.util.Arrays;

public class Ranking {
    private String suit, handRank;
    private int flushCheck;
    private ArrayList<Card> HandCards;
    private boolean chk = true;


    public Ranking() {
        this.handRank = "";
    }

    public void printRank(){
        System.out.println(handRank);
    }

    public void evaluateHand(ArrayList<Card> hand) {
        this.HandCards = hand;
        sortHandCards();
        getRank();
    }

    public void sortHandCards() {
        ArrayList<Card> unsortCards = new ArrayList<>();
        for (Card c : this.HandCards) {
            unsortCards.add(c);
        }
        this.HandCards = new ArrayList<>();

        //Sorting The Card Values
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = unsortCards.get(i).getCardVal();
        }
        Arrays.sort(arr);

        //Copying The Sorted Cards To The Hand
        Card x = null;
        for (int a : arr) {
            for (Card c : unsortCards) {
                if (a == c.getCardVal()) {
                    x = c;
                    break;
                }
            }
            this.HandCards.add(x);
            unsortCards.remove(x);
        }
    }

    private void getRank() {
        int i = 0;
        flushCheck = 1;
        for (Card c : HandCards) {
            if (i == 0) {
                suit = c.getCardSuit();
            } else if (suit.equals(c.getCardSuit())) {
                continue;
            } else {
                flushCheck = 0;
                break;
            }
            i++;
        }


        if (flushCheck != 0) {
            if (chk) {
                checkStraightFlush();
                handRank = "Straight Flush";
            }
            if (chk) {
                checkFlush();
                handRank = "Flush";
            }

        } else {
            if (chk) {
                checkFourOfAKind();
                handRank = "Four of a Kind";
            }
            if (chk) {
                checkFullHouse();
                handRank = "Full House";
            }
            if (chk) {
                checkStraight();
                handRank = "Straight";
            }
            if (chk) {
                checkThreeOfAKind();
                handRank = "Three of a Kind";
            }
            if (chk) {
                checkTwoPair();
                handRank = "Two Pair";
            }
            if (chk) {
                checkOnePair();
                handRank = "One Pair";
            }
            if (chk) {
                HighCard();
                handRank = "High Card";
            }
        }
    }

    public void checkStraightFlush() {
        //Checking For Straight Flush with A in 1st
        if ((HandCards.get(0).getCardVal() + 3) == HandCards.get(3).getCardVal() &&
                HandCards.get(4).getCardVal() == 14 &&
                HandCards.get(0).getCardVal() == 2) {
            chk = false;
        }
        //Checking Straight Flush For Other values
        else if ((HandCards.get(0).getCardVal() + 4) == HandCards.get(4).getCardVal()) {
            chk = false;
        }
    }

    public void checkFourOfAKind() {
        if (HandCards.get(0).getCardVal() == HandCards.get(1).getCardVal() &&
                HandCards.get(1).getCardVal() == HandCards.get(2).getCardVal() &&
                HandCards.get(2).getCardVal() == HandCards.get(3).getCardVal() ||
                HandCards.get(1).getCardVal() == HandCards.get(2).getCardVal() &&
                        HandCards.get(2).getCardVal() == HandCards.get(3).getCardVal() &&
                        HandCards.get(3).getCardVal() == HandCards.get(4).getCardVal()) {

            chk = false;
        }
    }

    public void checkFullHouse() {
        if (HandCards.get(0).getCardVal() == HandCards.get(1).getCardVal() &&
                HandCards.get(1).getCardVal() == HandCards.get(2).getCardVal() &&
                HandCards.get(3).getCardVal() == HandCards.get(4).getCardVal() ||
                HandCards.get(0).getCardVal() == HandCards.get(1).getCardVal() &&
                        HandCards.get(2).getCardVal() == HandCards.get(3).getCardVal() &&
                        HandCards.get(3).getCardVal() == HandCards.get(4).getCardVal()) {
            chk = false;
        }
    }

    public void checkFlush() {
        chk = false;
    }

    public void checkStraight() {
        if ((HandCards.get(0).getCardVal() + 1) == HandCards.get(1).getCardVal() &&
                (HandCards.get(1).getCardVal() + 1) == HandCards.get(2).getCardVal() &&
                (HandCards.get(2).getCardVal() + 1) == HandCards.get(3).getCardVal() &&
                (HandCards.get(3).getCardVal() + 1) == HandCards.get(4).getCardVal() ||
                HandCards.get(4).getCardVal() == 14 &&
                        HandCards.get(0).getCardVal() == 2 &&
                        (HandCards.get(0).getCardVal() + 1) == HandCards.get(1).getCardVal() &&
                        (HandCards.get(1).getCardVal() + 1) == HandCards.get(2).getCardVal() &&
                        (HandCards.get(2).getCardVal() + 1) == HandCards.get(3).getCardVal()) {

            chk = false;
        }
    }

    public void checkThreeOfAKind() {
        if (HandCards.get(0).getCardVal() == HandCards.get(1).getCardVal() &&
                HandCards.get(1).getCardVal() == HandCards.get(2).getCardVal() ||
                HandCards.get(1).getCardVal() == HandCards.get(2).getCardVal() &&
                        HandCards.get(2).getCardVal() == HandCards.get(3).getCardVal() ||
                HandCards.get(2).getCardVal() == HandCards.get(3).getCardVal() &&
                        HandCards.get(3).getCardVal() == HandCards.get(4).getCardVal()) {
            chk = false;
        }
    }

    public void checkTwoPair() {
        if (HandCards.get(0).getCardVal() == HandCards.get(1).getCardVal() &&
                HandCards.get(2).getCardVal() == HandCards.get(3).getCardVal() ||
                HandCards.get(1).getCardVal() == HandCards.get(2).getCardVal() &&
                        HandCards.get(3).getCardVal() == HandCards.get(4).getCardVal() ||
                HandCards.get(0).getCardVal() == HandCards.get(1).getCardVal() &&
                        HandCards.get(3).getCardVal() == HandCards.get(4).getCardVal()) {
            chk = false;
        }
    }

    public void checkOnePair() {
        if (HandCards.get(0).getCardVal() == HandCards.get(1).getCardVal()) {
            chk = false;
        }
        if (HandCards.get(1).getCardVal() == HandCards.get(2).getCardVal()) {
            chk = false;
        }
        if (HandCards.get(2).getCardVal() == HandCards.get(3).getCardVal()) {
            chk = false;
        }
        if (HandCards.get(3).getCardVal() == HandCards.get(4).getCardVal()) {
            chk = false;
        }
    }

    public void HighCard() {
        chk = false;
    }
}
