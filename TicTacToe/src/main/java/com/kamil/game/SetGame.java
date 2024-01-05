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

    public SetGame(){
        setBoard();
        setParticipants();
    }


    public void setParticipants(){
        int numberOfPlayers = Console.getInputInt("How many players will play?");
        for (int i=1; i<=numberOfPlayers; i++){
            String name = Console.getInput("Please provide name for player " + i);
            String sign = Console.getInput("Please provide sign for player " + i);
            players.add(new Player(name, sign));
        }
    }

    public void setBoard(){
        int sizeOfBoard = Console.getInputInt("Specify size of board");
        this.board = new Board(sizeOfBoard);
    }

    public void showBoard(){
        board.showBoard();
    }

    public void showPlayers(){
        for(Player player:players)
            System.out.println(player);
    }

    public void playGame(){
        boolean continuePlay = true;
        while(continuePlay){
            for(Player player : players){
                showBoard();
                System.out.println(player.getName() + " your turn!");
                int rowIndex = Console.getInputInt("Please provide row (1-" + board.getSize()+")");
                int columnIndex = Console.getInputInt("Please provide column (1-" + board.getSize()+")");
                Field fieldToBeUpdated = board.selectField(rowIndex,columnIndex);
                fieldToBeUpdated.setSign("["+player.getSign()+"]");
                if(hasWon(player) || hasWonVertically(player)) {
                    showBoard();
                    continuePlay=false;
                    break;
                }
            }
        }
    }

//for iteration through columns it might be a good idea to replace axis X by Y, to use the same mechanism, but I will try to go with two approaches
    public boolean hasWon(Player player){

        int result = 0;
        System.out.println("I am checking if " + player.getName() + " has won the game.");
        String playerSign = "["+player.getSign()+"]";  // make a change in relaiton to the sign used in field

        for(Row row : board.rows){
            for(int i =0; i<board.getSize(); i++){
                if(row.fields.get(i).getSign().equals(playerSign)) {
                    result += 1;
                }else
                    result=0;

                if(result==3){
                    System.out.println(player.getName() + " has won and has " + result + " points");
                    return true;
                            }
                        }
                    }
        System.out.println("No win after this round for " + player.getName());
        return false;
    }

    public boolean hasWonVertically(Player player){
        int result=0;
        System.out.println("I am checking if " + player.getName() + " has won the game.");
        String playerSign = "["+player.getSign()+"]";  // make a change in relation to the sign used in field //move it later up

        for(int i = 0; i<board.getSize(); i++){
            for (Row row : board.rows){
                if(row.fields.get(i).getSign().equals(playerSign)){
                    result+=1;
                }else{
                    result=0;
                }
                if(result==3){
                    System.out.println(player.getName() + " has won and has " + result + " points");
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasWonDiagonally(Player player){
        int result=0;
        int columnLeftDirection = 0;
        System.out.println("I am checking if " + player.getName() + " has won the game.");
        String playerSign = "["+player.getSign()+"]";  // make a change in relation to the sign used in field //move it later up

        for(Row row : board.rows){
            for(int column = columnLeftDirection; column< board.getSize(); column++){
                if(row.fields.get(column).getSign().equals(playerSign)){
                    result+=1;
                    if(columnLeftDirection-1>=0){
                        columnLeftDirection-=1;
                    }

                }
            }
//            column=0;

        }
        return false;
    }
    public boolean diagonallyLeft(){
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
