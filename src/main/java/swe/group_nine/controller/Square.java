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
    //TODO: add documentation for Square() method
    public Square(int locX, int locY, boolean isMine) {
        this.locX = locX;
        this.locY = locY;
        this.isMine = isMine;

        revealed = false;
        neighbors = new ArrayList<>();
        neighborMineCount = 0;
        setOnAction(e -> reveal() );
    }
    //TODO: add documentation for setNeighbors() method
    public void setNeighbors(ArrayList<Square> neighbors) {
        this.neighbors = neighbors;

        for(Square neighbor : neighbors) {
            if(neighbor.hasMine()) neighborMineCount++;
        }
    }
    //TODO: add documentation for getNeighbors() method
    public ArrayList<Square> getNeighbors() { return neighbors; }
    //TODO: add documentation for getNeighborMineCount() method
    public int getNeighborMineCount() { return neighborMineCount; }
    //TODO: add documentation for getLocation() method
    public int[] getLocation() { return new int[]{locX, locY}; }
    //TODO: add documentation for hasMine() method
    public boolean hasMine() { return isMine; }
    //TODO: add documentation for isRevealed() method
    public boolean isRevealed() { return revealed; }
    //TODO: add documentation for reveal() method
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
    //TODO: change name of notSureWhatToCallThisYet()
    //TODO: add documentation for notSureWhatTOCallThisYet() method
    public void notSureWhatToCallThisYet() {
        for(Square neighbor : neighbors) {
            if( !neighbor.hasMine() && !neighbor.isRevealed() ) {
                neighbor.reveal();
            }
        }
    }
    //TODO: add documentation for disable() method
    public void disable() {
        setDisable(true);
        setOpacity(1);
    }
    //TODO: add documentation for reset() method
    public void reset() {
        setText("");
        setStyle("");
        setDisable(false);
        revealed = false;
        isMine = Math.random() <.2;
        neighborMineCount = 0;
    }
}