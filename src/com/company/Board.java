package com.company;

import com.company.mark.Circle;
import com.company.mark.Cross;
import com.company.mark.Mark;

import java.util.Arrays;

public class Board {
    private Mark[][] marks;
    private WinningChcker checker;
    private Mark currentMark = new Circle();

    public Board(WinningChcker checker) {
        this.marks = new Mark[3][3];
        this.checker = checker;
    }

    public void play(int x, int y) throws IllegalArgumentException {
        play(currentMark, x, y);
        switchCurrentMark();
    }

    private void play(Mark m, int x, int y) throws IllegalArgumentException {
        if(marks[x][y] != null) {
            throw new IllegalArgumentException("There's already a mark on specified position.");
        }
        marks[x][y] = m;
    }

    private void switchCurrentMark() {
        if(currentMark instanceof Circle) {
            currentMark = new Cross();
        } else {
            currentMark = new Circle();
        }
    }

    public boolean hasWinner() {
        return checker.hasWinner(this);
    }

    public Mark getWinningMark() {
        return checker.winningMark();
    }

    public boolean sameMarkInRow(int index) {
        if(!indexIsValid(index)) {
            return false;
        }
        Mark[] row = marks[index];
        return sameMarkInArray(row);
    }

    public boolean sameMarkInColumn(int index) {
        if(!indexIsValid(index)) {
            return false;
        }
        Mark[] column = Arrays.stream(marks).map(row -> row[index]).toArray(Mark[]::new);

        return sameMarkInArray(column);
    }

    public boolean sameMarkLeftTopToRightBottom() {
        Mark[] list = new Mark[] { marks[0][0], marks[1][1], marks[2][2] };
        return sameMarkInArray(list);
    }

    public boolean sameMarkRightTopToLeftBottom() {
        Mark[] list = new Mark[] { marks[0][2], marks[1][1], marks[2][0] };
        return sameMarkInArray(list);
    }

    private boolean indexIsValid(int index) {
        return index > -1 && index < 3;
    }

    private boolean sameMarkInArray(Mark[] marks) {
        Mark first = marks[0];
        if(first == null) {
            return false;
        }
        for(int i = 1; i < marks.length; i++) {
            Mark mark = marks[i];
            if(mark == null) {
                return false;
            }
            if(!mark.isSameTypeAs(first)) {
                return false;
            }
        }
        return true;
    }

    public Mark getMarkAt(int x, int y) {
        return marks[x][y];
    }

    public void displayBoard() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        String[][] representation =
                Arrays.stream(marks)
                        .map(row ->
                            Arrays.stream(row)
                                    .map(this::markToString)
                                    .toArray(String[]::new)
                        )
                        .toArray(String[][]::new);

        String output = "";
        for(String[] row: representation) {
            for(int i = 0; i < row.length; i++) {
                output += row[i];
                if(i == row.length - 1) {
                    output += "\n";
                } else {
                    output += "|";
                }
            }
        }
        return output;
    }

    private String markToString(Mark m) {
        if(m == null) {
            return "_";
        } else {
            return m.toString();
        }
    }
}
