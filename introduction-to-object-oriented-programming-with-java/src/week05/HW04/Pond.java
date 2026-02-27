public class Pond {
  public static void main(String[] args) {
    Frog peepo = new Frog("Peepo");
    Frog pepe = new Frog("Pepe", 10, 15.0);
    Frog peepaw = new Frog("Peepaw", 4.6, 5.0);
    Frog walker = new Frog("Walker", 15, 10.0);

    Fly fly1 = new Fly(1.0, 3.0);
    Fly fly2 = new Fly(6.0);
    Fly fly3 = new Fly();

    peepo.setSpecies("1331 Frogs");
    System.out.println(peepo.toString());
    peepo.eat(fly2);
    System.out.println(fly2.toString());
    peepo.grow(8);
    peepo.eat(fly2);
    System.out.println(fly2.toString());
    System.out.println(peepo.toString());
    System.out.println(walker.toString());
    peepaw.grow(4);
    System.out.println(peepaw.toString());
    System.out.println(pepe.toString());

    Frog test = new Frog("test", 31, 20);
    // test.grow(8);
    test.grow();
    test.grow();
    test.grow();
    test.grow();
    test.grow();
    test.grow();
    test.grow();
    test.grow();
    System.out.println(test.toString());
  }
}
