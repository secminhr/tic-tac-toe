package com.company.mark;

import com.company.Board;
import com.company.WinningChcker;

public class TraditionalChecker implements WinningChcker {

    private Mark winMark = null;

    @Override
    public boolean hasWinner(Board board) {
        for(int i = 0; i <= 2; i++) {
            if(board.sameMarkInRow(i)) {
                winMark = board.getMarkAt(i, 0);
                return true;
            }
            if(board.sameMarkInColumn(i)) {
                winMark = board.getMarkAt(0, i);
                return true;
            }
        }
        if(board.sameMarkLeftTopToRightBottom()) {
            winMark = board.getMarkAt(0, 0);
            return true;
        }
        if(board.sameMarkRightTopToLeftBottom()) {
            winMark = board.getMarkAt(0, 2);
            return true;
        }
        return false;
    }

    @Override
    public Mark winningMark() {
        return winMark;
    }
}
