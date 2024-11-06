import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TriangleTester {

  public static int countTrianglesA(String filename) {
    int validTriangles = 0;
    try {
      File file = new File(filename);
      Scanner input = new Scanner(file);
      while (input.hasNextInt()) {
        int side1 = input.nextInt();
        int side2 = input.nextInt();
        int side3 = input.nextInt();
        if (side1 + side2 > side3 || side3 + side2 > side1 || side1 + side3 > side2) {
          validTriangles++;
        }
      }
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
    }
    return validTriangles;
  }
