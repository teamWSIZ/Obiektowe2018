package wsi.exec.service.publisher;

import wsi.exec.model.places.Place;

import java.util.List;

/**
 * Publikuje stan świata do klienta podłączonego przez websocket
 */
public class WebsocketPublisher implements WorldPublisher {
    @Override
    public void publishWorld(List<Place> places) {
        
    }
}
