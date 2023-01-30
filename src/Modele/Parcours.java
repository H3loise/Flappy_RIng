package Modele;
import java.util.List;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import Vue.Affichage;

public class Parcours {
    public ArrayList<Point> ligne;
    private Affichage affichage;
    private int position;
    public Etat etat;

    // Constructeur de Parcours (on met volontairment une ligne droite dès le début pour laisser le temps au jeu de charger et a l'utilisateur e commencer la partie
    public Parcours(int hauteur, int largeur,Etat etat){
        this.position=0;
        this.etat=etat;
        this.ligne=new ArrayList<>();
        this.ligne.add(new Point(-20,270));
        this.ligne.add(new Point(0,270));
        this.ligne.add(new Point(100,270));
        this.ligne.add(new Point(200,270));
        this.ligne.add(new Point(300,270));
        for(int i=400;i<=largeur+200;i=i+100){
            Random rn =new Random();
            int randomNum = ThreadLocalRandom.current().nextInt(etat.max, etat.min + 1);
            //this.ligne.add(new Point(i,new Random().nextInt( (this.ligne.get(this.ligne.size()-1).y+25)-(this.ligne.get(this.ligne.size()-1).y-25)+1)+(this.ligne.get(this.ligne.size()-1).y-25)));
            this.ligne.add(new Point(i,randomNum));
        }
    }

    public ArrayList<Point> getLigne(){//permet d'accéder a la list de point qui modélise la ligne brisée
        ArrayList<Point> l = new ArrayList<>();
        for(int i =0;i< ligne.size();i++){
            if(ligne.get(i).x<=etat.largeurFenetre+position+200) {
                l.add(ligne.get(i));
            }
        }
        return l;


    }

    public Point getPremier(){
        return ligne.get(1);
    }// accède au premier element du tableau de points

    public Point getSecond(){
        return ligne.get(2);
    }//accède au deuxième element du tableau de points

    public Point getThird(){
        return ligne.get(3);
    }//accède au troisième element du tableau de points



    public int getPosition(){
        return this.position;
    }//renvoie la positon du rond et donc le score

    public void setPosition(int p){
        this.position=p;
    }// Change la position du rond et donc le score

    public void setLigne(ArrayList<Point> ligne){
        this.ligne=ligne;
    }//renvoie le tableau de points



}
