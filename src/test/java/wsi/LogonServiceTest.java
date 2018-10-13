package wsi;


import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LogonServiceTest {
    LogonService testee;

    @Before
    public void setUp() throws Exception {
        testee = new LogonService();
    }


    @Test
    public void name1() {
        //given
        String user = "karol";
        String pass = "marks#123";
        //when
        testee.login(user, pass);
        //then
        assertThat(testee.isLoggedIn()).isTrue();
        assertThat(testee.loggedUser()).isEqualTo(user);
    }

    @Test
    public void name2() {
        //given
        String user = "karol";
        String pass = "marks#123";
        //when
        testee.login(user, pass);
        testee.logout();
        //then
        assertThat(testee.isLoggedIn()).isFalse();
    }
}