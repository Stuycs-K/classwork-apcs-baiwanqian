import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D3 {

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

  public static boolean isValidTriangle(int a, int b, int c) {
    return (a + b > c) && (a + c > b) && (b + c > a);
  }

  public static void main(String[] args) {
    System.out.println(countTrianglesA("inputTri.txt"));
  }

}
