package swe.group_nine.model;

import javafx.stage.Stage;
import swe.group_nine.controller.Square;

import java.io.IOException;

public class GameModel extends AbstractModel {
    private Square[][] grid;

    private int WIDTH;
    private int HEIGHT;
    private int rows;
    private int cols;
    private int SQUARE_SIZE;
    private Difficulty difficulty;

    public GameModel() throws IOException {
        this.SQUARE_SIZE = 50;
        this.WIDTH = 500;
        this.HEIGHT = 500;
        this.rows = WIDTH / SQUARE_SIZE;
        this.cols = HEIGHT / SQUARE_SIZE;

        this.grid = new Square[rows][cols];
        setGrid();
    }

    public void setDifficulty(Difficulty difficulty) { this.difficulty = difficulty; }

    public void setGrid() {
        for(int x = 0; x < rows; x++) {
            for(int y = 0; y < cols; y++) {
                grid[x][y] = new Square(x, y, (Math.random() < .2));
                grid[x][y].setPrefSize(SQUARE_SIZE, SQUARE_SIZE);
            }
        }
    }

    public Square[][] getGrid() { return grid; }

    public boolean gridIsSet() { return grid != null; }

    public int getRows() { return this.rows; }

    public int getCols() { return this.cols; }

    public int getWIDTH() { return this.WIDTH; }

    public int getHEIGHT() { return  this.HEIGHT; }
}