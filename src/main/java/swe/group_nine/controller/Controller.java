package swe.group_nine.controller;

import swe.group_nine.model.Model;

/**
 * Controller interface implements the game model used as a controller
 */
public interface Controller {
    void setModel(Model model);
    Model getModel();
}