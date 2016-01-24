package snakecube;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static snakecube.Position.Pos;
import static snakecube.Section.Sec;
import static snakecube.Solution.Sol;

/**
 * Created by fex on 23.01.16.
 */
public class SolutionTest {
  @Test
  public void simpleSolution() {
    Solution s0 = Sol(Sec(Pos(1,2,3)));
    assertEquals(1, s0.length());
    assertEquals("[[(1,2,3)]]", s0.toString());
  }

  @Test
  public void concatSolution() {
    Solution s0 = Sol(Sec(Pos(1,1,1)));
    Solution s1 = Sol(Sec(Pos(1,3,1), Pos(1,2,1)), s0);
    assertEquals(2, s1.length());
    assertEquals("[[(1,3,1),(1,2,1)],[(1,1,1)]]", s1.toString());
    assertEquals(Pos(1,3,1), s1.headPos());

    Solution s2 = Sol(Sec(Pos(3,3,1), Pos(2,3,1)), s1);
    assertEquals(2, s1.length());
    assertEquals("[[(3,3,1),(2,3,1)],[(1,3,1),(1,2,1)],[(1,1,1)]]", s2.toString());
    assertEquals(Pos(3,3,1), s2.headPos());
  }
}
