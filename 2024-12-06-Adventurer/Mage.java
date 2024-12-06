public class Mage extends Adventurer {

  private int mana, maxMana;

  public Mage(String name) {
    super(name, 10);
    this.mana = 10;
    this.maxMana = 20;
  }

  public String getSpecialName() {
    return "Mana";
  }
}
