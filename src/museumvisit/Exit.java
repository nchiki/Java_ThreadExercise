package museumvisit;

public class Exit extends MuseumSite {
public Exit() {
    super("Exit");
    }

public List<Turnstile> getExitTurnstiles(){
    return new ArrayList<Turnstile>();
    }

}
