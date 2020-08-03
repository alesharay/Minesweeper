package swe.group_nine.model;

import javafx.scene.Node;
import javafx.scene.image.Image;
import swe.group_nine.controller.GameController;
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

    public void setDifficulty(Difficulty difficulty) { this.difficulty = difficulty; }

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

    public boolean gridIsSet() { return grid != null; }

    public int getRows() { return this.rows; }

    public int getCols() { return this.cols; }

    public int getWIDTH() { return this.WIDTH; }

    public int getHEIGHT() { return  this.HEIGHT; }

    public int getMineCount(){ return this.mineCount; }

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
        GameController.timer.stop();
        for(Square[] row : GameModel.grid) {
            for (Square square : row) {
                square.disable();
            }
        }

        if(!gameLost) { gameWon = true; }
    }
}
