package wsi.exec.model.bees;

import wsi.exec.model.places.Place;

import java.util.List;

public class WanderingBee extends Bee {

    @Override
    public Place preferredMove(Place current) {
        Place next =  selectDifferent(current, current.getNearbyPlaces());
        this.setCanMove(false);
        return next;
    }

    protected Place selectDifferent(Place current, List<Place> candidates) {
        System.out.println("selecting from: " + candidates);
        Place toGo = current;
        for(Place p : candidates) {
            if (!p.equals(current)) {
                toGo = p;
                break;
            }
        }
        System.out.println("selected: " + toGo);
        return toGo;
    }


}
