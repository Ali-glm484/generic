package products;

public class Notebook extends Product {
    private int pageCount;
    private boolean isHardCover;

    public Notebook (String title, Double price, int pageCount, boolean isHardCover) throws Exception {
        super(title, price);
        super.id = generateId();

        setPageCount(pageCount);
        setIsHardCover(isHardCover);
    }

    private void setPageCount(int pageCount) throws Exception {
        if (pageCount < 0)
            throw new Exception("The Page count can not be negative.");

        this.pageCount = pageCount;
    }

    private void setIsHardCover(boolean isHardCover) {
        this.isHardCover = isHardCover;
    }

    public int getPageCount() {
        return this.pageCount;
    }

    public boolean getIsHardCover() {
        return this.isHardCover;
    }

    private final int type = 2;
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
        return super.toString() + " | Page count: " + this.pageCount + " | Hard Cover: " + this.isHardCover;
    }
}
