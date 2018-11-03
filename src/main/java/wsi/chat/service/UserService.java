package wsi.chat.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import wsi.chat.model.User;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Serwis kontolujący tworzenie userów i sprawdzanie ich haseł.
 */

@Component
@Slf4j
public class UserService {
    Map<String,String> userPass;

    public UserService() {
        userPass = new ConcurrentHashMap<>();
    }

    public User createUser(String nick) {
        //sp czy nick istnieje
        if (userPass.containsKey(nick)) {
            log.warn("Cannot create user with nick [{}], key exists", nick);
            throw new RuntimeException("This nickname already exists");
        } else {
            //cztery znaki z losowego UUID'a
            String pass = UUID.randomUUID().toString().substring(0,4);
            userPass.put(nick, pass);
            log.info("Created user with nick [{}]", nick);
            return new User(nick, pass);
        }
    }

    /**
     * Sprawdzenie czy hasło podane zgadza się z oryginalnym hasłem
     */
    public boolean checkPassword(String nick, String pass) {
        if (!userPass.containsKey(nick)) return false;
        return userPass.get(nick).equals(pass);
    }
}
