package swe.group_nine.view;

import swe.group_nine.model.Model;

/**
 * The View interface implements the game model used as an interface
 */
public interface View {
    void setModel(Model model);
    Model getModel();
}
