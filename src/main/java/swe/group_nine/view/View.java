package swe.group_nine.view;

import javafx.stage.Stage;
import swe.group_nine.controller.GameController;
import swe.group_nine.model.GameModel;

/**
 * The View interface implements the game model used as an interface
 */
public interface View {

    void setModel(GameModel model);
    GameModel getModel();

    void setController(GameController controller);
    GameController getController();

    void setStage(Stage primaryStage);
    Stage getStage();

    void show();
}
