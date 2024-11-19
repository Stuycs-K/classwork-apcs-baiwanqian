import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D2 {

  public static void main(String[] args) {
    String filename = "D2Input.txt";
    int[][] keypad = new int[][]{
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };
    int y = 1, x = 1;
    String passcode = "";
    try {
      File file = new File(filename);
      Scanner input = new Scanner(file);
      while (input.hasNextLine()) {
        String dir = input.nextLine();
        for (int i = 0; i < dir.length(); i++) {
          char shift = dir.charAt(i);
          if (shift == 'U') {
            if (y > 0) y--;
          } else if (shift == 'D') {
            if (y < 2) y++;
          } else if (shift == 'R') {
            if (x < 2) x++;
          } else if (shift == 'L') {
            if (x > 0) x--;
          }
        }
        passcode += keypad[y][x];
      }
      System.out.println(passcode);
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
    }
  }

}
