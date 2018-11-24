package wsi.exec.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PasswordService {

    //wartość spod klucza app.password w application.properties (lub z parametru java -Dapp.password=...)
    //https://www.baeldung.com/spring-value-annotation
    @Value("${app.password:abra_kadabra}")
    String pass;

    public boolean checkPassword(String fromClient) {
        return pass.equals(fromClient);
    }


    public String getPass() {
        return pass;
    }
}
