package wsi.exec.model;

import lombok.Data;

@Data
public class Bee {
    int strength;   //strength + capacity == 100
    int capacity;
    int food;

    public Bee() {
        //tworzenie domyślnej pszczoły
        strength = 50;
        capacity = 50;
        food = 0;
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

}
