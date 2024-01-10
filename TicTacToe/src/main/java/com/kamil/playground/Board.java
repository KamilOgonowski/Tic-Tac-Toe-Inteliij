package com.kamil.playground;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Board {

    public List<Row> rows = new ArrayList<>();

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    int size;
     public Board(int size){
         this.size = size;
         for(int i = 0; i < size; i++){
             rows.add(new Row(size));
         }
     }

     public void showBoard(){
         Iterator<Row> iterator = rows.iterator();
         while(iterator.hasNext()) {
             Row row = iterator.next();
             row.showRow();
             System.out.println();
         }
     }

    public void showBoard2(){
         for(Row row : rows){
             row.showRow();
             System.out.println();
         }
    }

    public Field selectField(int row, int column){
         Row rowToUpdate = rows.get(row);
         Field fieldToBeUpdated  = rowToUpdate.fields.get(column);
         return fieldToBeUpdated ;
         }
    }



