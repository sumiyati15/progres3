/*
Deskripsi: Di class ini, Methods yang terutama digunakan untuk mendapatkan pertanyaan, 
opsi, jawaban, dan petunjuk dari file teks dan mengirimkannya ke program utama
*/
   import java.io.*;

   public class soalLvl1 {

   	// variabel
      static FileReader file;
      static BufferedReader buffer;
      static String soal1 , a, b, c, d, jawaban, bantuan;
      static int skor;
      // Methods
      public void level1() // Constructor Method
      {
         try
         {
            file = new FileReader("Soal1.txt"); 
            buffer = new BufferedReader(file); 
         }
            catch (IOException e)
            {

            }
      }
      public String getQuestion() // Methods untuk mengembalikan pertanyaan
      {
         try
         {
            soal1 = buffer.readLine(); // Menetapkan nilai pertanyaan
         }
            catch (IOException e)
            {

            }
         return soal1;
      }
      public String getA() // Methods untuk mengembalikan opsi a
      {
         try
         {
            a  = buffer.readLine(); // Menetapkan nilai a
         }
            catch (IOException e)
            {

            }
         return a;
      }
      public String getB() // Methods untuk mengembalikan opsi b
      {
         try
         {
            b  = buffer.readLine(); // Menetapkan nilai b
         }
            catch (IOException e)
            {

            }
         return b;
      }
      public String getC() // Methods untuk mengembalikan opsi c
      {
         try
         {
            c  = buffer.readLine(); // Menetapkan nilai c
         }
            catch (IOException e)
            {

            }
         return c;
      }
      public String getD() // Methods untuk mengembalikan opsi d
      {
         try
         {
            d  = buffer.readLine(); // Menetapkan nilai d
         }
            catch (IOException e)
            {

            }
         return d;
      }
      public String getJawab() // Methods untuk mengembalikan jawaban
      {
         try
         {
            jawaban  = buffer.readLine(); // Menetapkan nilai jawaban
         }
            catch (IOException e)
            {

            }
         return jawaban;
      }
      public String getBantuan() // Methods untuk mengembalikan petunjuk
      {
         try
         {
            bantuan  = buffer.readLine(); // Menetapkan nilai petunjuk
         }
            catch (IOException e)
            {

            }
         return bantuan; 
      }
      public void resetBuffer () // Methods untuk mengatur ulang buffer sehingga pertanyaan menjadi pertanyaan pertama dalam file teks setiap kali kontestan menyelesaikan gilirannya
      {
         try
         {
            file.close(); // Menutup file
            buffer.close(); // Menutup buffer
            file = new FileReader("Soal1.txt"); // Menginisialisasi ulang file
            buffer = new BufferedReader(file); // Inisialisasi ulang buffer
         }
            catch (IOException e)
            {
            }
      }
   }
