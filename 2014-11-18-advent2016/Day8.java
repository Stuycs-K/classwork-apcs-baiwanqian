import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day8 {

  public static int countLitPixels(String filename) {
    int count = 0;
    int height = 6;
    int width = 50;
    boolean[][] screenIsLit = new boolean[height][width];
    try {
      File file = new File(filename);
      Scanner input = new Scanner(file);
      while (input.hasNextLine()) {
        String line = input.nextLine();
        if (line.indexOf("rect") == 0) {
          String[] parts = line.split(" ");
          String[] dimensions = parts[1].split("x");
          int a = Integer.parseInt(dimensions[0]);
          int b = Integer.parseInt(dimensions[1]);
          for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
              screenIsLit[i][j] = true;
            }
          }
        } else if (line.indexOf("rotate row") == 0) {
          String[] parts = line.split(" ");
          int row = Integer.parseInt(parts[2].substring(2));
          int shift = Integer.parseInt(parts[4]);
          boolean[] newRow = new boolean[width];
          for (int i = 0; i < width; i++) {
            newRow[(i + shift) % width] = screenIsLit[row][i];
          }
          screenIsLit[row] = newRow;
        } else if (line.indexOf("rotate column") == 0) {
          String[] parts = line.split(" ");
          int column = Integer.parseInt(parts[2].substring(2));
          int shift = Integer.parseInt(parts[4]);
          boolean[] newColumn = new boolean[height];
          for (int i = 0; i < height; i++) {
            newColumn[(i + shift) % height] = screenIsLit[i][column];
          }
          for (int i = 0; i < height; i++) {
            screenIsLit[i][column] = newColumn[i];
          }
        }
      }
      input.close();
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          if (screenIsLit[i][j]) {
            count++;
          }
        }
      }
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
    }
    return count;
  }

  public static void main(String[] args) {
    String filename = "Day8Input.txt";
    System.out.println(countLitPixels(filename));
  }

}
