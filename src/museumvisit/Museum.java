package museumvisit;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class  Museum {

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

    List<Thread> visitors = new ArrayList<>();
    IntStream.range(0, numberOfVisitors).sequential().forEach(i -> {
      Thread visitorThread =
          new Thread(new Visitor("Vis" + i, museum.getEntrance()));
      visitors.add(visitorThread);
      visitorThread.start();
      visitorThread.run();
    });

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
    Set<MuseumSite> sites = new HashSet<>();
    sites.add(new ExhibitionRoom("Exhibitionroom", 10));
    return new Museum(new Entrance(), new Exit(), sites);
  }

  public static Museum buildLoopyMuseum() {
    Set<MuseumSite> sites = new HashSet<>();
    sites.add(new ExhibitionRoom("Whales Exhibition Room", 10));
    sites.add(new ExhibitionRoom("VenomKillerAndCUreRoom", 10));
    return new Museum(new Entrance(), new Exit(), sites);
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
