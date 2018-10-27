package wsi;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import wsi.model.Pogoda;
import wsi.model.Todo;

import java.util.List;

public class TodoReader {
    public static void main(String[] args) {

        RestTemplate template = new RestTemplate();

        //http://api.nbp.pl/api/exchangerates/rates/a/cad?format=json
        ResponseEntity<List<Todo>> response = template.exchange(
                "https://jsonplaceholder.typicode.com/todos",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Todo>>(){});
        List<Todo> datas = response.getBody();
        System.out.println(datas);


    }

}
