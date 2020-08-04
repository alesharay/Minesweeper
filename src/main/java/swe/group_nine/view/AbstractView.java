package swe.group_nine.view;

import swe.group_nine.controller.GameController;
import swe.group_nine.model.GameModel;

public abstract class AbstractView implements View {
    GameModel model;
    GameController controller;

    /**
     * Sets the model for the current instance of the Minesweeper game
     * @param model the model for the current instance of the Minesweeper game
     */
    @Override
    public void setModel(GameModel model) { this.model = model; }

    /**
     * Gets the model for the current instance of the Minesweeper game
     * @return the model for the current instance of the Minesweeper game
     */
    @Override
    public GameModel getModel() { return model; }

    /**
     * Sets the controller for the current instance of the Minesweeper game
     * @param controller the controller for the current instance of the Minesweeper game
     */
    @Override
    public void setController(GameController controller) { this.controller = controller; }

    /**
     * Gets the controller for the current instance of the Minesweeper game
     * @return the controller for the current instance of the Minesweeper game
     */
    @Override
    public GameController getController() { return controller; }
}
