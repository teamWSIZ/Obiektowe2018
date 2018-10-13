package wsi;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class OgrzewanieTest {
    Ogrzewanie testee;

    @Before
    public void setUp() throws Exception {
        testee = new Ogrzewanie();
    }

    @Test
    public void heat1() {
        //given
        int[] dane = new int[]{1};
        int r = 1;
        //when
        boolean allheated = testee.isHeated(dane, r);
        //then
        assertThat(allheated).isTrue();
    }

    @Test
    public void heat2() {
        //given
        int[] dane = new int[]{0};
        int r = 1;
        //when
        boolean allheated = testee.isHeated(dane, r);
        //then
        assertThat(allheated).isFalse();
    }

    @Test
    public void heat3() {
        //given
        int[] dane = new int[]{0,0,1,0,0,0,1,0,0,0,1};
        int r = 2;
        //when
        boolean allheated = testee.isHeated(dane, r);
        //then
        assertThat(allheated).isTrue();
    }

    @Test
    public void heat4() {
        //given
        int[] dane = new int[]{0,0,1,0,0,0,1,0,0,0,1};
        int r = -2;
        //when
        boolean allheated = testee.isHeated(dane, r);
        //then
        assertThat(allheated).isFalse();
    }

    @Test
    public void heat5() {
        //given
        int[] dane = new int[]{};
        int r = 1;
        //when
        boolean allheated = testee.isHeated(dane, r);
        //then
        assertThat(allheated).isTrue();
    }




}