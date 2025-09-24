import java.io.FileNotFoundException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    int numargs = args.length;
    assert numargs >= 4 : "invalid number of arguments";

    double dt = 1000;
    int pausetime = 0;
    boolean trace = args[2].toLowerCase().equals("trace");

    String configType = args[3].toLowerCase();
    Universe universe = null;
// args: 1000 0 trace file data/3body.txt
    switch (configType) {
      case "file":
        String fname = args[4];
        universe = UniverseFactory.makeUniverseFromFile(fname);
        break;
      //args: 100 10 trace central 10 0.85
      case "central":
        dt = 100;
        pausetime = 10;
        universe = UniverseFactory.makeCentralConfiguration(10, 0.85);
        break;
      //args: 10 10 trace planetary 8
      case "planetary":
        dt = 10;
        pausetime = 10;
        universe = UniverseFactory.makePlanetaryConfiguration(10);
        break;
      //args: 0.0001 0 trace choreography 10
      case "choreography":
        dt = 0.0001;
        universe = UniverseFactory.makeChoreography(10);
        break;
    }

    NBodySimulator simulator = new NBodySimulator(universe, dt, pausetime, trace);
    simulator.simulate();
  }
}