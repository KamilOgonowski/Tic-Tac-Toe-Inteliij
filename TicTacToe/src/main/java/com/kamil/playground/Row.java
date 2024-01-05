package com.kamil.playground;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Row {
    public List<Field> fields = new ArrayList<>();  // - remember to change modifier and use set/get

    public Row(int size){
        for (int i =0; i<size; i++){
            fields.add(new Field());
        }
    }

//    public void showRow(){
//        Iterator<Field> iterator = fields.iterator();
//        while(iterator.hasNext()) {
//            Field field = iterator.next();
//            System.out.print(field);
//        }
//    }


    public void showRow(){
        for (Field field : fields) {
            System.out.print(field);
        }
    }
}
