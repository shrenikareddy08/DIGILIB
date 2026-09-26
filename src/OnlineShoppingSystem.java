 class OnlineShoppingSystem {
    public static void main(String[] args) {

    	 OnlineShoppingSystem shop = new OnlineShoppingSystem();

         shop.initializeProducts();

         System.out.println("Available Products:");
         shop.displayProducts();

         shop.addToCart(102);
         shop.addToCart(103);

         shop.undoCart();
         shop.placeOrder();
         shop.processOrders();
     }
 }