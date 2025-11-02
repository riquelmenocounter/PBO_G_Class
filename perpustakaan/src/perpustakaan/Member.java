package perpustakaan;

import java.util.ArrayList;

class Member {
    private String name;
    private String member_id;
    private ArrayList<Book> LoanBookList;
    private double penalties_total;
    
    public Member(String name, String member_id) {
        this.name = name;
        this.member_id = member_id;
        this.LoanBookList = new ArrayList<>();
        this.penalties_total = 0;
    }
    
    public void BookLoan(Book book, Library library) {
        if (library.BookLoan(book.getTitle())) {
            LoanBookList.add(book);
            System.out.println(name + " telah meminjam buku: " + book.getTitle());
        } else {
            System.out.println("Buku tidak tersedia atau stok telah habis");
        }
    }
    
    public void BookReturn(Book book, Library library, int late_deadline) {
        if (LoanBookList.contains(book)) {
            LoanBookList.remove(book);
            library.BookReturn(book.getTitle());
            
            if (late_deadline > 0) {
                double penalties = library.PayPenalties(book.getTitle(), late_deadline);
                penalties_total += penalties;
                System.out.println("Keterlambatan " + late_deadline + " hari");
                System.out.println("Biaya denda sebesar Rp " + penalties);
            }
        } else {
            System.out.println("Buku tidak ada di dalam daftar peminjaman!");
        }
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getMember_ID() {
        return member_id;
    }
    
    public void setMember_ID(String member_id) {
        this.member_id = member_id;
    }
    
    public ArrayList<Book> getLoanbookList() {
        return LoanBookList;
    }
    
    public double getPenalties_Payment() {
        return penalties_total;
    }
    
    public void setPenalties_Payment(double penalties_total) {
        this.penalties_total = penalties_total;
    }
}
