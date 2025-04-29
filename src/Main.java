import inventory.Inventory;
import products.Accessory;
import products.Book;
import products.Notebook;
import products.Product;

public class Main {
    public static void main(String[] args) {
        Inventory<Book> myBooks = new Inventory<>();
        Inventory<Notebook> myNotebooks = new Inventory<>();
        Inventory<Accessory> myAccessories = new Inventory<>();

        try {
            myBooks.addItems(new Book("Math1", 120.5, "Yusofi-kia", "Saba1", "mathematics"));
            myBooks.addItems(new Book("Math2", 160.5, "Yusofi-kia", "Saba2", "mathematics"));

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            myNotebooks.addItems(new Notebook("Notebook1", 132.6, 45, false));
            myNotebooks.addItems(new Notebook("Notebook2", 155.6, 60, true));

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            myAccessories.addItems(new Accessory("pen1", 12.5, "red"));
            myAccessories.addItems(new Accessory("pen2", 19.5, "blue"));

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println();
        myBooks.displayAll();
        myNotebooks.displayAll();
        myAccessories.displayAll();

        myNotebooks.removeItemsById(2001);
        myAccessories.removeItemsById(3002);
        System.out.println();

        System.out.println("Total price of books: " + calculateTotalPrice(myBooks));
        System.out.println("Total price of notebooks: " + calculateTotalPrice(myNotebooks));
        System.out.println("Total price of accessories: " + calculateTotalPrice(myAccessories));
        System.out.println();

        myBooks.findItemsById(1003);
        Book book = myBooks.findItemsById(1001);
        System.out.println(book.toString());
        System.out.println();

        try {
            myBooks.applyDiscount("Math1", 20);
            myBooks.applyDiscount("Math2", 30);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        myBooks.displayAll();
        myNotebooks.displayAll();
        myAccessories.displayAll();

    }

    public static double calculateTotalPrice(Inventory<? extends Product> inventory) {
        double totalAmount = 0;
        for (Product product : inventory.getItems())
            totalAmount += product.getPrice();

        return totalAmount;
    }
}