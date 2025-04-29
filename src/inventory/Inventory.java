package inventory;

import products.Product;

import java.util.ArrayList;

public class Inventory<T extends Product>{
    private ArrayList<T> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public ArrayList<T> getItems() {
        return items;
    }

    public void applyDiscount(String productName, int discount) throws Exception {
        for (T product : items) {
            if (product.getTitle().equals(productName)) {
                product.setPrice((product.getPrice() * (100 - discount)) / 100.0);

                System.out.println("Discount has been applied.");
                return;
            }
        }

        System.out.println("The product does not exist.");
    }

    public void addItems(T product) {
        items.add(product);
        System.out.println("The product has been added to the list.");
    }

    public void removeItemsById(int id) {
        for (T product : items) {
            if (product.getId().equals(String.valueOf(id))) {
                items.remove(product);

                System.out.println("The Product has been removed.");
                return;
            }
        }

        System.err.println("The product does not exist.");
    }

    public T findItemsById(int id) {
        for (T product : items)
            if (product.getId().equals(Integer.toString(id))) {
                System.out.println("The product exists.");
                return product;
            }

        System.err.println("The product does not exist.");
        return null;
    }

    public void displayAll() {
        if (items.isEmpty())
            System.out.println();

        else {
            for (T product : items)
                System.out.println(product.toString());

            System.out.println();
        }
    }
}
