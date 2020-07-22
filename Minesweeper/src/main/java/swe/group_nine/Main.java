package swe.group_nine;

import javafx.application.Application;
import javafx.stage.Stage;
import swe.group_nine.view.GameView;

public class Main extends Application {
    public GameView view = new GameView();

    @Override
    public void start(Stage primaryStage) throws Exception{
        view.show( primaryStage );
    }

    public static void main(String[] args) {
        launch(args);
    }
}
