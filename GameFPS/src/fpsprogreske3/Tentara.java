package fpsprogreske2;

public class Tentara {
        private String nama;
        private int skor;
        private int levelTerakhir;

        public Tentara(String nama) {
            this.nama = nama;
        }

        public int ambilLevelTerakhir(){
            return this.levelTerakhir;
        }

        public void tambahSkor(){

        }

        public String ambilNama(){
            return this.nama;
        }


        public int ambilSkor(){
            return this.skor;
        }

        public boolean tembak(Pistol pistol, int arah, int posisiLawan){
            if(!pistol.apaKesempatanHabis()) pistol.kurangiKesempatan();

            if(arah != posisiLawan || pistol.apaKesempatanHabis()) {
                return false;
            }

            return true;
        }

        public void aturNama(String nama){
            this.nama = nama;
        }

}


