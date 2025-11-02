package perpustakaan;

class Book {
    private String title;
    private String author;
    private int publish_year;
    private double penalty;
    
    public Book(String title, String author, int publish_year, double penalty) {
        this.title = title;
        this.author = author;
        this.publish_year = publish_year;
        this.penalty = penalty;
    }
    
    public void information_display() {
        System.out.println("Judul: " + title);
        System.out.println("Pengarang: " + author);
        System.out.println("Tahun Terbit: " + publish_year);
        System.out.println("Denda per Hari: Rp " + penalty);
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAuthor(){
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public int getPublish_Year() {
        return publish_year;
    }
    
    public void setPublish_Year(int publish_year) {
        this.publish_year = publish_year;
    }
    
    public double getPenalty() {
        return penalty;
    }
    
    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }
}