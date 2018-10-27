package wsi.fin;


import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import wsi.model.Pogoda;
import wsi.model.Todo;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@Slf4j
public class FinControler {

    @RequestMapping(value = "/fin_status", method = RequestMethod.GET)
    public String getStatus() {
        return "App is running OK, " + new Date();
    }


    //https://www.baeldung.com/spring-scheduled-tasks


    @Scheduled(cron = "0/10 * * * * ?")
    public void doSomethingInSchduledWay() {
        log.info("doing...");
    }


}
