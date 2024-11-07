public class Driver{
  public static void main(String[] args){
    Animal a1 =  new Animal("moo", 3, "cow");
    a1.speak();

    Bird b1 = new Bird("cacow", 2, "bird", 4.0, "yellow");
    b1.speak();
  }
}
