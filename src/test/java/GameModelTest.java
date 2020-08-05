import javafx.animation.Animation;
import javafx.application.Platform;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import swe.group_nine.controller.GameController;
import swe.group_nine.controller.Square;
import swe.group_nine.model.Difficulty;
import swe.group_nine.model.GameModel;

import static org.junit.Assert.*;

public class GameModelTest {
  GameModel model;
  GameController controller;

  @BeforeClass
  public static void setUpBeforeClass() {
    Platform.startup(()->{});
  }

  @Before
  public void setUp() { model = new GameModel(Difficulty.EASY); }

  @Test
  public void gridIsSet() { assertTrue(model.gridIsSet()); }

  @Test
  public void reset() {
    model.reset();
  }

  @Test
  public void disableAllSquares() {
    model.disableAllSquares();
    for(Square[] row : GameModel.grid) {
      for (Square square : row) { assertTrue(square.isDisabled()); }
    }
  }

  @Test
  public void gameOver() {
    controller = new GameController(Difficulty.EASY);
    controller.getTimer();
    GameModel.gameLost = true;
    GameModel.gameOver();

    assertTrue(GameModel.gameOver);
    assertEquals(Animation.Status.STOPPED, GameController.timer.getTimeline().getStatus());
    assertFalse(GameModel.gameWon);

    GameModel.gameLost = false;
    GameModel.gameOver();

    assertTrue(GameModel.gameWon);
  }
}