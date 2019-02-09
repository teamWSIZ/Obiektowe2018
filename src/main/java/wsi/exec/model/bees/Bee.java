package wsi.exec.model.bees;

import lombok.Data;
import wsi.exec.model.places.Place;

import java.util.UUID;

/**
 * głupia pszczoła... pozostaje ciągle w swoim miejscu
 *
 * todo: jak stworzyć interface do pluginów, czyli pszczół podawanych z BeeMarketplace
 */

@Data
public class Bee implements Movable {
    private int strength;   //strength + capacity == 100
    private int capacity;
    private int food;
    private String id; //unikalny ID w roju

    private boolean canMove;

    public Bee() {
        //tworzenie domyślnej pszczoły
        strength = 50;
        capacity = 50;
        food = 0;
        id = UUID.randomUUID().toString().substring(0,8);
    }


    @Override
    public Place preferredMove(Place current) {
        setCanMove(false);
        return current;
    }

    @Override
    public boolean isCanMove() {
        return canMove;
    }

    @Override
    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setCapacity(int capacity) {
        if (capacity<0) capacity = 0;
        if (capacity>100) capacity = 100;
        this.capacity = capacity;
        this.strength = 100 - this.capacity;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public boolean validate() {
        return ((strength + capacity == 100) && (strength >= 0) &&
                (capacity >= 0) && food >= 0 && food <= capacity);
    }

    public String getId() {
        return id;
    }
}
