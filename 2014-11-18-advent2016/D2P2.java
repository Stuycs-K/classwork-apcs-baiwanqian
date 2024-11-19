import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D2 {

  public static String bathroomCode(String filename) {
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
    System.out.println(bathroomCode("D2Input.txt"));
  }

}
