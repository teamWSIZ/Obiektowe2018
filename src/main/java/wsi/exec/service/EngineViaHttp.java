package wsi.exec.service;

import org.springframework.stereotype.Service;
import wsi.exec.model.EngineStatus;

import java.util.List;

@Service
public class EngineViaHttp implements EngineInterface {
  @Override
  public List<Double> getTemps() {
    return null;
  }

  @Override
  public EngineStatus start() {
    return null;
  }

  @Override
  public EngineStatus stop() {
    return null;
  }

  @Override
  public EngineStatus status() {
    //powinien wysłać zapytanie po http do silnika by sprawdzić jego status...
    return null;
  }

  @Override
  public EngineStatus reverse() {
    return null;
  }
}
