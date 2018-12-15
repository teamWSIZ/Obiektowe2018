package wsi.exec.service;


import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import wsi.exec.model.VM;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class KvmClientTest {
    KvmClient kvmClient;

    @Before
    public void setUp() throws Exception {
        kvmClient = new KvmClient();
    }

    @Test
    public void parseOKTest() {
        //given
        List<String> fixed = Arrays.asList(
                " Id    Name                           State\n",
                "----------------------------------------------------\n",
                " 3     boston                         running\n",
                " -     eTester                        shut off\n"
        );

        //when
        List<VM> vms = kvmClient.parseVms(fixed);

        //then
        assertThat(vms).isNotEmpty();
        assertThat(vms.size()).isEqualTo(2);
        assertThat(vms.get(0).getState()).isEqualTo(kvmClient.RUNNING);
        assertThat(vms.get(1).getState()).isEqualTo(kvmClient.SHUT_OFF);
        assertThat(vms.get(0).getName()).isEqualTo("boston");
        assertThat(vms.get(1).getName()).isEqualTo("eTester");
        assertThat(vms.get(0).getId()).isEqualTo("3");
        assertThat(vms.get(1).getId()).isEqualTo("-");
    }

    @Test
    public void parseVmPausedTest() {
        //given
        List<String> fixed = Arrays.asList("setlocale: No such file or directory\n",
                " Id    Name                           State\n",
                "----------------------------------------------------\n",
                " 3     boston                         running\n",
                " 5     DenverWD2                      running\n",
                " 12    monitor                        paused\n",
                " -     eTester                        shut off\n",
                " -     SerwerAnalizRuchuSieciowego    shut off");

        //when
        List<VM> vms = kvmClient.parseVms(fixed);

        //then
        assertThat(vms).isNotEmpty();
        assertThat(vms.size()).isEqualTo(5);
        assertThat(vms.get(2).getState()).isEqualTo(kvmClient.PAUSED);
        assertThat(vms.get(2).getName()).isEqualTo("monitor");
        assertThat(vms.get(2).getId()).isEqualTo("12");
    }
}