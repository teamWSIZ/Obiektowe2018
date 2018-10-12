package wsi;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SzukaczTest {
    Szukacz testee;

    @Before
    public void setUp() throws Exception {
        testee = new Szukacz();
    }

    @Test
    public void easyContains() {
        //given
        int[] a = new int[]{0, 1, 2};
        //when
        boolean w = testee.doesContain(a, 1);
        //then
        assertThat(w).isTrue();
    }

    @Test
    public void easyDoesNotContain() {
        //given
        int[] a = new int[]{0, 1, 2};
        //when
        boolean w = testee.doesContain(a, 3);
        //then
        assertThat(w).isFalse();
    }

    @Test
    public void easyEmptyArray() {
        //given
        int[] a = new int[]{};
        //when
        boolean w = testee.doesContain(a, 1);
        //then
        assertThat(w).isFalse();
    }

    @Test
    public void easyLargeNumbers() {
        //given
        int[] a = new int[]{0, 1, 2,111,1111111};
        //when
        boolean w = testee.doesContain(a, 111);
        //then
        assertThat(w).isTrue();
    }
}