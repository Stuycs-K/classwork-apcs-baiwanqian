import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3 {

  public static int countTrianglesA(String filename) {
    int validTriangles = 0;
    try {
      File file = new File(filename);
      Scanner input = new Scanner(file);
      while (input.hasNextInt()) {
        int side1 = input.nextInt();
        int side2 = input.nextInt();
        int side3 = input.nextInt();
        if (isValidTriangle(side1, side2, side3)) {
          validTriangles++;
        }
      }
      input.close();
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
    }
    return validTriangles;
  }

  public static int countTrianglesB(String filename) {
    int validTriangles = 0;
    try {
      File file = new File(filename);
      Scanner input = new Scanner(file);
      while (input.hasNextInt()) {
        int[] col1 = new int[3];
        int[] col2 = new int[3];
        int[] col3 = new int[3];
        for (int i = 0; i < 3; i++) {
          col1[i] = input.nextInt();
          col2[i] = input.nextInt();
          col3[i] = input.nextInt();
        }
        if (isValidTriangle(col1[0], col1[1], col1[2])) {
          validTriangles++;
        }
        if (isValidTriangle(col2[0], col2[1], col2[2])) {
          validTriangles++;
        }
        if (isValidTriangle(col3[0], col3[1], col3[2])) {
          validTriangles++;
        }
      }
      input.close();
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
    }
    return validTriangles;
  }

  public static boolean isValidTriangle(int a, int b, int c) {
    return (a + b > c) && (a + c > b) && (b + c > a);
  }

  public static void main(String[] args) {
    String filename = "Day3Input.txt";
    System.out.println(countTrianglesA(filename));
    System.out.println(countTrianglesB(filename));
  }

}
