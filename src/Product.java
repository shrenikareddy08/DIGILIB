public class Product {

    int id;
    String name;
    double price;
    int quantity;

    Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void display() {
        System.out.println(id + " " + name + " " + price + " " + quantity);
    }
}