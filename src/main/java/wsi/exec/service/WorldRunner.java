package wsi.exec.service;

import wsi.exec.model.bees.Bee;
import wsi.exec.model.bees.ScoutBee;
import wsi.exec.model.bees.WanderingBee;
import wsi.exec.model.places.Meadow;
import wsi.exec.model.places.Place;

import java.util.List;

import static java.util.Arrays.asList;

public class WorldRunner {

    static List<Place> worldWithTwoMeadows() {
        //zbudować świat
        Meadow m1 = new Meadow(10, "Mazańcowice");
        Meadow m2 = new Meadow(10, "Hałcnów");
        m1.addNearbyPlace(m2);
        m2.addNearbyPlace(m1);

        Bee b1 = new WanderingBee();
        Bee b2 = new ScoutBee();
        Bee b3 = new WanderingBee();
        m1.addBee(b1);
        m1.addBee(b2);
        m1.addBee(b3);
        return asList(m1, m2);
    }

    static List<Place> complicatedWorld() {
        //zbudować świat
        Meadow m1 = new Meadow(10, "m1");
        Meadow m2 = new Meadow(10, "m2");
        Meadow m3 = new Meadow(10, "m3");
        Meadow m4 = new Meadow(10, "m4");
        m1.addNearbyPlace(m2);
        m1.addNearbyPlace(m3);
        m2.addNearbyPlace(m1);
        m2.addNearbyPlace(m3);
        m2.addNearbyPlace(m4);
        m3.addNearbyPlace(m1);
        m3.addNearbyPlace(m2);
        m3.addNearbyPlace(m4);
        m4.addNearbyPlace(m2);
        m4.addNearbyPlace(m3);

        Bee b1 = new ScoutBee();
        m1.addBee(b1);
        return asList(m1, m2, m3, m4);
    }


    public static void main(String[] args) {

        //odpalić "run"
        World w = new World();
        w.initSimulation(complicatedWorld());
        w.runSimulation(5);
    }
}
