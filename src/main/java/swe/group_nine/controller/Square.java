package swe.group_nine.controller;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import swe.group_nine.model.GameModel;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * The Square class implements logic for the individual square of the Minesweeper game.
 *
 * @author Alesha Ray
 * @author Francisco Santos-Andujar
 * @author Timothy Wood
 */
public class Square extends Button {
    private int locX;
    private int locY;
    private int neighborMineCount;
    private boolean isMine;
    private boolean revealed;
    private boolean flagged;
    private ArrayList<Square> neighbors;

    /**
     * Constructor for the Square class.
     *
     * @param locX the x location of the square
     * @param locY the y location of the square
     * @param isMine The parameter that determines whether the square is a mine
     */
    public Square(int locX, int locY, boolean isMine) {
        this.locX = locX;
        this.locY = locY;
        this.isMine = isMine;

        revealed = false;
        flagged = false;
        neighbors = new ArrayList<>();
        neighborMineCount = 0;
        setOnMouseClicked(e -> reveal(e));
    }

    /**
     * Function that reads input of the neighbors and determines the mine count of each
     * neighbor.
     *
     * @param neighbors the array list of neighbors nearby the square
     */
    public void setNeighbors(ArrayList<Square> neighbors) {
        this.neighbors = neighbors;

        for (Square neighbor : neighbors) {
            if (neighbor.hasMine()) neighborMineCount++;
        }
    }

    /**
     * Returns the neighbors of the square
     * @return the neighbors of the square
     */
    public ArrayList<Square> getNeighbors() {
        return neighbors;
    }

    /**
     * Returns the mine count of the neighbors
     * @return the mine count of the neighbors
     */
    public int getNeighborMineCount() {
        return neighborMineCount;
    }

    /**
     * Returns the location of the square
     * @return the location of the square
     */
    public int[] getLocation() {
        return new int[]{locX, locY};
    }

    /**
     * Returns true when the square is a mine, false otherwise
     * @return true when the square is a mine, false otherwise
     */
    public boolean hasMine() {
        return isMine;
    }

    /**
     * Returns true when the square is revealed, false otherwise
     * @return true when the square is revealed, false otherwise
     */
    public boolean isRevealed() {
        return revealed;
    }

    /**
     * Receives the mouse input to reveal the square or set a flag to it
     * @param e the primary or secondary input of the mouse
     */
    public void reveal(MouseEvent e) {
        if (e.getButton() == MouseButton.PRIMARY) {
            revealed = true;
            if (isMine) {
                setText("MINE");
                setStyle(
                        "-fx-background-color: red; " +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 10"
                );
                setDisable(true);
                setOpacity(1);
                GameController.showAllMines(locX, locY);
                GameModel.gameLost = true;
                GameModel.gameOver();
            } else if (neighborMineCount > 0) {
                setText(String.valueOf(neighborMineCount));
                setStyle(
                        "-fx-background-color: #fffbf2;" +
                        "-fx-border-color: #e6e6e6;" +
                        "-fx-border-width: .5 .5 .5 .5;" +
                        "-fx-text-fill: black"
                );
                setDisable(true);
                setOpacity(1);
            } else if (neighborMineCount == 0) {
                setStyle(
                        "-fx-background-color: #fffbf2;" +
                        "-fx-border-color: #e6e6e6;" +
                        "-fx-border-width: .5 .5 .5 .5"
                );
                setDisable(true);
                setOpacity(1);
                neighborReveal(e);
            }
        } else if (e.getButton() == MouseButton.SECONDARY) {
            if (!flagged) {
                InputStream input = getClass().getResourceAsStream("/flag.png");
                Image image = new Image(input, 30, 30, true, true);
                ImageView imageView = new ImageView(image);
                setGraphic(imageView);
                flagged = true;
            } else {
                setGraphic(null);
                flagged = false;
            }
        }
    }

    /**
     * Recursive function that reveals all the neighbors within a 3x3 area of the square
     * if the neighbor is not a mine and is not revealed
     * @param e mouse input for revealing the square
     */
    public void neighborReveal(MouseEvent e) {
        for (Square neighbor : neighbors) {
            if (!neighbor.hasMine() && !neighbor.isRevealed()) {
                neighbor.reveal(e);
            }
        }
    }

    /**
     * Disable the square calling the function.
     */
    public void disable() {
        setDisable(true);
        setOpacity(1);
    }

    /**
     * Resets the square calling the function.
     */
    public void reset() {
        setText("");
        setStyle("");
        setGraphic(null);
        setDisable(false);
        revealed = false;
        isMine = Math.random() < .2;
        neighborMineCount = 0;
    }
}