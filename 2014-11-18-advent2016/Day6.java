import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day6 {

  public static String correctMessage(String filename, boolean isPart2) {
    String message = "";
    try {
      File file = new File(filename);
      Scanner input = new Scanner(file);
      int[][] frequencies = new int[8][26];
      while (input.hasNextLine()) {
        String line = input.nextLine();
        for (int i = 0; i < line.length(); i++) {
          char c = line.charAt(i);
          frequencies[i][c - 'a']++;
        }
      }
      if (isPart2) {
        for (int col = 0; col < frequencies.length; col++) {
          int leastCount = 2147483647;
          char leastChar = 'a';
          for (int i = 0; i < frequencies[col].length; i++) {
            if (frequencies[col][i] > 0 && frequencies[col][i] < leastCount) {
              leastCount = frequencies[col][i];
              leastChar = (char)('a' + i);
            }
          }
          message += leastChar;
        }
      } else {
        for (int col = 0; col < frequencies.length; col++) {
          int mostCount = 0;
          char mostChar = 'a';
          for (int i = 0; i < frequencies[col].length; i++) {
            if (frequencies[col][i] > mostCount) {
              mostCount = frequencies[col][i];
              mostChar = (char)('a' + i);
            }
          }
          message += mostChar;
        }
      }
      input.close();
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
    }
    return message;
  }

  public static void main(String[] args) {
    String filename = "Day6Input.txt";
    System.out.println(correctMessage(filename, false));
    System.out.println(correctMessage(filename, true));
  }

}
