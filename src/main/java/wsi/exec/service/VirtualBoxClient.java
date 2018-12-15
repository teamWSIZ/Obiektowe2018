package wsi.exec.service;

import com.google.common.base.Splitter;
import wsi.exec.model.ExecResponse;
import wsi.exec.model.VM;

import java.util.ArrayList;
import java.util.List;

/**
 * Uwaga: trzeba jakoś podać ścieżkę do VBoxManage (na windows).
 *
 * Komendy:
 * VBoxManage list vms
 * VBoxManage list runningvms
 * VBoxManage start xb
 * VBoxManage controlvm xb poweroff
 */


public class VirtualBoxClient implements VirtualizationClient {
    String RUNNING = "running";
    String SHUT_OFF = "shut off";
    String PAUSED = "paused";


    @Override
    public List<VM> listVms() {
        return null;
    }

    @Override
    public ExecResponse start(String vmName) {
        return null;
    }

    @Override
    public ExecResponse stop(String vmName) {
        return null;
    }

    @Override
    public ExecResponse forceStop(String vmName) {
        return null;
    }

    /**
     * Podaje listę wszystkich istniejących VM
     */
    List<VM> parseVms(List<String> resp) {
        List<VM> vms = new ArrayList<>();
        for(String s : resp) {
            s = s.replace("\"", "");
            s = s.replace("{", "");
            s = s.replace("}", "");
            List<String> ss = Splitter.on(" ").trimResults().omitEmptyStrings().splitToList(s);
            vms.add(new VM(ss.get(0), ss.get(1), RUNNING));
        }
        return vms;
    }

    }
