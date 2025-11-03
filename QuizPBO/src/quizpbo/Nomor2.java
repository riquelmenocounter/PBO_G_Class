package quizpbo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Nomor2 {

    public static void main(String[] args) {
        File InputFile = new File("C:\\Users\\Pongo\\QuizPBO\\inputno2.txt");
        File OutputFile = new File("C:\\Users\\Pongo\\QuizPBO\\outputno2.txt");

        try {
            if (!InputFile.exists()) {
                Scanner input = new Scanner(System.in);
                FileWriter createInput = new FileWriter(InputFile);

                System.out.print("");
                int angka = input.nextInt();
                input.nextLine();

                createInput.write(angka + System.lineSeparator());

                for (int i = 1; i <= angka; i++) {
                    System.out.print("");
                    String kalimat = input.nextLine();
                    createInput.write(kalimat + System.lineSeparator());
                }

                createInput.close();
                input.close();

                System.out.println("File txt dari input sudah dibuat!");
            }

            try (
                FileReader fileread = new FileReader(InputFile);
                Scanner input = new Scanner(fileread);
                FileWriter filewrite = new FileWriter(OutputFile)
            ) {
                if (!input.hasNextLine()) {
                    System.out.println("File input kosong!");
                    return;
                }

                int baris = Integer.parseInt(input.nextLine().trim());

                for (int i = 0; i < baris; i++) {
                    if (input.hasNextLine()) {
                        String line = input.nextLine();
                        int vokalCount = hitungVokal(line);
                        filewrite.write(vokalCount + System.lineSeparator());
                    }
                }
            }

            System.out.println("Hasil output berhasil dibuat di " + OutputFile.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Terjadi error file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Baris pertama harus berupa angka!");
        }
    }

    public static int hitungVokal(String teks) {
        int count = 0;
        teks = teks.toLowerCase();
        for (int i = 0; i < teks.length(); i++) {
            char vokal = teks.charAt(i);
            if ("aiueo".indexOf(vokal) != -1) {
                count++;
            }
        }
        return count;
    }
}