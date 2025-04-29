package products;

public abstract class Product {
    protected String title;
    protected Double price;
    protected String id;

    public Product (String title, Double price) throws Exception {
        setTitle(title);
        setPrice(price);
    }

    private void setTitle(String title) throws Exception {
        if (title == null || title.isEmpty())
            throw new Exception("title can not be empty.");

        this.title = title;
    }

    public void setPrice(Double price) throws Exception {
        if (price < 0)
            throw new Exception("The price can not be negative.");
        if (price == null)
            throw new Exception("The price can not be null.");

        this.price = price;
    }

    public String getTitle() {
        return this.title;
    }

    public Double getPrice() {
        return this.price;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return  "Title: " + this.title + " | Price: " + this.price + " | Id: " + this.id;
    }

    protected abstract String generateId();
}
