package wsi.exec.model.bees;

import wsi.exec.model.Place;

public interface Movable {

    Place preferredMove(Place current);

    public boolean isCanMove();

    public void setCanMove(boolean canMove);


}
