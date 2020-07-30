package swe.group_nine.controller;

import javafx.css.PseudoClass;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import swe.group_nine.model.GameModel;

import java.io.IOException;
import java.io.InputStream;

/**
 * The GameController class implements the control logic for the minesweeper game.
 *
 * @author Alesha Ray
 * @author Francisco Santos-Andujar
 * @author Timothy Wood
 */
public class GameController extends AbstractController {
    public static Button reset;

  private PseudoClass empty;
  private GameModel model;
  private int revealedSquares;
  private TextField mineCount;
  private Timer timer;

    /**
     * Constructor for the GameController class
     * @param model the model for the current instance of the Minesweeper Game
     */
    public GameController(GameModel model) {
        this.model = model;

        reset = new Button("reset");
        mineCount = new TextField();
        revealedSquares = 0;
        empty = PseudoClass.getPseudoClass("empty");
    }

    /**
     * Returns the reset button for the Minesweeper Game
     * @return the reset button for the minesweeper game
     */
    public Button getReset() {
        InputStream input = getClass().getResourceAsStream("/happy.png");
        Image image = new Image(input, 25, 25, true, true);
        ImageView imageView = new ImageView(image);

    reset = new Button();
    reset.setGraphic(imageView);
    reset.setOnAction(e -> {
      try {
        timer.start();
        model.reset();
      } catch (IOException ioe) {
        ioe.printStackTrace();
      }
    });
    return reset;
  }

    /**
     * Returns the text field holding the total mine count for the current instance of the Minesweeper Game
     * @return the text field holding the total mine count for the current instance of the Minesweeper game
     */
    public TextField getMineCount() {
        mineCount = new TextField();
        mineCount.setText(String.valueOf(model.getMineCount()));
        mineCount.setAlignment(Pos.CENTER);
        mineCount.setEditable(false);
        mineCount.setPrefSize(100, 20);
        return mineCount;
    }

  /**
   * Returns the text field holding the timer for the Minesweeper game
   * @return the text field holding the timer for the Minesweeper game
   */
  public TextField getTimer() {
    timer = new Timer();
    timer.start();
    return timer.getTimerLabel();
  }

    /**
     * Shows All mines when the game is lost by clicking on a mine
     * @param x the X location of the currently clicked mine
     * @param y the Y location of the currently clicked mine
     */
    public static void showAllMines(int x, int y) {
        for(Square[] row : GameModel.grid) {
            for(Square square : row) {
                if(square.hasMine()) {
                    if(!square.isFlagged()) {
                        boolean gameLosingSquare = square.getLocation()[0] == x &&
                                square.getLocation()[1] == y;
                        if (!gameLosingSquare) {
                            square.setText("MINE");
                            square.setStyle(
                                    "-fx-background-color: #fffbf2;" +
                                            "-fx-text-fill: black;" +
                                            "-fx-font-size: 10"
                            );
                            square.setDisable(true);
                        }
                    }
                } else if(square.isFlagged()) {
                    square.setGraphic(null);
                    square.setText("X");
                    square.setStyle(
                            "-fx-text-size: 10;" +
                            "-fx-text-fill: red;" +
                            "-fx-text-bold: true"
                    );
                    square.setDisable(true);
                }
            }
        }
    }
}
