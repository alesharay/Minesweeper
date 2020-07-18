module group_nine {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;

    opens swe.group_nine;
    opens swe.group_nine.controller;
    opens swe.group_nine.view;
    opens swe.group_nine.model;
}