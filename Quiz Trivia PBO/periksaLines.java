/* 
Deskripsi: Kelas ini menangani segala sesuatu yang berkaitan dengan lifelines termasuk menggunakannya, 
memeriksa untuk melihat yang tersisa.
*/

   import java.io.*;
   import java.util.*;
   public class periksaLines
   {
   	// variabel
      static String periksa[] = {"25-75", "50-50", "Bantuan"};
      static int numPeriksa=3, skor = 0;
      static Scanner scanner = new Scanner(System.in);
      static String[] jawaban = new String[4];
      static String a, b, c, d, soal, bantuan;
      static boolean hidup = true, mati = false;
      // Methods
      public void periksalines(String ma, String mb, String mc, String md, String mqjawaban, String msoal, String mbantuan, int mskor)
      {
      	// menginisialisasi variabel dengan pertanyaan, opsi, petunjuk, dan jawaban dari pertanyaan yang sedang digunakan pengguna.
         a = ma;
         b = mb;
         c = mc;
         d = md;
         soal = msoal;
         bantuan = mbantuan;
         jawaban = new String[] {a, b, c, d};
         skor = mskor;
      }
      public boolean hasPeriksa()
      {
         if (numPeriksa>0) // Memeriksa apakah pengguna memiliki periksa untuk digunakan
         {
            return true; // Jika ya, kembalikan true
         }
         else
         {
            return false; // Jika tidak, kembalikan false
         }
      }
      public String usePeriksa(String a, String b, String c, String d, String usejawaban, String soal, String bantuan)
      {
      	// Variabel
         String fa = Character.toString(a.charAt(0)), fb=Character.toString(b.charAt(0)), fc=Character.toString(c.charAt(0)), fd=Character.toString(d.charAt(0)), userjawab = "";
         String pilihan;
         boolean pilihanvar = false, keluar = false;
         Random acak = new Random();
         int acaknum;
         if (hasPeriksa()) // Memeriksa lifeline dan mengeluarkannya
         {
            System.out.println("\nkamu memiliki "+numPeriksa+" Lifelines tersisa");
            for (int i = 0; i<3; i++)
            {
               if (periksa[i]!="")
               {
                  System.out.println(periksa[i]+" ");
               }
            }
            do // Lakukan perulangan agar pemain bisa masuk ke lifeline untuk digunakan
            {
               keluar = false; 
               System.out.print("Pilih Lifeline : ");
               pilihan = scanner.nextLine(); // Gets the choice the user makes
               if (pilihan.compareTo("25-75")==0&&periksa[0].compareTo("")==0) // Melihat apakah masih memiliki lifeline 25-75
               {
                  System.out.println("Error! Input Tidak Valid");
                  keluar = true;
               }
               else if (pilihan.compareTo("50-50")==0&&periksa[1].compareTo("")==0) // Melihat apakah masih memiliki lifeline 50-50
               {
                  System.out.println("Error! Input Tidak Valid");
                  keluar = true;
               }
               else if (pilihan.compareTo("HINT")==0&&periksa[2].compareTo("")==0) // Melihat apakah masih memiliki lifeline PETUNJUK
               {
                  System.out.println("Error! Input Tidak Valid");
                  keluar = true;
               }
               if (keluar != true && pilihan != "50-50") // Memeriksa apakah jalan keluarnya benar dan apakah masih memilih 50-50 atau tidak
               {
                  if (pilihan.compareTo(periksa[0])!=0&&pilihan.compareTo(periksa[1])!=0&&pilihan.compareTo(periksa[2])!=0) // Jika pilihannya tidak sama dengan garis hidup apa pun, itu akan menampilkan pesan kesalahan
                  {
                     System.out.println("Error! Input Tidak Valid");
                     keluar = true;
                  }
               }
            } while (keluar == true);
            if (pilihan.compareTo("25-75")==0&&mati == false) // 25-75 Lifeline
            {
               if (periksa[0].compareTo("")!=0) // Memeriksa apakah kamu telah menggunakan 25-75 atau tidak
               {
                  if (usejawaban.compareTo(fa)==0) 
                  {
                     jawaban = new String[] {b, c, d}; // Membuat array menggunakan kemungkinan jawaban yang tersisa
                  }
                  else if (usejawaban.compareTo(fb)==0) // Cek untuk melihat apa jawabannya
                  {
                     jawaban = new String[] {a, c, d}; // Membuat array menggunakan kemungkinan jawaban yang tersisa
                  }
                  else if (usejawaban.compareTo(fc)==0) /// Cek untuk melihat apa jawabannya
                  {
                     jawaban = new String[] {a, b, d}; // Membuat array menggunakan kemungkinan jawaban yang tersisa
                  }
                  else if (usejawaban.compareTo(fd)==0) // Cek untuk melihat apa jawabannya
                  {
                     jawaban = new String[] {a, b, c}; // Membuat array menggunakan kemungkinan jawaban yang tersisa
                  }
                  acaknum = acak.nextInt(3); 
                  jawaban[acaknum] = usejawaban; // Mengganti jawaban acak dengan jawaban sebenarnya
                  Arrays.sort(jawaban); // Sorts array
                  System.out.println("\n"+soal); // Keluarkan pertanyaan sekali lagi
                  for (int i = 0; i<3; i++) // Untuk loop untuk menampilkan kemungkinan jawaban
                  {
                     if (a.charAt(0) == jawaban[i].charAt(0)) // Memeriksa apakah karakter pertama untuk a sama dengan karakter pertama dari jawaban.
                     {
                        jawaban[i] = a; // Tetapkan a sebagai nilai sebagai jawaban dengan indeks i
                        System.out.println(a+" "); // menampilkan a
                     }
                     if (b.charAt(0) == jawaban[i].charAt(0)) // Memeriksa apakah karakter pertama untuk b sama dengan karakter pertama dari jawaban.
                     {
                        jawaban[i] = b; // Menetapkan b sebagai nilai sebagai jawaban dengan indeks i
                        System.out.println(b+" ");  // menampilkan b
                     }
                     if (c.charAt(0) == jawaban[i].charAt(0)) // Checks to see if the first character for c is the same as the first character of the answer.
                     {
                        jawaban[i] = c; // // Menetapkan c sebagai nilai sebagai jawaban dengan indeks i
                        System.out.println(c+" ");  // menampilkan c
                     }
                     if (d.charAt(0) == jawaban[i].charAt(0)) // Checks to see if the first character for d is the same as the first character of the answer.
                     {
                        jawaban[i] = d; // Menetapkan d sebagai nilai sebagai jawaban dengan indeks i
                        System.out.println(d+" ");  // menampilkan d
                     }
                  }
                  if (hasPeriksa()) // Memeriksa apakah masih memiliki garis hidup
                  {
                     System.out.println("\ne) Gunakan lifeline");
                  }
                  if (skor != 10) // Mengecek apakah nilainya 10 atau tidak
                  {
                     System.out.println("f) keluar\n");
                  }
                  numPeriksa--; // Decrements
                  do // Lakukan looping untuk jawabannya
                  {
                     System.out.print("Masukkan Pilihan : ");
                     userjawab = scanner.nextLine(); // Mendinput jawaban
                     userjawab = userjawab.toLowerCase(); // Mengubah jawaban menjadi lower case
                     if (userjawab.charAt(0)<97|| userjawab.charAt(0)>102) // Mengecek apakah jawabannya antara a dan f
                     {
                        System.out.println("Input Tidak Valid");
                     }
                     if (userjawab.compareTo("e")== 0&& hidup == false) // Periksa, untuk melihat apakah masih memiliki lifeline yang tersisa
                     {
                        System.out.println("Error! Anda keluar dari lifeline!");
                        do 
                        {
                           System.out.print("Masukkan Pilihan : ");
                           userjawab = scanner.nextLine(); 
                           userjawab = userjawab.toLowerCase(); 
                           if (userjawab.charAt(0)<97|| userjawab.charAt(0)>102) 
                           {
                              System.out.println("Invalid Entry!");
                           }
                           if (userjawab.compareTo("e")== 0&& hidup == false) 
                           {
                              System.out.println("Error! You are out of Lifelines!");
                           }
                        } while (userjawab.compareTo("e")== 0 ||(userjawab.charAt(0)<97|| userjawab.charAt(0)>102)); // Terus berjalan jika pengguna memasukkan e lagi
                     }
                     if (userjawab.compareTo("f")==0&&skor==10) 
                     {
                        System.out.println("Kamu tidak bisa berhenti!");
                     }
                  } while ((userjawab.charAt(0)<97|| userjawab.charAt(0)>102)||(userjawab.compareTo("f")==0&&skor==10)); 
                  periksa[0]=""; // Menetapkan nilai indeks garis hidup untuk 25-75 sebagai tidak ada
               }
               else if (pilihan.compareTo("25-75")==0&&mati == true) // Pernyataan lain jika mereka baru saja menggunakan 50-50
               {
                  System.out.println("Jika menggunakan lifeline ini, akan mendapatkan hasil yang sama seperti yang sudah di miliki.\n");
                  System.out.println(soal); // Mencetak ulang pertanyaan
                  for (int i = 0; i<jawaban.length; i++)
                  {
                     System.out.println(jawaban[i]); // Mencetak semua kemungkinan jawaban
                  }
                  if (hasPeriksa())
                  {
                     System.out.println("\ne) Gunakan lifeline\n"); // Memeriksa untuk melihat apakah pengguna memiliki garis hidup
                  }
                  System.out.println("Masukkan Pilihan : ");
                  userjawab = scanner.nextLine(); 
               }
            }
            else if (pilihan.compareTo("50-50")==0&&periksa[1]!="") // 50-50
            {
               if (usejawaban.compareTo(fa)==0) // Cek untuk melihat apa jawabannya
               {
                  jawaban = new String[] {b, c, d}; // Membuat array menggunakan kemungkinan jawaban yang tersisa
               }
               else if (usejawaban.compareTo(fb)==0) // Cek untuk melihat apa jawabannya
               {
                  jawaban = new String[] {a, c, d}; // Membuat array menggunakan kemungkinan jawaban yang tersisa
               }
               else if (usejawaban.compareTo(fc)==0) // Cek untuk melihat apa jawabannya
               {
                  jawaban = new String[] {a, b, d}; // Membuat array menggunakan kemungkinan jawaban yang tersisa
               }
               else if (usejawaban.compareTo(fd)==0) // Cek untuk melihat apa jawabannya
               {
                  jawaban = new String[] {a, b, c}; // Membuat array menggunakan kemungkinan jawaban yang tersisa
               }
               acaknum = acak.nextInt(3); // acak nomor
               jawaban[acaknum] = "";; // mengganti jawaban acak
               if (acaknum == 0) // Cek untuk melihat nomor acaknya
               {
                  jawaban = new String[] {jawaban[1], jawaban[2]}; // Membuat array baru berdasarkan jawaban yang tersisa
               }
               else if (acaknum == 1) // Cek untuk melihat nomor acaknya
               {
                  jawaban = new String[] {jawaban[0], jawaban[2]}; // Membuat array baru berdasarkan jawaban yang tersisa
               }
               else if (acaknum == 2) // Cek untuk melihat nomor acaknya
               {
                  jawaban = new String[] {jawaban[0], jawaban[1]}; // Membuat array baru berdasarkan jawaban yang tersisa
               }
               acaknum = acak.nextInt(2); 
               jawaban[acaknum] = usejawaban; // Setel ulang kemungkinan jawaban pada nomor ke jawaban yang sebenarnya
               Arrays.sort(jawaban); // Sorts array
               System.out.println("\n"+soal); // menampilkan soal
               for (int i = 0; i<2; i++) 
               {
                  if (a.charAt(0) == jawaban[i].charAt(0)) // Memeriksa apakah karakter pertama untuk a sama dengan karakter pertama dari jawaban.
                  {
                     jawaban[i] = a; // Tetapkan a sebagai nilai sebagai jawaban dengan indeks i
                     System.out.println(a+" "); // menampilkan a
                  }
                  if (b.charAt(0) == jawaban[i].charAt(0)) // Memeriksa apakah karakter pertama untuk a sama dengan karakter pertama dari jawaban.
                  {
                     jawaban[i] = b; // Menetapkan b sebagai nilai sebagai jawaban dengan indeks i
                     System.out.println(b+" "); // menampilkan b
                  }
                  if (c.charAt(0) == jawaban[i].charAt(0)) // Checks to see if the first character for a is the same as the first character of the answer.
                  {
                     jawaban[i] = c; // Menetapkan c sebagai nilai sebagai jawaban dengan indeks i
                     System.out.println(c+" "); // menampilkan c
                  }
                  if (d.charAt(0) == jawaban[i].charAt(0)) // Checks to see if the first character for a is the same as the first character of the answer.
                  {
                     jawaban[i] = d;// Menetapkan d sebagai nilai sebagai jawaban dengan indeks i
                     System.out.println(d+" "); // menampilkan d
                  }
               }
               numPeriksa--; // Dencrement
               if (hasPeriksa()) // Memeriksa untuk melihat apakah memiliki lifeline
               {
                  System.out.println("\ne) Gunakan lifeline"); // Menampilkan opsi untuk e
               }
               if (skor != 10) // Memeriksa untuk melihat apakah ini giliran pertama
               {
                  System.out.println("f) Keluar\n"); // Menampilkan opsi untuk e
               }
               else
               {
                  System.out.println(); //menampikna extra line
               }
               do{ 
                  System.out.print("Masukkan Pilihan : ");
                  userjawab = scanner.nextLine(); 
                  userjawab = userjawab.toLowerCase(); 
                  if (userjawab.charAt(0)<97|| userjawab.charAt(0)>102) 
                  {
                     System.out.println("Input Tidak Valid");
                  }
                  if (userjawab.compareTo("f")==0&&skor==10) 
                  {
                     System.out.println("Kamu tidak bisa berhenti!");
                  }
               } while ((userjawab.charAt(0)<97|| userjawab.charAt(0)>102)||(userjawab.compareTo("f")==0&&skor==10)); 
               periksa[1]=""; // Reset lifeline untuk 50-50 menjadi nol
               mati = true; // Setel ke true menunjukkan telah digunakan giliran ini
            }
            else if (pilihan.compareTo("HINT")==0&&periksa[2]!="") // Hint
            {
               System.out.println("\n"+soal); 
               for (int i = 0; i<jawaban.length; i++)
               {
                  System.out.println(jawaban[i]); 
               }
               numPeriksa--;// Menurunkan jumlah lifeline sebanyak 1
               if (hasPeriksa()) // Memeriksa untuk melihat apakah mereka memiliki garis hidup
               {
                  System.out.println("\ne) Gunakan lifeline"); // menampikan e
               }
               if (skor != 10) // Mencetak opsi untuk menyerah/berhenti
               {
                  System.out.println("f) Keluar\n");
               }
               System.out.println("\n"+bantuan+"\n"); 
               do 
               {
                  System.out.print("Masukkan Pilihan : ");
                  userjawab = scanner.nextLine(); 
                  userjawab = userjawab.toLowerCase(); 
                  if (userjawab.charAt(0)<97|| userjawab.charAt(0)>102) 
                  {
                     System.out.println("Inpt Tidak Valid!");
                  }
                  if (userjawab.compareTo("e")== 0&& hidup == false) 
                  {
                     System.out.println("Error! keluar dari Lifelines!"); 
                     do 
                     {
                        System.out.print("Masukkan Pilihan : ");
                        userjawab = scanner.nextLine();
                        userjawab = userjawab.toLowerCase(); 
                        if (userjawab.charAt(0)<97|| userjawab.charAt(0)>102) 
                        {
                           System.out.println("Input Tidak Valid!");
                        }
                        if (userjawab.compareTo("e")== 0&& numPeriksa<=0) 
                        {
                           System.out.println("Error! Keluar dari Lifelines!");
                        }
                     } while (userjawab.compareTo("e")== 0 ||(userjawab.charAt(0)<97|| userjawab.charAt(0)>102)); 
                  }
                  if (userjawab.compareTo("f")==0&&skor==10) 
                  {
                     System.out.println("Kamu tidak bisa keluar!");
                  }
               } while ((userjawab.charAt(0)<97|| userjawab.charAt(0)>102)||(userjawab.compareTo("f")==0&&skor==10)); 
               periksa[2] = ""; 
               jawaban = new String[4]; 
            }
         }
         else // Jika tidak memiliki lifelines
         {
            System.out.println("Error! keluar dari Lifelines!"); 
            do  
            {
               System.out.print("Masukkan pilihan : ");
               userjawab = scanner.nextLine(); 
               userjawab = userjawab.toLowerCase(); 
               if (userjawab.charAt(0)<97|| userjawab.charAt(0)>102) 
               {
                  System.out.println("Input Tidak Valid!");
               }
               if (userjawab.compareTo("e")== 0&& numPeriksa<=0) 
               {
                  System.out.println("Error! keluar dari Lifelines!");
               }
            } while (userjawab.compareTo("e")== 0 ||(userjawab.charAt(0)<97|| userjawab.charAt(0)>102)); 
         }
         return userjawab; 
      }
      public void resetPeriksa () // Reset Lifelines
      {
         numPeriksa = 3; // Reset NumofLifelines
         periksa = new String[] {"25-75", "50-50", "HINT"}; // Reset semua lifelines
      }
      public void resetJawab (String ma, String mb, String mc, String md) // Reset jawaban
      {
         jawaban = new String[] {ma, mb, mc, md}; // Array Baru
      }
      public void newSkor (int mvalue) // Dapatkan Nilai Baru dan tetapkan ke nilai
      {
         skor = mvalue; // menetapkan nilai dari file utama ke nilai di sini
      }
      public void resetMati () // Dapatkan Nilai Baru dan tetapkan ke nilai
      {
         mati = false; // mengatur ulang mati
      }
   }
