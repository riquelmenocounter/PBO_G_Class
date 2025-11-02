package perpustakaan;

class Fiction_Book extends Book {
    private String genre;
    
    public Fiction_Book(String title, String author, int publish_year, double penalty, String genre) {
        super(title, author, publish_year, penalty);
        this.genre = genre;
    }
    
    @Override
    public void information_display() {
        super.information_display();
        System.out.println("Genre: " + genre);
    }
    
    public String getGenre() {
        return genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
}