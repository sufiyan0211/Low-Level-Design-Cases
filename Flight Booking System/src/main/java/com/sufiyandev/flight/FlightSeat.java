package com.sufiyandev.flight;


import com.sufiyandev.user.User;

public class FlightSeat extends Seat{
    private Long price;
    private Currency currency;

    private User user;

    public Long getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
