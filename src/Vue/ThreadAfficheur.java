package Vue;

import Modele.Avancer;
import Modele.Voler;

public class ThreadAfficheur extends Thread{
    Affichage affichage;
    Voler voler;
    Avancer avancer;

    public ThreadAfficheur(Affichage a, Voler v, Avancer avancer){
        this.affichage=a;
        this.voler=v;
        this.avancer=avancer;

    }

    @Override
    public void run() {
        while(true){
            //System.out.println("rentre dans le thread affichage");
            //System.out.println("la position du cercle est en : "+affichage.e.ligne.getPosition());
            //System.out.println("la position du point est en : "+affichage.e.ligne.getLigne().get(1).x);
            //System.out.println("la position du deuxième point est : "+affichage.e.ligne.getLigne().get(2).x);
            affichage.repaint();
            try {
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(affichage.e.testPerdu()){
                avancer.stop();
                voler.stop();
            }
        }

    }
}
