package wsi.exec.service;

import wsi.exec.model.places.Place;

import java.util.List;

public class World {
    List<Place> places;


    //inicjalizuje warunki symulacji (miejsca i pszczoły)
    void initSimulation(List<Place> places) {
        this.places = places;
    }

    void runSimulation(int maxTurn) {
        for (int i = 0; i < maxTurn; i++) {
            runTurnSequence();
        }
    }



    void runTurnSequence() {
        printWorld();
        unfreezeBeeMovement();
        beesFeed();
        beesCommunicate();
        beesBreed();
        beesMove();
    }

    private void unfreezeBeeMovement() {
        places.forEach(place -> place.getBees().forEach(bee -> bee.setCanMove(true)));
    }

    private void beesFeed() {
        places.forEach(Place::beesFeed);
    }
    private void beesCommunicate() {
        places.forEach(Place::beesCommunicate);
    }
    private void beesBreed() {
        places.forEach(Place::beesBreed);
    }
    private void beesMove() {
        places.forEach(Place::beesMove);
    }

    public void printWorld() {
        System.out.println("----------------");
        places.forEach(place -> place.print());
        System.out.println("----------------");
    }



}
