public class Frog {
  private String name;
  private int age;
  private double tongueSpeed;
  private boolean isFroglet;
  private static String species = "Rare Pepe";

  public Frog(String name, int age, double tongueSpeed) {
    this.name = name;
    this.age = age;
    this.tongueSpeed = tongueSpeed;

    if (age > 1 && age < 7) {
      this.isFroglet = true;
    } else {
      this.isFroglet = false;
    }
  }

  public Frog(String name, double ageInYears, double tongueSpeed) {
    this(name, (int)(ageInYears * 12), tongueSpeed);
  }

  public Frog(String name) {
    this(name, 5, 5.0);
  }

  public void grow(int ageInMonths) {

    int newAge = this.age + ageInMonths;

    if (this.age < 12) {
      if (newAge <= 12) {
        this.tongueSpeed += ageInMonths;
      } else {
        this.tongueSpeed += 12 - this.age;
      }
    } else if (this.age >= 12 && this.age < 30) {
      if (newAge >= 30) {
        this.tongueSpeed -= (newAge - 30);
      }
    } else if (this.age >=30) {
      this.tongueSpeed -= ageInMonths;
    }

    if (this.tongueSpeed <= 5) {
      this.tongueSpeed = 5;
    }

    this.age = newAge;
    if (this.age > 1 && this.age < 7) {
      this.isFroglet = true;
    } else {
      this.isFroglet = false;
    }
  }

  public void grow() {
    this.grow(1);
  }

  public void eat(Fly fly) {
    if (fly.isDead()) {
      return;
    }

    if (this.tongueSpeed > fly.getSpeed()) {
      if (fly.getMass() * 0.5 >= this.age) {
        this.grow();
      }
      fly.setMass(0);
    } else {
      fly.grow(1);
    }
  }

  public String toString() {
    if (this.isFroglet) {
      return String.format("My name is %s and I'm a rare froglet! I'm %d months old and my tongue has a speed of %.2f.", this.name, this.age, this.tongueSpeed);
    }
    return String.format("My name is %s and I'm a rare frog. I'm %d months old and my tongue has a speed of %.2f.", this.name, this.age, this.tongueSpeed);
  }

  public String getSpecies() {
    return Frog.species;
  }

  public void setSpecies(String species) {
    Frog.species = species;
  }
}
