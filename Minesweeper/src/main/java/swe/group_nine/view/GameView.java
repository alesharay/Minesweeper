package swe.group_nine.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import swe.group_nine.model.GameModel;

import java.io.IOException;

public class GameView {
    private Stage primaryStage;
    private GameModel model;

    public GameView(Stage primaryStage) throws IOException {
        // Parent root = FXMLLoader.load(getClass().getResource("/View.fxml"));
        this.model = new GameModel(primaryStage);
        this.primaryStage = model.getStage();
    }

    public GameModel getModel() { return model; }

    public void show() throws IOException {
        primaryStage.show();
    }
}
