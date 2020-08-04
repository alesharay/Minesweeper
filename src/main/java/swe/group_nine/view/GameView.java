package swe.group_nine.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import swe.group_nine.Minesweeper;
import swe.group_nine.controller.GameController;
import swe.group_nine.model.Difficulty;
import swe.group_nine.model.GameModel;

/**
 * The GameView class implements the logic allowing the Minesweeper game to be viewed properly.
 *
 * @author Alesha Ray
 * @author Francisco Santos-Andujar
 * @author Timothy Wood
 *
 */
public class GameView extends AbstractView {
    private boolean stageInitialized;

    private BorderPane borderPane;

    private GridPane gridPane;
    private boolean gridPaneInitialized;

    private HBox HBox;
    private boolean HBoxInitialized;

    /**
     * Constructor for the GameView class
     */
    public GameView() {
        controller = new GameController(Difficulty.EASY);
        model = controller.getModel();

        controller.getDiffDropDown().setOnAction(e -> setDifficutly());

        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPaneInitialized = true;

        HBox = new HBox();
        HBoxInitialized = true;

        borderPane = new BorderPane();
        setBorderPane();

        stageInitialized = true;
        initStage();
    }

    public void setDifficutly() {
        Difficulty difficulty = controller.getDiffDropDown().getValue();

        switch(difficulty) {
            case HARD:
                model.setDifficulty(Difficulty.HARD);
                restart(Difficulty.HARD);
                break;
            case MEDIUM:
                model.setDifficulty(Difficulty.MEDIUM);
                restart(Difficulty.MEDIUM);
                break;
            case EASY:
            default:
                model.setDifficulty(Difficulty.EASY);
                restart(Difficulty.EASY);
                break;
        }
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
            Minesweeper.primaryStage.setTitle("Minesweeper");
            Minesweeper.primaryStage.setScene(new Scene(this.borderPane, model.getWIDTH(), model.getHEIGHT()));
        }
    }

    /**
     * Show the primary stage of the Minesweeper Game
     */
    @Override
    public void show() {
        Minesweeper.primaryStage.show();
    }

    /**
     * Restarts the game based on the difficulty chosen
     * @param difficulty the difficult (Easy, Medium, Hard) of the Minesweeper game
     */
    public void restart(Difficulty difficulty) {
        controller = new GameController(difficulty);
        model = controller.getModel();
        controller.getDiffDropDown().setOnAction(e -> setDifficutly());

        this.gridPane = new GridPane();
        this.gridPane.setAlignment(Pos.CENTER);
        this.gridPaneInitialized = true;

        this.HBox = new HBox();
        this.HBoxInitialized = true;

        this.borderPane = new BorderPane();
        setBorderPane();

        this.stageInitialized = true;
        initStage();
    }
}
