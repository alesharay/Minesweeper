import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Duration;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import swe.group_nine.controller.Timer;

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
        timer.start();
        assertTrue(timer.getTimerLabel().textProperty().isBound());
        assertNotNull(timer.getTimeline());
        assertEquals(Animation.Status.RUNNING, timer.getTimeline().getStatus());
    }

    @Test
    public void getTimerLabel() {
        assertNotNull(timer.getTimerLabel());
    }

    @Test
    public void getTimeline() {
        timer.start();
        assertNotNull(timer.getTimeline());
    }

    @Test
    public void getTimeInSeconds() {
        assertNotNull(timer.getTimeInSeconds());
    }

    @Test
    public void stop() {
        timer.start();
        timer.stop();
        assertEquals(Animation.Status.STOPPED, timer.getTimeline().getStatus());
    }
}