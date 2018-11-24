package wsi.exec;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wsi.exec.model.ExecResponse;
import wsi.exec.model.GenericResponse;
import wsi.exec.model.SensorData;
import wsi.exec.service.ExecEngine;

@RestController
@CrossOrigin
@Slf4j
public class MainController {
    @Autowired
    ExecEngine execEngine;

    @GetMapping(value = "/status")
    public String getStatus() {
        return "OK";
    }

    @GetMapping(value = "/execute")
    public ExecResponse execCommand(@RequestParam(value = "com") String command) {
        return execEngine.executeIt(command);
    }

    @PostMapping(value = "/update")
    public GenericResponse uploadData(@RequestBody SensorData sensorData) {

        return new GenericResponse("OK");
    }

}
