package snakecube;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by fex on 23.01.16.
 */
public class DirectionTest {
  public static final Direction UP       = new Direction( 0,  1,  0);
  public static final Direction DOWN     = new Direction( 0, -1,  0);
  public static final Direction LEFT     = new Direction(-1,  0,  0);
  public static final Direction RIGHT    = new Direction( 1,  0,  0);
  public static final Direction FORWARD  = new Direction( 0,  0,  1);
  public static final Direction BACKWARD = new Direction( 0,  0, -1);

  @Test(expected = RuntimeException.class)
  public void moreThanOneStepX() {
    new Direction(2,0,0);
  }

  @Test(expected = RuntimeException.class)
  public void moreThanOneStepY() {
    new Direction(0,2,0);
  }

  @Test(expected = RuntimeException.class)
  public void moreThanOneStepZ() {
    new Direction(0,0,2);
  }

  @Test(expected = RuntimeException.class)
  public void moreThanOneCoordinate() {
    new Direction(1,1,0);
  }

  @Test(expected = RuntimeException.class)
  public void noDirection() {
    new Direction(0,0,0);
  }

  @Test
  public void validDirection() {
    new Direction( 1, 0, 0);
    new Direction( 0, 1, 0);
    new Direction( 0, 0, 1);
    new Direction(-1, 0, 0);
    new Direction( 0,-1, 0);
    new Direction( 0, 0,-1);
  }

  @Test
  public void turnDirections() {
    assertContains(LEFT, UP.turnDirections());
    assertContains(RIGHT, UP.turnDirections());
    assertContains(FORWARD, UP.turnDirections());
    assertContains(BACKWARD, UP.turnDirections());
    assertContainsNot(UP, UP.turnDirections());
    assertContainsNot(DOWN, UP.turnDirections());

    assertContains(LEFT, DOWN.turnDirections());
    assertContains(RIGHT, DOWN.turnDirections());
    assertContains(FORWARD, DOWN.turnDirections());
    assertContains(BACKWARD, DOWN.turnDirections());
    assertContainsNot(UP, DOWN.turnDirections());
    assertContainsNot(DOWN, DOWN.turnDirections());

    assertContainsNot(LEFT, LEFT.turnDirections());
    assertContainsNot(RIGHT, LEFT.turnDirections());
    assertContains(FORWARD, LEFT.turnDirections());
    assertContains(BACKWARD, LEFT.turnDirections());
    assertContains(UP, LEFT.turnDirections());
    assertContains(DOWN, LEFT.turnDirections());

    assertContainsNot(LEFT, RIGHT.turnDirections());
    assertContainsNot(RIGHT, RIGHT.turnDirections());
    assertContains(FORWARD, RIGHT.turnDirections());
    assertContains(BACKWARD, RIGHT.turnDirections());
    assertContains(UP, RIGHT.turnDirections());
    assertContains(DOWN, RIGHT.turnDirections());

    assertContains(LEFT, FORWARD.turnDirections());
    assertContains(RIGHT, FORWARD.turnDirections());
    assertContainsNot(FORWARD, FORWARD.turnDirections());
    assertContainsNot(BACKWARD, FORWARD.turnDirections());
    assertContains(UP, FORWARD.turnDirections());
    assertContains(DOWN, FORWARD.turnDirections());

    assertContains(LEFT, BACKWARD.turnDirections());
    assertContains(RIGHT, BACKWARD.turnDirections());
    assertContainsNot(FORWARD, BACKWARD.turnDirections());
    assertContainsNot(BACKWARD, BACKWARD.turnDirections());
    assertContains(UP, BACKWARD.turnDirections());
    assertContains(DOWN, BACKWARD.turnDirections());
  }

  private void assertContainsNot(Direction d, Direction[] directions) {
    assertFalse("Direction " + d + " is in " + Arrays.deepToString(directions), isContained(d, directions));
  }

  private void assertContains(Direction d, Direction[] directions) {
    assertTrue("Direction " + d + " not in " + Arrays.deepToString(directions), isContained(d, directions));
  }

  private boolean isContained(Direction d, Direction[] directions) {
    boolean found = false;
    for (Direction dCand: directions) {
      if (dCand.equals(d)) {
        found = true;
      }
    }
    return found;
  }
}
