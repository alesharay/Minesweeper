package swe.group_nine.controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.util.Duration;

/**
 * The Timer class starts a counter when the game starts so the user knows how long it took them
 * to complete the game.
 *
 * @author Alesha Ray
 * @author Francisco Santos-Andujar
 * @author Timothy Wood
 */
public class Timer {
    private final Integer START = 0;
    private final TextField timerLabel;
    private final IntegerProperty timeInSeconds;
    private Timeline timeline;

    /**
     * The constructor for the timer class
     */
    public Timer() {
        timeInSeconds = new SimpleIntegerProperty(START); // used for binding timer text

        timerLabel = new TextField();
        timerLabel.setPrefSize(100, 20);
        timerLabel.setAlignment(Pos.CENTER);
        timeline = new Timeline(); // create timeline object
    }

    /**
     * Starts the timer from 0 and counts up in seconds
     */
    public void start() {
        timerLabel.textProperty().bind(timeInSeconds.asString());
        timeInSeconds.set(START);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(3600), //total time of animation (1 hour in seconds)
                new KeyValue(timeInSeconds, 3600))); //start and end values
        timeline.playFromStart(); // start animation
    }

    /**
     * Returns the label for the timer text field
     * @return the label for the timer text field
     */
    public TextField getTimerLabel() {
        return timerLabel; //return the label
    }

    /**
     * Returns the timeline object of the Timer object
     * @return the timeline object of the Timer object
     */
    public Timeline getTimeline() {
        return timeline;
    }

    /**
     * Returns the timeInSeconds object of the Timer object
     * @return the timeInSeconds object of the Timer object
     */
    public IntegerProperty getTimeInSeconds() {
        return timeInSeconds;
    }

    /**
     * Stops the timer when then game is completed
     */
    public void stop() {
        timeline.stop();
        timerLabel.textProperty().unbind();
        timerLabel.setText(timeInSeconds.getValue().toString());
    }
}