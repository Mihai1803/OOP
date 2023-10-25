
public class Main {
    public static void main(String[] args) {

        int minimumNumberOfMoves = 1000;
        int maximumNumberOfMoves = 0;
        int totalNumberOfMoves = 0;
        double meanNumberOfMoves = 0;

        WarGame game = new WarGame();

        for (int games = 0; games < 10; games++) {

            int numberOfMoves = game.playGame();
            if (maximumNumberOfMoves < numberOfMoves) {
                maximumNumberOfMoves = numberOfMoves;
            }
            if (minimumNumberOfMoves > numberOfMoves && numberOfMoves != -1) {
                minimumNumberOfMoves = numberOfMoves;
            }

            totalNumberOfMoves += (numberOfMoves == -1) ? 99 : numberOfMoves;

        }

        meanNumberOfMoves = (double) totalNumberOfMoves / 10;

        // I did not take into consideration the draw situation for the maximumNumberOfMoves
        // But I did take it into consideration for the meanNumberOfMoves
        System.out.println("Maximum number of moves: " + maximumNumberOfMoves);
        System.out.println("Minimum number of moves: " + minimumNumberOfMoves);
        System.out.println("Mean number of moves: " + meanNumberOfMoves);

    }
}
