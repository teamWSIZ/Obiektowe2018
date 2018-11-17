package wsi.exec;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wsi.exec.model.ExecResponse;
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

}
