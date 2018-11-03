package wsi.chat.rest;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import wsi.chat.Service.RoomService;
import wsi.chat.Service.UserService;
import wsi.chat.model.Room;
import wsi.chat.model.User;
import wsi.model.Pogoda;
import wsi.model.Todo;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@Slf4j
public class MainController {

    @Autowired
    UserService userService;
    @Autowired
    RoomService roomService;


    @RequestMapping(value = "/users/create", method = RequestMethod.GET)
    public User createUser(
            @RequestParam(value = "nick") String nick) {
        log.info("Attempt to create user with nick [{}]", nick);
        return userService.createUser(nick);
    }

    @RequestMapping(value = "/rooms/create", method = RequestMethod.GET)
    public Room createRoom(
            @RequestParam(value = "roomid") String roomid) {
        log.info("Attempt to create room with id[{}]", roomid);
        return roomService.createRoom(roomid);
    }


}
