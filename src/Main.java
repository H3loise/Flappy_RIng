import Controller.Control;
import Modele.*;
import Vue.Affichage;
import Vue.Images;
import Vue.ThreadAfficheur;
import Vue.VueOiseau;

import javax.swing.*;
import java.util.ArrayList;

public class Main{

    public static void main(String [] args) {

        JFrame fenetre = new JFrame("Jumping Ring");
        Images images=new Images();
        Etat etat = new Etat(220);
        VueOiseau vueOiseau = new VueOiseau(images);
        Parcours p = new Parcours(etat.largeurFenetre, etat.hauteurFenetre,etat);
        Affichage a= new Affichage(etat,images, vueOiseau);
        Control c = new Control(etat,a);

        etat.ligne=p;
        fenetre.addMouseListener(c);
        fenetre.add(a);
        fenetre.pack();
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Voler v=new Voler(etat);
        v.start();
        Avancer avancer = new Avancer(p,etat);
        avancer.start();
        new ThreadAfficheur(a,v,avancer).start();

    }


}