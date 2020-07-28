package swe.group_nine;

import javafx.application.Application;
import javafx.stage.Stage;
import swe.group_nine.controller.GameController;
import swe.group_nine.view.GameView;

/**
 * The Minesweeper class launches the Minesweeper game.
 *
 * @author Alesha Ray
 * @author Francisco Santos-Andujar
 * @author Timothy Wood
 *
 * @since  2020-07-16
 */
public class Minesweeper extends Application {
    public GameController controller;
    public GameView view;

    @Override
    public void start(Stage primaryStage) throws Exception{
        view = new GameView( primaryStage );
        view.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}