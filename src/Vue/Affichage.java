package Vue;

import Modele.Etat;

import javax.swing.*;
import java.awt.*;

public class Affichage extends JPanel{
    //public static final int largeur = 300;
    //public static final int hauteur = 300;
    private int largeur;
    private int hauteur;
    private int hauteurRond;
    private int widthRond;

    //public static final int hauteurRond = 60;
    //public static final int widthRond = 30;
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
        largeur=e.largeurFenetre;
        hauteur=e.hauteurFenetre;
        hauteurRond=e.hauteurRond;
        widthRond=e.widthRond;
        setPreferredSize(new Dimension(largeur, hauteur));
        this.e=etat;
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
            vueOiseau.dessiner(g);
            g.drawOval(x, e.getHauteur(), widthRond, hauteurRond);
            int x = e.ligne.getLigne().get(0).x - this.e.ligne.getPosition();
            int y = e.ligne.getLigne().get(0).y;
            g.setColor(Color.BLACK);
            for (int i = 1; i < e.ligne.getLigne().size(); i++) {
                g.drawLine(x - this.e.ligne.getPosition(), y, e.ligne.getLigne().get(i).x - this.e.ligne.getPosition(), e.ligne.getLigne().get(i).y);
                x = e.ligne.getLigne().get(i).x;
                y = e.ligne.getLigne().get(i).y;
                g.setColor(Color.BLACK);
            }
        }
    }

}
