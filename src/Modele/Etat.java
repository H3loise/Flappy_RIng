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
    public static final int widthRond = 40;

    public Etat(int h){
        this.hauteur=h;
    }

    public int getHauteur(){
        return this.hauteur;
    }// permet d'accéder a la variable hauteur

    public void jump(){
        hauteur=hauteur-25;
    }// réalise un saut

    public void moveDown(){
        Point p1 = ligne.getPremier();
        Point p2 = ligne.getSecond();
        float pente = (float) (p2.y-p1.y)/(p2.x-p1.x);
        System.out.println("la pente est "+pente);
        if(hauteur <10){
            dead=true;
        }
        hauteur=hauteur+2;
    }// fait descendre le rond

    public boolean testPerdu(){
        return this.dead;
    }


}
