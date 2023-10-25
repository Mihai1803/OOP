import enums.Rank;
import enums.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Deck {

    ArrayList<PlayingCard> deck = new ArrayList<>();


    public void addCard(PlayingCard card) {
        this.deck.add(card);
    }

    public void removeCard(PlayingCard cardToBeRemoved) {
        if (cardToBeRemoved == null) {
            return;
        }
        boolean found = false;
        for (PlayingCard card : this.deck) {
            if (card.getRank() == cardToBeRemoved.getRank() &&
                card.getSuit() == cardToBeRemoved.getSuit()) {
                this.deck.remove(card);
                found = true;
                break;
            }
        }
        if (!found && cardToBeRemoved.getRank().getValue() != Rank.ZERO.getValue()) {
            System.out.println("Card is not in the deck");
        }
    }

    public PlayingCard drawCard() {
        Random random = new Random();
        int randomIndex = random.nextInt(this.deck.size());
        return this.deck.get(randomIndex);
    }

    public PlayingCard drawTopCard() {
        if (this.deck.isEmpty()) {
            return new PlayingCard(Rank.ZERO, Suit.CLUBS);
        }
        return this.deck.get(0);
    }

    public int deckSize() {
        return this.deck.size();
    }

    public void shuffle() {
        Collections.shuffle(this.deck);
    }

    public void sort() {
        Collections.sort(this.deck, new CardComparator());
    }

    public ArrayList<PlayingCard> getDeck() {
        return deck;
    }

    private static class CardComparator implements Comparator<PlayingCard> {

        @Override
        public int compare(PlayingCard card1, PlayingCard card2) {

            int suitComparison = card1.getSuit().getValue() - card2.getSuit().getValue();
            int rankComparison = card1.getRank().getValue() - card2.getRank().getValue();

            if (suitComparison == 0 && rankComparison == 0) {
                throw new IllegalArgumentException("Duplicate in the deck: " + card1.getSuit().getValue() + " " + card1.getRank().getValue());
            }

            if (suitComparison == 0) {
                return rankComparison;
            } else {
                return suitComparison;
            }
        }
    }
}
