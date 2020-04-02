package com.company.mark;

public class Cross implements Mark {

    @Override
    public boolean isSameTypeAs(Mark m) {
        return m instanceof Cross;
    }

    @Override
    public String toString() {
        return "\u2715"; //cross unicode
    }
}
