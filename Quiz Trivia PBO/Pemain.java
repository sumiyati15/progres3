/*
Deskripsi: Di kelas ini, Variabel dan metode menghitung dan hal-hal yang berkaitan dengan Pemain. 
Hal-hal seperti menghitung skor yang dimenangkan, Nama mereka dll.
*/
	// Import Packages
   import java.io.*;
   import java.util.*;
   public class Pemain
   {
   	// Variabel
      static FileReader file;
      static BufferedReader buffer;
      static String nama[] = new String [2];
      static int dataSkor[] = new int [2], pemainnum, dataSkornum;
      static int skor [] = new int [] {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
      // static int skor [] = new int [] {500, 1000, 2000, 5000, 10000, 20000, 50000, 75000, 150000, 250000, 500000, 1000000};
      // Methods
      public void pemain()
      {
         try
         {
            file = new FileReader("Pemain.txt"); // pemanggilan terhadapa file Pemain
            buffer = new BufferedReader(file); // Inisialisasi BufferedReader
         }
            catch (IOException e)
            {

            }
      }
      public String[] getnama()
      {
         try
         {
            for (int i = 0; i<1; i++) // looping, untuk inisiasi nilai pada array nama menjadi nama dalam Pemain
            {
               nama[i]=buffer.readLine();
            }
         }
            catch (IOException e)
            {

            }
         return nama; // Mengembalikan nilai array Nama
      }
      public int getDataSkor(int value)
      {
         int skorBaru = 0; // Membuat variabel baru yang akan berisi nilai baru
         for (int i = 0; i<10; i++) // Melewati 12 kemungkinan jumlah skor
         {
            if (value == skor[i]) // untuk melihat apakah nilai pengguna sama dengan nilai dalam array
            {
               skorBaru = skor[i+1]; // Menjadikan nilai baru menjadi nilai berikutnya dalam array
               break; 
            }
            else
            {
               skorBaru = value; // Menjadikan nilai baru ke nilai yang sama
            }
         }
         return skorBaru;
      }
      public int getSkorAkhir(int skor, boolean benarSalah)
      {
         int skorAkhir = 0; // Membuat variabel untuk menyimpan nilai terakhir
         for (int i = 0; i<10; i++) // untuk melewati semua nilai
         {
            if (skor == 10) // Jika nilainya adalah pertanyaan pertama
            {
               skorAkhir = 0;  // skorAkhir menjadi nol
            }
            else if (skor == 20&&benarSalah == false) // Jika nilai 20 dan salah menjawab
            {
               skorAkhir = 10; // Nilai terakhir adalah 0
            }
            else if (skor == 30&&benarSalah == false) // Jika nilai 30 dan salah menjawab
            {
               skorAkhir = 20; // Nilai terakhir adalah 20
            }
            else if (skor == 40&&benarSalah == false) // Jika nilai 40 dan salah menjawab
            {
               skorAkhir = 30; // Nilai terakhir adalah 50
            }
            else if (skor ==50&&benarSalah == false) // Jika nilainya 50 dan mereka salah
            {
               skorAkhir = 40; // Nilai terakhir tetap 50 
            }
            else if (skor == 60 && benarSalah == false)
            {
               skorAkhir = 50;
            }
            else if (skor == 70 && benarSalah == false)
            {
               skorAkhir = 60;
            }
            else if (skor == 80 && benarSalah == false)
            {
               skorAkhir = 70;
            }
            else if (skor == 90 && benarSalah == false)
            {
               skorAkhir = 80;
            }
            else if (skor == 100 && benarSalah == false)
            {
               skorAkhir = 90;
            }
            else if (skor == 100 && benarSalah == true)
            {
               skorAkhir = 100;
            }
         }
         return skorAkhir; // mengembalikan nilaiAkhir
      }
      public int getSkorKeluar(int gskor)
      {
         int skorAkhir = 0; // Membuat variabel untuk menyimpan nilai nilai ketika keluar
         for (int i = 0; i<10; i++) // Menelusuri semua nilai
         {
            if (gskor == skor[i]&&gskor!=20) // Memeriksa apakah nilainya sama dengan yang ada di dalam dan memastikan bukan 1000 agar tidak ada kesalahan
            {
               skorAkhir = skor[i-1];
            }
            else if (gskor == skor[i]&&gskor==20) // memeriksa untuk melihat apakah nilainya 1000
            {
               skorAkhir = 10; // Nilai ditetapkan sebagai $500
            }
         }
         return skorAkhir; // mengembalikan skorAkhir
      }
      public void setSkor (int skor, String gnama)
      {
         int index = 0; // Variabel indeks
         for (int i = 0; i<1; i++) // Untuk loop melewati pemain
         {
            if (nama[i].compareTo(gnama)==0) // Memeriksa apakah nama yang ada dalam array sama dengan nama pengguna yang kita coba berikan nilai yang dimenangkan.
            {
               index = i; // Memberikan nilai indeks
            }
         }
         dataSkor [index] = skor; // Menetapkan nilai pemain
      }
      public int[] getArray()
      {
         return dataSkor; // mengembalikan nilai dataSkor
      }
   }
