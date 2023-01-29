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
    Affichage a;

    public Avancer(Parcours l, Etat e){
        this.ligne=l;
        this.etat=e;
        //this.a=a;
    }

    //@Override
    /**
    public void run() {
        System.out.println("la postion modifiée est " + this.ligne.getPosition());
        int n=0;
        while(true) {
            System.out.println("taille de tableau debut "+ligne.getLigne().size());
            if (this.ligne.getPosition() % 20 == 0) {
                ArrayList<Point> l = ligne.getLigne();
                System.out.println("taille du tableau après "+ligne.getLigne().size());
                l.add(new Point(this.etat.getHauteur() + this.ligne.getPosition(), new Random().nextInt(this.etat.getHauteur() + 1)));
                //l.remove(0);
                this.ligne.setLigne(l);
            }
            this.ligne.setPosition(this.ligne.getPosition() + 1);
            //System.out.println("la position est de "+this.ligne.getPosition());
            //this.ligne.setLigne(l);
            n=n+1;
            //System.out.println("taille du tableau après "+ligne.getLigne().size());
            a.repaint();
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
     **/

    void affichageLigne(){
        for(int i=0;i<this.ligne.getLigne().size();i++){
            System.out.println(this.ligne.getLigne().get(i));
        }
    }

    @Override
    public void run() {
        while(true){
            this.ligne.setPosition(this.ligne.getPosition()+1);
            //System.out.println("la position est "+this.ligne.getPosition());
            //int max=this.ligne.getLigne().get(this.ligne.getLigne().size()-1).y+45;
            //int min=this.ligne.getLigne().get(this.ligne.getLigne().size()-1).y-45;
            if(this.ligne.getPosition()%100==0){
                //System.out.println("rentre dans la boucle");
                ArrayList<Point> prov = this.ligne.getLigne();
                int x=this.ligne.getLigne().get(this.ligne.getLigne().size()-1).x+100;
                prov.remove(0);
                int randomNum = ThreadLocalRandom.current().nextInt(etat.max, etat.min + 1);
                //prov.add(new Point(x,new Random().nextInt( this.ligne.getLigne().get(this.ligne.getLigne().size()-1).y+25)+20));
                prov.add(new Point(x,randomNum));
                this.ligne.setLigne(prov);
                //System.out.println("DEBUT");
                affichageLigne();
                //System.out.println("FIN");

            }
            //a.repaint();
            try {
                sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
