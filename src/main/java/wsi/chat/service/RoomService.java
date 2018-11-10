package wsi.chat.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import wsi.chat.model.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Serwis kontolujący tworzenie userów i sprawdzanie ich haseł.
 */

@Component
@Slf4j
public class RoomService {
    Set<String> roomIds;

    public RoomService() {
        roomIds = new ConcurrentSkipListSet<>();
    }

    public Room createRoom(String id) {
        if (roomIds.contains(id))
            throw new RuntimeException("This room already exists");
        roomIds.add(id);
        return new Room(id);
    }

    //Zwraca wszystkie dostępne chat-roomy
    public List<Room> getRooms() {
        List<Room> result = new ArrayList<>();
        for(String id : roomIds) {
            Room r = new Room(id);
            result.add(r);
        }

        return result;
    }


    public boolean roomExists(String id) {
        return roomIds.contains(id);
    }

}
