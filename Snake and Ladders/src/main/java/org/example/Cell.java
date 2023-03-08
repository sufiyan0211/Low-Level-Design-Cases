package org.example;

/**
 *
 * @author sofiyan
 */
public class Cell {
    public Jump jump;

    public Cell() {
    }

    public Cell(Jump jump) {
        this.jump = jump;
    }

    public Jump getJump() {
        return jump;
    }

    public void setJump(Jump jump) {
        this.jump = jump;
    }
}
