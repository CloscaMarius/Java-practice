package teme.w06_collections.ex2_card_deck;

import java.util.List;

class CardDeck {

    //TODO: add fields, constructors, fill method bodies, etc..

    void shuffle() {
        //???
    }

    List<Card> dealHand(int handSize) {
        //???
        return null;
    }

    int getAvailableCardCount() {
        //???
        return -1;
    }

    int getUsedCardCount() {
        //???
        return -1;
    }


    /**
     * Just for some manual tests
     */
    public static void main(String[] args) {
        CardDeck deck = new CardDeck();
        System.out.println(deck.dealHand(5)); // <- print 5 cards 3 times
        System.out.println(deck.dealHand(5));
        System.out.println(deck.dealHand(5));
        System.out.println(deck.dealHand(50)); // <- only 39 cards should be printed here
        System.out.println(deck.dealHand(50)); // <- and empty list should be printed
        deck.shuffle();
        System.out.println(deck.dealHand(5)); // <- another 5 cards
    }
}
