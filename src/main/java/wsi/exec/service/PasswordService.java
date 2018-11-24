package wsi.exec.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PasswordService {

    @Value("${app.password:abra_kadabra}")
    String pass;

    public boolean checkPassword(String fromClient) {
        return pass.equals(fromClient);
    }


    public String getPass() {
        return pass;
    }
}
