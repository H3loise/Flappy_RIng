package Vue;

import Modele.Etat;

import javax.swing.*;
import java.awt.*;

public class Affichage extends JPanel{
    public static final int largeur = 300;
    public static final int hauteur = 300;
    public static final int hauteurRond = 60;
    public static final int widthRond = 40;
    public int x=0;
    //public int y=200;
    public Etat e;

    public Affichage(Etat etat){
        setPreferredSize(new Dimension(largeur, hauteur));
        this.e=etat;
    }

    @Override
    //génère l'affichage
    public void paint(Graphics g) {
        if(e.testPerdu()){
            g.drawString("You Lost at : "+e.ligne.getPosition(),largeur/4,hauteur/2);
        }else {
            g.drawOval(x, e.getHauteur(), widthRond, hauteurRond);
            int x = e.ligne.getLigne().get(0).x - this.e.ligne.getPosition();
            int y = e.ligne.getLigne().get(0).y;
            System.out.println("la postion du cercle est a : " + e.getHauteur());
            g.setColor(Color.GREEN);
            g.drawLine(0,e.getHauteur()+hauteurRond/2,4,e.getHauteur()+hauteurRond/2);
            g.setColor(Color.BLACK);
            for (int i = 1; i < e.ligne.getLigne().size(); i++) {
                if(i==2){
                    g.setColor(Color.BLUE);
                }
                g.drawLine(x - this.e.ligne.getPosition(), y, e.ligne.getLigne().get(i).x - this.e.ligne.getPosition(), e.ligne.getLigne().get(i).y);
                x = e.ligne.getLigne().get(i).x;
                y = e.ligne.getLigne().get(i).y;
                g.setColor(Color.BLACK);
            }
        }
    }

}
