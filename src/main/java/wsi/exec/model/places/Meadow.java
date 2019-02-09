package wsi.exec.model.places;

import wsi.exec.model.bees.Bee;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Meadow implements Place {
    int internalFood;
    List<Bee> bees;
    List<Place> nearbyPlaces;
    String name;

    public Meadow(int internalFood, String name) {
        this.internalFood = internalFood;
        this.name = name;
        bees = new ArrayList<>();
        nearbyPlaces = new ArrayList<>();
    }

    @Override
    public List<Bee> getBees() {
        return bees;
    }

    @Override
    public List<Place> getNearbyPlaces() {
        return nearbyPlaces;
    }

    @Override
    public void addBee(Bee b) {
        bees.add(b);
    }

    @Override
    public void removeBee(Bee b) {
        bees.remove(b);
    }

    @Override
    public void addNearbyPlace(Place other) {
        nearbyPlaces.add(other);
    }

    @Override
    public void beesFeed() {

    }

    @Override
    public void beesCommunicate() {

    }

    @Override
    public void beesBreed() {

    }

    @Override
    public void beesMove() {
        Set<Bee> toremove = new HashSet<>();
        bees.forEach(bee -> {
            if (!bee.isCanMove()) return; //nie robimy ruchu dla tej pszczoły bo się już ruszała
            Place next = bee.preferredMove(this);
            if (next.equals(this)) return; //nie ma ruchu, więc nic nie zmieniamy
            toremove.add(bee);
            next.addBee(bee);
        });

        toremove.forEach(this::removeBee);
    }

    @Override
    public void print() {
        System.out.println("   .......");
        System.out.println("      bees at this place (" + name + ")");
        bees.forEach(System.out::println);
        System.out.println("   .......");
    }
}
