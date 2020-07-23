package swe.group_nine.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameView {
    private Stage primaryStage;
    private boolean stageIsSet;

    public GameView() throws IOException {
        stageIsSet = false;
    }

    public GameView(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        stageIsSet = true;
    }

    public void setStage(Stage primaryStage) { this.primaryStage = primaryStage; }

    public Stage getStage() { return primaryStage; }

    public void show() throws IOException {
        if( stageIsSet ) {
            Parent root = FXMLLoader.load(getClass().getResource("/View.fxml"));
            primaryStage.setTitle("Minesweeper");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } else {
            throw new IllegalStateException("Stage Not Set!");
        }
    }
}
