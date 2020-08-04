package swe.group_nine.model;

import swe.group_nine.controller.Square;

public abstract class AbstractModel implements Model {
    int WIDTH;
    int HEIGHT;
    int rows;
    int cols;
    int SQUARE_SIZE;
    Difficulty difficulty;

    /**
     * Sets the number of rows for the grid
     * @param rows the number of rows for the grid
     */
    public void setRows(int rows) { this.rows = rows; }

    /**
     * Returns the number of rows
     * @return the number of rows
     */
    @Override
    public int getRows() { return this.rows; }

    /**
     * Sets the number of columns for the grid
     * @param cols the number of columns for the grid
     */
    public void setCols(int cols) { this.cols = cols; }

    /**
     * Returns the number of columns
     * @return the number of columns
     */
    @Override
    public int getCols() { return this.cols; }

    /**
     * Sets the width of the grid window
     * @param WIDTH the width of the grid window
     */
    public void setWIDTH(int WIDTH) { this.WIDTH = WIDTH; }

    /**
     * Returns the width of the board
     * @return the width of the board
     */
    @Override
    public int getWIDTH() { return this.WIDTH; }

    /**
     * Sets the height of the grid window
     * @param HEIGHT the height of the grid window
     */
    public void setHEIGHT(int HEIGHT) { this.HEIGHT = HEIGHT; }

    /**
     * Returns the height of the board
     * @return the height of the board
     */
    @Override
    public int getHEIGHT() { return this.HEIGHT; }

    /**
     * Sets the size of the squares on the grid
     * @param SQUARE_SIZE this size of the squares on the grid
     */
    public void setSQUARE_SIZE(int SQUARE_SIZE) { this.SQUARE_SIZE = SQUARE_SIZE; }

    /**
     * Returns the size of the squares on the board
     * @return the size of the squares on the board
     */
    @Override
    public int getSQUARE_SIZE() { return this.SQUARE_SIZE; }

    public void sizeHelper(int WIDTH_HEIGHT) {
        WIDTH = WIDTH_HEIGHT;
        HEIGHT = WIDTH_HEIGHT;
        rows = WIDTH / SQUARE_SIZE;
        cols = HEIGHT / SQUARE_SIZE;
        GameModel.grid = new Square[rows][cols];
    }

    /**
     * Sets the difficulty of the Minesweeper game
     * @param difficulty the difficulty of the minesweeper game
     */
    @Override
    public void setDifficulty(Difficulty difficulty) {
        if(difficulty == null) { difficulty = Difficulty.EASY; }

        switch (difficulty) {
            case HARD:
                this.difficulty = Difficulty.HARD;
                sizeHelper(1000);
                break;
            case MEDIUM:
                this.difficulty = Difficulty.MEDIUM;
                sizeHelper(750);
                break;
            default:
            case EASY:
                this.difficulty = Difficulty.EASY;
                sizeHelper(500);
                break;
        }
    }

    /**
     * Returns the difficulty of the Minesweeper game
     * @return the difficulty of the Minesweeper game
     */
    @Override
    public Difficulty getDifficulty() { return this.difficulty; }

}
