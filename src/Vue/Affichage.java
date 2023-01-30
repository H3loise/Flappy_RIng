package Vue;

import Modele.Etat;

import javax.swing.*;
import java.awt.*;

public class Affichage extends JPanel{
    public static final int largeur = 300;
    public static final int hauteur = 300;
    //private int largeur;
    //private int hauteur;
    //private int hauteurRond;
    //private int widthRond;

    public static final int hauteurRond = 60;
    public static final int widthRond = 30;
    public int x=0;
    //public int y=200;
    public Etat e;
    Images images;
    VueOiseau vueOiseau;

    public int getlargeur(){
        return largeur;
    }

    public int gethauteur(){
        return hauteur;
    }

    //Constructeur de l'affichage extraction de la taille de la fenetre et du cercle depuis le modele
    public Affichage(Etat etat, Images i ,VueOiseau vo){
        setPreferredSize(new Dimension(largeur, hauteur));
        this.e=etat;
        //largeur=e.largeurFenetre;
        //hauteur=e.hauteurFenetre;
        //hauteurRond=e.hauteurRond;
        //widthRond=e.widthRond;
        this.images=i;
         this.vueOiseau = vo;
    }

    @Override
    //génère l'affichage
    public void paint(Graphics g) {
        this.setBackground(Color.WHITE);
        if(e.testPerdu()){
            g.drawString("You Lost at : "+e.ligne.getPosition(),largeur/4,hauteur/2);
        }else {
            //g.drawImage(images.ImageOiseau.get(e.o1.getEtat()-1),e.o1.getX(),50,100,100,null);
            vueOiseau.dessiner(g);
            e.o1.setX(e.o1.getX()-1);
            g.drawOval(x, e.getHauteur(), widthRond, hauteurRond);
            int x = e.ligne.getLigne().get(0).x - this.e.ligne.getPosition();
            int y = e.ligne.getLigne().get(0).y;
            //System.out.println("la postion du cercle est a : " + e.getHauteur());
            g.setColor(Color.GREEN);
            g.drawLine(0,e.getHauteur()+hauteurRond/2,4,e.getHauteur()+hauteurRond/2);
            g.setColor(Color.BLUE);
            g.drawLine(0,e.getHauteur(),50,e.getHauteur());
            g.setColor(Color.MAGENTA);
            g.drawLine(x,e.getHauteur()+hauteurRond,50,e.getHauteur()+hauteurRond);
            g.setColor(Color.DARK_GRAY);
            g.drawLine(widthRond/2,e.getHauteur()+hauteurRond/2,widthRond/2+5,e.getHauteur()+hauteurRond/2);
            g.setColor(Color.BLACK);
            for (int i = 1; i < e.ligne.getLigne().size(); i++) {
                if(i==2){
                    g.setColor(Color.RED);
                }
                if(i==3){
                    g.setColor(Color.MAGENTA);
                }
                g.drawLine(x - this.e.ligne.getPosition(), y, e.ligne.getLigne().get(i).x - this.e.ligne.getPosition(), e.ligne.getLigne().get(i).y);
                x = e.ligne.getLigne().get(i).x;
                y = e.ligne.getLigne().get(i).y;
                g.setColor(Color.BLACK);
            }
        }
    }

}
