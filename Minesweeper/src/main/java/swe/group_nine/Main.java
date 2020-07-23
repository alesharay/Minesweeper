package swe.group_nine;

import javafx.application.Application;
import javafx.stage.Stage;
import swe.group_nine.view.GameView;

public class Main extends Application {
    public GameView view;

    @Override
    public void start(Stage primaryStage) throws Exception{
        view = new GameView( primaryStage );
        view.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}