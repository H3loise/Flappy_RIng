package Modele;
//faire un thread pour respecter l'architecture qui va repaint toutes les 50 milisecondes

import Vue.Affichage;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Avancer extends Thread{
    Parcours ligne;
    Etat etat;

    public Avancer(Parcours l, Etat e){
        this.ligne=l;
        this.etat=e;
    }


    void affichageLigne(){
        for(int i=0;i<this.ligne.getLigne().size();i++){
            System.out.println(this.ligne.getLigne().get(i));
        }
    }

    @Override
    public void run() {
        while(true){
            this.ligne.setPosition(this.ligne.getPosition()+1);
            if(this.ligne.getPosition()%100==0){
                ArrayList<Point> prov = this.ligne.getLigne();
                int x=this.ligne.getLigne().get(this.ligne.getLigne().size()-1).x+100;
                prov.remove(0);
                int randomNum = ThreadLocalRandom.current().nextInt(etat.max, etat.min + 1);
                prov.add(new Point(x,randomNum));
                this.ligne.setLigne(prov);
                affichageLigne();

            }
            try {
                sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
