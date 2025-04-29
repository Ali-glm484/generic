package products;

public class Book extends Product{
    private String author;
    private String publication;
    private String genre;

    public Book (String title, Double price, String author, String publication, String genre) throws Exception {
        super(title, price);
        super.id = generateId();

        setAuthor(author);
        setPublication(publication);
        setGenre(genre);
    }

    private void setAuthor(String author) throws Exception {
        if (author.isEmpty() || author == null)
            throw new Exception("The author can not be empty.");

        this.author = author;
    }

    private void setPublication(String publication) throws Exception {
        if (publication.isEmpty() || publication == null)
            throw new Exception("The publication can not be empty.");

        this.publication = publication;
    }

    private void setGenre(String genre) throws Exception {
        if (genre.isEmpty() || genre == null)
            throw new Exception("The genre can not be empty.");

        this.genre = genre;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getPublication() {
        return this.publication;
    }

    public String getGenre() {
        return this.genre;
    }

    private final int type = 1;
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
        return super.toString() + " | Author: " + this.author + " | Publication: " + this.publication + " | Genre: " + this.genre;
    }
}
