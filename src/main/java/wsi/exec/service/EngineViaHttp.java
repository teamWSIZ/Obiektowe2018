package wsi.exec.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import wsi.exec.model.EngineStatus;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Service
@Slf4j
public class EngineViaHttp implements EngineInterface, InitializingBean {
//  String engineURL = "https://localhost:8443";
  @Value("${realengine.url}")
  String engineURL;
  RestTemplate template;

  @Override
  public void afterPropertiesSet() throws Exception {
    template = new RestTemplate();
    log.info("Starting engine connection to: {}", engineURL);
  }

  @Override
  public List<Double> getTemps() {
    return null;
  }

  @Override
  public EngineStatus start() {
    return callEngine("/start");
  }

  @Override
  public EngineStatus stop() {
    return callEngine("/stop");
  }

  @Override
  public EngineStatus status() {
    //powinien wysłać zapytanie po http do silnika by sprawdzić jego status...
    return callEngine("/status");
  }

  @Override
  public EngineStatus reverse() {
    return callEngine("/reverse");
  }

  //Helper method to call the realEngine via http
  private EngineStatus callEngine(String path) {
    log.info("Calling engine on: {}", path);
    ResponseEntity<EngineStatus> response = template.exchange(engineURL + path,
            GET, null, EngineStatus.class);
    return response.getBody();
  }
}
