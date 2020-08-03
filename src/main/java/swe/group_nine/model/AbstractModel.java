package swe.group_nine.model;

public class AbstractModel implements Model {
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

    /**
     * Sets the difficulty of the Minesweeper game
     * @param difficulty the difficulty of the minesweeper game
     */
    @Override
    public void setDifficulty(Difficulty difficulty) {
        if(difficulty == null) { difficulty = Difficulty.EASY; }

        switch (difficulty) {
            case MEDIUM:
                WIDTH = 750;
                HEIGHT = 750;
                break;
            case HARD:
                WIDTH = 1000;
                HEIGHT = 1000;
                break;
            default:
            case EASY:
                WIDTH = 500;
                HEIGHT = 500;
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
