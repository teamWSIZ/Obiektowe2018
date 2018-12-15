package wsi.exec.service;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Splitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wsi.exec.model.ExecResponse;
import wsi.exec.model.VM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class KvmClient implements VirtualizationClient {
    @Autowired ExecEngine execEngine;

    String RUNNING = "running";
    String SHUT_OFF = "shut off";
    String PAUSED = "paused";


    @Override
    public List<VM> listVms() {
        ExecResponse resp = execEngine.executeIt("virsh list --all");
        return parseVms(resp.getOut());
    }

    @Override
    public ExecResponse start(String vmName) {
        if (!vmExists(vmName)) throw new RuntimeException("VM does not exist");
        return execEngine.executeIt("virsh start " + vmName);
    }

    @Override
    public ExecResponse stop(String vmName) {
        if (!vmExists(vmName)) throw new RuntimeException("VM does not exist");
        return execEngine.executeIt("virsh shutdown " + vmName);
    }

    @Override
    public ExecResponse forceStop(String vmName) {
        if (!vmExists(vmName)) throw new RuntimeException("VM does not exist");
        return execEngine.executeIt("virsh destroy " + vmName);
    }


    /**
     * Na podstawie wyniku komendy `virsh list --all` tworzy listę
     * wirtualnych maszyn dostępnych w systemie.
     *
     * - Nazwy maszyn nie powinny zawierać spacji
     */
    @VisibleForTesting
    List<VM> parseVms(List<String> resp) {
        List<VM> vms = new ArrayList<>();
        for(String line : resp) {
            line = line.trim();
            if (line.contains(RUNNING)) {
                List<String> ss = Splitter.on(" ").trimResults().omitEmptyStrings().splitToList(line);
                vms.add(new VM(ss.get(1), ss.get(0), RUNNING));
            }
            if (line.contains(SHUT_OFF)) {
                List<String> ss = Splitter.on(" ").trimResults().omitEmptyStrings().splitToList(line);
                vms.add(new VM(ss.get(1), ss.get(0), SHUT_OFF));
            }
            if (line.contains(PAUSED)) {
                List<String> ss = Splitter.on(" ").trimResults().omitEmptyStrings().splitToList(line);
                vms.add(new VM(ss.get(1), ss.get(0), PAUSED));
            }
        }
        return vms;
    }

    /**
     * Sprawdza czy na systemie jest dostępna maszyna o nazwie `vmName`
     */
    private boolean vmExists(String vmName) {
        List<VM> existing = listVms();
        for(VM vm : existing) if (vm.getName().equals(vmName)) return true;
        return false;
    }

}
