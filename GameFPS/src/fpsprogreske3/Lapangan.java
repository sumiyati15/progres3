package fpsprogreske2;

public class Lapangan {
        private int nomorLapangan = 0;
        private int kesempatan;

        public Lapangan(int kesempatan){
            this.kesempatan = kesempatan;
        }

        public int ambilNomorLapangan(){
            return this.nomorLapangan;
        }

        public boolean kurangiKesempatan(){
            this.kesempatan--;
            if(this.kesempatan==0){
                return false;
            }
            return true;
        }

        public void naikArena(){
            this.nomorLapangan+=10;
        }
}


