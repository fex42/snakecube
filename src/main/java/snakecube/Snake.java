package snakecube;

/**
 * Created by fex on 22.01.16.
 */
public class Snake {
  private int len;
  private int[] segments;

  public Snake(int... segments) {
    len = segments.length;
    this.segments = new int[len];
    for (int i = 0; i < len; i++) {
      this.segments[i] = segments[i];
    }
  }

  public int head() {
    return segments[0];
  }

  public boolean isEmpty() {
    return segments.length == 0;
  }

  public Snake tail() {
    int[] tailSegments = new int[len - 1];
    for (int i = 1; i < len; i++) {
      tailSegments[i - 1] = this.segments[i];
    }
    return new Snake(tailSegments);
  }
}
