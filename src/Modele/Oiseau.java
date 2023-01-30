package Modele;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Oiseau extends Thread{
    int delai;
    private int state;
    int hauteur;
    int x;
    private Etat etat;

    public int getEtat() {
        return state;
    }

    public int getX(){
        return this.x;
    }

    public int getHauteur(){
        return this.hauteur;
    }

    public void setX(int x){
        this.x=x;
    }

    public Oiseau(Etat e){
        this.etat=e;
        Random rn =new Random();
        int randomNum = ThreadLocalRandom.current().nextInt(80, 150);
        this.delai= randomNum;
        randomNum = ThreadLocalRandom.current().nextInt(0, 150);
        this.hauteur= randomNum;
        this.state=1;
        //this.hauteur=h;
        this.x=400;
    }


    @Override
    public void run() {
        while(true){
            if(state==8){
                state=1;
            }else{
                state++;
            }
            try {
                sleep(delai);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

