package perpustakaan;

class NonFiction_Book extends Book {
    private String topic;
    
    public NonFiction_Book(String title, String author, int publish_year, double penalty, String topic) {
        super(title, author, publish_year, penalty);
        this.topic = topic;
    }
    
    @Override
    public void information_display() {
        super.information_display();
        System.out.println("Topik: " + topic);
    }
    
    public String getTopic() {
        return topic;
    }
    
    public void setTopic(String topic) {
        this.topic = topic;
    }
}