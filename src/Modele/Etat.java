package Modele;

import java.awt.*;

public class Etat {
    private int hauteur;
    public Parcours ligne;
    public int min= 250;
    public int max = 50;
    public boolean dead = false;
    public static final int largeurFenetre = 300;
    public static final int hauteurFenetre = 300;
    public static final int hauteurRond = 60;
    public static final int widthRond = 30;


    //Constructeur de Etat hauteur est la valeur de départ du cercle
    public Etat(int h){
        this.hauteur=h;
    }


    public int getHauteur(){
        return this.hauteur;
    }// permet d'accéder a la variable hauteur

    public void jump(){
        hauteur=hauteur-20;
    }// réalise un saut l'anneau monte de 20 pixels

    public void moveDown(){
        hauteur=hauteur+2;
    }// fait descendre le rond l'anneau decsned de 2 pixels

    public boolean testPerdu(){
        Point p1 = ligne.getPremier();
        Point p2 = ligne.getSecond();
        Point p3 = ligne.getThird();


        //recalcule la pente sur le segment suivant si le dernier point du segment a depassé la moitié du segment ( permet d'avoir la position précise du point sur la courbe
        // et non le point qui serait sur le seglent precedant
        if(ligne.getPosition()+widthRond/2> p2.x){
            p1=p2;
            p2=p3;
        }
        float pente = (float) (p2.y-p1.y)/(p2.x-p1.x);

        float pos3 = (float)p1.y+pente *(ligne.getPosition()+widthRond/2-p1.x);
        int y1=hauteur;
        int y2=hauteur+hauteurRond;
        if(pos3>hauteur+hauteurRond || pos3<hauteur){
            return true;
        }
        return false;

    }
}
