import javafx.animation.Animation;
import javafx.application.Platform;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import swe.group_nine.controller.Timer;

import static org.junit.Assert.*;

public class TimerTest {
  Timer timer;

  @BeforeClass
  public static void setUpBeforeClass() { Platform.startup(()->{}); }

  @Before
  public void setUp() { timer = new Timer(); }

  @Test
  public void start() {
    timer.start();
    assertTrue(timer.getTimerLabel().textProperty().isBound());
    assertNotNull(timer.getTimeline());
    assertEquals(Animation.Status.RUNNING, timer.getTimeline().getStatus());
  }

  @Test
  public void getTimerLabelTest() { assertNotNull(timer.getTimerLabel()); }

  @Test
  public void getTimelineTest() { assertNotNull(timer.getTimeline()); }

  @Test
  public void getTimeInSecondsTest() { assertNotNull(timer.getTimeInSeconds()); }

  @Test
  public void stopTest() {
    timer.start();
    timer.stop();
    assertEquals(Animation.Status.STOPPED, timer.getTimeline().getStatus());
  }
}