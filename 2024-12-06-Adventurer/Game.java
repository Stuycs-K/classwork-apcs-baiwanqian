import java.util.Scanner;

public class Game {
  public static void main(String[] args) {

    Adventurer player = new CodeWarrior("Player", 20, "Java");
    Adventurer enemy = new Mage("Enemy");

    while (player.isAlive() && enemy.isAlive()) {
      System.out.println(player.getName() + ": " + player.getHP() + "/" player.getMaxHP() +
      " HP, " + player.getSpecial() + "/" + player.getSpecialMax() + " " + player.getSpecialName();
      System.out.println(enemy.getName() + ": " + enemy.getHP() + "/" enemy.getMaxHP() +
      " HP, " + enemy.getSpecial() + "/" + enemy.getSpecialMax() + " " + enemy.getSpecialName();

      Scanner userInput = new Scanner(System.in);
      System.out.println("Type: (a)ttack / (sp)ecial / (su)pport / quit");
      String input = userInput.nextLine().toLowerCase();
      if (input.equals("quit")) {
        System.out.println("Logging out...");
        return;
      }
      String move;
      if (input.equals("a")) || input.equals("attack") {
        move = player.attack(enemy);
      } else if (choice.equals("sp") || choice.equals("special")) {
        move = player.specialAttack(enemy);
      } else if (choice.equals("su") || choice.equals("support")) {
        move = player.support();
      } else {
        System.out.println("Input Invalid! Try again.");
      }
  }
}
