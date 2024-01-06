package com.kamil.game;

import com.kamil.players.Player;
import com.kamil.playground.Board;
import com.kamil.playground.Field;
import com.kamil.playground.Row;
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


    public void setParticipants() {
        int numberOfPlayers = Console.getInputInt("How many players will play?");
        for (int i = 1; i <= numberOfPlayers; i++) {
            String name = Console.getInput("Please provide name for player " + i);
            String sign = Console.getInput("Please provide sign for player " + i);
            players.add(new Player(name, sign));
        }
    }

    public void setBoard() {
        int sizeOfBoard = Console.getInputInt("Specify size of board");
        this.board = new Board(sizeOfBoard);
    }

    public void showBoard() {
        board.showBoard();
    }

    public void showPlayers() {
        for (Player player : players)
            System.out.println(player);
    }

    public void playGame() {
        boolean continuePlay = true;
        while (continuePlay) {
            for (Player player : players) {
                showBoard();
                System.out.println(player.getName() + " your turn!");
                int rowIndex = Console.getInputInt("Please provide row (1-" + board.getSize() + ")")-1;
                int columnIndex = Console.getInputInt("Please provide column (1-" + board.getSize() + ")")-1;
                Field fieldToBeUpdated = board.selectField(rowIndex, columnIndex);
                fieldToBeUpdated.setSign("[" + player.getSign() + "]"); // overwrite to have it cone without concat

                if (hasWon(player) || hasWonVertically(player) || diagonallyLeft(player)) {
                    showBoard();
                    continuePlay = false;
                    break;
                }
            }
        }
    }

    public void playGame1() {
        boolean continuePlay = true;
        while (continuePlay) {
            for (Player player : players) {
                playerPlayingThisTurn = player; // just added to fields
                showBoard();
                System.out.println(player.getName() + " your turn!");
                int rowIndex = Console.getInputInt("Please provide row (1-" + board.getSize() + ")")-1;
                int columnIndex = Console.getInputInt("Please provide column (1-" + board.getSize() + ")")-1;
                Field fieldToBeUpdated = board.selectField(rowIndex, columnIndex);
                fieldToBeUpdated.setSign("[" + player.getSign() + "]"); // overwrite to have it cone without concat

                if(scanTheBoard()){
                    showBoard();
                    continuePlay=false;
                    break;
                }
            }
        }
    }


    public boolean scanTheBoard(){
        boolean winner = false;
        for(int row = 0; row< board.getSize(); row++){
            for(int column = 0; column<board.getSize(); column++){
                if (board.selectField(row, column).getSign().equals(playerPlayingThisTurn.getSign())){
                    if (hasWon1(row,column)){
                        winner = true;
                        return winner;
                    }
                }
            }
        }
        return winner;
    }


    public boolean hasWon1(int row, int column){
        if(hasWonHorizontally(row, column) || hasWonVertically1(row, column) || hasWonDiagonally1() ){
            return true;
        }
        return false; //no winner after this round
    }
    public boolean hasWonHorizontally(int row, int column ) {
        int remainingPoints = pointsRequiredToWin - 1; //move this later up
        for ()



    }



    //for iteration through columns it might be a good idea to replace axis X by Y, to use the same mechanism, but I will try to go with two approaches
    public boolean hasWon(Player player) {

        int result = 0;
        System.out.println("I am checking if " + player.getName() + " has won the game.");
        String playerSign = "[" + player.getSign() + "]";  // make a change in relaiton to the sign used in field

        for (Row row : board.rows) {
            for (int i = 0; i < board.getSize(); i++) {
                if (row.fields.get(i).getSign().equals(playerSign)) {
                    result += 1;
                } else
                    result = 0;

                if (result == 3) {
                    System.out.println(player.getName() + " has won and has " + result + " points");
                    return true;
                }
            }
        }
        System.out.println("No win after this round for " + player.getName());
        return false;
    }

    public boolean hasWonVertically(Player player) {
        int result = 0;
        System.out.println("I am checking if " + player.getName() + " has won the game.");
        String playerSign = "[" + player.getSign() + "]";  // make a change in relation to the sign used in field //move it later up

        for (int i = 0; i < board.getSize(); i++) {
            for (Row row : board.rows) {
                if (row.fields.get(i).getSign().equals(playerSign)) {
                    result += 1;
                } else {
                    result = 0;
                }
                if (result == 3) {
                    System.out.println(player.getName() + " has won and has " + result + " points");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasWonDiagonally(Player player) {
        int result = 0;
        int columnLeftDirection = 0;
        System.out.println("I am checking if " + player.getName() + " has won the game.");
        String playerSign = "[" + player.getSign() + "]";  // make a change in relation to the sign used in field //move it later up

        for (Row row : board.rows) {
            for (int column = columnLeftDirection; column < board.getSize(); column++) {
                if (row.fields.get(column).getSign().equals(playerSign)) {
                    result += 1;
                    if (columnLeftDirection - 1 >= 0) {
                        columnLeftDirection -= 1;
                    }

                }
            }
//            column=0;

        }
        return false;
    }

//    public boolean diagonallyLeft(Player player) {
//        int result = 0;
//        for (int i = 0; i < board.getSize(); i++) {
//            Row currentRow = board.rows.get(i);
//            for (int j = 0; j < board.getSize(); j++) {
//                Field fieldToStartCheckFrom = currentRow.fields.get(j) {
//                    if (fieldToStartCheckFrom.getSign().equals(player.getSign()) {
//
//                    }
//
//                }
//
//            }
//        }
//        return false;
//    }

//    public boolean diagonallyLeft(Player player) {
//        String playerSign = "[" + player.getSign() + "]";
//        int result = 0;
//        for (int i = 0; i < board.getSize(); i++) {
//            Row currentRow = board.rows.get(i);
//            for (int j = 0; j < board.getSize(); j++) {
//                Field fieldToStartCheckFrom = currentRow.fields.get(j);
//                if (fieldToStartCheckFrom.getSign().equals(playerSign)) {
//                    result += 1;
//                    if (i + 1 <= board.getSize() && j - 1 >= 0) {
//                        System.out.println("Jestem tu!");
//                        int wiersz = i +1;
//                        int kolumna = j- 1;
//                        if (board.rows.get(wiersz).fields.get(kolumna).getSign().equals(playerSign)) {
//                            result += 1;
//                            if (wiersz + 1 <= board.getSize() && kolumna - 1 >= 0) {
//                                wiersz += 1;
//                                kolumna -= 1;
//                                if (board.rows.get(wiersz).fields.get(kolumna).getSign().equals(playerSign)) {
//                                    result += 1;
//                                    if (result == 3) {
//                                        System.out.println("Congrats you have reached 3 point left diagonally!. You have won the game");
//                                        return true;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return false;
//    }

    public boolean diagonallyLeft(Player player) {
        String playerSign = "[" + player.getSign() + "]";
        int result = 0;
        for (int i = 0; i < board.getSize(); i++) {
            Row currentRow = board.rows.get(i);
            for (int j = 0; j < board.getSize(); j++) {
                Field fieldToStartCheckFrom = currentRow.fields.get(j);
                if (fieldToStartCheckFrom.getSign().equals(playerSign)) {
                    result += 1;
                    if (i + 1 <= board.getSize() && j - 1 >= 0) {
                        System.out.println("Jestem tu!");
                        int wiersz = i +1;
                        int kolumna = j- 1;
                        if (board.selectField(wiersz, kolumna).getSign().equals(playerSign)) {
                            result += 1;
                            if (wiersz + 1 <= board.getSize() && kolumna - 1 >= 0) {
                                wiersz += 1;
                                kolumna -= 1;
                                if (board.selectField(wiersz, kolumna).getSign().equals(playerSign)) {
                                    result += 1;
                                    if (result == 3) {
                                        System.out.println("Congrats you have reached 3 point left diagonally!. You have won the game");
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }



    /*
    -> if hasWonDiagonally find a sign matching player then invoke diagonallyLeft and diagonallyRight
    -> diagonLeft need index of row where the sign has been found to reduce it by 1 (if this is still bigger than 0)
    -> diagonLeft needs index of column where the sign was found to reduce it by 1 (if this is still bigger than 0)
    -> it needs to check whether the field having this new coordinates has been selected by the player (has its sign)
       if yes point should be added and another invoke of diagonLeft(), otherwise the points should be removed, and
       iteration should be continued inner loop through columns/fields, and outer loop through rows.
    -> when player sign will be found once again check should be performed

     */
}
