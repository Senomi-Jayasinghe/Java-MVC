package bookPackage;
public class Book {
    
    private int BookID;
    private String BookName;
    
    public Book() {}
    
    // Parameterized Constructor
    public Book(int BookID, String BookName) {
        this.BookID = BookID;
        this.BookName = BookName;
    }
    
    //GETTERS AND SETTERS FOR ATTRIBUTES
    public int getBookID() {
        return BookID;
    }

    public void setBookID(int BookID) {
        this.BookID = BookID;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String BookName) {
        this.BookName = BookName;
    }
}
