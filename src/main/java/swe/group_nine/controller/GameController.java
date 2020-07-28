package swe.group_nine.controller;

import swe.group_nine.model.GameModel;

public class GameController extends AbstractController {
    GameModel model;

    int revealedSquares;
    boolean gameWon;
    boolean gameOver;

    public GameController(GameModel model) {
        this.model = model;
        GameModel.grid = this.model.getGrid();

        revealedSquares = 0;
        gameWon = false;
        gameOver = false;
    }

    public void resetGame() {}
    
    public static void showAllMines(int x, int y) {
        for(Square[] row : GameModel.grid) {
            for(Square square : row) {
                if(square.hasMine()) {
                    square.setText("MINE");
                    square.setStyle("-fx-background-color: red; -fx-text-fill: white");
                    square.setDisable(true);
                }
            }
        }
    }

    public static void gameOver() {
        for(Square[] row : GameModel.grid) {
            for (Square square : row) {
                square.setDisable(true);
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
