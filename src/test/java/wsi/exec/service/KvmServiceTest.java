package wsi.exec.service;


import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import wsi.exec.model.VM;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class KvmServiceTest {
    KvmService kvmService;

    @Before
    public void setUp() throws Exception {
        kvmService = new KvmService();
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
        List<VM> vms = kvmService.parseVms(fixed);

        //asse
        Assertions.assertThat(vms).isNotEmpty();
        Assertions.assertThat(vms.size()).isEqualTo(2);
        Assertions.assertThat(vms.get(0).getState()).isEqualTo(kvmService.RUNNING);
        Assertions.assertThat(vms.get(1).getState()).isEqualTo(kvmService.SHUT_OFF);
        Assertions.assertThat(vms.get(0).getName()).isEqualTo("boston");
        Assertions.assertThat(vms.get(1).getName()).isEqualTo("eTester");
        Assertions.assertThat(vms.get(0).getId()).isEqualTo("3");
        Assertions.assertThat(vms.get(1).getId()).isEqualTo("-");
    }
}