package wsi.exec.model;


import lombok.Data;

import java.util.List;

@Data
public class ExecResponse {
    List<String> out;
    List<String> err;
}
