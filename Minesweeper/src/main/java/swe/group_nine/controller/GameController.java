package swe.group_nine.controller;

import javafx.stage.Stage;
import swe.group_nine.model.GameModel;

import java.util.ArrayList;

public class GameController extends AbstractController {
    GameModel model;
    Square[][] grid;

    int revealedSquares;
    boolean gameWon;
    boolean gameOver;

    public GameController(GameModel model) {
        this.model = model;
        grid = this.model.getGrid();

        revealedSquares = 0;
        gameWon = false;

    }

    public void resetGame() {}
    
    private void showAllMines() {
        for(Square[] row : grid) {
            for(Square square : row) {
                if(square.hasMine()) {
                    square.setText("MINE");
                    square.setStyle("-fx-background-color: red; -fx-text-fill: white");
                    square.setDisable(true);
                }
            }
        }
    }

//    public void reveal(Square square) {
//        ArrayList<Square> neighbors = square.getNeighbors();
//
//        if(square.hasMine()) {
//            square.setText("MINE");
//            square.setStyle("-fx-background-color: red; -fx-text-fill: white");
//            square.setDisable(true);
//        }
//        else if(square.getNeighborMineCount() > 0) {
//            square.setText(String.valueOf(square.getNeighborMineCount()));
//            square.setDisable(true); }
//        else {
//            for (Square neighbor : neighbors) {
//                if (!neighbor.hasMine()) {
//                    if (neighbor.getNeighborMineCount() == 0) {
//
//                        neighbor.setDisable(true);
//                    } else {
//                        neighbor.setText(String.valueOf(neighbor.getNeighborMineCount()));
//                        neighbor.setDisable(true);
//                    }
//                }
//            }
//        }
//    }
}
