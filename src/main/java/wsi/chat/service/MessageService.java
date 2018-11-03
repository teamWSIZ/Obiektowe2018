package wsi.chat.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wsi.chat.model.Message;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class MessageService {
    @Autowired
    UserService userService;
    @Autowired
    RoomService roomService;

    Map<Integer, Message> messageById;
    AtomicInteger idGenerator = new AtomicInteger();

    public MessageService() {
        messageById = new ConcurrentHashMap<>();
    }

    public List<Message> getByRoom(String roomid) {
        List<Message> result = new ArrayList<>();
        for(Message m : messageById.values()) {
            if (!m.getRoom().equals(roomid)) continue;
            result.add(m);
        }
        //trzeba postorować message po polu "id", by były zwrócone w
        //kolejności chronologicznej
        Collections.sort(result, Comparator.comparing(Message::getId));
        return result;
    }

    public Message create(Message newMessage) {
        //sprawdzić czy room istnieje
        if (newMessage.getRoom()==null ||
                !roomService.roomExists(newMessage.getRoom())) {
            throw new RuntimeException("Room does not exist");
        }

        //nadać nowy ID do message
        int id = idGenerator.incrementAndGet();
        newMessage.setId(id);

        //zapisać
        messageById.put(id, newMessage);

        //zwrócić message z ID
        return newMessage;
    }

    public Message update(Message toUpdate) {
        //sprawdzić czy room istnieje
        if (toUpdate.getRoom()==null ||
                !roomService.roomExists(toUpdate.getRoom())) {
            throw new RuntimeException("Room does not exist");
        }

        //sprawdzić czy ID istnieje
        if (!messageById.containsKey(toUpdate.getId())) {
            throw new RuntimeException("Message with given ID does not exist");
        }

        //zapisać
        messageById.put(toUpdate.getId(), toUpdate);

        //zwrócić message z ID
        return toUpdate;
    }


    public void delete(Integer messageId) {
        if (!messageById.containsKey(messageId)) {
            throw new RuntimeException("Message with given ID does not exist");
        }
        messageById.remove(messageId);
    }
}
