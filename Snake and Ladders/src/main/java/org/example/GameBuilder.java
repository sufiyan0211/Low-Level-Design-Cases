package org.example;

/**
 *
 * Builder Pattern for Game constructor
 *
 * @author sofiyan
 */
public class GameBuilder {
    private int snakes;
    private int ladders;
    private int players;
    private int dices;
    private int boardSize;

    public GameBuilder setBoardSize(int boardSize) {
        this.boardSize = boardSize;
        return this;
    }

    public GameBuilder setSnakes(int snakes) {
        this.snakes = snakes;
        return this;
    }

    public GameBuilder setLadders(int ladders) {
        this.ladders = ladders;
        return this;
    }

    public GameBuilder setPlayers(int players) {
        this.players = players;
        return this;
    }

    public GameBuilder setDices(int dices) {
        this.dices = dices;
        return this;
    }

    public Game build() {
        return new Game(this.boardSize, this.snakes, this.ladders, this.dices, this.players);
    }
}
