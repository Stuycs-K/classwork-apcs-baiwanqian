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

  public void setSpecial(int n) {
    this.mana = n;
  }

  public int getSpecialMax() {
    return this.maxMana;
  }

  public String attack(Adventurer other) {
    int damage = 2;
    other.applyDamage(damage);
    return this.getName() + " chucks a spell on " + other.getName() + " for " + damage + " damage.";
  }


}
