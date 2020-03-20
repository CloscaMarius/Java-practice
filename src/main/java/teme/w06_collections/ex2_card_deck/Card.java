package teme.w06_collections.ex2_card_deck;


import java.util.Objects;

enum Suit {
    DIAMONDS, CLUBS, HEARTS, SPADES
}

class Card {

    private int number;
    private Suit suit;

    Card(int number, Suit suit) {

        this.number = number;
        this.suit = suit;
    }

    public int getNumber() {
        return number;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return number == card.number &&
                suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, suit);
    }

    @Override
    public String toString() {
        return "Card{" +
                "number=" + number +
                ", suit=" + suit +
                '}';
    }
}


