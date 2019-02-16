package egz;

import lombok.Data;

@Data
public class Order {
    String productName;
    String customer;
    int quantity;
}
