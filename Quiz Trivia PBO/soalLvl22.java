/*
 Deskripsi: Di kelas ini sama pada soalvl1 tapi pada class ini soal level 2
 */


import java.io.*;


public class soalLvl22 {
     
   	// Static Variable Declarations
       static FileReader file;
       static BufferedReader buffer;
       static String soal2 , a, b, c, d, jawaban, bantuan;
       static int skor;
       // Methods
       public void soalLvl21() 
       {
          try
          {
             file = new FileReader("Soal2.txt"); 
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
             soal2 = buffer.readLine(); // Menetapkan nilai pertanyaan
          }
             catch (IOException e)
             {
 
             }
          return soal2;
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
       public String getAnswer() // Methods untuk mengembalikan jawaban
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
       public String getHint() // Methods untuk mengembalikan hint
       {
          try
          {
             bantuan  = buffer.readLine(); // Menetapkan nilai hint
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
             file = new FileReader("Soal2.txt"); // Menginisialisasi ulang file
             buffer = new BufferedReader(file); // Inisialisasi ulang buffer
          }
             catch (IOException e)
             {
             }
       }
}
