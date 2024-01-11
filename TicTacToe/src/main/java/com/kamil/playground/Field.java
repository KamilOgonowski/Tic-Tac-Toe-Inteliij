package com.kamil.playground;

public class Field {

    String sign = "[ ]";
    boolean selected = false;  //possibility to check based on status


    @Override
    public String toString() {
        return sign;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public boolean isSelected() {
        return selected;
    }

//    public void setSelected(boolean selected) {
//        this.selected = selected;
//    }

    public void setSelected(){
        this.selected = true;
    }


}
