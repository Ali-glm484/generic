package products;

public class Accessory extends Product {
    private String color;

    public Accessory (String title, Double price, String color) throws Exception {
        super(title, price);
        super.id = generateId();

        setColor(color);
    }

    private void  setColor(String color) throws  Exception {
        if (color.isEmpty() || color == null)
            throw new Exception("The color can not be empty.");

        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    private final int type = 3;
    private static int counter = 1;

    @Override
    protected String generateId() {
        String id;
        if (counter / 10 == 0)
            id = type + "00" + counter;
        else if (counter / 100 == 0) {
            id = type + "0" + counter;
        } else {
            id = type + "" + counter;
        }

        counter++;

        return id;
    }

    @Override
    public String toString() {
        return super.toString() + " | Color: " + this.color;
    }
}
