package swe.group_nine.controller;

import swe.group_nine.model.GameModel;
import swe.group_nine.view.GameView;

public class GameController extends AbstractController {
    GameView view;
    GameModel model;

    boolean gameWon;
    boolean gameLost;

    public GameController() {
        gameWon = false;
        gameLost = false;
    }

    public void startGame() {}

    public void resetGame() {}
    
		public boolean gameOver() {
        return gameWon || gameLost;
    }
}
