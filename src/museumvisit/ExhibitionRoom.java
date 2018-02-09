package museumvisit;

import java.util.ArrayList;
import java.util.List;

public class ExhibitionRoom extends MuseumSite {

  int capacity;

  public ExhibitionRoom(String name, int capacity) {
    super(name);
    assert capacity > 0;
    this.capacity = capacity;
    this.exitTurnstiles = new ArrayList<>();
  }

  public int getCapacity() {
    return this.capacity;
  }

  @Override
  boolean hasAvailability() {
    return this.getCapacity() > getOccupancy();
  }
}
