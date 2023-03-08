package org.example;

/**
 *
 * @author sofiyan
 */
public class Main {
    public static void main(String[] args) {
        Game game = new GameBuilder()
                .setBoardSize(7)
                .setDices(1)
                .setSnakes(3)
                .setLadders(3)
                .setPlayers(2)
                .build();

        game.startGame();
        game.printWinner();
    }
}