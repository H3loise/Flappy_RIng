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
    public Oiseau o1;

    public Etat(int h){
        this.hauteur=h;
    }


    public int getHauteur(){
        return this.hauteur;
    }// permet d'accéder a la variable hauteur

    public void jump(){
        Point p1 = ligne.getPremier();
        Point p2 = ligne.getSecond();
        Point p3 = ligne.getThird();
        Point p4 = ligne.getForth();
        if(ligne.getPosition()+widthRond/2> p2.x){
            p1=p3;
            p2=p4;
        }
        float pente = (float) (p2.y-p1.y)/(p2.x-p1.x);
        float pos = (float)p1.y+pente * (ligne.getPosition()-p2.x);
        /**
        if(pos>hauteur+hauteurRond || pos<hauteur){
            dead=true;
        }
         **/
        hauteur=hauteur-20;
    }// réalise un saut

    public void moveDown(){
        /**
         Point p1 = ligne.getPremier();
         Point p2 = ligne.getSecond();
         Point p3 = ligne.getThird();
         Point p4 = ligne.getForth();
         if(ligne.getPosition()+widthRond/2> p2.x){
         p1=p3;
         p2=p4;
         }
         float pente = (float) (p2.y-p1.y)/(p2.x-p1.x);
         pente=-pente;

         System.out.println("la pente est "+pente);
         System.out.println("le get position est "+ligne.getPosition());
         float pos = (float)p1.y+pente *(ligne.getPosition()-p1.x);
         System.out.println("les coos de p1 "+p1.y);
         System.out.println("les coos de p2 "+p2.y);
         System.out.println("la position du point a un endroit donné "+pos);
         System.out.println("borne sup "+hauteur);
         System.out.println("borne inf "+(hauteur+hauteurRond));
         /**

        if(pos>hauteur+hauteurRond+3 || pos<hauteur-4){
            dead=true;
        }
         **/
        if(hauteur <10){
            dead=true;
        }
        hauteur=hauteur+2;
    }// fait descendre le rond

    public boolean testPerdu(){
        Point p1 = ligne.getPremier();
        Point p2 = ligne.getSecond();
        Point p3 = ligne.getThird();
        Point p4 = ligne.getForth();
        int xcentre = ligne.getPosition()+widthRond/2;


        if(ligne.getPosition()+widthRond/2> p2.x){
            p1=p2;
            p2=p3;
        }
        float pente = (float) (p2.y-p1.y)/(p2.x-p1.x);
        //pente=-pente;
        float pos1 = (float)p1.y+pente *(ligne.getPosition()-p1.x);
        float pos2 = (float)p1.y+pente *(ligne.getPosition()+widthRond-p1.x);
        float pos3 = (float)p1.y+pente *(ligne.getPosition()+widthRond/2-p1.x);
        int e=0;
        int x=ligne.getPosition()+hauteurRond/2;
        int y1=hauteur;
        int y2=hauteur+hauteurRond;

        //if((pos1>hauteur+hauteurRond && pos2>hauteur+hauteurRond)|| (pos1<hauteur && pos2<hauteur)){
        if(pos3>hauteur+hauteurRond+3 || pos3<hauteur-3){
            //dead=true;
            System.out.println("la borne sup est a : "+y1);
            System.out.println("la borne moins est a : "+y2);
            System.out.println("le point sur la pente est a : "+pos3);
            System.out.println("mort");
            e=1;
            return true;
        }
        return false;

    }
}
