package snakecube;

import static snakecube.Section.Sec;

/**
 * Created by fex on 23.01.16.
 */
public class Solution {
  private final int len;
  private final Section[] sections;

  public Solution(Section... sections) {
    this.len = sections.length;
    this.sections = new Section[len];
    for (int i = 0; i < len; i++) {
      this.sections[i] = sections[i];
    }
  }

  /** Convenience shortcut so you can write {@code Sol(...)} instead of {@code new Solution(...)} */
  public static Solution Sol(Section... sections) {
    return new Solution(sections);
  }

  public Solution(Section section, Solution sol) {
    this.len = sol.length() + 1;
    this.sections = new Section[len];
    this.sections[0] = section;
    for (int i = 1; i < len; i ++) {
      this.sections[i] = sol.at(i - 1);
    }
  }

  /** Convenience shortcut so you can write {@code Sol(...)} instead of {@code new Solution(...)} */
  public static Solution Sol(Section sec, Solution sol) {
    return new Solution(sec, sol);
  }

  private Section at(int i) {
    return sections[i];
  }

  public int length() {
    return this.len;
  }

  public Position headPos() {
    if (len > 0) {
      return at(0).headPos();
    }
    return null;
  }

  public Solution[] extend(Solution s, Direction d, int len, ValidPredicate p) {
    Position start = s.headPos();
    Section sect = Sec(start, d, len);
    if (sect.allValid(p, usedPositions())) {
      return new Solution[] { Sol(sect, s) };
    } else {
      return new Solution[] {};
    }
  }

  private Position[] usedPositions() {
    Position[] result = new Position[usedBricks()];
    int n = 0;
    for(int i = 0; i < length(); i++) {
      Section s = at(i);
      for (int j = 0; j < s.length(); j++) {
        result[n++] = s.at(j);
      }
    }
    return result;
  }

  public int usedBricks() {
    int n = 0;
    for (Section s: this.sections) {
      n += s.length();
    }
    return n;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (int i = 0; i < this.len; i++) {
      if (i > 0) {
        sb.append(',');
      }
      sb.append(at(i));
    }
    sb.append(']');
    return sb.toString();
  }
}
