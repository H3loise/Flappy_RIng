package Vue;

import Modele.Avancer;
import Modele.Voler;

public class ThreadAfficheur extends Thread{
    Affichage affichage;
    VueOiseau vueOiseau;
    Voler voler;
    Avancer avancer;

    //constructeur de Threadafficheur contenant tout les thread pour pouvoir les arreter en fin de partie
    public ThreadAfficheur(Affichage a, Voler v, Avancer avancer,VueOiseau vo){
        this.affichage=a;
        this.voler=v;
        this.avancer=avancer;

    }

    // Fonction Run reaffichant le jeu toutes les 20 miliseconde ( valeur arbitraire)
    @Override
    public void run() {
        while(true){
            affichage.repaint();

            try {
                sleep(20);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            if(affichage.e.testPerdu()){
                avancer.stop();
                voler.stop();
                affichage.repaint();
                this.stop();
            }
        }

    }
}
