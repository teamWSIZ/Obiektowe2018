package wsi.fin;


import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@CrossOrigin
@Slf4j
public class FinControler implements InitializingBean {
    //do metryk/monitorwania
    @Autowired
    MeterRegistry registry;

    AtomicInteger kurs;



    @Override
    public void afterPropertiesSet() throws Exception {
        kurs = registry.gauge("kurs_USD", new AtomicInteger(0));
    }

    @RequestMapping(value = "/fin_status", method = RequestMethod.GET)
    public String getStatus() {
        return "App is running OK, " + new Date();
    }


    //https://www.baeldung.com/spring-scheduled-tasks


//    @Scheduled(cron = "0 0/10 * * * ?")
    public void doSomethingInSchduledWay() {
        Random r = new Random();
        kurs.set(r.nextInt(100) + 10);
        log.info("doing...");
    }


}
