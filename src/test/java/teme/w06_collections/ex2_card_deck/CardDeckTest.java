package teme.w06_collections.ex2_card_deck;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * MAX GRADE: 25p
 */
@RunWith(GradeRunner.class)
public class CardDeckTest {

    @Test
    @Grade(1)
    public void testCard_SuitEnum() {
        assertEquals(
                new HashSet<>(Arrays.asList("DIAMONDS", "CLUBS", "HEARTS", "SPADES")),
                Arrays.stream(Suit.values()).map(s -> s.toString().toUpperCase()).collect(Collectors.toSet()));
    }

    @Test
    @Grade(2)
    public void testCard_fieldsAndEquals() {
        Card c1 = new Card(5, suit("DIAMONDS"));
        Card c2 = new Card(5, suit("DIAMONDS"));
        Card c3 = new Card(1, suit("DIAMONDS"));
        Card c4 = new Card(5, suit("CLUBS"));

        assertEquals(c1, c2);
        assertNotSame(c1, c2);

        assertNotEquals(c1, c3);
        assertNotEquals(c1, c4);
    }

    @Test
    @Grade(1)
    public void testCard_toString() {
        String s = new Card(5, suit("DIAMONDS")).toString().toLowerCase();
        assertTrue(s.contains("diamonds"));
        assertTrue(s.contains("5"));
    }

    private Suit suit(String name) {
        return Arrays.stream(Suit.values())
                .filter(s -> s.toString().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }


    @Test
    @Grade(1)
    public void testDeck_availableAndUsedCount_newDeck() {
        CardDeck d = new CardDeck();
        assertEquals(0, d.getUsedCardCount());
        assertEquals(52, d.getAvailableCardCount());
    }

    @Test
    @Grade(2)
    public void testDeck_availableAndUsedCount_afterDeal() {
        CardDeck d = new CardDeck();
        assertEquals(0, d.getUsedCardCount());
        assertEquals(52, d.getAvailableCardCount());

        d.dealHand(1);
        assertEquals(1, d.getUsedCardCount());
        assertEquals(51, d.getAvailableCardCount());

        d.dealHand(21);
        assertEquals(22, d.getUsedCardCount());
        assertEquals(30, d.getAvailableCardCount());

        d.dealHand(30);
        assertEquals(52, d.getUsedCardCount());
        assertEquals(0, d.getAvailableCardCount());
    }

    @Test
    @Grade(1)
    public void testDeck_getAvailableCardCount_afterShuffle() {
        CardDeck d = new CardDeck();
        assertEquals(0, d.getUsedCardCount());
        assertEquals(52, d.getAvailableCardCount());

        d.dealHand(20);
        assertNotEquals(0, d.getUsedCardCount());
        assertNotEquals(52, d.getAvailableCardCount());

        d.shuffle();
        assertEquals(0, d.getUsedCardCount());
        assertEquals(52, d.getAvailableCardCount());
    }


    @Test
    @Grade(2)
    public void testDeck_contentsOfNewDeck_andDeal() {
        //deal all cards, to check the full package is present
        handContainsFullPackage(new CardDeck().dealHand(100));
    }

    private void handContainsFullPackage(List<Card> hand) {
        assertEquals(52, hand.size());
        for (int number = 2; number <= 14; number++) {
            for (Suit suit : Suit.values()) {
                Card card = new Card(number, suit);
                assertTrue("hand should contain card: " + card, hand.contains(card));
            }
        }
    }

    @Test
    @Grade(1)
    public void testDeck_dealHand_getEnoughCards() {
        CardDeck d = new CardDeck();
        assertEquals(1, d.dealHand(1).size());
        assertEquals(5, d.dealHand(5).size());
        assertEquals(10, d.dealHand(10).size());
        assertEquals(20, d.dealHand(20).size());
    }

    @Test
    @Grade(2)
    public void testDeck_dealHand_getRemainingCardsIfNotEnough() {
        CardDeck d = new CardDeck();
        assertEquals(50, d.dealHand(50).size());
        assertEquals(2, d.dealHand(10).size());
        assertEquals(0, d.dealHand(10).size());
    }

    @Test
    @Grade(3)
    public void testDeck_deal_getDistinctCards() {
        CardDeck d = new CardDeck();

        List<Card> h1 = d.dealHand(1);
        List<Card> h2 = d.dealHand(5);
        List<Card> h3 = d.dealHand(10);
        List<Card> h4 = d.dealHand(10);

        assertEquals(1, h1.stream().distinct().count());
        assertEquals(5, h2.stream().distinct().count());
        assertEquals(10, h3.stream().distinct().count());
        assertEquals(10, h4.stream().distinct().count());

        List<Card> combined = new ArrayList<>(h1);
        combined.addAll(h2);
        combined.addAll(h3);
        combined.addAll(h4);
        assertEquals(26, combined.stream().distinct().count()); //they are distinct between hands too
    }

    @Test
    @Grade(2)
    public void testDeck_deal_fullPackage() {
        CardDeck d = new CardDeck();

        List<Card> h = d.dealHand(10);
        h.addAll(d.dealHand(20));
        h.addAll(d.dealHand(32));

        //cards should be unique in each hand, and together they should form the full package
        handContainsFullPackage(h);
    }

    @Test
    @Grade(2)
    public void testDeck_shuffle_resetsCounterAndPackageContent() {
        CardDeck d = new CardDeck();

        List<Card> h1 = d.dealHand(100);
        handContainsFullPackage(h1);

        d.shuffle();
        List<Card> h2 = d.dealHand(100);
        handContainsFullPackage(h2);
    }

    @Test
    @Grade(3)
    public void testDeck_deal_randomOrder_sameDeckAfterShuffle() {
        List<List<Card>> hands = new ArrayList<>();

        //3 hands dealt in a row should be different (most probably)
        CardDeck d1 = new CardDeck();
        hands.add(d1.dealHand(5));
        hands.add(d1.dealHand(5));
        hands.add(d1.dealHand(5));

        //hands dealt after reshuffle should be different again
        d1.shuffle();
        hands.add(d1.dealHand(5));
        hands.add(d1.dealHand(5));
        hands.add(d1.dealHand(5));

        d1.shuffle();
        hands.add(d1.dealHand(5));
        hands.add(d1.dealHand(5));
        hands.add(d1.dealHand(5));

        //check all different
        assertEquals(9, hands.stream().distinct().count());
    }

    @Test
    @Grade(2)
    public void testDeck_deal_randomOrder_differentNewDecks() {
        List<List<Card>> hands = new ArrayList<>();

        //3 hands dealt in a row should be different (most probably)
        CardDeck d1 = new CardDeck();
        hands.add(d1.dealHand(5));
        hands.add(d1.dealHand(5));
        hands.add(d1.dealHand(5));

        //hands from another deck should be different too
        CardDeck d2 = new CardDeck();
        hands.add(d2.dealHand(5));
        hands.add(d2.dealHand(5));
        hands.add(d2.dealHand(5));

        CardDeck d3 = new CardDeck();
        hands.add(d3.dealHand(5));
        hands.add(d3.dealHand(5));
        hands.add(d3.dealHand(5));

        //check all different
        assertEquals(9, hands.stream().distinct().count());
    }
}
