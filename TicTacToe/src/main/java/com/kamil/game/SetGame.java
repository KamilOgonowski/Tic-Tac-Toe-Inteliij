package com.kamil.game;

import com.kamil.players.Player;
import com.kamil.playground.Board;
import com.kamil.util.Console;

import java.util.ArrayList;
import java.util.List;

public class SetGame {
    Board board;
    List<Player> players = new ArrayList<>();

    public SetGame(){
        setBoard();
        setParticipants();
    }


    public void setParticipants(){
        int numberOfPlayers = Console.getInputInt("How many players will be played?");
        for (int i=1; i<=numberOfPlayers; i++){
            String name = Console.getInput("Please provide name for player " + i);
            String sign = Console.getInput("Please provide sign for player " + i);
            players.add(new Player(name, sign));
        }
    }

    public void setBoard(){
        int sizeOfBoard = Console.getInputInt("Specify size of board: ");
        this.board = new Board(sizeOfBoard);
    }

    public void showBoard(){
        board.showBoard();
    }

    public void showPlayers(){
        for(Player player:players)
            System.out.println(player);
    }
}
