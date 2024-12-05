public class Driver {

  public static void drawBorder() {
    Text.color(Text.BRIGHT, Text.BLUE, Text.background(Text.CYAN));
    for (int i = 1; i <= 80; i++) {
      Text.go(1, i);
      System.out.print(" ");
      Text.go(30, i);
      System.out.print(" ");
    }
    for (int i = 2; i <= 29; i++) {
      Text.go(i, 1);
      System.out.print(" ");
      Text.go(i, 80);
      System.out.print(" ");
    }
    System.out.print(Text.RESET);
  }

  public static int[] createRandomArray(int size) {
    int[] randArray = new int[size];
    for (int i = 0; i < size; i++) {
      randArray[i] = (int) (Math.random() * 100);
    }
    return randArray;
  }

  public static void displayRandom(int[] randArray) {
    int position = 20;
    for (int num : randArray) {
      if (num < 25) {
        Text.color(Text.BRIGHT, Text.RED);
      } else if (num > 75) {
        Text.color(Text.BRIGHT, Text.GREEN);
      } else {
        Text.color(Text.BRIGHT, Text.WHITE);
      }
      Text.go(2, position);
      System.out.print(String.valueOf(num));
      position += 20;
    }
    System.out.print(Text.RESET);
  }

  public static void drawHorizontalSeperator() {
    Text.color(Text.BRIGHT, Text.BLACK, Text.background(Text.CYAN));
    for (int i = 1; i <= 80; i++) {
      Text.go(3, i);
      System.out.print("-");
    }
    System.out.print(Text.RESET);
  }

  public static void drawInMiddle() {
    int x = 15;
    int y = 40;
    Text.go(x, y);
    System.out.print("^ ^");
    Text.go(x + 1, y);
    System.out.print("o.o");
    Text.go(x + 2, y - 1);
    System.out.print("\\| |/");
    Text.go(x + 3, y);
    System.out.print("| |");
  }

  public static void main(String[] args) {
    System.out.print(Text.CLEAR_SCREEN);
    System.out.print(Text.HIDE_CURSOR);
    drawBorder();
    int[] randomNums = createRandomArray(3);
    displayRandom(randomNums);
    drawHorizontalSeperator();
    drawInMiddle();
    Text.go(31, 1);
    System.out.print(Text.RESET);
  }

}
