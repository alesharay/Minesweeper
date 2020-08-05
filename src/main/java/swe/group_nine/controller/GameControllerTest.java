package swe.group_nine.controller;

import javafx.application.Platform;
import org.junit.BeforeClass;
import org.junit.Test;
import swe.group_nine.controller.GameController;
import swe.group_nine.model.GameModel;

import static org.junit.Assert.*;

public class GameControllerTest {

    GameModel model = new GameModel();
    GameController controller = new GameController(model);

    @BeforeClass
    public static void setUpBefore() throws Exception {
        Platform.startup(()->{});
    }

    @Test
    public void getReset() {
        assertNotNull(controller.getReset());
    }

    @Test
    public void getMineCount() {
        assertNotNull(controller.getMineCount());
    }

    @Test
    public void getTimer() {
        assertNotNull(controller.getTimer());
    }

    @Test
    public void showAllMines() {
    }
}