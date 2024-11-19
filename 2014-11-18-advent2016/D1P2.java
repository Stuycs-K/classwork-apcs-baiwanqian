import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class D1P2 {

  public static void main(String[] args) {
    String filename = "Day1Input.txt";
    try {
      File file = new File(filename);
      Scanner input = new Scanner(file);
      String[] instructions = input.nextLine().split(", ");
      int x = 0, y = 0, direction = 0;
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
            System.out.println(Math.abs(x) + Math.abs(y));
            return;
          }
          visited.add(current);
        }
      }
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
    }
  }

}
