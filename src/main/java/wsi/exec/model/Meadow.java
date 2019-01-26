package wsi.exec.model;

import java.util.ArrayList;
import java.util.List;

public class Meadow implements BeePlace {
    int internalFood;
    List<Bee> bees;
    List<BeePlace> nearbyPlaces;

    public Meadow(int internalFood) {
        this.internalFood = internalFood;
        bees = new ArrayList<>();
        nearbyPlaces = new ArrayList<>();
    }

    @Override
    public List<Bee> getBees() {
        return bees;
    }

    @Override
    public Integer getFood() {
        return internalFood;
    }

    @Override
    public List<BeePlace> nearbyPlaces() {
        return nearbyPlaces;
    }

    @Override
    public void beeEnters(Bee b) {
        bees.add(b);
    }

    @Override
    public void beeLeaves(Bee b) {

    }

    @Override
    public void addNearbyPlace(BeePlace other) {

    }
}
