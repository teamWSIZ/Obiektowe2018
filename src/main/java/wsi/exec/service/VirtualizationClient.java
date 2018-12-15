package wsi.exec.service;

import wsi.exec.model.ExecResponse;
import wsi.exec.model.VM;

import java.util.List;

public interface VirtualizationClient {

    List<VM> listVms();

    ExecResponse start(String vmName);

    ExecResponse stop(String vmName);

    ExecResponse forceStop(String vmName);


}
