package Modele;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Oiseau extends Thread{
    int delai;
    private int state;
    int hauteur;
    int x;
    private Etat etat;

    // Accède a l'etatv de 1 à 8 correspondant a l'image a afficher
    public int getEtat() {
        return state;
    }

    // Renvoie l'abscise de l'oiseau
    public int getX(){
        return this.x;
    }

    // Renvoie la hauteur de l'oiseau
    public int getHauteur(){
        return this.hauteur;
    }

    // permet de changer l'abscisse de l'oiseau
    public void setX(int x){
        this.x=x;
    }

    // Constructeur d'un oiseau avec hauteur et delais aléatoire
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


    //Mise a jour de l'etat
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

