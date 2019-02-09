package wsi.exec.model.bees;

import wsi.exec.model.places.Place;

public interface Movable {

    Place preferredMove(Place current);

    boolean isCanMove();

    void setCanMove(boolean canMove);


}
