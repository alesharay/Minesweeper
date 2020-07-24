package swe.group_nine.controller;

import swe.group_nine.model.Model;
import swe.group_nine.view.View;

public abstract class AbstractController implements Controller {
    private View view;
    private Model model;

    public void setModel(Model model) { this.model = model; }

    public Model getModel() { return model; }

    public void setView(View view) { this.view = view; }

    public View getView() { return view; }
}