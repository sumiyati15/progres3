package fpsprogreske2;

import java.util.Scanner;

public class Main {
    static Lapangan lapangan = new Lapangan(3);
    static Tentara tentara = new Tentara("");
    static Pistol pistol = new Pistol("Pistol", 700, 100);
    static papanTembak papantembak = new papanTembak();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Masukkan nama Tentara: ");
        String nama = scanner.nextLine();

        inisialisasiPermainan(nama);

        while(!papantembak.lihatStatusApaMati()){
            aksi();
            if(papantembak.lihatStatusApaMati()){
                lapangan.naikArena();
                papantembak.hidupKembali();
            }
        }
    }

    private static void inisialisasiPermainan(String namaPemain){
        tentara.aturNama(namaPemain);
    }


    private static String masukanAksi(){
        System.out.println("LepasTembakan : T");
        String masukanAksi = scanner.nextLine();

        return masukanAksi;
    }

    private static String ambilArah(){
        System.out.println("Tentukan arah tembakan: ");
        System.out.println("posisi1 = A  Posisi2 = B  Posisi3 = C ");
        System.out.println("posisi4 = D  Posisi5 = E  Posisi6 = F ");
        System.out.println("posisi7 = G  Posisi8 = F  Posisi9 = G ");
        String masukanArah = scanner.nextLine();
        return masukanArah;
    }

    private static int arahDalamInt(String arahStr){
        if(arahStr.equalsIgnoreCase("A")){
            return -4;
        } else if(arahStr.equalsIgnoreCase("B")){
            return -3;
        }else if(arahStr.equalsIgnoreCase("C")){
            return -2;
        }else if(arahStr.equalsIgnoreCase("D")){
            return -1;
        }else if(arahStr.equalsIgnoreCase("E")){
            return 0;
        }else if(arahStr.equalsIgnoreCase("F")){
            return 1;
        }else if(arahStr.equalsIgnoreCase("G")){
            return 2;
        }else if(arahStr.equalsIgnoreCase("H")){
            return 3;
        } else {
            return 4;
        }
    }

    private static String arahSasaran(papanTembak papantembak){
        switch(papantembak.ambilTarget()){
            case -4:
                return "posisi1";
            case -3:
                return "posisi2";
            case -2:
                return "posisi3";
            case -1:
                return "posisi4";
            case 0:
                return "posisi5";
            case 1:
                return "posisi6";
            case 2:
                return "posisi7";
            case 3:
                return "posisi8";
            case 4:
                return "posisi9";
            default:
                return "Error";
        }
    }

    private static void aksi(){
        tampilkanStatus();

        String aksi = masukanAksi();
        while(true){
            if(!pistol.apaKesempatanHabis()){
                if(aksi.equalsIgnoreCase("T")){
                    String arahStr = ambilArah();
                    int arah = arahDalamInt(arahStr);

                    papantembak.gerakGerak();

                    if(tentara.tembak(pistol, arah, papantembak.ambilTarget())){
                        papantembak.kena(pistol.ambilKerusakan());
                        System.out.println("Tertembak");
                    } else {
                        System.out.println("temmbakan meleset");
                        System.out.println("papan tembakan ke " + arahSasaran(papantembak));
                    }
                }
            }else{
                System.out.println("Game Over/Kesempatan Habis");
                System.exit(0);
            }
            break;
        }
    }

    private static void tampilkanStatus(){
        System.out.println("Nama: " + tentara.ambilNama());
        System.out.println("Point: " + lapangan.ambilNomorLapangan());
        System.out.println("Kesempatan: " + pistol.ambilJumlahKesempatan());
        System.out.println("--------------------------------------");
    }


}
