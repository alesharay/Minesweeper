package swe.group_nine.model;

import swe.group_nine.controller.GameController;
import swe.group_nine.controller.Square;

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

    public static Square[][] grid;
    public static int mineCount;
    public static int disabledSquareCount;
    public static boolean gameOver;
    public static boolean gameWon;
    public static boolean gameLost;

    /**
     * Constructor of the GameModel class
     */
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

    /**
     * Sets the selected difficulty level for the game
     * @param difficulty selected difficulty level for the game
     */
    public void setDifficulty(Difficulty difficulty) { this.difficulty = difficulty; }

    /**
     * Sets up the grid for the game and assigns the amount of mines on the board
     */
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

    /**
     * Gets all the neighbors adjacent to the square in a 3X3 area
     */
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

    /**
     * Returns true if the grid has values; otherwise, false if the grid is null
     * @return true if the grid has values; otherwise, false if the grid is null
     */
    public boolean gridIsSet() { return grid != null; }

    /**
     * Returns the number of rows
     * @return the number of rows
     */
    public int getRows() { return this.rows; }

    /**
     * Returns the number of columns
     * @return the number of columns
     */
    public int getCols() { return this.cols; }

    /**
     * Returns the width of the board
     * @return the width of the board
     */
    public int getWIDTH() { return this.WIDTH; }

    /**
     * Returns the height of the board
     * @return the height of the board
     */
    public int getHEIGHT() { return  this.HEIGHT; }

    /**
     * Returns the count of mines on the board
     * @return the count of mines on the board
     */
    public int getMineCount(){ return mineCount; }

    /**
     * Resets the entire grid/game when called
     */
    public void reset() {
        mineCount = 0;
        for(Square[] row : grid) {
            for(Square square : row) {
                square.reset();
                if(square.hasMine()) { mineCount++; }
            }
        }
        getNeighbors();
    }

    /**
     * Ends the game when either a mine is clicked or the game is won
     */
    public static void gameOver(int locX, int locY) {
        gameOver = true;
        for(Square[] row : GameModel.grid) {
            for (Square square : row) {
                square.disable();
            }
        }
        GameController.timer.stop();
        if(!gameLost) { gameWon = true; }
        else { GameController.showAllMines(locX, locY); }
    }
}
