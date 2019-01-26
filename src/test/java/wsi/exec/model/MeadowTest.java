package wsi.exec.model;


import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MeadowTest {
    Meadow testee;

    @Before
    public void setUp() throws Exception {
        testee = new Meadow(100);
    }

    @Test
    public void oneBeeEnters_isInMeadow() {
        //given
        Bee b = new Bee();
        //when
        testee.beeEnters(b);
        //then
        assertThat(testee.getBees()).containsOnly(b);
    }

    @Test
    public void oneBeeEnters_thenLeaves_noBeeInMeadow() {
        //given
        Bee b = new Bee();
        //when
        testee.beeEnters(b);
        testee.beeLeaves(b);
        //then
        assertThat(testee.getBees()).isEmpty();
    }
}