package wsi.chat.rest;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import wsi.chat.Service.MessageService;
import wsi.chat.Service.RoomService;
import wsi.chat.Service.UserService;
import wsi.chat.model.Message;
import wsi.chat.model.Response;
import wsi.chat.model.Room;
import wsi.chat.model.User;
import wsi.model.Pogoda;
import wsi.model.Todo;

import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@CrossOrigin
@Slf4j
public class MainController {

    @Autowired
    UserService userService;
    @Autowired
    RoomService roomService;
    @Autowired
    MessageService messageService;


    @RequestMapping(value = "/users/create", method = GET)
    public User createUser(
            @RequestParam(value = "nick") String nick) {
        log.info("Attempt to create user with nick [{}]", nick);
        return userService.createUser(nick);
    }

    @RequestMapping(value = "/rooms/create", method = GET)
    public Room createRoom(
            @RequestParam(value = "roomid") String roomid) {
        log.info("Attempt to create room with id[{}]", roomid);
        return roomService.createRoom(roomid);
    }

    ////////////////////////////////////////////

    //MESSAGES

    //CRUD (create read update delete)

    @RequestMapping(value = "/rooms/messages", method = GET)
    public List<Message> getAllMessagesInRoom(
            @RequestParam(value = "roomid") String roomid) {
        return messageService.getByRoom(roomid);
    }

    @RequestMapping(value = "/rooms/messages", method = POST)
    public Message postMessage(@RequestBody Message newMessage) {
        return messageService.create(newMessage);
    }

    @RequestMapping(value = "/rooms/messages", method = PUT)
    public Message updateMessage(@RequestBody Message toUpdate) {
        return messageService.update(toUpdate);
    }

    @RequestMapping(value = "/rooms/messages", method = DELETE)
    public Response deleteMessage(
            @RequestParam(value = "messageId") Integer messageId) {
        messageService.delete(messageId);
        return new Response("OK");
    }

    /// VOTING
//    @RequestMapping(value = "/rooms/messages/upvote", method = GET)
//    public Room upvoteMessage(@RequestParam(value = "messageid") String messageid) {
//        return roomService.createRoom(roomid);
//    }
//    @RequestMapping(value = "/rooms/messages/downvote", method = GET)
//    public Room downvoteMessage(@RequestParam(value = "messageid") String messageid) {
//        return roomService.createRoom(roomid);
//    }
//    @RequestMapping(value = "/rooms/messages/flag", method = GET)
//    public Room flagMessage(@RequestParam(value = "messageid") String messageid) {
//        return roomService.createRoom(roomid);
//    }




}
