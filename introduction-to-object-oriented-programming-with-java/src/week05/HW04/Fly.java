public class Fly {
  private double mass;
  private double speed;

  public Fly(double mass, double speed) {
    this.mass = mass;
    this.speed = speed;
  }

  public Fly(double mass) {
    this(mass, 10.0);
  }

  public Fly() {
    this(5.0);
  }

  public double getMass() {
    return this.mass;
  }

  public void setMass(double mass) {
    this.mass = mass;
  }

  public double getSpeed() {
    return this.speed;
  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }

  public String toString() {
    if (this.mass == 0) {
      // return "I'm dead, but I used to be a fly with a speed of "
      return String.format("I'm dead, but I used to be a fly with a speed of %.2f.", this.speed);
    }

    return String.format("I'm a speedy fly with %.2f speed and %.2f mass.", this.speed, this.mass);
  }

  public void grow(int amount) {
    double newMass = this.mass + amount;

    if (newMass < 20) {
      this.speed += amount;
    }
    if (this.mass < 20 && newMass >= 20) {
      this.speed = this.speed + (20 - this.mass) - 0.5 * (newMass - 20);
    }
    if (this.mass >= 20 && newMass > 20) {
      this.speed -= 0.5 * amount;
    }

    // if (this.mass < 20) {
    //   this.speed += amount;
    // } else {
    //   this.speed = this.speed - (this.mass - 20)*0.5;
    // }

    this.mass = newMass;
  }

  public boolean isDead() {
    return this.mass == 0;
  }
}
