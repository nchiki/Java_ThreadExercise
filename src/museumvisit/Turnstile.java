package museumvisit;

import java.util.Optional;

public class Turnstile {

  private final MuseumSite originRoom;
  private final MuseumSite destinationRoom;
  private final MuseumSite r1 = getDestinationRoom();
  private final MuseumSite r2 = getOriginRoom();

  public Turnstile(MuseumSite originRoom, MuseumSite destinationRoom) {
    assert !originRoom.equals(destinationRoom);
    this.originRoom = originRoom;
    this.destinationRoom = destinationRoom;
    this.originRoom.exitTurnstiles.add(this);  }


  public Optional<MuseumSite> passToNextRoom(){
    if(this.destinationRoom.hasAvailability()){
      this.originRoom.exit();
      this.destinationRoom.enter();
      return Optional.of(this.destinationRoom);
    } else{
      return Optional.empty();
    }
  }


  public MuseumSite getOriginRoom() {
    return this.originRoom;
  }

  public MuseumSite getDestinationRoom() {
    return this.destinationRoom;
  }
}
