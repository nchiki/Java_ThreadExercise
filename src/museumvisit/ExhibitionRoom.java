package museumvisit;

import java.util.List;

public class ExhibitionRoom extends MuseumSite {

  int capacity;

  public ExhibitionRoom(String name, int capacity) {
    super(name);
    assert capacity > 0;
    this.capacity = capacity;
  }

  public int getCapacity() {
    return this.capacity;
  }

  @Override
  public void enter(){
    if(this.getOccupancy() < this.getCapacity()) {
      this.occupancy += 1;
    }
  }

  @Override
  boolean hasAvailability() {
    return this.getCapacity() > getOccupancy();
  }
}
