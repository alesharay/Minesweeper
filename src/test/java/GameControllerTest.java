import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import swe.group_nine.controller.GameController;
import swe.group_nine.controller.Square;
import swe.group_nine.model.Difficulty;
import swe.group_nine.model.GameModel;

import static org.junit.Assert.*;

public class GameControllerTest {
  GameController controller;

  @BeforeClass
  public static void setUpBeforeClass() { Platform.startup(()->{}); }

  @Before
  public void setUp() { controller = new GameController(Difficulty.EASY); }

  @Test
  public void getDiffDropDownTest() {
    ObservableList<Difficulty> list = controller.getDiffDropDown().getItems();
    for (int i = 0; i < list.size(); i++) {
      if (i == 0) { assertEquals(Difficulty.EASY, list.get(i)); }
      if (i == 1) { assertEquals(Difficulty.MEDIUM, list.get(i)); }
      if (i == 2) { assertEquals(Difficulty.HARD, list.get(i)); }
    }

    assertEquals(20, controller.getDiffDropDown().getPrefHeight(),0.0 );
    assertEquals(100, controller.getDiffDropDown().getPrefWidth(), 0.0);
    assertNotNull(controller.getDiffDropDown());
  }

  @Test
  public void getResetTest() {
    assertNotNull(controller.getReset());
    assertNotNull(controller.getReset().getGraphic());
  }

  @Test
  public void getMineCountFieldTest() {
    assertNotNull(controller.getMineCountField());
    assertEquals(String.valueOf(GameModel.mineCount), controller.getMineCountField().getText());
    assertEquals(Pos.CENTER, controller.getMineCountField().getAlignment());
    assertFalse(controller.getMineCountField().isEditable());
    assertEquals(20, controller.getMineCountField().getPrefHeight(),0.0 );
    assertEquals(100, controller.getMineCountField().getPrefWidth(), 0.0);
  }

  @Test
  public void getTimerTest() {
    assertNotNull(controller.getTimer());
    assertNotNull(GameController.timer);
  }

  @Test
  public void showAllMinesTest() {
    GameController.showAllMines(1,1);
    for(Square[] row : GameModel.grid) {
      for (Square square : row) {
        if (square.hasMine()) {
          assertEquals("MINE", square.getText());
          assertEquals("-fx-background-color: #fffbf2;" +
            "-fx-text-fill: black;" +
            "-fx-font-size: 10", square.getStyle());
          assertTrue(square.isDisabled());
        } else if (square.isFlagged()) {
          assertNull(square.getGraphic());
          assertEquals("X", square.getText());
          assertEquals("-fx-text-size: 10;" +
            "-fx-text-fill: red;" +
            "-fx-text-bold: true", square.getStyle());
          assertTrue(square.isDisabled());
        }
      }
    }
  }

  @Test
  public void getModelTest() {
    assertNotNull(controller.getModel());
  }
}