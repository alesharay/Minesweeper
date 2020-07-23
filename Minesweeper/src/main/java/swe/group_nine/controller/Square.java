package swe.group_nine.controller;

import javafx.scene.control.Button;
import swe.group_nine.model.GameModel;

import java.util.ArrayList;

public class Square extends Button {
    ArrayList<Square> neighbors;
    Square[][] grid;
    int locX;
    int locY;
    boolean isMine;
    int neighborMineCount;

    public Square(int locX, int locY, boolean isMine) {
        neighbors = new ArrayList<>();
        grid = GameModel.getGrid();
        this.locX = locX;
        this.locY = locY;
        this.isMine = isMine;
        neighborMineCount = 0;
        setNeighbors();
    }

    public void setNeighbors() {
        for(int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                int neighborX = locX + x;
                int neighborY = locY + y;

                boolean neighborXWithinRange = neighborX >= 0 && neighborX < grid.length;
                boolean neighborYWithinRange = neighborY >= 0 && neighborY < grid.length;
                boolean isCurrentSquare = locX == neighborX && locY == neighborY;



                if( neighborXWithinRange && neighborYWithinRange && !isCurrentSquare ) {
                    Square neighbor = grid[neighborX][neighborY];
//                    if (neighbor.hasMine()) neighborMineCount++;
                    neighbors.add(neighbor);
                }

            }
        }
//        System.out.println("Neighbor mine count: " + neighborMineCount);
    }

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
}
