public abstract class Integrator {
  protected double timeStep;

  public Integrator(double timeStep) {
    this.timeStep = timeStep;
  }

  public void move (Universe universe){
  }
}
