package swe.group_nine.controller;

import javafx.application.Platform;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.*;

public class SquareTest {
    Square square;
    Square square2;
    Square square3;
    ArrayList<Square> neighbors = new ArrayList<>();

    @BeforeClass
    public static void setUpBeforeClass() {
        Platform.startup(()->{});
    }

    @Before
    public void setUp() throws Exception {
        square = new Square(1,1,true);
        square2 = new Square(2, 2, false);
        square3 = new Square(3,3, true);
        neighbors.add(square2);
        neighbors.add(square3);

    }

    @Test
    public void setNeighbors() {
        square.setNeighbors(neighbors);
        assertEquals(1, square.getNeighborMineCount());

    }

    @Test
    public void getLocation() {
        int[] loc = square.getLocation();
        for (int i: loc) {
            assertEquals(1, i);
        }

        int[] loc2 = square2.getLocation();
        for (int i : loc2) {
            assertEquals(2, i);
        }

        int[] loc3 = square3.getLocation();
        for (int i: loc3) {
            assertEquals(3, i);
        }
    }

    @Test
    public void hasMine() {
        assertTrue(square.hasMine());
        assertFalse(square2.hasMine());
        assertTrue(square3.hasMine());
    }

    @Test
    public void isRevealed() {
        assertFalse(square.isRevealed());
    }

    @Test
    public void isFlagged() {
        assertFalse(square.isFlagged());
    }

    @Test
    public void reveal() {
    }

    @Test
    public void neighborReveal() {
    }

    @Test
    public void disable() {
        square.disable();
        assertTrue(square.isDisabled());
    }

    @Test
    public void reset() {
        assertEquals("", square.getText());
        assertEquals("", square.getStyle());
        assertEquals(null, square.getGraphic());
        assertEquals(false, square.isDisabled());
        assertEquals(false, square.isRevealed());
        assertEquals(false, square.isFlagged());
    }
}