package perpustakaan;

class Library {
    private Book[] bookList;
    private int[] bookStock;
    
    public Library(int capacity) {
        bookList = new Book[capacity];
        bookStock = new int[capacity];
        database_Book();
    }
    
    private void database_Book() {
        bookList[0] = new Fiction_Book("Kisah Kejayaan Emyu Yang Tenggelam", "Driadisca Purba Hapsara", 2007, 17000.0, "Sci-Fi");
        bookStock[0] = 5;
        
        bookList[1] = new Fiction_Book("Buku Pintar Ngoding", "Andaru Hanif Pergita", 1838, 50000.0, "Teknologi");
        bookStock[1] = 3;
        
        bookList[2] = new NonFiction_Book("10 Cara Menjadi Atlet", "Theodorus Satria Dwipamudya", 2016, 1000.0, "Teknologi");
        bookStock[2] = 4;
        
        bookList[3] = new NonFiction_Book("Filsafat Sumatera", "Imam Adi Wicaksana", 1838, 34000.0, "Sosiologi");
        bookStock[3] = 1;
    }
    
    public void BookInfo_display() {
        System.out.println("\n--- Informasi Buku ---");
        for (int i = 0; i < bookList.length; i++) {
            if (bookList[i] != null) {
                bookList[i].information_display();
                System.out.println();
            }
        }
    }
    
    public void BookStock_display() {
        System.out.println("\nDaftar Stok Buku di Perpustakaan:");
        for (int i = 0; i < bookList.length; i++) {
            if (bookList[i] != null) {
                System.out.println("- " + bookList[i].getTitle() + ": " + bookStock[i] + " Biji");
            }
        }
    }
    
    public void BookStock_add(String title, int qty) {
        for (int i = 0; i < bookList.length; i++) {
            if (bookList[i] != null && bookList[i].getTitle().equalsIgnoreCase(title)) {
                bookStock[i] += qty;
                System.out.println("Stok buku " + title + " berhasil ditambah");
                System.out.println("Stok sekarang adalah sebanyak " + bookStock[i] + " Buah");
                return;
            }
        }
        System.out.println("Buku tidak ditemukan, silahkan coba lagi!");
    }
    
    public Book SearchBookwithTitle(String title) {
        for (int i = 0; i < bookList.length; i++) {
            if (bookList[i] != null && bookList[i].getTitle().equalsIgnoreCase(title)) {
                return bookList[i];
            }
        }
        return null;
    }
    
    public boolean BookLoan(String title) {
        for (int i = 0; i < bookList.length; i++) {
            if (bookList[i] != null && bookList[i].getTitle().equalsIgnoreCase(title)) {
                if (bookStock[i] > 0) {
                    bookStock[i]--;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    
    public void BookReturn(String title) {
        for (int i = 0; i < bookList.length; i++) {
            if (bookList[i] != null && bookList[i].getTitle().equalsIgnoreCase(title)) {
                bookStock[i]++;
                System.out.println("Buku " + title + " berhasil dikembalikan");
                return;
            }
        }
    }
    
    public double PayPenalties(String title, int late_deadline) {
        Book book = SearchBookwithTitle(title);
        if (book != null) {
            return book.getPenalty() * late_deadline;
        }
        return 0;
    }
}