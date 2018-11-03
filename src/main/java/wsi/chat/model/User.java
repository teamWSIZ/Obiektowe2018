package wsi.chat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    String nick; //unikalny (sprawdzany przy tworzeniu)
    String pass; //generowany przy tworzeniu usera
}
