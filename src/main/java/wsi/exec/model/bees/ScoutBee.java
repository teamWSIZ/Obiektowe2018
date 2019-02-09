package wsi.exec.model.bees;

import wsi.exec.model.places.Place;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ScoutBee extends WanderingBee {
    Set<Place> visited = new HashSet<>();

    /**
     * Typowy skaut: leci tylko do miejsc w których jeszcze nie była ...
     * (najprawdopodobniej padnie z powodu braku żywności,
     * ale zwiedzi spory kawał świata)
     */

    @Override
    public Place preferredMove(Place current) {
        List<Place> candidates = current.getNearbyPlaces();
        candidates.removeAll(visited);
        Place selected = selectDifferent(current, candidates);
        visited.add(selected);
        setCanMove(false);
        return selected;
    }
}
