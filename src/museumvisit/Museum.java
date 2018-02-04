package museumvisit;

import java.util.Set;

public class Museum {

  private final Entrance entrance;
  private final Exit exit;
  private final Set<MuseumSite> sites;

  public Museum(Entrance entrance, Exit exit, Set<MuseumSite> sites) {
    this.entrance = entrance;
    this.exit = exit;
    this.sites = sites;
  }

  public static void main(String[] args) {
    final int numberOfVisitors = 100; // Your solution has to work with any
    // number of visitors
    final Museum museum = buildSimpleMuseum(); // buildLoopyMuseum();

    // create the threads for the visitors and get them moving

    // wait for them to complete their visit

    // Checking no one is left behind
    if (museum.getExit().getOccupancy() == numberOfVisitors) {
      System.out.println("\nAll the visitors reached the exit\n");
    } else {
      System.out
          .println("\n" + (numberOfVisitors - museum.getExit().getOccupancy())
              + " visitors did not reach the exit. Where are they?\n");
    }

    System.out.println(
        "Occupancy status for each room (should all be zero, but the exit site):");
    museum.getSites().forEach(s -> {
      System.out.println(
          "Site " + s.getName() + " final occupancy: " + s.getOccupancy());
    });
  }

  public static Museum buildSimpleMuseum() {
    // to be implemented
    return null;
  }

  public static Museum buildLoopyMuseum() {
    // to be implemented
    return null;
  }

  public Entrance getEntrance() {
    return entrance;
  }

  public Exit getExit() {
    return exit;
  }

  public Set<MuseumSite> getSites() {
    return sites;
  }
}
