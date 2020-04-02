package com.company;

import com.company.checker.TraditionalChecker;
import com.company.checker.WinningChcker;

import java.util.Scanner;

public class Main {

    private static WinningChcker checker = new TraditionalChecker();
    private static Board board = new Board(checker);
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while(!board.hasWinner()) {
            turn();
        }
        System.out.println("Winner is: " + board.getWinningMark().toString());
    }

    private static void turn() {
        int x = -1;
        int y = -1;
        while(!inputIsValid(x) || !inputIsValid(y)) {
            System.out.println("Please enter x and y in a row. ex: 2 1");
            x = scanner.nextInt();
            y = scanner.nextInt();
        }
        try {
            board.play(x, y);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        board.displayBoard();
    }

    private static boolean inputIsValid(int in) {
        return in > -1 && in < 3;
    }
}
