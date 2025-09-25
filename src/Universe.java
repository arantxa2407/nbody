
public class Universe {
  private int numBodies;
  private double radius;
  private Body[] bodies; //public??

  public Universe(Body[] bodies, double radius) {
    this.radius = radius;
    this.numBodies = bodies.length;
    this.bodies = bodies;
  }


  public void update(double dt){

    // initialize forces to zero
    Vector[] f =  new Vector[numBodies];
    for (int i = 0; i < numBodies; i++) {
      f[i] = new Vector(new double[2]);
    }

    //compute forces
      for (int i = 0; i < numBodies; i++) {
        for (int j = 0; j < numBodies; j++) {
          if (i != j) {
            f[i] = f[i].plus(bodies[i].forceFrom(bodies[j]));
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

  //para euler y leapfrog integrator

  public Vector getBodyVelocity( int i){
    return bodies[i].getVelocity();
  }

  public double getBodyMass(int i){
    return bodies[i].getMass();
  }

  public void setBodyPosition(int i, Vector v) {
    bodies[i].setPosition(v);
  }

  public void setBodyVelocity(int i, Vector v){
    bodies[i].setVelocity(v);
  }

  public void setBodyAcceleration(int i, Vector v){
    bodies[i].setAcceleration(v);
  }

  public Vector getBodyAcceleration(int i){
    return bodies[i].getAcceleration();
  }

  public Vector computeForceOn(int i){
    Vector f = new Vector(new double[2]);
    for (int j=0; j< numBodies; j++){
      if (i != j){
        f = f.plus(bodies[i].forceFrom(bodies[j]));
      }
    }
    return f;
  }


}
