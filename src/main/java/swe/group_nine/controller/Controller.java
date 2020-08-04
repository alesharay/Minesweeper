package swe.group_nine.controller;

import swe.group_nine.model.Model;
import swe.group_nine.view.View;

/**
 * Controller interface implements the game model used as a controller
 */
public interface Controller {
    void setModel(Model model);
    Model getModel();

    void setView(View view);
    View getView();
}