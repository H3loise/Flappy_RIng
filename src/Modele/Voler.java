package Modele;

import Modele.Etat;
import Vue.Affichage;

public class Voler extends Thread{

    public Etat etat;

    //Constructeur de Voler
    public Voler(Etat etat){
        this.etat=etat;
    }

    //Fais decendre le rond si il n'est pas deja tout en bas de la fenetre
    @Override
    public void run() {
        while(true){
            if(etat.getHauteur()<etat.hauteurFenetre - etat.hauteurRond) {
                etat.moveDown();
            }
            try {
                sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
