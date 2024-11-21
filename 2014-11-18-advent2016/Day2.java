import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {

  public static String findPasscode(String filename) {
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
      input.close();
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
    }
    return passcode;
  }

  public static String findPasscodePart2(String filename) {
    String[][] keypad = new String[][]{
      {null, null, "1", null, null},
       {null, "2", "3", "4", null},
        {"5", "6", "7", "8", "9"},
       {null, "A", "B", "C", null},
      {null, null, "D", null, null},
    };
    int y = 2, x = 0;
    String passcode = "";
    try {
      File file = new File(filename);
      Scanner input = new Scanner(file);
      while (input.hasNextLine()) {
        String dir = input.nextLine();
        for (int i = 0; i < dir.length(); i++) {
          char shift = dir.charAt(i);
          if (shift == 'U') {
            if (y > 0 && keypad[y-1][x] != null) y--;
          } else if (shift == 'D') {
            if (y < 4 && keypad[y+1][x] != null) y++;
          } else if (shift == 'R') {
            if (x < 4 && keypad[y][x+1] != null) x++;
          } else if (shift == 'L') {
            if (x > 0 && keypad[y][x-1] != null) x--;
          }
        }
        passcode += keypad[y][x];
      }
      input.close();
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
    }
    return passcode;
  }

  public static void main(String[] args) {
    String filename = "Day2Input.txt";
    System.out.println(findPasscode(filename));
    System.out.println(findPasscodePart2(filename));
  }

}
