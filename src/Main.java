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
        Oiseau o1 = new Oiseau(etat);
        o1.start();
        etat.o1=o1;
        VueOiseau vueOiseau = new VueOiseau(images);
        Parcours p = new Parcours(etat.largeurFenetre, etat.hauteurFenetre,etat);
        Affichage a= new Affichage(etat,images, vueOiseau);
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
        Voler v=new Voler(etat);
        v.start();
        //new Voler(etat).start();
        Avancer avancer = new Avancer(p,etat);
        avancer.start();
        //new Avancer(p,etat).start();
        new ThreadAfficheur(a,v,avancer,vueOiseau).start();

    }


}