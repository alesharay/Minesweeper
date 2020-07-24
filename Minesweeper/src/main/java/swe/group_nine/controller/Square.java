package swe.group_nine.controller;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import swe.group_nine.model.GameModel;

import java.util.ArrayList;

public class Square extends Button {
    ArrayList<Square> neighbors;
    int locX;
    int locY;
    boolean isMine;
    boolean isRevealed;
    int neighborMineCount;

    public Square(int locX, int locY, boolean isMine) {
        this.neighbors = new ArrayList<>();
        this.locX = locX;
        this.locY = locY;
        this.isMine = isMine;
        this.isRevealed = false;
        this.neighborMineCount = 0;
    }

    public void addNeighbor(Square neighbor) {
        neighbors.add(neighbor);
        if(neighbor.hasMine()) neighborMineCount++;
    }

    public int[] getLocation() { return new int[]{locX, locY}; }

    public boolean hasMine() {return isMine; }

    public void reveal() {
        if(isMine) { setText("MINE"); }
        else { setText("-"); }

        for(Square neighbor : neighbors) {
            if( neighbor.isMine) { }
            else {
                if( neighborMineCount == 0 ) this.setText("-");
                else this.setText(String.valueOf(neighborMineCount));
            }
        }
    }

    public String toString() {
        return super.toString();
    }
}
