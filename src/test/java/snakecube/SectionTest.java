package snakecube;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static snakecube.Direction.Dir;
import static snakecube.Position.Pos;
import static snakecube.Section.Sec;

/**
 * Created by fex on 23.01.16.
 */
public class SectionTest {
  @Test
  public void simpleSection() {
    Section s1 = new Section(Pos(1,2,3));
    assertEquals(1, s1.length());
    assertEquals(1, s1.at(0).getX());
    assertEquals(2, s1.at(0).getY());
    assertEquals(3, s1.at(0).getZ());

    Section s2 = new Section(Pos(1,2,3), Pos(1,2,2));
    assertEquals(2, s2.length());
  }

  @Test
  public void buildSections() {
    assertEquals("[(1,3,1),(1,2,1)]", Sec(Pos(1,1,1), Dir(0,1,0), 3).toString());
    assertEquals("[(3,3,1),(2,3,1)]", Sec(Pos(1,3,1), Dir(1,0,0), 3).toString());
  }
}
