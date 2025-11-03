package pbogtts;

import java.util.InputMismatchException;
import java.util.Scanner;

class Problem {
    String kode;
    String nama;

    public Problem() {
        this.kode = "P000";
        this.nama = "Problem X";
    }

    public void PrintAll() {
        System.out.println("Kode  : " + kode);
        System.out.println("Nama  : " + nama);
    }
}

public class PBOGTTS {

    public static String caesar(String input, int shift) {
        shift = ((shift % 26) + 26) % 26;
        StringBuilder sb = new StringBuilder(input.length());

        for (char ch : input.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                sb.append((char) ('A' + (ch - 'A' + shift) % 26));
            } else if (Character.isLowerCase(ch)) {
                sb.append((char) ('a' + (ch - 'a' + shift) % 26));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void segitigaPiramida(int n) {
        System.out.println("\n=== Pola Piramida Angka ===");
        for (int i = 1; i <= n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void stringAneh(String kalimat) {
        String[] kata = kalimat.trim().split("\\s+");
        StringBuilder hasil = new StringBuilder();

        for (String k : kata) {
            if (k.length() > 2) {
                String body = k.substring(0, k.length() - 2);
                String akhir = k.substring(k.length() - 2).toUpperCase();
                hasil.append(body).append(akhir).append(" ");
            } else {
                hasil.append(k.toUpperCase()).append(" ");
            }
        }

        System.out.println("Hasil: " + hasil.toString().trim());
    }

    public static void hitungBilangan(Scanner sc) {
        int positif = 0, negatif = 0, angka;

        System.out.println("\n=== Program Hitung Bilangan Positif & Negatif ===");
        System.out.println("Masukkan bilangan (0 untuk berhenti):");

        do {
            System.out.print("Masukkan angka: ");
            try {
                angka = sc.nextInt();
                if (angka > 0) {
                    positif++;
                } else if (angka < 0) {
                    negatif++;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid! Masukkan angka yang benar.");
                sc.nextLine(); 
                angka = 1; 
            }
        } while (angka != 0);

        System.out.println("\nJumlah bilangan positif: " + positif);
        System.out.println("Jumlah bilangan negatif: " + negatif);
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Problem p = new Problem();
        int pilihan;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. P001 - Caesar Cipher");
            System.out.println("2. P002 - Segitiga Angka Piramida");
            System.out.println("3. P003 - Dua Kata Terakhir Uppercase");
            System.out.println("4. P004 - Hitung Bilangan Positif & Negatif");
            System.out.println("5. Keluar");
            System.out.print("Pilih program: ");
            try {
                pilihan = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid, silahkan coba lagi!");
                pilihan = 0;
                continue;
            }

            switch (pilihan) {
                case 1:
                    p.kode = "P001";
                    p.nama = "Problem Caesar";
                    p.PrintAll();

                    System.out.print("Masukkan teks: ");
                    String teks = input.nextLine();
                    System.out.print("Masukkan shift: ");
                    
                    try {
                        int shift = input.nextInt();
                        input.nextLine();
                        System.out.println("Hasil Enkripsi: " + caesar(teks, shift));
                    } catch (InputMismatchException e) {
                        System.out.println("Harus berupa angka!");
                        input.nextLine();
                    }
                    break;

                case 2:
                    p.kode = "P002";
                    p.nama = "Segitiga Angka Piramida";
                    p.PrintAll();

                    System.out.print("Masukkan jumlah baris: ");
                    try {
                        int n = input.nextInt();
                        input.nextLine(); 
                        segitigaPiramida(n);
                    } catch (InputMismatchException e) {
                        System.out.println("Jumlah baris harus berupa angka!");
                        input.nextLine(); 
                    }
                    break;

                case 3:
                    p.kode = "P003";
                    p.nama = "Program Dua Kata Akhir Uppercase";
                    p.PrintAll();

                    System.out.print("Masukkan kalimat: ");
                    String kalimat = input.nextLine();
                    stringAneh(kalimat);
                    break;

                case 4:
                    p.kode = "P004";
                    p.nama = "Menghitung Bilangan Positif & Negatif";
                    p.PrintAll();
                    hitungBilangan(input);
                    break;

                case 5:
                    System.out.println("Keluar dari program...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 5);

        input.close();
    }
}
