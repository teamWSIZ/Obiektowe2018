package egz;


import java.util.List;

public interface Vendor {

    List<String> getProducts();  //lista dostępnych potraw

    List<Order> getOrders();  //lista zamówień

    Order orderProduct(String productName, String custormer, int quantity);  //tworzy nowe zamówienie

}
