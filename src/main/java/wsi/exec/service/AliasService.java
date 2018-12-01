package wsi.exec.service;

import org.springframework.stereotype.Service;
import wsi.exec.model.Alias;

import java.util.ArrayList;
import java.util.List;

@Service
public class AliasService {
    List<Alias> aliasy = new ArrayList<>();


    public Alias getById(int id) {
        for(Alias a : aliasy) {
            if (a.getId()==id) {
                return a;
            }
        }
        return new Alias(-1, "");    //nie znaleziony
    }






}
