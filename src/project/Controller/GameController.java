package project.Controller;

import javafx.event.EventHandler; //used for processing events
import javafx.scene.input.MouseEvent; //used for processing mouse clicked event

//class for controller
public class GameController extends AbstractController {
    //handle mouse clicked events
    EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
        //create event handler for mouse clicked events
        @Override
        public void handle(MouseEvent mouseEvent) {
                //reveal square and update view to show
        }
    };
}
