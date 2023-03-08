package org.example;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author sofiyan
 */
public class Board {
    public Cell[][] cells;

    public Board(int boardSize, int snakes, int ladders) {
        initializeBoard(boardSize);
        addSnakeNLadder(snakes, ladders);
    }

    private void initializeBoard(int boardSize) {
        cells = new Cell[boardSize][boardSize];
        for (int i=0;i<boardSize;i++) {
            for (int j=0;j<boardSize;j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    private void addSnakeNLadder(int snakes, int ladders) {
        while(snakes != 0) {
            int start = ThreadLocalRandom.current().nextInt(1, cells.length* cells.length);
            int end = ThreadLocalRandom.current().nextInt(1, cells.length* cells.length);

            if(end >= start) continue;

            Jump jump = new Jump(start, end);
            Cell cell = getCell(start);
            cell.jump = jump;

            snakes--;
        }
        while(ladders != 0) {
            int start = ThreadLocalRandom.current().nextInt(1, cells.length* cells.length);
            int end = ThreadLocalRandom.current().nextInt(1, cells.length* cells.length);

            if(end <= start) continue;

            Jump jump = new Jump(start, end);
            Cell cell = getCell(start);
            cell.jump = jump;

            ladders--;
        }
    }

    public Jump getJump(Cell cell) {
        if (cell.jump != null) return cell.jump;
        return null;
    }


    public Cell getCell(int number) {
        int rowFromTop = (number - 1) / cells.length;
        int rowFromBottom = (cells.length - 1) - rowFromTop;

        int col = (number - 1) % cells.length;
        if ( (cells.length%2 == 0 && rowFromBottom%2 == 0) || (cells.length%2 == 1 && rowFromBottom%2 == 1) ) {
            col = (cells.length - 1) - col;
        }

        return cells[rowFromBottom][col];
    }

}
