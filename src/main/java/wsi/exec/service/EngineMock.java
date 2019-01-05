package wsi.exec.service;

import org.springframework.stereotype.Service;
import wsi.exec.model.EngineStatus;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Symuluje realny silnik
 */

@Service
public class EngineMock {
  List<Double> temps;
  int direction;  //1 or -1
  int runningState; //1 or -1 or 0 for not running

  public EngineMock() {
    temps = Arrays.asList(20.,20.,20.,20.,20.,20.,20.,20.,20.);
    direction = 1;
    runningState = 0;
  }

  public List<Double> getTemps() {
    mockTimeLapse();
    return temps;
  }

  public EngineStatus start() {
    if (runningState==0) {
      runningState = direction;
    }
    return getCurrentState();
  }

  public EngineStatus stop() {
    if (runningState!=0) {
      runningState = 0;
    }
    return getCurrentState();
  }


  public EngineStatus status() {
    return new EngineStatus(direction, runningState);
  }


  public EngineStatus reverse() {
    if (runningState==0) {
      direction = -direction;
    } else {
      mockReverse();
      direction = -direction;
      runningState = - runningState;
    }
    return getCurrentState();
  }

  private void mockTimeLapse() {
    Random r = new Random();
    for (int i = 0; i < temps.size(); i++) {
      temps.set(i, temps.get(i) + r.nextDouble() * 0.1 - 0.05);
    }
  }

  private void mockReverse() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private EngineStatus getCurrentState() {
    return new EngineStatus(direction, runningState);
  }

}
