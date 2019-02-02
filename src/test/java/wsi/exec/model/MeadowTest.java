package wsi.exec.model;


import org.junit.Before;
import org.junit.Test;
import wsi.exec.model.bees.Bee;

import static org.assertj.core.api.Assertions.assertThat;

public class MeadowTest {
    Meadow testee;

    @Before
    public void setUp() throws Exception {
        testee = new Meadow(100, "x");
    }

    @Test
    public void oneBeeEnters_isInMeadow() {
        //given
        Bee b = new Bee();
        //when
        testee.addBee(b);
        //then
        assertThat(testee.getBees()).containsOnly(b);
    }

    @Test
    public void oneBeeEnters_thenLeaves_noBeeInMeadow() {
        //given
        Bee b = new Bee();
        //when
        testee.addBee(b);
        testee.removeBee(b);
        //then
        assertThat(testee.getBees()).isEmpty();
    }
}