public abstract class Canine {
  protected double size;
  public Canine(double size) {
    this.size = size;
  }

  // public Canine() {
  //   this.size = 0;
  // }
  public void bark() {
    System.out.println("Woof Woof");
  }

  public abstract void groom();
}