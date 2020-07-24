package swe.group_nine.controller;

public class GameController extends AbstractController {
    boolean gameWon;
    boolean gameLost;

    public GameController() {
        gameWon = false;
        gameLost = false;
    }

    public void startGame() {}

    public void resetGame() {}

    public void chooseSquare() {}

    private void update(){}

    public boolean gameOver() {
        return gameWon || gameLost;
    }
}
