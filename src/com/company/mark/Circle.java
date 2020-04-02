package com.company.mark;

public class Circle implements Mark {

    @Override
    public boolean isSameTypeAs(Mark m) {
        return m instanceof Circle;
    }

    @Override
    public String toString() {
        return "\u25CB"; //circle unicode
    }
}
