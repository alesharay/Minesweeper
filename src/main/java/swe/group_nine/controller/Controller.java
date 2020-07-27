package swe.group_nine.controller;

import swe.group_nine.model.Model;
import swe.group_nine.view.View;

public interface Controller {
    void setModel(Model model);
    Model getModel();
}