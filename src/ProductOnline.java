import java.util.Scanner;

class ProductOnline {
    String name;
    double price;
    int quantity;
    ProductOnline next;

    ProductOnline(String name,double price,int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.next = null;
    }
}
    
   
    
    class SLL {
    	 ProductOnline head;
    	 Scanner sc = new Scanner(System.in);
    	 public void createShopCart() {
             ProductOnline temp;
             int ch;

             do {
                 System.out.println("Enter item to add to cart:");
                 String name = sc.nextLine();
                 System.out.println("Enter price of the product");
                 double price=sc.nextDouble();
                 System.out.println("enter quantity");
                 int quantity=sc.nextInt();

                 ProductOnline t = new ProductOnline(name,price,quantity);

                 if (head == null) {
                     head = t;
                 } 
                 else {
                     temp = head;
                     while (temp.next != null) {
                         temp = temp.next;
                     }
                     temp.next = t;
                 }

                 System.out.println("Do you want to add another product? Press 1 to Continue, 0 to Stop");
                 ch = sc.nextInt();
                 sc.nextLine();

             } while (ch != 0);
         }
    	 
    	 
 public void addItem(String name,double price,int quantity)
 {
	 ProductOnline t = new ProductOnline(name,price,quantity);
	 t.next=head;
	 head=t;
	 
 }
 
 public void totalCart()
 {
	 double sum=0;
	 ProductOnline temp= head;
	 while(temp!=null)
	 {
		  sum=sum+(temp.price * temp.quantity);
		  temp=temp.next;
	 }
	 System.out.println("Bill is:"+sum);
 }
 
 
 
 
 public void countProducts()
 {
	 int count=0;
	 ProductOnline temp= head;
	 while(temp!=null)
	 {
		 count++;
		 temp=temp.next;
	 }
	 System.out.println("Total number of Products are:"+count);
 }
 
 public void removeProducts(String name) {

	    ProductOnline temp = head;
	    ProductOnline prev = null;

	    while (temp != null && !temp.name.equalsIgnoreCase(name)) {
	        prev = temp;
	        temp = temp.next;
	    }

	    if (temp == null) {
	        System.out.println("Product not found!");
	        return;
	    }

	    if (prev == null) {
	        head = head.next;   
	    } else {
	        prev.next = temp.next;  
	    }

	    System.out.println(name + " removed from cart!");
	}
 
 
 
    	 public void display()
    	 {
    		 if (head==null)
    		 {
    			 System.out.println("Cart is empty");
    		 }
    		 else {
    			 ProductOnline temp = head;
    			 while(temp!=null)
    			 {
    				 System.out.println("Product: " + temp.name +" || Price: " + temp.price + " || Qty: " + temp.quantity);
                   temp=temp.next;
    			 }
    		 }
    	 }
    
}