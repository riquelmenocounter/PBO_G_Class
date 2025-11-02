package perpustakaan;

import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Library library = new Library(10);
        HashMap<String, Member> member_list = new HashMap<>();
        
        int pilihan;
        boolean running = true;
        
        do {
            try {
                System.out.println("\n=== Menu Perpustakaan ===");
                System.out.println("1. Melihat Informasi Buku");
                System.out.println("2. Tambah Stok Buku");
                System.out.println("3. Pinjam Buku");
                System.out.println("4. Kembalikan Buku");
                System.out.println("5. Bayar Denda");
                System.out.println("6. Exit");
                System.out.print("Pilih Opsi: ");
                
                pilihan = input.nextInt();
                input.nextLine();
                
                switch (pilihan) {
                    case 1:
                        library.BookInfo_display();
                        library.BookStock_display();
                        break;
                        
                    case 2:
                        System.out.print("Masukkan judul buku yang ingin ditambah stok: ");
                        String add_title = input.nextLine();
                        System.out.print("Masukkan jumlah stok yang ingin ditambahkan: ");
                        
                        try {
                            int add_qty = input.nextInt();
                            input.nextLine();
                            
                            if (add_qty <= 0) {
                                System.out.println("Input tidak valid, silahkan coba lagi!");
                            } else {
                                library.BookStock_add(add_title, add_qty);
                            }
                        } catch (Exception e) {
                            System.out.println("Input tidak valid, silahkan coba lagi!");
                            input.nextLine();
                        }
                        break;
                        
                    case 3:
                        System.out.print("Masukkan nama anggota: ");
                        String loan_name = input.nextLine();
                        System.out.print("Masukkan nomor anggota: ");
                        String loan_id = input.nextLine();
                        
                        try {
                            Integer.parseInt(loan_id); 
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Input tidak valid.");
                            break;
                        }
                        
                        System.out.print("Masukkan judul buku yang ingin dipinjam: ");
                        String loan_title = input.nextLine();
                        
                        Book loan_book = library.SearchBookwithTitle(loan_title);
                        
                        if (loan_book != null) {
                            if(!member_list.containsKey(loan_id)) {
                                member_list.put(loan_id, new Member(loan_name, loan_id));
                            }
                            
                            Member member = member_list.get(loan_id);
                            member.BookLoan(loan_book, library);
                        } else {
                            System.out.println("Buku tidak ditemukan!");
                        }
                        break;
                        
                    case 4:
                        System.out.print("Masukkan judul buku yang ingin dikembalikan: ");
                        String booktitle_return = input.nextLine();
                        
                        Book ReturnBook = library.SearchBookwithTitle(booktitle_return);
                        
                        if (ReturnBook != null) {
                            library.BookReturn(booktitle_return);
                        } else {
                            System.out.println("Mohon maaf tidak dapat menemukan buku tersebut, silahkan coba lagi!");
                        }
                        break;
                        
                    case 5:
                        System.out.print("Masukkan judul buku untuk pembayaran denda keterlambatan: ");
                        String booktitle_penalties = input.nextLine();
                        
                        Book penalties_book = library.SearchBookwithTitle(booktitle_penalties);
                        
                        if (penalties_book != null) {
                            try {
                                System.out.print("Masukkan jumlah hari keterlambatan: ");
                                int lateday_penalties = input.nextInt();
                                input.nextLine();
                                
                                if (lateday_penalties <= 0) {
                                    System.out.println("Input tidak valid, silahkan coba lagi!");
                                } else {
                                    double penalties_total = library.PayPenalties(booktitle_penalties, lateday_penalties);
                                    System.out.println("Total denda untuk saat ini: Rp " + penalties_total);
                                    System.out.println("Denda keterlambatan " + lateday_penalties + " hari adalah Rp " + penalties_total);
                                }
                            } catch (Exception e) {
                                System.out.println("Input tidak valid, silahkan coba lagi!");
                                input.nextLine();
                            }
                        } else {
                            System.out.println("Buku tidak dapat ditemukan!");
                        }
                        break;
                        
                    case 6:
                        System.out.println("Anda telah keluar dari program menu, terimakasih telah berkunjung.");
                        running = false;
                        break;
                        
                    default:
                        System.out.println("Pilihan tidak valid, silahkan coba lagi!");
                }
            } catch (Exception e) {
                System.out.println("Input tidak valid!");
                input.nextLine();
            }
        } while (running);
        
        input.close();
    }
}