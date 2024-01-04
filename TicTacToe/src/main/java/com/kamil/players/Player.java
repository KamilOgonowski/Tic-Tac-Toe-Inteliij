package com.kamil.players;

import com.kamil.playground.Board;
import com.kamil.util.Console;

public class Player {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

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

    public String getFieldSelection(){
        return Console.getInput("Please indicate the field you want to mark").trim();
    }
}
