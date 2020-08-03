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

/**
 * The GameView class implements the logic allowing the Minesweeper game to be viewed properly.
 *
 * @author Alesha Ray
 * @author Francisco Santos-Andujar
 * @author Timothy Wood
 *
 */
public class GameView implements View {
    private GameModel model;
    private GameController controller;

    private Stage primaryStage;
    private boolean stageInitialized;

    private BorderPane borderPane;

    private GridPane gridPane;
    private boolean gridPaneInitialized;

    private HBox HBox;
    private boolean HBoxInitialized;

    /**
     * Constructor for the GameView class
     * @param primaryStage the stage to which all javafx components will be added
     */
    public GameView(Stage primaryStage) {


        this.model = new GameModel(null);
        this.controller = new GameController(this.model);
        this.primaryStage = primaryStage;

        this.gridPane = new GridPane();
        this.gridPane.setAlignment(Pos.CENTER);
        this.gridPaneInitialized = true;

        this.HBox = new HBox();
        this.HBoxInitialized = true;

        this.borderPane = new BorderPane();
        setBorderPane();

        this.primaryStage = primaryStage;
        this.stageInitialized = true;
        initStage();
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

        HBox.getChildren().addAll(controller.getMineCountField());
        HBox.getChildren().addAll(controller.getDiffDropDown());
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
    public void initStage() {
        if( !stageInitialized ) { throw new IllegalStateException("Stage Not Initialized!"); }
        else if( !gridPaneInitialized ) { throw new IllegalStateException("GridPane Not Initialized!"); }
        else if( !HBoxInitialized) { throw new IllegalStateException("HBoxPane not Initialized!"); }
        else {
            primaryStage.setTitle("Minesweeper");
            primaryStage.setScene(new Scene(this.borderPane, model.getWIDTH(), model.getHEIGHT()));
        }
    }

    /**
     * Show the primary stage of the Minesweeper Game
     */
    @Override
    public void show() {
        primaryStage.show();
    }

    /**
     * Sets the primary stage for the current instance of the Minesweeper game
     * @param primaryStage the primary stage for the current instance of the Minesweeper game
     */
    @Override
    public void setStage(Stage primaryStage) { this.primaryStage = primaryStage; }

    /**
     * Returns the primary stage for the current instance of the Minesweeper game
     * @return the primary stage for the current instance of the Minesweeper game
     */
    @Override
    public Stage getStage() { return primaryStage; }

    /**
     * Sets the model for the current instance of the Minesweeper game
     * @param model the model for the current instance of the Minesweeper game
     */
    @Override
    public void setModel(GameModel model) { this.model = model; }

    /**
     * Gets the model for the current instance of the Minesweeper game
     * @return the model for the current instance of the Minesweeper game
     */
    @Override
    public GameModel getModel() { return model; }

    /**
     * Sets the controller for the current instance of the Minesweeper game
     * @param controller the controller for the current instance of the Minesweeper game
     */
    @Override
    public void setController(GameController controller) { this.controller = controller; }

    /**
     * Gets the controller for the current instance of the Minesweeper game
     * @return the controller for the current instance of the Minesweeper game
     */
    @Override
    public GameController getController() { return controller; }
}
