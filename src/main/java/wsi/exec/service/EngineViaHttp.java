package wsi.exec.service;

import com.google.common.util.concurrent.AtomicDouble;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import wsi.exec.model.EngineStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.springframework.http.HttpMethod.GET;

@Service
@Slf4j
public class EngineViaHttp implements EngineInterface, InitializingBean {
  @Autowired
  MeterRegistry registry;  //pozwala na eksport metryk do prometheus-a

  List<AtomicDouble> engineTemps;

  @Value("${realengine.url}")
  String engineURL;
  RestTemplate template;

  @Override
  public void afterPropertiesSet() throws Exception {
    template = new RestTemplate();
    log.info("Starting engine connection to: {}", engineURL);

    setupGauges();
  }

  private void setupGauges() {
    engineTemps = new ArrayList<>();
    for (int i = 0; i < 8; i++) {
//      AtomicDouble someTempValue = new AtomicDouble(20);
      //zamiast tworzyć "AtomicDouble" tworzymy go przez registry.gauge,
      //który rejestruje "gauge" (zestaw wawrtości) widocznych potem na
      // /actuator/prometheus
      // te wartości zczytuje potem prometheus i umożliwia graficzną prezentację
      // (np. przez graphana)
      AtomicDouble someTempValue = registry.gauge("enginetemp_" + i, new AtomicDouble(0));
      engineTemps.add(someTempValue);
    }
  }

  //https://crontab.guru/
  @Scheduled(cron = "0/5 * * * * ?")  ///cron expression; sec min hour day moth day_of_week
  public void updateCurrentEngineTemps() {
    List<Double> currentTemps = getTemps();
    ArrayList<Double> ct = new ArrayList<>(currentTemps); //zamiana listy na arraylist
    for (int i = 0; i < 8; i++) {
      engineTemps.get(i).set(ct.get(i));
    }
  }

  @Override
  public List<Double> getTemps() {
    log.info("Calling engine on: /temps");
    ResponseEntity<List<Double>> response = template.exchange(engineURL + "/temps",
            GET, null, new ParameterizedTypeReference<List<Double>>(){});
    return response.getBody();
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
