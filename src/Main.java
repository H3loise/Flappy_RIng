import Controller.Control;
import Modele.Avancer;
import Modele.Etat;
import Modele.Parcours;
import Modele.Voler;
import Vue.Affichage;
import Vue.ThreadAfficheur;

import javax.swing.*;
import java.util.ArrayList;

public class Main{

    public static void main(String [] args) {

        JFrame fenetre = new JFrame("Jumping Ring");
        Etat etat = new Etat(220);
        Parcours p = new Parcours(etat.largeurFenetre, etat.hauteurFenetre,etat);
        Affichage a= new Affichage(etat);
        new ThreadAfficheur(a).start();
        Control c = new Control(etat,a);

        /**fenetre.addMouseListener(a);**/
        etat.ligne=p;
        fenetre.addMouseListener(c);
        fenetre.add(a);
        fenetre.pack();
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for(int i=0;i<p.ligne.size();i++){
            System.out.println(p.ligne.get(i).toString());
            System.out.println("l'index est : "+i);
        }
        System.out.println("rentre dans le v run");
        //avance.run();
        //new Voler(etat,a).start();


        System.out.println("commence le deuxième thread");
        new Voler(etat).start();
        new Avancer(p,etat).start();
    }


}