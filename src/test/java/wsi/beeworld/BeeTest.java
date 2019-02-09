package wsi.beeworld;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BeeTest {

    @Test
    public void name() {
        Assertions.assertThat(2).isEqualTo(2);
    }
}