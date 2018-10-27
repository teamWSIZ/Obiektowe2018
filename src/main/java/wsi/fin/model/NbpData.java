package wsi.fin.model;


import lombok.Data;

import java.util.List;

@Data
public class NbpData {
    String table;
    String currency;
    String code; //CAD
    List<Rate> rates;

}
