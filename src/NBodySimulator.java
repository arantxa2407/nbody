public class NBodySimulator {

  private double timeStep;
  private int pauseTime;
  private boolean trace;
  private Universe universe;
  private Integrator integrator;

  public NBodySimulator(Universe universe, double dt, int pt, boolean doTrace, Integrator integrator) {
    this.universe = universe;
    timeStep = dt;
    pauseTime = pt;
    trace = doTrace;
    this.integrator = integrator;
  }

  public void simulate(  ){
    createCanvas(); // canvas creation
    StdDraw.clear(StdDraw.GRAY); // canvas clearing
    integrator.move(universe);
    //no trace simulation
    while(!trace){
      StdDraw.clear(); // canvas clearing
      universe.update(timeStep);
      drawUniverse();
      StdDraw.show();
      StdDraw.pause(pauseTime);
    }

    // Trace simulation
      while(trace){
        StdDraw.setPenColor(StdDraw.WHITE); //white trace
        drawUniverse();
        universe.update(timeStep);
        StdDraw.setPenColor(StdDraw.BLACK); //black body
        drawUniverse();
        StdDraw.show();
        StdDraw.pause(pauseTime);
    }
  }


  private void createCanvas() {
    //StdDraw.setCanvasSize(700, 700); // uncomment for a larger window
    StdDraw.enableDoubleBuffering();
    StdDraw.setPenRadius(0.025);
    double radius = universe.getRadius();
    //read from txt file, second line
    StdDraw.setXscale(-radius, +radius);
    StdDraw.setYscale(-radius, +radius);
  }

  private void drawUniverse(){
    for (int i = 0; i < universe.getNumBodies(); i++){
      StdDraw.setPenRadius(0.025);
      StdDraw.point(universe.getBodyPosition(i).cartesian(0),  universe.getBodyPosition(i).cartesian(1));
    }
  }
}
