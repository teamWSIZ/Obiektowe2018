package wsi.exec.service.publisher;

import wsi.exec.model.places.Place;

import java.util.List;

public interface WorldPublisher {
    void publishWorld(List<Place> places);
}
