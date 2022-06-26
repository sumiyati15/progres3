import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main
{
	// Variabel
   static soalLvl1 soalClass[] = new soalLvl1[4]; // Inisiasi object soalClass
   static Pemain pemainClass[] = new Pemain[4]; // Inisiasi Object pemain
   static periksaLines periksaClass[] = new periksaLines [4]; // inisiasi object periksalines
   final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
   public static void main (String[] args)
   {
      try (Scanner scanner = new Scanner (System.in)) {
         int SKOR = 0, SKORS [] = new int [] {0, 10, 20, 30, 40}, skorAkhir1[] = new int [4], Skortertinggi=0, hitung = 0;
         String soal="", a = "", b = "", c = "", d = "", jawabn="", bantuan = "", nama[] = new String [4], response = "";
         boolean rightwrong = false, quit = false;
         String pilih;
         System.out.println("!!! Dikasih Infoo madzehh !!!\n");
         System.out.println("1. Kamu diberikan waktu 20 detik untuk menjawab");
         System.out.println("2. Setiap salah maka akan SKOR dikurangi 10\n"); 
         System.out.println("Tekan enter untuk mulai");
         pilih = scanner.nextLine();
         
         // Main Program
         for (int i = 0; i<4; i++) 
         {
            if (SKOR == 0) {
            soalClass[i]= new soalLvl1 (); // Inisialisasi soalClass
            soalClass[i].level1(); // jalankan method level1
            pemainClass[i] = new Pemain(); // Inisialisasi pemain
            pemainClass[i].pemain(); // jalankan methods pemain
            nama = pemainClass[i].getnama();  // Inisialisasi nama pemain
            periksaClass[i] = new periksaLines (); // Inisialisasi periksa
            periksaClass[i].periksalines (a, b, c, d, jawabn, soal, bantuan, SKORS[i]); // Inisialisasi nilai di kelas periksaLines
            }else {
               System.out.println("!! anda keluar !!");
            }
            
         }
         System.out.println("\t\t-----------------------------");
         System.out.println("\t\tSelamat Datang di QUIZ TRIVIA");
         System.out.println("\t\t-----------------------------");
         for (int i = 0; i<1; i++) // putaran untuk pemain
         {
            hitung = 0;
            quit = false;
            SKOR = 0; // inisialisasi nilai pertama
            soalClass[i].resetBuffer(); // Reset Buffer untuk setiap Kontestan
            periksaClass[i].resetPeriksa(); // Mengatur Ulang periksaLines untuk para kontestan
            do // "Do While" untuk pertanyaan sampai pemain memilih untuk berhenti atau salah menjawab
            {
               periksaClass[i].newSkor(SKOR); // Mereset nilai di class periksaLines
               if (SKOR == 0)
               {
                  System.out.println(nama[i]+", Selamat mengerjakan\n"); 
                  System.out.println("waktu kamu 20 DETIk");
               }
               for (int j = 1; j<=7; j++) // untuk menginisialisasi semua pertanyaan, jawaban, kemungkinan jawaban, dan petunjuk.
               {
                  if (j == 1)
                  {
                     soal = soalClass[i].getQuestion(); // Inisialisasi Soal
                     System.out.print("\t\t\t\t\t\t\t\t\t\tSKOR : "+SKOR+"\n\n"+ soal + "\n");
                  }
                  if (j == 2)
                  {
                     a = soalClass[i].getA(); // Inisialisasi pilihan a
                     System.out.println(a);
                  }
                  if (j == 3)
                  {
                     b = soalClass[i].getB(); // Inisialisasi pilihan b
                     System.out.println(b);
                  }
                  if (j == 4)
                  {
                     c = soalClass[i].getC(); // Inisialisasi pilihan c
                     System.out.println(c);
                  }
                  if (j == 5)
                  {
                     d = soalClass[i].getD(); // Inisialisasi pilihan d
                     System.out.println(d);
                  }
                  if (j == 6)
                  {
                     jawabn = soalClass[i].getJawab(); // Inisialisasi jawaban
                  }
                  if (j == 7)
                  {
                     bantuan = soalClass[i].getBantuan(); // Inisialisasi bantuan
                  }
               }
               if (periksaClass[i].hasPeriksa()) // Periksa untuk melihat apakah ada periksaLines
               {
                  System.out.println("\ne) Gunakan lifeline");
                  if (SKOR == 0) 
                  {
                     System.out.println();
                  }
               }
               periksaClass[i].resetJawab(a, b, c, d); // reset jawaban untuk nilai-nilai di class periksaLines
               if (SKOR != 0&&periksaClass[i].hasPeriksa() == false) // Periksa apakah itu pertanyaan pertama atau tidak dan apakah ada lifelines
               {
                  System.out.println("\nf) Keluar\n");
               }
               else  if (SKOR != 0) // Periksa apakah itu pertanyaan pertama atau tidak
               {
                  System.out.println("f) Keluar\n");
               }
               do // untuk memeriksa respons kontestan dan untuk memastikan mereka memasukkan opsi yang valid
               {
                  System.out.print("Ketik Jawaban Kamu : ");
                  response = scanner.nextLine(); // input jawaban pemain
                  response = response.toLowerCase(); // Mengubah input menjadi LowerCase
                  if (response.charAt(0)<97|| response.charAt(0)>102) // Periksa untuk melihat apakah nilainya antara a dan f
                  {
                     System.out.println("Inputan Tidak Valid!");
                  }
                  if (periksaClass[i].hasPeriksa() == false&&response.compareTo("e")==0) // Periksa untuk melihat apakah ada lifeline
                  {
                     System.out.println("Inputan Tidak Valid! kamu keluar dari lifelines!");
                  }
                  if (response.compareTo("f")==0&&SKOR==0) 
                  {
                     System.out.println("kamu tidak bisa berhenti");
                  }
               } while ((response.charAt(0)<97|| response.charAt(0)>102)||(periksaClass[i].hasPeriksa() == false&&response.compareTo("e")==0)|| (response.compareTo("f")==0&&SKOR==0));
               if (response.compareTo("e")==0&&periksaClass[i].hasPeriksa()) // jika memiliki statment maka setiap lifeline dan jika mereka memilih lifelines.
               {
                  do // Lakukan looping untuk tetap menggunakan lifeline selama mereka masuk pada pilihan e.
                  {
                     response = periksaClass[i].usePeriksa(a, b, c, d, jawabn, soal, bantuan);
                  } while (response.compareTo("e")==0);
               }
               if (response.compareTo("f")==0&&SKOR != 0) // Memeriksa apakah pengguna ingin keluar, dan akan mengeluarkan pernyataan terima kasih dan keluar dari permainan.
               {
                  System.out.println("Terimakasih telah bermain!");
                  quit = true; // Boolean untuk memberitahu permainan berakhir.
               }
               if (periksaClass[i].hasPeriksa() == false) // Memeriksa untuk melihat apakah pengguna memiliki lifeline
               {
                  if (response.compareTo("e") == 0) // Memeriksa apakah pengguna memilih untuk menggunakan lifelines
                  {
                     do{ // Do while loop to tell them they are out of lifelines and input the correct answer
                        System.out.print("Anda kehabisan lifeline!\nMasukkan pilihan lagi:");
                        response = scanner.nextLine();
                     } while (response.compareTo("a")!=0&&response.compareTo("b")!=0&&response.compareTo("c")!=0&&response.compareTo("d")!=0&&response.compareTo("f")!=0);
                  }
               }
               if (response.compareTo(jawabn) == 0) // Mengecek apakah pertanyaannya benar
               {
                  rightwrong = true;
               }
               else // untuk menunjukkan bahwa mereka tidak menjawab dengan benar
               {
                  rightwrong = false;
               }
               if (rightwrong == true&&SKOR!=40) 
               {
                  System.out.println ("\njawaban "+jawabn+" benar!\n");
                  SKOR = SKORS[hitung+1];
               }
               else if (rightwrong == true&&SKOR==40) // Keluarkan jika benar atau tidak saat itu adalah pertanyaan terakhir
               {
                  System.out.println("Selamat!!!! Kamu Menang dengan nilai SEMPURNA!\n");
                  pemainClass[i].setSkor(SKOR, nama[i]); // Tetapkan nilai yang dimenangkan oleh pengguna itu
                  rightwrong = false;
               }
               else if (rightwrong == false&&response.compareTo("f")!=0) // Memeriksa untuk melihat apakah mereka tidak memilih untuk keluar dari permainan dan menjawab pertanyaan dengan benar atau salah
               {
                  SKOR = pemainClass[i].getSkorAkhir(SKOR, rightwrong); 
                  pemainClass[i].setSkor(SKOR, nama[i]); // Tetapkan nilai terakhir sebagai nilai yang dimenangkan
                  System.out.println("\nkamu Salah! Jawaban yang benar adalah : "+jawabn);
                  System.out.println("SKOR akhir kamu : " + SKOR+"\n");
               }
               else if (rightwrong == false&&response.compareTo("f")==0) // Memeriksa untuk melihat apakah mereka telah memilih untuk keluar dari game
               {
                  SKOR = pemainClass[i].getSkorKeluar(SKOR); // Mendapatkan nilai yang mereka dapatkan dengan benar
                  pemainClass[i].setSkor(SKOR, nama[i]); // Tetapkan nilai menjadi jumlah yang dimenangkan
                  System.out.println("\nKamu memilih untuk meninggalkan permainan! Jawaban yang benar adalah: "+jawabn);
                  System.out.println("SKOR akhir kamu : " + SKOR+"\n");
               }
               hitung++; // Increment jumlah
               periksaClass[i].resetMati();
            }  while (rightwrong != false && SKOR<=40 && quit!=true); 
         }
         skorAkhir1 = pemainClass[1].getArray(); // Mendapatkan array dari nilai yang dimenangkan dan memberikannya ke array skortertinggi
         for (int i = 0; i<1; i++) // looping untuk menemukan SKOR pemenang
         {
            if (i == 0) // Memeriksa apakah ini pertama kalinya. Jika ya, ini menginisialisasi SKOR pengguna sebagai SKOR pemenang
            {
               Skortertinggi = skorAkhir1[i];
            }
            else
            {
               if (skorAkhir1[i]>Skortertinggi) // Memeriksa nilai yang dimenangkan oleh pengguna yg lebih tinggi dari nilai tertinggi saat ini
               {
                  Skortertinggi = skorAkhir1[i]; // Menemukan SKOR pemenang
               }
            }
         }
         System.out.println("Hasil : "); // Menampilkan hasil
         for (int i = 0; i<1; i++) // Untuk Output nama dan SKOR pemain
         {
            System.out.println(nama[i]+"\t=> "+skorAkhir1[i]);
         }
         if (Skortertinggi!=0) // Memeriksa apakah SKOR pemenang adalah 0 atau tidak 
         {
            System.out.print ("\nSemangat ");
         }
         else if (Skortertinggi == 0) // Memeriksa apakah nilai pemenang adalah 0 atau tidak untuk menentukan apa yang akan dihasilkan
         {
            System.out.print ("\nHanya segini tetapi tetap semangat");
         }
         for (int i = 0; i<1; i++) // untuk menemukan nama pemenang
         {
            if (skorAkhir1[i] == Skortertinggi&&skorAkhir1[i]!=0&&Skortertinggi!=0) // Memeriksa apakah nilai pemenang sama dengan SKOR yang dimenangkan oleh pemain
            {
               System.out.print(nama[i]+" emot api api ");
            }
         }


         if (SKOR > 30){
            soalLvl2 mainQ = new soalLvl2();
            mainQ.soalLvl21();
         }else{
            System.out.println("\n\n SKOR anda tidak cukup untuk ke level 2!!");
         }
      }




      


      }  
   }


