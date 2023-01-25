package Controller;

import Modele.Etat;
import Vue.Affichage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Control implements MouseListener {
    public Etat etat;
    public Affichage a;


    public Control(Etat etat, Affichage affichage){
        this.etat=etat;
        this.a=affichage;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(etat.getHauteur()>0){
            etat.jump();
        }
        //etat.jump();
        /**repaint();**/
        System.out.println("coucou\n");
        //a.repaint();


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
