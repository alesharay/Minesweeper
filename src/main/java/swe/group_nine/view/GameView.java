package swe.group_nine.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import swe.group_nine.controller.GameController;
import swe.group_nine.model.GameModel;

import java.io.IOException;

/**
 * The GameView class implements the logic allowing the Minesweeper game to be viewed properly.
 *
 * @author Alesha Ray
 * @author Francisco Santos-Andujar
 * @author Timothy Wood
 *
 */
public class GameView {
    private GameModel model;
    private GameController controller;

    private Stage primaryStage;
    private boolean stageInitialized;

    private BorderPane borderPane;
    private boolean borderPaneInitialized;

    private GridPane gridPane;
    private boolean gridPaneInitialized;

    private HBox HBox;
    private boolean HBoxInitialized;

    /**
     * Constructor for the GameView class
     * @param primaryStage the stage to which all javafx components will be added
     */
    public GameView(Stage primaryStage) {
        // Parent root = FXMLLoader.load(getClass().getResource("/View.fxml"));
        this.model = new GameModel();
        this.controller = new GameController(this.model);
        this.primaryStage = primaryStage;

        this.gridPane = new GridPane();
        this.gridPane.setAlignment(Pos.CENTER);
        this.gridPaneInitialized = true;

        this.HBox = new HBox();
        this.HBoxInitialized = true;

        this.borderPane = new BorderPane();
        this.borderPaneInitialized = true;
        setBorderPane();

        this.primaryStage = primaryStage;
        this.stageInitialized = true;
        setStage();
    }


    /**
     * Sets the GridPane that the squares will be placed on
     */
    public void setGridPane() {
        if( !model.gridIsSet()) { throw new IllegalStateException("Grid Not Set!"); }
        else if( !gridPaneInitialized) { throw new IllegalStateException("GridPane Not Initialized!"); }
        else {
            for(int x = 0; x < model.getRows(); x++) {
                for(int y = 0; y < model.getCols(); y++) {
                    gridPane.add(GameModel.grid[x][y], x, y);
                }
            }
        }
    }

    /**
     * Sets the HBoxPane for the Timer, Reset and Mine count
     */
    public void setHBoxPane() {
        setGridPane();
        int spacing = (model.getWIDTH() / 10) + 20;
        this.HBox.setPadding(new Insets(15, 12, 15, 12));
        this.HBox.setAlignment(Pos.CENTER);
        this.HBox.setSpacing(spacing);
        this.HBox.setStyle("-fx-background-color: #696969;");

        HBox.getChildren().addAll(controller.getMineCount());
        HBox.getChildren().addAll(controller.getReset());
        HBox.getChildren().addAll(controller.getTimer());
    }

    /**
     * Sets the BorderPane to allow for effortless layout
     */
    public void setBorderPane() {
        setHBoxPane();
        this.borderPane.setTop(this.HBox);

        borderPane.setCenter(this.gridPane);
    }

    /**
     * Sets the primary stage for the Minesweeper Game
     */
    public void setStage() {
        if( !stageInitialized ) { throw new IllegalStateException("Stage Not Initialized!"); }
        else if( !gridPaneInitialized ) { throw new IllegalStateException("GridPane Not Initialized!"); }
        else if( !HBoxInitialized) { throw new IllegalStateException("HBoxPane not Initialized!"); }
        else {
            primaryStage.setTitle("Minesweeper");
            primaryStage.setScene(new Scene(this.borderPane, model.getWIDTH(), model.getHEIGHT()));
        }
    }

    /**
     * Gets the GameController for the current instance of the Minesweeper Game
     * @return the controller for the current instance of the Minesweeper game
     */
    public GameController getController() { return controller; }

    /**
     * Show the primary stage of the Minesweeper Game
     */
    public void show() {
        primaryStage.show();
    }
}