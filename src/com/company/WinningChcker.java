package com.company;

import com.company.mark.Mark;

public interface WinningChcker {
    public boolean hasWinner(Board board);
    public Mark winningMark();
}
