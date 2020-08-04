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
    public static Square[][] grid;
    public static int mineCount;
    public static int disabledSquareCount;
    public static boolean gameOver;
    public static boolean gameWon;
    public static boolean gameLost;
    public static Difficulty difficulty;

    /**
     * Constructor of the GameModel class
     * @param difficulty the difficulty selection of the Minesweeper game
     */
    public GameModel(Difficulty difficulty) {
        SQUARE_SIZE = 50;
        setDifficulty(difficulty);
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
     * Sets up the grid for the game and assigns the amount of mines on the board
     */
    public void setGrid() {
        for(int x = 0; x < rows; x++) {
            for(int y = 0; y < cols; y++) {
                boolean isMine = Math.random() <.2;
                grid[x][y] = new Square(x, y, isMine);
                grid[x][y].setPrefSize(SQUARE_SIZE, SQUARE_SIZE);
                if(isMine) mineCount++;
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
     * @param locX the X location for the current square
     * @param locY the Y location for the current square
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
