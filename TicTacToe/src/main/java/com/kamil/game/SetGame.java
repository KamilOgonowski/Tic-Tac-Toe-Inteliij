package com.kamil.game;

import com.kamil.players.Player;
import com.kamil.playground.Board;
import com.kamil.playground.Field;
import com.kamil.util.Console;
import java.util.ArrayList;
import java.util.List;

public class SetGame {
    Board board;
    List<Player> players = new ArrayList<>();
    Player playerPlayingThisTurn;
    int pointsRequiredToWin;


    public SetGame() {
        setBoard();
        setParticipants();
    }

    public void setBoard() {
        int sizeOfBoard = Console.getInputInt("Specify size of board");
        this.board = new Board(sizeOfBoard);
        setPointsRequiredToWin();
    }

    public void setParticipants() {
        int numberOfPlayers = Console.getInputInt("How many players will play");
        for (int i = 1; i <= numberOfPlayers; i++) {
            String name = Console.getInput("Please provide name for player " + i);
            String sign = Console.getInput("Please provide sign for player " + i);
            sign = "["+sign+"]";
            players.add(new Player(name, sign));
        }
    }

    public void setPointsRequiredToWin(){
        pointsRequiredToWin = Console.getInputInt("How many points are needed to win the game [1- "+board.getSize()+"]?",board.getSize());
    }

    public void showPlayers() {
        for (Player player : players)
            System.out.println(player);
    }

    public void playGame() {
        boolean continuePlay = true;
        while (continuePlay) {
            for (Player player : players) {
                playerPlayingThisTurn = player;
                board.showBoard();
                System.out.println(player.getName() + " your turn!");

                if(!selectField()){
                    System.out.println("Player: " + playerPlayingThisTurn + " has not provided correct value in three attempts.\nThe application has been closed");
                    continuePlay=false;
                    break;
                }

                if (scanTheBoard()) {
                    board.showBoard();
                    continuePlay = false;
                    System.out.println(player.getName() + " has just won the game!!");
                    break;
                }
            }
        }
    }

    public boolean scanTheBoard() {
        boolean winner = false; // added for better readability
        for (int row = 0; row < board.getSize(); row++) {
            for (int column = 0; column < board.getSize(); column++) {
                if (board.selectField(row, column).getSign().equals(playerPlayingThisTurn.getSign())) {
                    if (hasWonTheGame(row, column)) {
                        winner = true;
                        return winner;
                    }
                }
            }
        }
        return winner;
    }


    public boolean selectField(){
        while(true){
            int counter = 3;
            int rowIndex = Console.getInputInt("Please provide row (1-" + board.getSize() + ")" , board.getSize());// - 1;
            if (rowIndex==-1){
//                System.out.println("The user has not provided correct value in three attempts.\nThe application has been closed");
                return false;
            }
            int columnIndex = Console.getInputInt("Please provide column (1-" + board.getSize() + ")", board.getSize()); // - 1;
            if(columnIndex==-1){
//                System.out.println("The user has not provided correct value in three attempts.\nThe application has been closed");
                return false;
            }

            Field fieldToBeUpdated = board.selectField(rowIndex-1, columnIndex-1);
            if(fieldToBeUpdated.isSelected()) {
                System.out.println("The field you chose has been already selected - please try again");
                continue;
            }
            fieldToBeUpdated.setSelected(); // for additional check
            fieldToBeUpdated.setSign(playerPlayingThisTurn.getSign());
            return true;
        }
    }

    public boolean hasWonTheGame(int row, int column) {
        if (hasWonHorizontally(row, column) || hasWonVertically1(row, column) || hasWonDiagonally1(row, column)) { // || hasWonDiagonally1(row, column))
            return true;
        }
        return false; //no winner after this round
    }

    public boolean hasWonHorizontally(int row, int column) {
        int columnToBeChecked = column;
        int remainingPoints = pointsRequiredToWin - 1; //move this later up

        for (int i = remainingPoints; i > 0; i--) {
            if (columnToBeChecked + 1 < board.getSize()) { // check if the potential increase is still in range of board's size
                columnToBeChecked += 1;
                if (board.selectField(row, columnToBeChecked).getSign().equals(playerPlayingThisTurn.getSign())) {
                    continue; // better readability - temporary
                } else
                    return false;
            }
            return false;
        }
        System.out.println("Horizontal win!");
        return true;
    }


    public boolean hasWonVertically1(int row, int column) {
        int rowToBeChecked = row;

        int remainingPoints = pointsRequiredToWin - 1; //move this later up
        for (int i = remainingPoints; i > 0; i--) {
            if (rowToBeChecked + 1 < board.getSize()) { // check if the potential increase is still in range of board's size
                rowToBeChecked += 1;
                if (board.selectField(rowToBeChecked, column).getSign().equals(playerPlayingThisTurn.getSign())) {
                    continue; // better readability - temporary
                } else
                    return false;
            }
            return false;
        }
        System.out.println("Vertical win!");
        return true;
    }

    public boolean hasWonDiagonally1(int row, int column) {
        return diagonallyLeft(row, column) || diagonallyRight(row, column);
    }

    public boolean diagonallyLeft(int row, int column) {

        int rowToBeChecked = row;
        int columnToBeChecked = column;

        int remainingPoints = pointsRequiredToWin - 1; //move this later up
        for (int i = remainingPoints; i > 0; i--) {
            if (rowToBeChecked + 1 < board.getSize() && columnToBeChecked - 1 >= 0) { // check if the potential increase is still in range of board's size
                rowToBeChecked += 1;
                columnToBeChecked -= 1;
                if (board.selectField(rowToBeChecked, columnToBeChecked).getSign().equals(playerPlayingThisTurn.getSign())) {
                    continue; // better readability - temporary
                } else
                    return false;
            }
            return false;
        }
        System.out.println("diagonallyLeft win!");
        return true;
    }

    public boolean diagonallyRight(int row, int column) {

        int rowToBeChecked = row;
        int columnToBeChecked = column;

        int remainingPoints = pointsRequiredToWin - 1; //move this later up
        for (int i = remainingPoints; i > 0; i--) {
            if (rowToBeChecked + 1 < board.getSize() && columnToBeChecked + 1 < board.getSize()) { // check if the potential increase is still in range of board's size
                rowToBeChecked += 1;
                columnToBeChecked += 1;
                if (board.selectField(rowToBeChecked, columnToBeChecked).getSign().equals(playerPlayingThisTurn.getSign())) {
                    continue; // better readability - temporary
                } else
                    return false;
            }
            return false;
        }
        System.out.println("diagonallyRight win!");
        return true;
    }
}
