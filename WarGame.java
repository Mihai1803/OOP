import enums.Rank;
import enums.Suit;

public class WarGame {

    private int highestCard;
    private int handWinner;

    public WarGame() {

    }

    public boolean playingCondition(Deck player1Deck, Deck player2Deck, Deck player3Deck, Deck player4Deck) {
        return (
            (player1Deck.deckSize() == 0 ? 0 : 1) +
            (player2Deck.deckSize() == 0 ? 0 : 1) +
            (player3Deck.deckSize() == 0 ? 0 : 1) +
            (player4Deck.deckSize() == 0 ? 0 : 1)
        ) > 1;
    }

    public void highestCard(PlayingCard player1Card, PlayingCard player2Card, PlayingCard player3Card, PlayingCard player4Card) {

        if (player1Card != null && player2Card != null &&
            player1Card.getRank().getValue() > player2Card.getRank().getValue()
        ) {
            this.highestCard = player1Card.getRank().getValue();
            this.handWinner = 1;
        } else if (player2Card != null) {
            this.highestCard = player2Card.getRank().getValue();
            this.handWinner = 2;
        }
        if (player3Card != null && player3Card.getRank().getValue() > this.highestCard) {
            this.highestCard = player3Card.getRank().getValue();
            this.handWinner = 3;
        }
        if (player4Card != null && player4Card.getRank().getValue() > this.highestCard) {
            this.highestCard = player4Card.getRank().getValue();
            this.handWinner = 4;
        }
    }

