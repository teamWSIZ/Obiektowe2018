package wsi.http;


import org.springframework.web.bind.annotation.*;
import wsi.model.Todo;

import java.util.Date;

@RestController
@CrossOrigin
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


}
