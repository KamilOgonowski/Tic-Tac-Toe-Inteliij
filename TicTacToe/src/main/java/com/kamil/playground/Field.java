package com.kamil.playground;

public class Field {

    String sign = "[ ]";
    boolean selected = false;  //possibility to check based on status

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return sign;
    }
}
