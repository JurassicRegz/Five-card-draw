import java.util.ArrayList;

public class Ranking {
    private String handRank;
    private ArrayList<Card> handCards;
    private boolean rankNotFound, flushCheck;

    public Ranking() {
        this.handRank = "";
    }

    /**
     * 
     * @param hand ArrayList of Card objects which represents a player's hand.
     * @return String which represents the strength of a player's hand.
     */
    public String evaluateHand(ArrayList<Card> hand) {
        this.handCards = hand;
        return this.evaluateRank();
    }

    /**
     * method to evaluate an Arraylist of Card objects to determine it's strength.
     * 
     * @return String which represents the strength of a player's hand.
     */
    private String evaluateRank() {
        this.handRank = "";
        this.rankNotFound = true;
        int iterator = 0;
        String comparisonSuit = "";
        this.flushCheck = true;

        ////Check if cards follow a type of flush rank////
        for (Card card : this.handCards) {
            if (iterator == 0) {
                comparisonSuit = card.getCardSuit();
            } else if (comparisonSuit.equals(card.getCardSuit())) {
                continue;
            } else {
                this.flushCheck = false;
                break;
            }
            iterator++;
        }

        ////Follows a trickle down style to match a rank to a player's hand////
        if (this.flushCheck) {
            if (rankNotFound) {
                checkStraightFlush();
                this.handRank = "Straight Flush";
            }
            if (rankNotFound) {
                checkFlush();
                this.handRank = "Flush";
            }

        } else {
            if (this.rankNotFound) {
                checkFourOfAKind();
                this.handRank = "Four of a Kind";
            }
            if (this.rankNotFound) {
                checkFullHouse();
                this.handRank = "Full House";
            }
            if (this.rankNotFound) {
                checkStraight();
                this.handRank = "Straight";
            }
            if (this.rankNotFound) {
                checkThreeOfAKind();
                this.handRank = "Three of a Kind";
            }
            if (this.rankNotFound) {
                checkTwoPair();
                this.handRank = "Two Pair";
            }
            if (this.rankNotFound) {
                checkOnePair();
                this.handRank = "One Pair";
            }
            if (this.rankNotFound) {
                HighCard();
                this.handRank = "High Card";
            }
        }

        return this.handRank;
    }

    ////////////Various methods to check hand ranks///////////

    public void checkStraightFlush() {
        if ((this.handCards.get(0).getCardVal() + 3) == this.handCards.get(3).getCardVal() &&
                this.handCards.get(4).getCardVal() == 14 &&
                this.handCards.get(0).getCardVal() == 2) {
            this.rankNotFound = false;
        }
        else if ((this.handCards.get(0).getCardVal() + 4) == this.handCards.get(4).getCardVal()) {
            this.rankNotFound = false;
        }
    }

    public void checkFourOfAKind() {
        if (this.handCards.get(0).getCardVal() == this.handCards.get(1).getCardVal() &&
                this.handCards.get(1).getCardVal() == this.handCards.get(2).getCardVal() &&
                this.handCards.get(2).getCardVal() == this.handCards.get(3).getCardVal() ||
                this.handCards.get(1).getCardVal() == this.handCards.get(2).getCardVal() &&
                        this.handCards.get(2).getCardVal() == this.handCards.get(3).getCardVal() &&
                        this.handCards.get(3).getCardVal() == this.handCards.get(4).getCardVal()) {

            this.rankNotFound = false;
        }
    }

    public void checkFullHouse() {
        if (this.handCards.get(0).getCardVal() == this.handCards.get(1).getCardVal() &&
                this.handCards.get(1).getCardVal() == this.handCards.get(2).getCardVal() &&
                this.handCards.get(3).getCardVal() == this.handCards.get(4).getCardVal() ||
                this.handCards.get(0).getCardVal() == this.handCards.get(1).getCardVal() &&
                        this.handCards.get(2).getCardVal() == this.handCards.get(3).getCardVal() &&
                        this.handCards.get(3).getCardVal() == this.handCards.get(4).getCardVal()) {
            this.rankNotFound = false;
        }
    }

    public void checkFlush() {
        this.rankNotFound = false;
    }

    public void checkStraight() {
        if ((this.handCards.get(0).getCardVal() + 1) == this.handCards.get(1).getCardVal() &&
                (this.handCards.get(1).getCardVal() + 1) == this.handCards.get(2).getCardVal() &&
                (this.handCards.get(2).getCardVal() + 1) == this.handCards.get(3).getCardVal() &&
                (this.handCards.get(3).getCardVal() + 1) == this.handCards.get(4).getCardVal() ||
                this.handCards.get(4).getCardVal() == 14 &&
                        this.handCards.get(0).getCardVal() == 2 &&
                        (this.handCards.get(0).getCardVal() + 1) == this.handCards.get(1).getCardVal() &&
                        (this.handCards.get(1).getCardVal() + 1) == this.handCards.get(2).getCardVal() &&
                        (this.handCards.get(2).getCardVal() + 1) == this.handCards.get(3).getCardVal()) {

            this.rankNotFound = false;
        }
    }

    public void checkThreeOfAKind() {
        if (this.handCards.get(0).getCardVal() == this.handCards.get(1).getCardVal() &&
                this.handCards.get(1).getCardVal() == this.handCards.get(2).getCardVal() ||
                this.handCards.get(1).getCardVal() == this.handCards.get(2).getCardVal() &&
                        this.handCards.get(2).getCardVal() == this.handCards.get(3).getCardVal()
                ||
                this.handCards.get(2).getCardVal() == this.handCards.get(3).getCardVal() &&
                        this.handCards.get(3).getCardVal() == this.handCards.get(4).getCardVal()) {
            this.rankNotFound = false;
        }
    }

    public void checkTwoPair() {
        if (this.handCards.get(0).getCardVal() == this.handCards.get(1).getCardVal() &&
                this.handCards.get(2).getCardVal() == this.handCards.get(3).getCardVal() ||
                this.handCards.get(1).getCardVal() == this.handCards.get(2).getCardVal() &&
                        this.handCards.get(3).getCardVal() == this.handCards.get(4).getCardVal()
                ||
                this.handCards.get(0).getCardVal() == this.handCards.get(1).getCardVal() &&
                        this.handCards.get(3).getCardVal() == this.handCards.get(4).getCardVal()) {
            this.rankNotFound = false;
        }
    }

    public void checkOnePair() {
        if (this.handCards.get(0).getCardVal() == this.handCards.get(1).getCardVal()) {
            this.rankNotFound = false;
        }
        if (this.handCards.get(1).getCardVal() == this.handCards.get(2).getCardVal()) {
            this.rankNotFound = false;
        }
        if (this.handCards.get(2).getCardVal() == this.handCards.get(3).getCardVal()) {
            this.rankNotFound = false;
        }
        if (this.handCards.get(3).getCardVal() == this.handCards.get(4).getCardVal()) {
            this.rankNotFound = false;
        }
    }

    public void HighCard() {
        this.rankNotFound = false;
    }
}
