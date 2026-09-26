class ProductLL {
    ProductOnline head;

    // Add product
    void addProduct(String name, double price) {
        ProductOnline newProduct = new ProductOnline(name, price);
        if (head == null) {
            head = newProduct;
        } else {
            ProductOnline temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newProduct;
        }
        System.out.println(name + " added to cart!");
    }

    // Show cart and total
    void showCart() {
        if (head == null) {
            System.out.println("Your cart is empty!");
            return;
        }
        System.out.println("\n🛍️ Shopping Cart:");
        ProductOnline temp = head;
        int i = 1;
        double total = 0;
        while (temp != null) {
            System.out.println(i + ". " + temp.name + " - $" + temp.price);
            total += temp.price;
            temp = temp.next;
            i++;
        }
        System.out.println("Total Price: $" + total);
    }

    // Remove product by name
    void removeProduct(String name) {
        if (head == null) {
            System.out.println("Cart is empty!");
            return;
        }

        if (head.name.equalsIgnoreCase(name)) {
            head = head.next;
            System.out.println(name + " removed from cart!");
            return;
        }

        ProductOnline temp = head;
        while (temp.next != null && !temp.next.name.equalsIgnoreCase(name)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println(name + " not found in cart!");
        } else {
            temp.next = temp.next.next;
            System.out.println(name + " removed from cart!");
        }
    }
}