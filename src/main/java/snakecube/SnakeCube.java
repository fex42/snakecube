package snakecube;

import java.util.ArrayList;
import java.util.List;

import static snakecube.Direction.Dir;
import static snakecube.Position.Pos;
import static snakecube.Section.Sec;
import static snakecube.Solution.Sol;

/**
 * Created by fex on 22.01.16.
 */
public class SnakeCube {
  public final static int CUBE_SIZE = 3;

  public final static Snake SNAKE1 = new Snake(3,2,2,3,2,3,2,2,3,3,2,2,2,3,3,3,3);
  public final static Snake SNAKE2 = new Snake(3,3,2,3,2,3,2,2,2,3,3,3,2,3,3,3);

  public static void main(String[] args) {
    SnakeCube app = new SnakeCube();
    app.run();
  }

  private void run() {
    Snake snake = SNAKE1;
    Solution initialSolution = Sol(Sec(Pos(1,1,1)));
    Direction currentDirection = Dir(1,0,0);
    List<Solution> validSolutions = new ArrayList<Solution>();

    findSolutions(snake, initialSolution, currentDirection, validSolutions);

    printSolutions(validSolutions);
  }

  private void printSolutions(List<Solution> validSolutions) {
    System.out.println("Found " + validSolutions.size() + " valid solutions:");
    int i = 1;
    for (Solution s: validSolutions) {
      System.out.println("Solution #" + i + " (" + s.usedBricks() + " positions):");
      System.out.println(s);
      i++;
    }
  }

  private void findSolutions(Snake snake, Solution partialSolution, Direction currentDirection, List validSolutions) {
    if (snake.isEmpty()) {
      validSolutions.add(partialSolution);
    } else {

      for (Direction newDir : currentDirection.turnDirections()) {

        Solution[] ps = partialSolution.extend(partialSolution, newDir, snake.head(), new ValidPredicate() {
          @Override
          public boolean isValid(Position p) {
            return inCube(p);
          }
        });
        // only recourse, when a solution is found
        for(Solution s: ps) {
          findSolutions(snake.tail(), s, newDir, validSolutions);
        }
      }
    }
  }

  private boolean inCube(Position p) {
    return p.getX() >= 1 && p.getX() <= CUBE_SIZE
        && p.getY() >= 1 && p.getY() <= CUBE_SIZE
        && p.getZ() >= 1 && p.getZ() <= CUBE_SIZE;
  }
}