class soalLvl2 {
      
   static soalLvl22 soalLvl2Class[] = new soalLvl22[6];
   static Pemain pemainClass[] = new Pemain[4]; 
   static periksaLines lifelineclass[] = new periksaLines [4]; 


      // Main Program
      void soalLvl21 () {

         // Variable 
      try (Scanner scanner = new Scanner (System.in)) {
         int SKOR2 = 50, SKORS2 [] = new int [] { 50, 60, 70, 80, 90, 100}, money[] = new int [4], winnervalue=0, count = 0;
         String soal="", a = "", b = "", c = "", d = "", jawabn="", bantuan = "", nama[] = new String [4], response = "";
         boolean benarsalah = false, quit = false;
         String pilih;
            System.out.println("Selamat datang di Level 2");
            System.out.println("tekan enter untuk untuk mulai:");
            pilih = scanner.nextLine();

            for (int i = 0; i<4; i++) 
            {
               if (SKOR2 >= 50) {
               soalLvl2Class[i]= new soalLvl22 (); 
               soalLvl2Class[i].soalLvl21(); 
               pemainClass[i] = new Pemain(); 
               pemainClass[i].pemain(); 
               nama = pemainClass[i].getnama();  
               lifelineclass[i] = new periksaLines (); 
               lifelineclass[i].periksalines (a, b, c, d, jawabn, soal, bantuan, SKORS2[i]); 
               }else {
                  System.out.println("!! anda keluar !!");
               }
            }
            System.out.println("\t\t-----------------------------");
            System.out.println("\t\t WELCOME QUIZ TRIVIA LEVEL 2 ");
            System.out.println("\t\t-----------------------------");
            for (int i = 0; i<1; i++) 
            {
               count = 0;
               quit = false;
               SKOR2 = 50; 
               soalLvl2Class[i].resetBuffer(); 
               lifelineclass[i].resetPeriksa(); 
               do 
               {
                  lifelineclass[i].newSkor(SKOR2); 
                  if (SKOR2 == 50)
                  {
                     System.out.println(nama[i]+", Selamat Datang di Level 2\n"); 
                  }
                  for (int j = 1; j<=7; j++) 
                  {
                     if (j == 1)
                     {
                        soal = soalLvl2Class[i].getQuestion(); 
                        System.out.println("\t\t\t\t\t\t\t\t\t\tSKOR : "+ SKOR2 +"\n\n" + soal + "\n");
                     }
                     if (j == 2)
                     {
                        a = soalLvl2Class[i].getA(); 
                        System.out.println(a);
                     }
                     if (j == 3)
                     {
                        b = soalLvl2Class[i].getB(); 
                        System.out.println(b);
                     }
                     if (j == 4)
                     {
                        c = soalLvl2Class[i].getC();
                        System.out.println(c);
                     }
                     if (j == 5)
                     {
                        d = soalLvl2Class[i].getD(); 
                        System.out.println(d);
                     }
                     if (j == 6)
                     {
                        jawabn = soalLvl2Class[i].getAnswer(); 
                     }
                     if (j == 7)
                     {
                        bantuan = soalLvl2Class[i].getHint(); 
                     }
                  }
                  if (lifelineclass[i].hasPeriksa()) 
                  {
                     System.out.println("\ne) Gunakan lifeline");
                     if (SKOR2 == 50) 
                     {
                        System.out.println();
                     }
                  }
                  lifelineclass[i].resetJawab(a, b, c, d); 
                  if (SKOR2 != 50&&lifelineclass[i].hasPeriksa() == false) 
                  {
                     System.out.println("\nf) Keluar\n");
                  }
                  else  if (SKOR2 != 50) 
                  {
                     System.out.println("f) Keluar\n");
                  }
                  do 
                  {
                     System.out.print("Pilih Jawaban Kamu : ");
                     response = scanner.nextLine(); 
                     response = response.toLowerCase(); 
                     if (response.charAt(0)<97|| response.charAt(0)>102) 
                     {
                        System.out.println("Pilihan Tidak Valid!");
                     }
                     if (lifelineclass[i].hasPeriksa() == false&&response.compareTo("e")==0) 
                     {
                        System.out.println("Pilihan Tidak Valid! kamu keluar dari lifeline!");
                     }
                     if (response.compareTo("f")==0&&SKOR2==50)
                     {
                        System.out.println("Kamu tidak bisa berhenti");
                     }
                  } while ((response.charAt(0)<97|| response.charAt(0)>102)||(lifelineclass[i].hasPeriksa() == false&&response.compareTo("e")==0)|| (response.compareTo("f")==0&&SKOR2==2000));
                  if (response.compareTo("e")==0&&lifelineclass[i].hasPeriksa()) 
                  {
                     do 
                     {
                        response = lifelineclass[i].usePeriksa(a, b, c, d, jawabn, soal, bantuan);
                     } while (response.compareTo("e")==0);
                  }
                  if (response.compareTo("f")==0&&SKOR2 != 50) 
                  {
                     System.out.println("Terimakasi Telah Bermain!");
                     quit = true; 
                  }
                  if (lifelineclass[i].hasPeriksa() == false) 
                  {
                     if (response.compareTo("e") == 0) 
                     {
                        do{ 
                           System.out.print("Anda kehabisan lifeline!\nMasukkan pilihan lagi :");
                           response = scanner.nextLine();
                        } while (response.compareTo("a")!=0&&response.compareTo("b")!=0&&response.compareTo("c")!=0&&response.compareTo("d")!=0&&response.compareTo("f")!=0);
                     }
                  }
                  if (response.compareTo(jawabn) == 0) 
                  {
                     benarsalah = true;
                  }
                  else 
                  {
                     benarsalah = false;
                  }
                  if (benarsalah == true&&SKOR2!=100) 
                  {
                     System.out.println ("\nPilihan "+jawabn+" Benar!\n");
                     SKOR2 = SKORS2[count+1];
                  }
                  else if (benarsalah == true&&SKOR2==100)  
                  {
                     System.out.println("\n||===========================================||");
                     System.out.println("|| Selamat kamu menang dengan nilai SEMPURNA ||");
                     System.out.println("||===========================================||\n");
                     pemainClass[i].setSkor(SKOR2, nama[i]); 
                     benarsalah = false;
                  }
                  else if (benarsalah == false&&response.compareTo("f")!=0) 
                  {
                     SKOR2 = pemainClass[i].getSkorAkhir(SKOR2, benarsalah); 
                     pemainClass[i].setSkor(SKOR2, nama[i]); 
                     System.out.println("\nkamu Salah! Jawaban yang benar adalah : "+jawabn);
                     System.out.println("SKOR akhir kamu : " + SKOR2+"\n");
                  }
                  else if (benarsalah == false&&response.compareTo("f")==0) 
                  {
                     SKOR2 = pemainClass[i].getSkorKeluar(SKOR2); 
                     pemainClass[i].setSkor(SKOR2, nama[i]); 
                     System.out.println("\nKamu memilih untuk meninggalkan permainan! Jawaban yang benar adalah :"+jawabn);
                     System.out.println("SKOR akhir kamu" + SKOR2+"\n");
                  }
                  count++; // Increment hitung
                  lifelineclass[i].resetMati();
               }  while (benarsalah != false && SKOR2<=100 && quit!=true);
            }
   
      money = pemainClass[1].getArray(); 
         for (int i = 0; i<1; i++) 
         {
            if (i == 0) 
            {
               winnervalue = money[i];
            }
            else
            {
               if (money[i]>winnervalue) 
               {
                  winnervalue = money[i]; 
               }
            }
         }
         System.out.println("Hasil");
         for (int i = 0; i<1; i++) 
         {
            System.out.println(nama[i]+"\t=> "+money[i]);
         }
         if (winnervalue!=0) 
         {
            System.out.print ("\nKamu orang yg ZENIUS ");
         }
         else if (winnervalue == 0) 
         {
            System.out.print ("Hanya sampai disini!");
         }
         for (int i = 0; i<1; i++)
         {
            if (money[i] == winnervalue&&money[i]!=0&&winnervalue!=0) 
            {
               System.out.print(nama[i]+", ");
            }
         }

      
   }
}
        
}
