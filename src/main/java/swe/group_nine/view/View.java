package swe.group_nine.view;

import swe.group_nine.model.Model;

public interface View {
    void setModel(Model model);
    Model getModel();
    void setView(View view);
    View getView();
}
