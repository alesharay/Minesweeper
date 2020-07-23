package swe.group_nine.model;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import swe.group_nine.controller.Square;

import java.io.IOException;

public class GameModel extends AbstractModel {
    private Stage primaryStage;
    private boolean stageIsSet;
    private GridPane gridPane;
    private boolean gridPaneIsSet;

    private int WIDTH;
    private int HEIGHT;
    private int rows;
    private int cols;
    private int SQUARE_SIZE;
    private static Square[][] grid;

    public GameModel() throws IOException {
        // Parent root = FXMLLoader.load(getClass().getResource("/View.fxml"));
        stageIsSet = false;
        gridPaneIsSet = false;
    }

    public GameModel(Stage primaryStage) throws IOException {
        this.gridPane = new GridPane();
        this.SQUARE_SIZE = 50;
        this.WIDTH = 500;
        this.HEIGHT = 500;
        this.rows = WIDTH / SQUARE_SIZE;
        this.cols = HEIGHT / SQUARE_SIZE;
        this.grid = new Square[rows][cols];
        this.primaryStage = primaryStage;
        this.stageIsSet = true;
        setGrid();
        this.gridPaneIsSet = true;
        setStage();
    }

   public void setDifficulty() { }

    public void setGrid() {
        for(int x = 0; x < rows; x++) {
            for(int y = 0; y < cols; y++) {
                Square square = new Square(x, y, (Math.random() < .2));
                square.setPrefSize(SQUARE_SIZE, SQUARE_SIZE);
                gridPane.add(square, x, y);
                System.out.printf("%nSquare Location: [%d,%d]",x,y);
                System.out.println("  Square has mine: " + square.hasMine());
            }
        }
    }

    public static Square[][] getGrid() { return grid; }

    public void setStage() {
        if( !stageIsSet ) { throw new IllegalStateException("Stage Not Set!"); }
        else if( !gridPaneIsSet ) { throw new IllegalStateException("GridPane Not Set!"); }
        else {
            primaryStage.setTitle("Minesweeper");
            primaryStage.setScene(new Scene(gridPane));
        }
    }

    public Stage getStage() { return primaryStage; }
}
