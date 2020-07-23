module Minesweeper {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens swe.group_nine;
    opens swe.group_nine.controller;
    opens swe.group_nine.model;
    opens swe.group_nine.view;
}