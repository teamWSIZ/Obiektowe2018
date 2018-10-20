package wsi;

import org.springframework.web.client.RestTemplate;
import wsi.model.Pogoda;

public class WeatherReader {
    public static void main(String[] args) {

        RestTemplate template = new RestTemplate();

        for (int i = 0; i < 10; i++) {
            Pogoda pogoda =
                    template.getForObject("http://10.10.26.127/update",
                            Pogoda.class);

            System.out.println("Odczytałem: " + pogoda);

        }




    }
}
