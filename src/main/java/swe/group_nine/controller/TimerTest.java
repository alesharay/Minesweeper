package swe.group_nine.controller;

import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.scene.control.TextField;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TimerTest {

    Timer timer;

    @BeforeClass
    public static void setUpBefore() {
        Platform.startup(()->{});
    }

    @Before
    public void setup() {
        timer = new Timer();
    }

    @Test
    public void start() {
        timer.start();
        assertNotNull(timer.getTimeline());
    }

    @Test
    public void stop() {
    }

    @Test
    public void getTimerLabel() {
        assertNotNull(timer.getTimerLabel());
    }

    @Test
    public void getTimeline() {
        assertNotNull(timer.getTimeline());
    }

    @Test
    public void getTimeInSeconds() {
        assertNotNull(timer.getTimeInSeconds());
    }
}