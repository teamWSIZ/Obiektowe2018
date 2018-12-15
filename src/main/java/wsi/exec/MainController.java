package wsi.exec;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wsi.exec.model.Alias;
import wsi.exec.model.ExecResponse;
import wsi.exec.model.VM;
import wsi.exec.service.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@Slf4j
public class MainController {
    @Autowired ExecEngine execEngine;
    @Autowired PasswordService passwordService;
    @Autowired AliasService aliasService;
    @Autowired VirtualizationClient virtualizationClient;

    int id = 0;
    List<Alias> aliasy = new ArrayList<>();


    @GetMapping(value = "/vm")
    public List<VM> listVMs() {
        return virtualizationClient.listVms();
    }
    @GetMapping(value = "/vm/{vmName}/start")
    public ExecResponse startVM(@PathVariable(value = "vmName") String vmName) {
        return virtualizationClient.start(vmName);
    }
    @GetMapping(value = "/vm/{vmName}/stop")
    public ExecResponse stopVM(@PathVariable(value = "vmName") String vmName) {
        return virtualizationClient.stop(vmName);
    }
    @GetMapping(value = "/vm/{vmName}/forcestop")
    public ExecResponse forceStopVM(@PathVariable(value = "vmName") String vmName) {
        return virtualizationClient.forceStop(vmName);
    }

    //---------------

    @GetMapping(value = "/alias/new")
    public Alias newAlias(@RequestParam(value = "alias") String alias) {
        //sprawdzenie czy już istnieje
        for(Alias a : aliasy) {
            if (a.getAlias().equals(alias)) {
                return new Alias(-1, ""); //już istnieje
            }
        }
        id++;
        Alias nowy = new Alias(id, alias);
        aliasy.add(nowy);
        return nowy;
    }

    @GetMapping(value = "/alias/byalias")
    public Alias findByAlias(@RequestParam(value = "alias") String alias) {
        //szukamy
        for(Alias a : aliasy) {
            if (a.getAlias().equals(alias)) {
                return a;
            }
        }
        return new Alias(-1,"");
    }

    @GetMapping(value = "/alias")
    public List<Alias> findAll() {
       return aliasy;

    }
    @GetMapping(value = "/alias/count")
    public Integer getAliasCount() {
        return aliasy.size();
    }








    //--------------------------------
    @GetMapping(value = "/status")
    public String getStatus() {
        return "OK";
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
