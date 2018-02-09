package museumvisit;

import java.util.ArrayList;
import java.util.HashSet;
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
    final Museum museum = buildSimpleMuseum();
    //buildLoopyMuseum();

    List<Thread> visitors = new ArrayList<>();
    IntStream.range(0, numberOfVisitors).sequential().forEach(i -> {
      Thread visitorThread =
          new Thread(new Visitor("Vis" + i, museum.getEntrance()));
      visitors.add(visitorThread);
      visitorThread.start();
    });

    // wait for them to complete their visit

      visitors.forEach(v -> {
          try {
              v.join();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      });

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
    Entrance ent = new Entrance();
    Exit ex = new Exit();
    ExhibitionRoom mainRoom = new ExhibitionRoom("Exhibition Room", 10);
    Turnstile tEnt = new Turnstile(ent, mainRoom);
    Turnstile tmainRoom = new Turnstile(mainRoom, ex);
    Set<MuseumSite> sites = new HashSet<>();
    sites.add(mainRoom);
    return new Museum(ent, ex, sites);
  }

  public static Museum buildLoopyMuseum() {
  Entrance ent = new Entrance();
  Exit ex = new Exit();
  ExhibitionRoom VKCroom = new ExhibitionRoom("VenomKillerandCureRoom", 10);
  ExhibitionRoom WERoom = new ExhibitionRoom("WhalesExhibitionRoom", 10);
  Turnstile tEnt = new Turnstile(ent, VKCroom);
  Turnstile tVKCroom1 = new Turnstile(VKCroom, ex);
  Turnstile tVCKroom2 = new Turnstile(VKCroom, WERoom);
  Turnstile tWERoom = new Turnstile(WERoom, VKCroom);
  Set<MuseumSite> sites = new HashSet<>();
    sites.add(VKCroom);
  sites.add(WERoom);
    return new Museum(ent, ex, sites);
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
