package org.example;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author sofiyan
 */
public class Dice {
    private int countDice;
    private final static int minValueOfDice = 1;
    private final static int maxValueOfDice = 6;


    public Dice(int countDice) {
        this.countDice = countDice;
    }

    public int getCountDice() {
        return countDice;
    }

    public void setCountDice(int countDice) {
        this.countDice = countDice;
    }

    public Dice() {
    }

    public int rollDice() {
        int result = 0;
        for(int dice=0; dice<countDice;dice++) {
            int randomNumber = ThreadLocalRandom.current().nextInt(minValueOfDice, maxValueOfDice+1);
            result += randomNumber;
        }
        return result;
    }
}
