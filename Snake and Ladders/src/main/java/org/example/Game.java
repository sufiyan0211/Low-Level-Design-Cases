package org.example;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 * @author sofiyan
 */
public class Game {
    private Dice dice;
    private Board board;
    private Deque<Player> players;
    private final static int playerInitialPosition = 1;
    private Player winner = null;


    public Game(int boardSize, int snakes, int ladders, int dices, int playersCount) {
        this.board = new Board(boardSize, snakes, ladders);
        this.dice = new Dice(dices);
        initializePlayers(playersCount);
    }

    private void initializePlayers(int playersCount) {
        this.players = new LinkedList<>();

        for(int playerIdx = 0; playerIdx<playersCount; playerIdx++) {
            Player player = new Player(playerIdx, playerInitialPosition);
            players.addLast(player);
        }
    }

    public void startGame() {
        while(winner == null) {
            Player player = players.getFirst();
            players.removeFirst();
            players.addLast(player);

            if(player.getCurrentPosition() >= board.cells.length * board.cells.length) {
                winner = player;
                return;
            }

            int nextPosition = dice.rollDice() + player.getCurrentPosition();
            if(nextPosition >= board.cells.length * board.cells.length) {
                winner = player;
                return;
            }

            Cell cell = board.getCell(nextPosition);
            Jump jump = board.getJump(cell);
            if(jump != null) {
                nextPosition = jump.getEnd();
            }

            player.setCurrentPosition(nextPosition);
        }
    }

    public void printWinner() {
        if(winner == null) {
            System.out.println("No-buddy won the game");
        }
        else {
            System.out.println("Winner is Player: "+ winner.getId());
        }
    }
}
