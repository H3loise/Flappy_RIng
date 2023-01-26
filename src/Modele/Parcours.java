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

    public Parcours(int hauteur, int largeur,Etat etat){
        this.position=0;
        this.etat=etat;
        this.ligne=new ArrayList<>();
        //valeur prec a 270
        this.ligne.add(new Point(-20,270));
        this.ligne.add(new Point(0,270));
        this.ligne.add(new Point(100,270));
        this.ligne.add(new Point(200,270));
        this.ligne.add(new Point(300,270));
        //int max=this.ligne.get(this.ligne.size()-1).y+45;
        //int min=this.ligne.get(this.ligne.size()-1).y-45;
        for(int i=400;i<=largeur+200;i=i+100){
            Random rn =new Random();
            int randomNum = ThreadLocalRandom.current().nextInt(etat.max, etat.min + 1);
            //this.ligne.add(new Point(i,new Random().nextInt( (this.ligne.get(this.ligne.size()-1).y+25)-(this.ligne.get(this.ligne.size()-1).y-25)+1)+(this.ligne.get(this.ligne.size()-1).y-25)));
            this.ligne.add(new Point(i,randomNum));
        }
    }

    public ArrayList<Point> getLigne(){//permet d'accéder a la list de point qui modélise la ligne brisée
        //return ligne;


        //List Listligne= this.ligne.subList(position,position+affichage.largeur);
        //Listligne.toArray();


        ArrayList<Point> l = new ArrayList<>();
        //System.out.println("la postion dans le get est : "+position);
        for(int i =0;i< ligne.size();i++){
            //System.out.println("rentre dans la boucle");
            if(ligne.get(i).x<=affichage.largeur+position+200) {
                l.add(ligne.get(i));
            }
        }
        return l;


    }

    public Point getPremier(){
        return ligne.get(1);
    }

    public Point getSecond(){
        return ligne.get(2);
    }

    public Point getThird(){
        return ligne.get(3);
    }

    public Point getForth(){
        return ligne.get(4);
    }


    public int getPosition(){
        return this.position;
    }

    public void setPosition(int p){
        this.position=p;
    }

    public void setLigne(ArrayList<Point> ligne){
        this.ligne=ligne;
    }



}
