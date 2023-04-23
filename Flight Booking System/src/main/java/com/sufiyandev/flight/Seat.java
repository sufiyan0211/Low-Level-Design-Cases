package com.sufiyandev.flight;

public class Seat {
    private int seatNumber;
    private ClassName className;
    private SeatStatus seatStatus;

    public int getSeatNumber() {
        return seatNumber;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public ClassName getClassName() {
        return className;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setClassName(ClassName className) {
        this.className = className;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }
}
