package swe.group_nine.controller;

import javafx.application.Platform;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimerTest {
    Timer timer;

    @BeforeClass
    public static void setUpBeforeClass() {
        Platform.startup(()->{});
    }

    @Before
    public void setUp() throws Exception {
        timer = new Timer();
    }

    @Test
    public void start() {
    }

    @Test
    public void getTimerLabel() {
        assertNotNull(timer.getTimerLabel());
    }

    @Test
    public void stop() {
    }
}