import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Day1 {

  public static String[] parse(String filename) {
    try {
      File file = new File(filename);
      Scanner input = new Scanner(file);
      return input.nextLine().split(", ");
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
      return null;
    }
  }

  public static int numberOfBlocks(String filename, boolean part2) {
    int x = 0, y = 0, direction = 0;
    String instructions[] = parse(filename);
    ArrayList<String> visited = new ArrayList<String>();
    visited.add("0,0");
    for (int i = 0; i < instructions.length; i++) {
      if (instructions[i].charAt(0) == 'R') {
        direction = (direction + 1) % 4;
      } else {
        direction = (direction + 3) % 4;
      }
      int steps = 0;
      for (int j = 1; j < instructions[i].length(); j++) {
        steps = steps * 10 + (instructions[i].charAt(j) - '0');
      }

      if (part2) {
        for (int j = 1; j <= steps; j++) {
          if (direction == 0) {
            y++;
          } else if (direction == 1) {
            x++;
          } else if (direction == 2) {
            y--;
          } else if (direction == 3) {
            x--;
          }
          String current = x + "," + y;
          if (visited.contains(current)) {
            return Math.abs(x) + Math.abs(y);
          }
          visited.add(current);
        }
      } else {
        if (direction == 0) {
          y += steps;
        } else if (direction == 1) {
          x += steps;
        } else if (direction == 2) {
          y -= steps;
        } else if (direction == 3) {
          x -= steps;
        }
      }
    }
    return Math.abs(x) + Math.abs(y);
  }

  public static void main(String[] args) {
    String filename = "Day1Input.txt";
    System.out.println(numberOfBlocks(filename, false));
    System.out.println(numberOfBlocks(filename, true));
  }

}
