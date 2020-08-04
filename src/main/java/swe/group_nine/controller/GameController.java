package swe.group_nine.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import swe.group_nine.model.Difficulty;
import swe.group_nine.model.GameModel;

import java.io.InputStream;

/**
 * The GameController class implements the control logic for the minesweeper game.
 *
 * @author Alesha Ray
 * @author Francisco Santos-Andujar
 * @author Timothy Wood
 */
public class GameController extends AbstractController {
    private final GameModel model;
    private TextField mineCount;

    public static Button reset;
    public static Timer timer;
    public static ComboBox<Difficulty> diffDropDown;

    /**
     * Constructor for the GameController class
     * @param difficulty the difficulty selection for the Minesweeper game
     */
    public GameController(Difficulty difficulty) {
        ObservableList<Difficulty> diffOptions = FXCollections.observableArrayList(Difficulty.EASY, Difficulty.MEDIUM,
        Difficulty.HARD);
        diffDropDown = new ComboBox(diffOptions);
        model = new GameModel(difficulty);
        reset = new Button("reset");
        mineCount = new TextField();
    }

    /**
     * Returns the difficulty drop down selection
     * @return the difficulty drop down selection
     */
    public ComboBox<Difficulty> getDiffDropDown() {

        diffDropDown.setPrefSize(100, 20);
        return diffDropDown;
    }

    /**
     * Returns the reset button for the Minesweeper Game
     * @return the reset button for the minesweeper game
     */
    public Button getReset() {
        InputStream input = getClass().getResourceAsStream("/straight.png");
        Image image = new Image(input, 30, 30, true, true);
        ImageView imageView = new ImageView(image);

        reset = new Button();
        reset.setGraphic(imageView);
        reset.setOnAction(e -> {
          timer.start();
          model.reset();
          mineCount.setText(String.valueOf(GameModel.mineCount));
        });
        return reset;
  }

    /**
     * Returns the text field holding the total mine count for the current instance of the Minesweeper Game
     * @return the text field holding the total mine count for the current instance of the Minesweeper game
     */
    public TextField getMineCountField() {
      mineCount = new TextField();
      mineCount.setText(String.valueOf(GameModel.mineCount));
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

    @Override
    public GameModel getModel() { return model; }
}
