import java.util.Scanner;

public class Game {

  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);

    Adventurer player = new CodeWarrior("Player", 20, "Java");
    Adventurer enemy = new Mage("Enemy");

    System.out.println("A");

    boolean runGame = true;

    while (runGame) {
      System.out.println(player.getName() + ": " + player.getHP() + "/" player.getMaxHP() +
      " HP, " + player.getSpecial() + "/" + player.getSpecialMax() + " " + player.getSpecialName();
      System.out.println(enemy.getName() + ": " + enemy.getHP() + "/" enemy.getMaxHP() +
      " HP, " + enemy.getSpecial() + "/" + enemy.getSpecialMax() + " " + enemy.getSpecialName();

      boolean validInput = true;

      System.out.println("Type: (a)ttack / (sp)ecial / (su)pport / quit");
      String input = userInput.nextLine().toLowerCase();

      if (input.equals("quit")) {
        System.out.println("Logging out...");
        runGame = false;
      } else if (input.equals("a")) || input.equals("attack") {
        System.out.println(player.attack(enemy));
      } else if (choice.equals("sp") || choice.equals("special")) {
        System.out.println(move = player.specialAttack(enemy));
      } else if (choice.equals("su") || choice.equals("support")) {
        System.out.println(player.support());
      } else {
        System.out.println("Input Invalid! Try again.");
        validInput = false;
      }

      if (validInput && runGame) {
        if (enemy.isAlive()) {
          int enemyMove = (int) (Math.random() * 3);
          if (enemyMove == 0) {
            System.out.println(enemy.attack(player));
          } else if (enemyMove == 1) {
            System.out.println(enemy.specialAttackPlayer());
          } else {
            System.out.println(enemy.support());
          }
          if (!player.isAlive()) {
            System.out.println("You were slain by the enemy.");
            runGame = false;
          }
        } else {
          System.out.println("You have slain the enemy!");
        }
      }
    }
    userInput.close();
  }

}
