package teme.w06_collections.ex2_card_deck;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class CardDeck {

    private List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);
    private List<Card> cards = new ArrayList<Card>(createDeck());
    private int usedCardCount;


    List<Card> createDeck() {
        List<Card> deckOfCards = new ArrayList<Card>();
        for (Suit s : Suit.values()) {
            for (int n : numbers) {
                Card card = new Card(n, s);
                deckOfCards.add(card);
            }
        }
        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }


    void shuffle() {
        this.cards = new ArrayList<>(createDeck());
        Collections.shuffle(this.cards);
        this.usedCardCount = 0;
    }

    List<Card> dealHand(int handSize) {
        List<Card> hand = new ArrayList<>(0);

        for (int i = 0; i < handSize; i++) {
            usedCardCount++;
            if (this.cards.size() == 0) {
                return new ArrayList<>(0);
            }
            hand.add(cards.get(0));
            this.cards.remove(0);
            if (this.cards.size() == 0) {
                return hand;
            }
        }
        return hand;
    }

    int getAvailableCardCount() {
        return this.cards.size();

    }

    int getUsedCardCount() {
        return usedCardCount;
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
