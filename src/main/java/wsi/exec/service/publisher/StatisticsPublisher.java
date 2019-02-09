package wsi.exec.service.publisher;

import wsi.exec.model.places.Place;

import java.util.List;

/**
 * Publikuje ogólne statystyczne własności roju w każdej z lokalizacji
 * (np. liczba pszczół każdego typu, średnie obciążenie żywnością itd)
 */
public class StatisticsPublisher implements WorldPublisher {
    @Override
    public void publishWorld(List<Place> places) {
        
    }
}
