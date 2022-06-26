package fpsprogreske2;
import java.util.Random;


public class papanTembak {
        private int nyawa = 100;
        private int posisiTerakhir = 0;
        private boolean apaMati = false;

        public papanTembak() {}
        public int ambilTarget(){
        return this.posisiTerakhir;
        }

        public void gerakGerak(){
            Random rand = new Random();
            int arah = rand.nextInt(3) - 1; //Generate random int from -1 to 1

            this.posisiTerakhir = arah;
        }

        public void kena(int besarKerusakan){
            kurangTarget(besarKerusakan);
            if(ambilTarget() <= 0){
                this.apaMati = true;
            }
        }

        private void kurangTarget(int besarKerusakan){
            this.nyawa -= besarKerusakan;
        }

        public boolean lihatStatusApaMati(){
            return this.apaMati;
        }

        public void hidupKembali(){
            this.nyawa = 100;
            this.apaMati = false;
        }
    }

