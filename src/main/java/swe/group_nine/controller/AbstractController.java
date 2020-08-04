package swe.group_nine.controller;

import swe.group_nine.model.Model;
import swe.group_nine.view.View;

/**
 * The AbstractController class implements the controller as an abstract model for
 * the minesweeper game
 */
public abstract class AbstractController implements Controller {
    private View view;
    private Model model;

    /**
     * Set the private model in the class to the parameter's model
     * @param model model assigned for the AbstractController class
     */
    public void setModel(Model model) { this.model = model; }

    /**
     * Returns the private model in the class
     * @return the private model in the class
     */
    public Model getModel() { return model; }

    /**
     * Set the class' private view variable to the assigned view interface
     * @param view view interface assigned for the AbstractController class
     */
    public void setView(View view) { this.view = view; }

    /**
     * Returns the private view interface in the class
     * @return the private view interface in the class
     */
    public View getView() { return view; }
}