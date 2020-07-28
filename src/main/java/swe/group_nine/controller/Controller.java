package swe.group_nine.controller;

import swe.group_nine.model.Model;

public interface Controller {
    void setModel(Model model);
    Model getModel();
}