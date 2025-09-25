
public class Body {
    private Vector position;           // position
    private Vector velocity;           // velocity
    private final double mass;  // mass
    private double gravity = 6.67e-11;
    private Vector acceleration;

    public Body(Vector r, Vector v, double mass) {
        this.position = r;
        this.velocity = v;
        this.mass = mass;
    }
    public Body(Vector r, Vector v, double mass, double gravity) {
        this.position = r;
        this.velocity = v;
        this.mass = mass;
        this.gravity = gravity;
    }


    public void move(Vector f, double dt) {
        Vector a = f.scale(1/mass);
        velocity = velocity.plus(a.scale(dt));
        position = position.plus(velocity.scale(dt));
    }

    public Vector forceFrom(Body b) {
        Body a = this;
//        double G = 6.67e-11;
        Vector delta = b.position.minus(a.position);
        double dist = delta.magnitude();
        double magnitude = (a.gravity * a.mass * b.mass) / (dist * dist);
        return delta.direction().scale(magnitude);

    }



    public Vector getPosition(){
      return position;
    }

    public Vector getVelocity(){
        return velocity;
    }

    public double getMass(){
        return mass;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    public Vector getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vector acceleration) {
        this.acceleration = acceleration;
    }

    @Override
    public String toString() {
        return "position "+position.toString()+", velocity "+velocity.toString() + ", mass "+mass;
    }
}
