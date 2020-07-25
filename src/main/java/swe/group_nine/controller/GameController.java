package swe.group_nine.controller;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import swe.group_nine.model.GameModel;

import java.io.IOException;

public class GameController extends AbstractController {
    GameModel model;

    Button reset;
    TextField mineCount;
    TextField timer;

    int revealedSquares;
    boolean gameWon;
    boolean gameOver;

    public GameController(GameModel model) {
        this.model = model;

        reset = new Button("reset");
        mineCount = new TextField();
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
        mineCount.setText(String.valueOf(model.getMineCount()));
        mineCount.setAlignment(Pos.CENTER);
        mineCount.setEditable(false);
        mineCount.setPrefSize(100, 20);
        return mineCount;
    }

    public TextField getTimer() {
        timer = new TextField();
        timer.setEditable(false);
        timer.setPrefSize(100, 20);
        return timer;
    }

    public static void showAllMines(int x, int y) {
        for(Square[] row : GameModel.grid) {
            for(Square square : row) {
                if(square.hasMine()) {
                    boolean gameLosingSquare = square.getLocation()[0] == x &&
                                                  square.getLocation()[1] == y;
                    if(!gameLosingSquare) {
                        square.setText("MINE");
                        square.setStyle(
                          "-fx-background-color: #fffbf2; " +
                            "-fx-text-fill: black;" +
                            "-fx-font-size: 10"
                        );
                        square.setDisable(true);
                    }
                }
            }
        }
    }

    public static void gameOver() {
        for(Square[] row : GameModel.grid) {
            for (Square square : row) {
                square.disable();
            }
        }
    }
}
