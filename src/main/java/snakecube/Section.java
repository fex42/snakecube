package snakecube;

/**
 * Created by fex on 23.01.16.
 */
public class Section {
  private final int len;
  private final Position[] positions;

  public Section(Position... positions) {
    this.len = positions.length;
    this.positions = new Position[len];
    for (int i = 0; i < len; i++) {
      this.positions[i] = positions[i];
    }
  }

  /** Convenience shortcut so you can write {@code Sol(...)} instead of {@code new Solution(...)} */
  public static Section Sec(Position... positions) {
    return new Section(positions);
  }

  /** Convenience method to build a Section starting at Position start, going into Direction dir for len cubes */
  public static Section Sec(Position start, Direction dir, int len) {
    Position[] pos = new Position[len - 1];
    Position p = start;
    for (int i = len - 2; i >= 0; i --) {
      pos[i] = p.neighbourPos(dir);
      p = pos[i];
    }
    return Sec(pos);
  }

  public int length() {
    return len;
  }

  public Position at(int i) {
    return positions[i];
  }

  public Position headPos() {
    if (len > 0) {
      return at(0);
    }
    return null;
  }

  public boolean allValid(ValidPredicate pred, Position[] blockedPositions) {
    for (Position pos: this.positions) {
      // check if position is within cube
      if (!pred.isValid(pos)) {
        return false;
      }
      // check if position is not blocked already
      for (Position blocked: blockedPositions) {
        if (blocked.equals(pos)) {
          return false;
        }
      }
    }
    return true;
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
