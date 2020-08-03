package swe.group_nine.controller;

import javafx.application.Platform;
import org.junit.Before;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class SquareTest {
    Square square;

    @BeforeClass
    public static void setUpBefore() {
        Platform.startup(()->{});

    }

    @Before public void setUp() {
        square = new Square(1, 1, true);
    }

    @Test
    public void setNeighbors() {
    }

    @Test
    //test for getNeighbors() results in success
    public void getNeighbors_shouldPass() {
        assertNotNull(square.getNeighbors());
    }

    @Test
    public void getNeighborMineCount() {
        assertEquals(0, square.getNeighborMineCount());
    }

    @Test
    public void getLocation() {
        int locx = 1;
        int locy = 1;
        int[] value = {locx, locy};
     //   assertEquals(value, square.getLocation());
    }

    @Test
    //test for hasMine() results in success
    public void hasMine() {
        assertEquals(true, square.hasMine());
    }


    @Test
    //test for isRevealed() results in success
    public void isRevealed() {
        assertEquals(false, square.isRevealed());
    }

    @Test
    public void reveal() {
    }

    @Test
    public void notSureWhatToCallThisYet() {
    }

    @Test
    public void disable() {
        square.disable();
        assertTrue(square.isDisabled());
    }

    @Test
    public void reset() {
    }
}