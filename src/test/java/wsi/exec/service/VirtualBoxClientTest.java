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
public class VirtualBoxClientTest {
    VirtualBoxClient client;

    @Before
    public void setUp() throws Exception {
        client = new VirtualBoxClient();
    }

    @Test
    public void parseOK() {
        List<String> in = Arrays.asList("\"xb\" {e6d4e880-56b7-4a07-b539-1dacd1f13311}");

        //when
        List<VM> lista = client.parseVms(in);

        //then
        Assertions.assertThat(lista.size()).isEqualTo(1);

    }
}