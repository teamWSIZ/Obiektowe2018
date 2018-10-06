package wsi;

import org.assertj.core.data.Percentage;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KalkulatorTest {
    Kalkulator testee;

    @Before
    public void setUp() throws Exception {
        testee = new Kalkulator();
    }

    @Test
    public void shouldAddNumbersCorrectly() {
        //given

        //when
        int u = testee.add(5, 6);
        //then
        assertThat(u).isEqualTo(11);
    }

    @Test
    public void shouldAddNumbersWithNegativeCorrectly() {
        //given

        //when
        int u = testee.add(5, -6);
        //then
        assertThat(u).isEqualTo(-1);
    }

    @Test
    public void shouldDivideIntegers() {
        //given

        //when
        int u = testee.divide(5, 2);
        //then
        assertThat(u).isEqualTo(2);
    }

    @Test(expected = ArithmeticException.class)
    public void shouldThrowErrorsOnDivisionByZero() {
        //given

        //when
        int u = testee.divide(5, 0);
        //then
        //exception thrown
    }

    @Test
    public void shouldDivideDoubles() {
        //given

        //when
        double u = testee.divide(5.0, 2.0);
        //then
        assertThat(u).isCloseTo(2.5, Percentage.withPercentage(0.1));
    }


}