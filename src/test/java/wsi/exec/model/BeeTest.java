package wsi.exec.model;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import wsi.exec.model.bees.Bee;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnit4.class)
@Slf4j
public class BeeTest {
    Bee testee;

    @Before
    public void setUp() throws Exception {
        log.info("Uruchamiam `before`");
        testee = new Bee();
    }

    @Test
    public void beeExists() {
        assertThat(testee).isNotNull();
    }

    @Test
    public void checkStrengthPlusCapacity() {
        assertThat(testee.validate()).isTrue();
    }

    @Test
    public void checkEquals() {
        Bee w1 = new Bee();
        Bee w2 = new Bee();
        assertThat(w1).isEqualTo(w2);
    }

    @Test
    public void capacitySetterWorks() {
        testee.setCapacity(90);
        assertThat(testee.getCapacity()).isEqualTo(90);
        assertThat(testee.getStrength()).isEqualTo(10);
    }

    @Test
    public void strengthSetterWorks() {
        testee.setStrength(5);
        assertThat(testee.getCapacity()).isEqualTo(95);
        assertThat(testee.getStrength()).isEqualTo(5);
    }

    @Test
    public void cantExceedFoodCapacity() {
        testee.setFood(110);
        assertThat(testee.getFood()).isEqualTo(100);
    }

}