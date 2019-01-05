package wsi.exec.service;

import wsi.exec.model.EngineStatus;

import java.util.List;

public interface EngineInterface {
  List<Double> getTemps();

  EngineStatus start();

  EngineStatus stop();

  EngineStatus status();

  EngineStatus reverse();
}
