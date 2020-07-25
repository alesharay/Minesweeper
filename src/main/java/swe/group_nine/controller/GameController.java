package swe.group_nine.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import swe.group_nine.model.GameModel;

import java.io.IOException;

public class GameController extends AbstractController {
    GameModel model;
    Square[][] grid;

    Button reset;
    TextField mineCount;
    TextField timer;

    int revealedSquares;
    boolean gameWon;
    boolean gameOver;

    public GameController(GameModel model) {
        this.model = model;
        grid = this.model.getGrid();

        reset = new Button("reset");
        mineCount = new TextField();
        timer = new TextField();

        revealedSquares = 0;
        gameWon = false;

    }

    public Button getReset() throws IOException {
        reset = new Button("Reset");
        reset.setPrefSize(100, 20);
        reset.setOnAction(e -> {
            try {
                model.reset();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        return reset;
    }

    public TextField getMineCount() {
        mineCount = new TextField();
        mineCount.setPrefSize(100, 20);
        return mineCount;
    }

    public TextField getTimer() {
        timer = new TextField();
        timer.setPrefSize(100, 20);
        return timer;
    }

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
