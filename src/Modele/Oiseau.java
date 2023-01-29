package Modele;

public class Oiseau extends Thread{
    int delai;
    private int etat;
    int hauteur;
    int x;

    public int getEtat() {
        return etat;
    }

    public Oiseau(int d, int e, int h, int x){
        this.delai=d;
        this.etat=e;
        this.hauteur=h;
        this.x=x;
    }


    @Override
    public void run() {
        while(true){
            if(etat==8){
                etat=1;
            }else{
                etat++;
            }
            try {
                sleep(delai);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

