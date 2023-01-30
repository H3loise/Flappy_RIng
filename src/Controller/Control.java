package Controller;

import Modele.Etat;
import Vue.Affichage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Control implements MouseListener {
    public Etat etat;
    public Affichage a;


    // constructeur de Controle
    public Control(Etat etat, Affichage affichage){
        this.etat=etat;
        this.a=affichage;
    }

    //fonction permettant interaction avec l'utilisateur (click)
    @Override
    public void mouseClicked(MouseEvent e) {
        if(etat.getHauteur()>0){
            etat.jump();
        }
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
