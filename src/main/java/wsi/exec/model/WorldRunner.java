package wsi.exec.model;

import wsi.exec.model.bees.Bee;
import wsi.exec.model.bees.WanderingBee;

import static java.util.Arrays.asList;

public class WorldRunner {
    public static void main(String[] args) {
        //zbudować świat
        Meadow m1 = new Meadow(10, "m1");
        Meadow m2 = new Meadow(10, "m2");
        m1.addNearbyPlace(m2);
        m2.addNearbyPlace(m1);

        Bee b1 = new WanderingBee();
        m1.addBee(b1);

        //odpalić "run"
        World w = new World();
        w.initSimulation(asList(m1,m2));
        w.runSimulation(5);
    }
}