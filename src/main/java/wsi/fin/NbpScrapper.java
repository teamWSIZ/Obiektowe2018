package wsi.fin;

import org.springframework.web.client.RestTemplate;
import wsi.fin.model.NbpData;
import wsi.fin.model.Rate;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class NbpScrapper {
    public static void main(String[] args) throws InterruptedException {
        List<String> waluty = asList("USD", "EUR", "CHF", "GBP", "AUD", "SGD", "RUB", "UAH");


        RestTemplate template = new RestTemplate();

        List<Rate> kursy = new ArrayList<>();
        for( String w : waluty) {
            NbpData kurs = template.getForObject(
                    "http://api.nbp.pl/api/exchangerates/rates/a/" + w + "?format=json",
                    NbpData.class);
            kursy.add(kurs.getRates().get(0));
        }

        for(Rate r : kursy) {
            System.out.println(r);
        }

    }

}
