import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {

  public static void main(String[] args) {
    String filename = "Day1Input.txt";
    try {
      File file = new File(filename);
      Scanner input = new Scanner(file);
      String[] instructions = input.nextLine().split(", ");
      int x, y, direction = 0;
      for (int i = 0; i < instructions.length(); i++) {
        if (instructions[i].charAt(0) == 'R') {
          direction = (direction + 1) % 4;
        } else {
          direction = (direction + 3) % 4;
        }
      int steps = 0;
      for (int j = 1; j < instructions[i].length(); j++) {
        steps = steps * 10 + (instructions[i].charAt(j) - '0');
      }
      if (direction == 0) {
        y += steps;
      }
      if (direction == 1) {
        x += steps;
      }
      if (direction == 2) {
        y -= steps;
      }
      if (direction == 3) {
        x -= steps;
      }
    }
    System.out.println(Math.abs(x) + Math.abs(y));
  } catch (FileNotFoundException ex) {
    System.out.println("File not found");
  }
}
}
