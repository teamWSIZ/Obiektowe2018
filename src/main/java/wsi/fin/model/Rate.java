package wsi.fin.model;

import lombok.Data;

import java.util.Date;

@Data
public class Rate {
    String no;
    Date effectiveDate;
    Double mid;
}
