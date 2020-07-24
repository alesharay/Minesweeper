package swe.group_nine.view;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import swe.group_nine.controller.GameController;
import swe.group_nine.controller.Square;
import swe.group_nine.model.GameModel;

import java.io.IOException;

public class GameView {
    private GameModel model;
    private GameController controller;

    private Stage primaryStage;
    private boolean stageInitialized;

    private GridPane gridPane;
    private boolean gridPaneInitialized;

    public GameView(Stage primaryStage) throws IOException {
        // Parent root = FXMLLoader.load(getClass().getResource("/View.fxml"));
        this.model = new GameModel();
        this.controller = new GameController();
        this.primaryStage = primaryStage;

        this.gridPane = new GridPane();
        this.gridPane.setAlignment(Pos.CENTER);
        this.gridPaneInitialized = true;
        setGridPane();

        this.primaryStage = primaryStage;
        this.stageInitialized = true;
        setStage();
    }

    public void setGridPane() {
        if( !model.gridIsSet()) { throw new IllegalStateException("Grid Not Set!"); }
        else if( !gridPaneInitialized) { throw new IllegalStateException("GridPane Not Initialized!"); }
        else {
            for(int x = 0; x < model.getRows(); x++) {
                for(int y = 0; y < model.getCols(); y++) {
                    gridPane.add(model.getGrid()[x][y], x, y);
                }
            }
        }
    }

    public void setStage() {
        if( !stageInitialized) { throw new IllegalStateException("Stage Not Initialized!"); }
        else if( !gridPaneInitialized) { throw new IllegalStateException("GridPane Not NotInitialized!"); }
        else {
            primaryStage.setTitle("Minesweeper");
            primaryStage.setScene(new Scene(gridPane, model.getWIDTH(), model.getHEIGHT()));
        }
    }

    public Stage getStage() { return primaryStage; }

    public void show() throws IOException {
        primaryStage.show();
    }
}
