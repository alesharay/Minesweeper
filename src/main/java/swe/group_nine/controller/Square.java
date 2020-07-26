package swe.group_nine.controller;

import javafx.scene.control.Button;
import swe.group_nine.model.GameModel;

import java.util.ArrayList;

/**
 * The Square class implements logic for the individual square of the Minesweeper game.
 *
 * @author Alesha Ray
 * @author Francisco Santos-Andujar
 * @author Timothy Wood
 *
 */
public class Square extends Button {
    private int locX;
    private int locY;
    private int neighborMineCount;
    private boolean isMine;
    private boolean revealed;
    private ArrayList<Square> neighbors;

    public Square(int locX, int locY, boolean isMine) {
        this.locX = locX;
        this.locY = locY;
        this.isMine = isMine;

        revealed = false;
        neighbors = new ArrayList<>();
        neighborMineCount = 0;
        setOnAction(e -> reveal() );
    }

    public void setNeighbors(ArrayList<Square> neighbors) {
        this.neighbors = neighbors;

        for(Square neighbor : neighbors) {
            if(neighbor.hasMine()) neighborMineCount++;
        }
    }

    public ArrayList<Square> getNeighbors() { return neighbors; }

    public int getNeighborMineCount() { return neighborMineCount; }

    public int[] getLocation() { return new int[]{locX, locY}; }

    public boolean hasMine() { return isMine; }

    public boolean isRevealed() { return revealed; }

    public void reveal() {
        revealed = true;
        if(isMine) {
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
        }
        else if(neighborMineCount > 0) {
            setText(String.valueOf(neighborMineCount));
            setStyle(
                "-fx-background-color: #fffbf2;" +
                "-fx-border-color: #e6e6e6;" +
                "-fx-border-width: .5 .5 .5 .5;" +
                "-fx-text-fill: black"
            );
            setDisable(true);
            setOpacity(1);
        }
        else if(neighborMineCount == 0) {
            setStyle(
                "-fx-background-color: #fffbf2;" +
                "-fx-border-color: #e6e6e6;" +
                "-fx-border-width: .5 .5 .5 .5"
            );
            setDisable(true);
            setOpacity(1);
            notSureWhatToCallThisYet();
        }

    }

    public void notSureWhatToCallThisYet() {
        for(Square neighbor : neighbors) {
            if( !neighbor.hasMine() && !neighbor.isRevealed() ) {
                neighbor.reveal();
            }
        }
    }

    public void disable() {
        setDisable(true);
        setOpacity(1);
    }

    public void reset() {
        setText("");
        setStyle("");
        setDisable(false);
        revealed = false;
        isMine = Math.random() <.2;
        neighborMineCount = 0;
    }
}