    // simulate (play) the game
    // distribute the cards evenly among all the players
    // each player draws the top card from their deck
    // the player with the highest card takes all the other cards
    // in case of two or more players drawing the same (highest) card they go to "war"
    // when players go to "war", all the other players need to draw a card
    // but only the ones with the equal cards "fight"
    // the one that draws the highest card wins and takes all the cards
    // the player that has all the cards win
    public int playGame() {
        // create deck
        Deck deck = new Deck();

        // create one deck for every player
        Deck player1Deck = new Deck();
        Deck player2Deck = new Deck();
        Deck player3Deck = new Deck();
        Deck player4Deck = new Deck();

        // put the cards in the deck and shuffle the deck
        for (Suit suit : Suit.values()) {
            for (Rank rank: Rank.values()) {
                PlayingCard card = new PlayingCard(rank, suit);
                deck.addCard(card);
            }
        }
        deck.shuffle();

        // distribute the card equally between players
        for (int i = 0; i < 52; i += 4) {
            player1Deck.addCard(deck.drawCard());
            player2Deck.addCard(deck.drawCard());
            player3Deck.addCard(deck.drawCard());
            player4Deck.addCard(deck.drawCard());
        }


        // I will simulate the game only for 100 rounds
        // if there is no winner after 100 rounds
        // I will consider the game a draw
        int numberOfMoves = 1;
        for (int round = 0; round <  100; round++) {
            numberOfMoves = round;
            // game running as long as at least 2 players still have cards
            if (!this.playingCondition(player1Deck, player2Deck, player3Deck, player4Deck)) {
                break;
            }

            // each player draw a card
            PlayingCard player1Card = player1Deck.drawTopCard();
            PlayingCard player2Card = player2Deck.drawTopCard();
            PlayingCard player3Card = player3Deck.drawTopCard();
            PlayingCard player4Card = player4Deck.drawTopCard();

            // remove the drawn card from the player deck
            player1Deck.removeCard(player1Card);
            player2Deck.removeCard(player2Card);
            player3Deck.removeCard(player3Card);
            player4Deck.removeCard(player4Card);

            PlayingCard[] cards = { new PlayingCard(), player1Card, player2Card, player3Card, player4Card };
            Deck[] playerDecks = { new Deck(), player1Deck, player2Deck, player3Deck, player4Deck };

            // get the highest card out of the four
            this.highestCard(player1Card, player2Card, player3Card, player4Card);

            // case in which cards are equal
            for (int player = 1; player <= 4; player++) {
                if (cards[player] != null && cards[player].getRank().getValue() == this.getHighestCard()) {
                    if (!playerDecks[player].getDeck().isEmpty() && !playerDecks[this.getHandWinner()].getDeck().isEmpty()) {
                        if (playerDecks[player].drawTopCard().getRank().getValue() >
                                playerDecks[this.getHandWinner()].drawTopCard().getRank().getValue()) {

                            this.setHandWinner(player);
                            int first = (player + 1 > 4) ? 1 : player + 1;
                            int second = (first + 1 > 4) ? 1 : first + 1;
                            int third = (second + 1 > 4) ? 1 : second + 1;

                            playerDecks[player].addCard(playerDecks[first].drawTopCard());
                            playerDecks[player].addCard(playerDecks[second].drawTopCard());
                            playerDecks[player].addCard(playerDecks[third].drawTopCard());

                            playerDecks[first].removeCard(playerDecks[first].drawTopCard());
                            playerDecks[second].removeCard(playerDecks[second].drawTopCard());
                            playerDecks[third].removeCard(playerDecks[third].drawTopCard());
                        } else {
                            int handWinner = this.getHandWinner();
                            int first = (handWinner + 1 > 4) ? 1 : handWinner + 1;
                            int second = (first + 1 > 4) ? 1 : first + 1;
                            int third = (second + 1 > 4) ? 1 : second + 1;

                            playerDecks[handWinner].addCard(playerDecks[first].drawTopCard());
                            playerDecks[handWinner].addCard(playerDecks[second].drawTopCard());
                            playerDecks[handWinner].addCard(playerDecks[third].drawTopCard());

                            playerDecks[first].removeCard(playerDecks[first].drawTopCard());
                            playerDecks[second].removeCard(playerDecks[second].drawTopCard());
                            playerDecks[third].removeCard(playerDecks[third].drawTopCard());
                        }
                    }
                    break;
                }
            }

            // give the winner all the cards
            int handWinner = this.getHandWinner();
            for (int player = 1; player <= 4; player++) {
                if (player == handWinner) {

                    int first = (player + 1 > 4) ? 1 : player + 1;
                    int second = (first + 1 > 4) ? 1 : first + 1;
                    int third = (second + 1 > 4) ? 1 : second + 1;

                    playerDecks[player].addCard(cards[first]);
                    playerDecks[player].addCard(cards[second]);
                    playerDecks[player].addCard(cards[third]);

                    break;
                }
            }
        }

        System.out.println("The winner is:");
        displayWinner(player1Deck, player2Deck, player3Deck, player4Deck);
        System.out.println("\n");

        return numberOfMoves == 99 ? -1 : numberOfMoves;
    }

    public void displayWinner(Deck player1Deck, Deck player2Deck, Deck player3Deck, Deck player4Deck) {

        if (this.playingCondition(player1Deck, player2Deck, player3Deck, player4Deck)) {
            System.out.println("DRAW");
        } else if (player1Deck.deckSize() != 0) {
            System.out.println("Player 1 with " + player1Deck.deckSize()  + "\n");
        } else if (player2Deck.deckSize() != 0) {
            System.out.println("Player 2 with " + player2Deck.deckSize() + "\n");
        } else if (player3Deck.deckSize() != 0) {
            System.out.println("Player 3 with " + player3Deck.deckSize() + "\n");
        } else if (player3Deck.deckSize() != 0) {
            System.out.println("Player 4 with " + player4Deck.deckSize() + "\n");
        }
    }



    public int getHighestCard() {
        return highestCard;
    }

    public int getHandWinner() {
        return handWinner;
    }

    public void setHighestCard(int highestCard) {
        this.highestCard = highestCard;
    }

    public void setHandWinner(int handWinner) {
        this.handWinner = handWinner;
    }
}
