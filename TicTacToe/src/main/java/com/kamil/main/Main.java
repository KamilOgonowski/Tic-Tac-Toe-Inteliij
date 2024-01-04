package com.kamil.main;

import com.kamil.game.SetGame;


public class Main {
    public static void main(String[] args) {

        SetGame game = new SetGame();
        game.showPlayers();
        game.playYourTurn();
    }
}