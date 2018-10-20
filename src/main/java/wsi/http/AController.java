package wsi.http;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import wsi.model.Pogoda;
import wsi.model.Todo;

import java.util.Date;

@RestController
@CrossOrigin
@Slf4j
public class AController {

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public String getStatus() {
        return "App is running OK, " + new Date();
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addition(
            @RequestParam(value = "a") Integer a,
            @RequestParam(value = "b") Integer b
                            ) {
        return "Wynik dodawania:" + (a+b);
    }

    //https://jsonplaceholder.typicode.com/
    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public Todo getTodo() {
        Todo res = new Todo(1, 3, "fugiat veniam minus", false);
        return res;
    }


    @RequestMapping(value = "/sala", method = RequestMethod.GET)
    public Pogoda getWeaterInRoom(
            @RequestParam(value = "id") String id
    ) {
        RestTemplate template = new RestTemplate();
        Pogoda pogoda = null;
        log.info("Getting weater info for [{}]", id);
        String url = "";
        if (id.equals("41")) url = "http://10.10.26.127/update";
        if (id.equals("31")) url = "http://10.10.27.16/update";
        log.info("url=[{}]", url);  //http://10.10.26.127/update
        pogoda = template.getForObject(url, Pogoda.class);
        return pogoda;
    }



}
