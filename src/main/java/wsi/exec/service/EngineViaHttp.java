package wsi.exec.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import wsi.exec.model.EngineStatus;

import java.util.List;

@Service
@Slf4j
public class EngineViaHttp implements EngineInterface {
//  String engineURL = "https://localhost:8443";
  String engineURL = "http://localhost:8081";
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
    log.info("Getting engine status from url: {}", engineURL);
    RestTemplate template = new RestTemplate();

    ResponseEntity<EngineStatus> response = template.exchange(engineURL + "/status",
      HttpMethod.GET,
      null, EngineStatus.class);
    EngineStatus status = response.getBody();
    log.info("Status of engine: {}", status);
    return status;
  }

  @Override
  public EngineStatus reverse() {
    return null;
  }
}
