package project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;
    private static final int SQUARE_SIZE = 50;
    private static final int X_SQUARES = WIDTH / SQUARE_SIZE;
    private static final int Y_SQUARES = HEIGHT / SQUARE_SIZE;

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(WIDTH, HEIGHT);

        return root;
    }

    private class Square extends StackPane {
        private int x;
        private int y;
        private boolean bombSquare;

        public Square(int x, int y, boolean bombSquare) {
            this.x = x;
            this.y = y;
            this.bombSquare = bombSquare;
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
        primaryStage.setTitle("Minesweeper");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
