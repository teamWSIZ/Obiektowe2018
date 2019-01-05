package wsi.exec.http;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wsi.exec.model.EngineStatus;
import wsi.exec.model.GenericResponse;
import wsi.exec.service.EngineInterface;

/**
 * REST kontroler dla backendu systemu kontroli silnikiem
 */


@RestController
@CrossOrigin
@Slf4j
public class MainController {

    @Qualifier("engineViaHttp")
    @Autowired EngineInterface engineInterface;

    @GetMapping(value = "/s")
    public GenericResponse appStatus() {
        return new GenericResponse("App is running OK");
    }

    @GetMapping(value = "/enginestatus")
    public EngineStatus getEngineStatus() {
        return engineInterface.status();
    }


}
