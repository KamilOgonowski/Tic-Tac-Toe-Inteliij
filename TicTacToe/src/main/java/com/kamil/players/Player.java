package com.kamil.players;

public class Player {

    String name;
    String sign;


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }

    public Player(String name, String sign) {
        this.name = name;
        this.sign = sign;
    }
}
