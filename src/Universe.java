
public class Universe {
  private int numBodies;
  private double radius;
  private Body[] bodies; //public??

  public Universe(Body[] bodies, double radius) {
    this.radius = radius;
    this.numBodies = bodies.length;
    this.bodies = bodies;
  }


  public void update(double dt, boolean choreography){

    // initialize forces to zero
    Vector[] f =  new Vector[numBodies];
    for (int i = 0; i < numBodies; i++) {
      f[i] = new Vector(new double[2]);
    }

    //compute forces
    if (choreography) {
      for (int i = 0; i < numBodies; i++) {
        for (int j = 0; j < numBodies; j++) {
          if (i != j) {
            f[i] = f[i].plus(bodies[i].forceFromChoreography(bodies[j]));
          }
        }
      }
    } else {
      for (int i = 0; i < numBodies; i++) {
        for (int j = 0; j < numBodies; j++) {
          if (i != j) {
            f[i] = f[i].plus(bodies[i].forceFrom(bodies[j]));
          }
        }
      }

    }

    // move the bodies
    for (int i = 0; i < numBodies; i++) {
      bodies[i].move(f[i], dt);
    }

  }

  public Vector getBodyPosition(int i){
    return bodies[i].getPosition();
  }

  public int getNumBodies() {
    return numBodies;
  }

  public double getRadius(){
    return radius;
  }

}
