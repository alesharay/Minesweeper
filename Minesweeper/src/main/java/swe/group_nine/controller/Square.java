package swe.group_nine.controller;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import swe.group_nine.model.GameModel;

import java.util.ArrayList;

public class Square extends Button {
    private int locX;
    private int locY;
    private boolean isMine;
    private boolean isRevealed;
    private ArrayList<Square> neighbors;
    private int neighborMineCount;

    public Square(int locX, int locY, boolean isMine) {
        this.locX = locX;
        this.locY = locY;
        this.isMine = isMine;
        this.isRevealed = false;
        this.neighbors = new ArrayList<>();
        this.neighborMineCount = 0;
        this.setOnAction(e -> reveal());
    }

    public void setNeighbors(ArrayList neighbors) {
        this.neighbors = neighbors;

        for(Square neighbor : this.neighbors) {
            if(neighbor.hasMine()) neighborMineCount++;
        }
    }

    public int getNeighborMineCount() { return neighborMineCount; }

    public int[] getLocation() { return new int[]{locX, locY}; }

    public boolean hasMine() {return isMine; }

    public void reveal() {
        if(isMine) {
            setText("MINE");
            this.setStyle("-fx-background-color: red; -fx-text-fill: white");
            this.setDisable(true);
        }
        else {
            this.setText("-");
            this.setDisable(true);
        }

        for(Square neighbor : neighbors) {
            if(!neighbor.hasMine()) {
                if( neighbor.getNeighborMineCount() == 0 ) {
                    neighbor.setText("-");
                    neighbor.setDisable(true);
                } else {
                    neighbor.setText(String.valueOf(neighbor.getNeighborMineCount()));
                    neighbor.setDisable(true);
                }
            }
        }
    }
}
