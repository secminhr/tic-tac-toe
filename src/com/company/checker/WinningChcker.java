package com.company.checker;

import com.company.Board;
import com.company.mark.Mark;

public interface WinningChcker {
    public boolean hasWinner(Board board);
    public Mark winningMark();
}
