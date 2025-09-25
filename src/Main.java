import java.io.FileNotFoundException;


public class Main {
  public static void main(String[] args) throws FileNotFoundException {

    double dt = 1000;
    int pausetime = 0;
    boolean trace = true;
    Integrator integrator = null;
    String configType = args[0].toLowerCase();
    String method = args[1].toLowerCase();
    Universe universe = null;

// args: 1000 0 trace file data/3body.txt
    switch (configType) {
      case "file":
        universe = UniverseFactory.makeUniverseFromFile("data/3body.txt");
        break;
      //args: 100 10 trace central 10 0.85
      case "central":
        dt = 100;
        pausetime = 10;
        universe = UniverseFactory.makeCentralConfiguration(10, 0.85);
        break;
      //args: 10 10 trace planetary 8
      case "planetary":
        dt = 5;
        pausetime = 10;
        universe = UniverseFactory.makePlanetaryConfiguration(8);
        break;
      //args: 0.0001 0 trace choreography 1 (infinito)
      //args: 0.0001 0 trace choreography 2 (corazon)
      case "choreography":
        dt = 0.0001;
        universe = UniverseFactory.makeChoreography(1);
        break;
    }

    switch (method){
      case "euler":
        integrator = new EulerIntegrator(dt);
        break;
        case "leapfrog":
          integrator = new LeapfrogIntegrator(dt);
    }

    NBodySimulator simulator = new NBodySimulator(universe, dt, pausetime, trace, integrator);
    simulator.simulate();



  }
}