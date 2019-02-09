package wsi.exec.model.bees;

import wsi.exec.model.places.Place;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DebugScoutBee extends ScoutBee {
    @Override
    public Place preferredMove(Place current) {
        Place next = super.preferredMove(current);
        ///tutaj dopisać kod wypisujący na ekran coś w stylu:
        ///  bee: (id); has visited ... places so far
        /// liczba odwiedzonych miejsc to: visited.size();
        return next;
    }
}
