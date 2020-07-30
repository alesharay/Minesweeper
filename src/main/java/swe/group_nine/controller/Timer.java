package swe.group_nine.controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class Timer {
    private final Integer START = 0;
    private Timeline timeline;
    private TextField timerLabel;
    private IntegerProperty timeInSeconds;

    public Timer() {
        timerLabel = new TextField();
        timeInSeconds = new SimpleIntegerProperty(START); // used for binding timer text

        timerLabel.textProperty().bind(timeInSeconds.asString());
        timerLabel.setAlignment(Pos.CENTER);
    }

    public void start() {
        timeInSeconds.set(START);
        timeline = new Timeline(); // create timeline object
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(3600), //total time of animation (1 hour in seconds)
                        new KeyValue(timeInSeconds, 3600))); //start and end values
        timeline.playFromStart(); // start animation
    }

    public TextField getTimerLabel() {
        return timerLabel; //return the label
    }
}