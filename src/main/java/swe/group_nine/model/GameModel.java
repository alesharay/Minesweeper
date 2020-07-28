package swe.group_nine.model;

import swe.group_nine.controller.Square;

import java.io.IOException;
import java.util.ArrayList;

public class GameModel extends AbstractModel {
    public static Square[][] grid;

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

        grid = new Square[rows][cols];
        setGrid();
        setNeighbors();
    }

    public void setDifficulty(Difficulty difficulty) { this.difficulty = difficulty; }

    public void setGrid() {
        for(int x = 0; x < rows; x++) {
            for(int y = 0; y < cols; y++) {
                grid[x][y] = new Square(x, y, (Math.random() < .2), grid.length);
                grid[x][y].setPrefSize(SQUARE_SIZE, SQUARE_SIZE);
            }
        }
    }


    public void setNeighbors() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ArrayList<Square> neighbors = new ArrayList<>();
                Square square = grid[i][j];

                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        int nbX = square.getLocation()[0] + x;
                        int nbY = square.getLocation()[1] + y;

                        boolean nbXInRange = (nbX >= 0) && (nbX < rows);
                        boolean nbYInRange = (nbY >= 0) && (nbY < rows);

                        if (nbXInRange && nbYInRange) {
                            neighbors.add(grid[nbX][nbY]);
                        }
                    }
                }
                square.setNeighbors(neighbors);
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
