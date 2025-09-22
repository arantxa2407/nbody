import java.io.FileNotFoundException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    int numargs = args.length;
    assert numargs >= 4 : "invalid number of arguments";

    double dt = Double.parseDouble(args[0]);
    int pausetime = Integer.parseInt(args[1]);
    boolean trace = args[2].toLowerCase().equals("trace");

    String configType = args[3].toLowerCase();
    Universe universe = null;
// args: 1000 0 trace file data/3body.txt
    switch (configType) {
      case "file":
        String fname = args[4];
        universe = UniverseFactory.makeUniverseFromFile(fname);
        break;
      //args: 100 10 trace central 10 0.6
      case "central":
        int numBodies = Integer.parseInt(args[4]);
        double angleVelPos = Double.parseDouble(args[5]);
        universe = UniverseFactory.makeCentralConfiguration(numBodies, angleVelPos);
        break;
      //args: 10 10 trace planetary 8
      case "planetary":
        int numPlanets = Integer.parseInt(args[4]);
        universe = UniverseFactory.makePlanetaryConfiguration(numPlanets);
        break;
      //args:
      case "choreography":
        int nchoreography = Integer.parseInt(args[4]);
        universe = UniverseFactory.makeChoreography(nchoreography);
        break;
    }

    NBodySimulator simulator = new NBodySimulator(universe, dt, pausetime, trace);
    simulator.simulate();
  }
}