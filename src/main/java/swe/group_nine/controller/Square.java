package swe.group_nine.controller;

import javafx.scene.control.Button;

import java.util.ArrayList;

public class Square extends Button {
    private int locX;
    private int locY;
    int gridSize;
    private boolean isMine;
    private boolean revealed;
    private ArrayList<Square> neighbors;
    private int neighborMineCount;



    public Square(int locX, int locY, boolean isMine, int gridSize) {
        this.locX = locX;
        this.locY = locY;
        this.isMine = isMine;
        this.revealed = false;
        this.neighbors = new ArrayList<>();
        this.neighborMineCount = 0;
        this.gridSize = gridSize;
        this.setOnAction(e -> reveal() );
    }

    public void setNeighbors(ArrayList neighbors) {
        this.neighbors = neighbors;

        for(Square neighbor : this.neighbors) {
            if(neighbor.hasMine()) neighborMineCount++;
        }
    }

    public ArrayList getNeighbors() { return neighbors; }

    public int getNeighborMineCount() { return neighborMineCount; }

    public int[] getLocation() { return new int[]{locX, locY}; }

    public boolean hasMine() { return isMine; }

    public boolean isRevealed() { return revealed; }

    public void reveal() {
        revealed = true;
        if(isMine) {
            setText("MINE");
            this.setStyle("-fx-background-color: red; -fx-text-fill: white");
            this.setDisable(true);
        }
        else if(neighborMineCount > 0) {
            this.setText(String.valueOf(neighborMineCount));
            this.setDisable(true);
        }
        else if(neighborMineCount == 0) {
            this.setDisable(true);
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

    public void reset() {
        setText("");
        setStyle("");
        setDisable(false);
        revealed = false;
        isMine = Math.random() <.2;
        neighborMineCount = 0;

    }
}