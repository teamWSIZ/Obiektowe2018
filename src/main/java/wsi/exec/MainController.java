package wsi.exec;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wsi.exec.model.ExecResponse;
import wsi.exec.service.ExecEngine;
import wsi.exec.service.PasswordService;

@RestController
@CrossOrigin
@Slf4j
public class MainController {
    @Autowired ExecEngine execEngine;
    @Autowired PasswordService passwordService;

    @GetMapping(value = "/status")
    public String getStatus() {
        return "OK" + passwordService.getPass();
    }

    @GetMapping(value = "/execute")
    public ExecResponse execCommand(
            @RequestParam(value = "com") String command,
            @RequestParam(value = "pass") String pass) {
        if (!passwordService.checkPassword(pass)) {
            throw new RuntimeException("Bad password");
        }
        return execEngine.executeIt(command);
    }

}
