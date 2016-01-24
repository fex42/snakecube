package snakecube;

/**
 * Created by fex on 22.01.16.
 */
public class Position {
  private int x;
  private int y;
  private int z;

  public Position(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /** Convenience shortcut so you can write {@code Pos(x,y,z)} instead of {@code new Position(x,y,z)} */
  public static Position Pos(int x, int y, int z) {
    return new Position(x, y, z);
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getZ() {
    return z;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Position)) return false;

    Position position = (Position) o;

    if (x != position.x) return false;
    if (y != position.y) return false;
    return z == position.z;

  }

  @Override
  public int hashCode() {
    int result = x;
    result = 31 * result + y;
    result = 31 * result + z;
    return result;
  }

  @Override
  public String toString() {
    return "(" + x +
        "," + y +
        "," + z +
        ')';
  }

  public Position neighbourPos(Direction d) {
    return Pos(this.x + d.getDeltaX(), this.y + d.getDeltaY(), this.z + d.getDeltaZ());
  }
}
