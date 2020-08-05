import javafx.application.Platform;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import swe.group_nine.controller.Square;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SquareTest {
  Square square;
  Square square2;
  Square square3;
  ArrayList<Square> neighbors = new ArrayList<>();

  @BeforeClass
  public static void setUpBeforeClass() { Platform.startup(()->{}); }

  @Before
  public void setUp() {
    square = new Square(1,1,true);
    square2 = new Square(2, 2, false);
    square3 = new Square(3,3, true);
    neighbors.add(square2);
    neighbors.add(square3);
  }

  @Test
  public void setNeighborsTest() {
    square.setNeighbors(neighbors);
    assertEquals(1, square.getNeighborMineCount());
  }

  @Test
  public void getLocationTest() {
    int[] loc = square.getLocation();
    for (int i: loc) { assertEquals(1, i); }

    int[] loc2 = square2.getLocation();
    for (int i : loc2) { assertEquals(2, i); }

    int[] loc3 = square3.getLocation();
    for (int i: loc3) { assertEquals(3, i); }
  }

  @Test
  public void hasMineTest() {
    assertTrue(square.hasMine());
    assertFalse(square2.hasMine());
    assertTrue(square3.hasMine());
  }

  @Test
  public void isRevealedTest() { assertFalse(square.isRevealed()); }

  @Test
  public void isFlaggedTest() { assertFalse(square.isFlagged()); }

  @Test
  public void disableTest() {
    square.disable();
    assertTrue(square.isDisabled());
    assertEquals(1, square.getOpacity(), 0.0);
  }

  @Test
  public void resetTest() {
    square.reset();
    assertEquals("", square.getText());
    assertEquals("", square.getStyle());
    assertNull(square.getGraphic());
    assertFalse(square.isDisable());
    assertFalse(square.isRevealed());
    assertFalse(square.isFlagged());
    assertEquals(0, square.getNeighborMineCount());
  }
}