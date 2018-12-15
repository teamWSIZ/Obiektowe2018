package wsi.exec.service;

import wsi.exec.model.ExecResponse;
import wsi.exec.model.VM;

import java.util.List;

public class VirtualBoxClient implements VirtualizationClient {
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
}
