package fpsprogreske2;

import java.util.Scanner;

public class Pistol {
        private String jenis;
        private int peluruMaksimal;
        private int jumlahPeluru;
        private int kaliber;
        private int kerusakan;
        private static Scanner scanner = new Scanner(System.in);

        public Pistol(String jenis, int kaliber, int kerusakan) {
            int peluruMaksimal;
            System.out.println("+------------------------+");
            System.out.println("| Game Latihan Menembak  |");
            System.out.println("|   Copyright klmpok 6   |");
            System.out.println("+------------------------+");
            System.out.print("Kesempatan: ");
            peluruMaksimal = scanner.nextInt();
            this.jenis = jenis;
            this.peluruMaksimal = peluruMaksimal;
            this.jumlahPeluru = peluruMaksimal;
            this.kaliber = kaliber;
            this.kerusakan = kerusakan;
        }

        public String ambilJenis(){
            return this.jenis;
        }

        public int ambilKaliber(){
            return this.kaliber;
        }

        public int ambilKerusakan(){
            return this.kerusakan;
        }

        public int ambilJumlahKesempatan(){
            return this.jumlahPeluru;
        }

        public void kurangiKesempatan(){
            this.jumlahPeluru--;
        }

        public boolean apaKesempatanHabis(){
            return (ambilJumlahKesempatan() == 0);
        }
    }

