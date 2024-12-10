public class Mage extends Adventurer {

  private int mana, maxMana;

  public Mage(String name) {
    super(name, 10);
    this.mana = 10;
    this.maxMana = 15;
  }

  public String getSpecialName() {
    return "Mana";
  }

  public int getSpecial() {
    return mana;
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
    return this.getName() + " chucks a spell on " + other.getName() + ", dealing " + damage + " damage.";
  }

  public String support(Adventurer other) {
    int heal = 3;
    if (other.getHP() + heal > super.getmaxHP()) {
      heal = super.getmaxHP() - other.getHP();
    }
    other.setHP(other.getHP() + heal);
    return this.getName() + " casts a heal on " + other.getName() + ", healing " + heal + " HP.";
  }

  public String support() {
    int heal = 4;
    if (this.getHP() + heal > super.getmaxHP()) {
      heal = super.getmaxHP() - this.getHP();
    }
    this.setHP(this.getHP() + heal);
    return this.getName() + " casts a heal on themselves, healing " + heal + " HP.";
  }

  public String specialAttack(Adventurer other) {
    if (this.mana >= 5) {
      int specialDamage = 5;
      other.applyDamage(specialDamage);
      this.mana -= 5;
      return this.getName() + " chucks a stronger spell on " + other.getName() + ", dealing " + specialDamage + " damage.";
    } else {
      return this.getName() + " has insufficient mana to cast a special attack." + this.attack(other);
    }
  }

}
