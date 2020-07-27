package swe.group_nine.model;

import javafx.scene.Node;
import javafx.scene.image.Image;
import swe.group_nine.controller.Square;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The GameModel class implements the base logic and manipulates the data of the Minesweeper game.
 *
 * @author Alesha Ray
 * @author Francisco Santos-Andujar
 * @author Timothy Wood
 *
 */
public class GameModel extends AbstractModel {
    private int WIDTH;
    private int HEIGHT;
    private int rows;
    private int cols;
    private int SQUARE_SIZE;
    private Difficulty difficulty;
    private int mineCount;

    public static Square[][] grid;
    public static int disabledSquareCount;
    public static boolean gameOver;
    public static boolean gameWon;
    public static boolean gameLost;
    //TODO: add documentation for GameModel() method
    public GameModel() {
        SQUARE_SIZE = 50;
        WIDTH = 500;
        HEIGHT = 500;
        rows = WIDTH / SQUARE_SIZE;
        cols = HEIGHT / SQUARE_SIZE;
        mineCount = 0;
        disabledSquareCount = 0;
        gameOver = false;
        gameWon = false;
        gameLost = false;

        grid = new Square[rows][cols];
        setGrid();
        getNeighbors();
    }
    //TODO: add documentation for setDifficulty() method
    public void setDifficulty(Difficulty difficulty) { this.difficulty = difficulty; }
    //TODO: add documentation for setGrid() method
    public void setGrid() {
        for(int x = 0; x < rows; x++) {
            for(int y = 0; y < cols; y++) {
                boolean isMine = Math.random() <.2;
                grid[x][y] = new Square(x, y, isMine);
                grid[x][y].setPrefSize(SQUARE_SIZE, SQUARE_SIZE);
                if( isMine ) mineCount++;
            }
        }
    }
    //TODO: add documentation for getNeighbors() method
    public void getNeighbors() {
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
    //TODO: add documentation for gridIsSet() method
    public boolean gridIsSet() { return grid != null; }
    //TODO: add documentation for getRows() method
    public int getRows() { return this.rows; }
    //TODO: add documentation for getCols() method
    public int getCols() { return this.cols; }
    //TODO: add documentation for getWIDTH() method
    public int getWIDTH() { return this.WIDTH; }
    //TODO: add documentation for getHEIGHT() method
    public int getHEIGHT() { return  this.HEIGHT; }
    //TODO: add documentation for getMineCount() method
    public int getMineCount(){ return this.mineCount; }
    //TODO: add documentation for reset() method
    public void reset() throws IOException {
        for(Square[] row : grid) {
            for(Square square : row) {
                square.reset();
            }
        }
        getNeighbors();
    }

    /**
     * Ends the game when either a mine is clicked or the game is won
     */
    public static void gameOver() {
        gameOver = true;
        for(Square[] row : GameModel.grid) {
            for (Square square : row) {
                square.disable();
            }
        }

        if(!gameLost) { gameWon = true; }
    }
}
