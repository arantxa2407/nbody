public class NBodySimulator {

  private double timeStep;
  private int pauseTime;
  private boolean trace;
  private Universe universe;

  public NBodySimulator(Universe universe, double dt, int pt, boolean doTrace){
    this.universe = universe;
    timeStep = dt;
    pauseTime = pt;
    trace = doTrace;
  }

  public void simulate(){
    createCanvas(); // canvas creation
//    while(true){
//      StdDraw.clear(); // canvas clearing
//      universe.update(timeStep);
//      drawUniverse();
//      StdDraw.show();
//      StdDraw.pause(pauseTime);
//    }

    // Per simular amb trace

    StdDraw.clear(StdDraw.GRAY); // canvas clearing
    while(true){
      StdDraw.setPenColor(StdDraw.WHITE);
      drawUniverse();
      universe.update(timeStep);
      StdDraw.setPenColor(StdDraw.BLACK);
      drawUniverse();
      StdDraw.show();
      StdDraw.pause(pauseTime);
    }

  }

  public void simulateChoreography(){
    createCanvas(); // canvas creation
//    while(true){
//      StdDraw.clear(); // canvas clearing
//      universe.update(timeStep);
//      drawUniverse();
//      StdDraw.show();
//      StdDraw.pause(pauseTime);
//    }

    // Per simular amb trace

    StdDraw.clear(StdDraw.GRAY); // canvas clearing
    while(true){
      StdDraw.setPenColor(StdDraw.WHITE);
      drawUniverse();
      universe.updateChoreography(timeStep);
      StdDraw.setPenColor(StdDraw.BLACK);
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
