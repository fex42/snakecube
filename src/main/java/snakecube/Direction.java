package snakecube;

/**
 * Created by fex on 22.01.16.
 */
public class Direction {
  private int deltaX;
  private int deltaY;
  private int deltaZ;

  public Direction(int deltaX, int deltaY, int deltaZ) {
    checkAllowedDirection(deltaX, deltaY, deltaZ);
    this.deltaX = deltaX;
    this.deltaY = deltaY;
    this.deltaZ = deltaZ;
  }

  /** Convenience shortcut so you can write {@code Dir(x,y,z)} instead of {@code new Direction(x,y,z)}*/
  public static Direction Dir(int deltaX, int deltaY, int deltaZ) {
    return new Direction(deltaX, deltaY, deltaZ);
  }

  private void checkAllowedDirection(int deltaX, int deltaY, int deltaZ) {
    if (Math.abs(deltaX) + Math.abs(deltaY) + Math.abs(deltaZ) != 1) {
      throw new RuntimeException("illegal Direction (" + deltaX + ", " + deltaY + ", " + deltaZ + ")");
    }
  }

  public int getDeltaX() {
    return deltaX;
  }

  public int getDeltaY() {
    return deltaY;
  }

  public int getDeltaZ() {
    return deltaZ;
  }

  /**
   * @return the four Directions when turning by 90 degrees.
   */
  public Direction[] turnDirections() {
    Direction[] result = new Direction[4];
    result[0] = Dir(deltaY, deltaZ, deltaX);
    result[1] = Dir(-deltaY, -deltaZ, -deltaX);
    result[2] = Dir(deltaZ, deltaX, deltaY);
    result[3] = Dir(-deltaZ, -deltaX, -deltaY);
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Direction)) return false;

    Direction direction = (Direction) o;

    if (deltaX != direction.deltaX) return false;
    if (deltaY != direction.deltaY) return false;
    return deltaZ == direction.deltaZ;

  }

  @Override
  public int hashCode() {
    int result = deltaX;
    result = 31 * result + deltaY;
    result = 31 * result + deltaZ;
    return result;
  }

  @Override
  public String toString() {
    return "(" + deltaX +
        ", " + deltaY +
        ", " + deltaZ +
        ')';
  }
}
