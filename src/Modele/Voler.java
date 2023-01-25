package Modele;

import Modele.Etat;
import Vue.Affichage;

public class Voler extends Thread{

    public Etat etat;
    //public Affichage affichage;

    public Voler(Etat etat){
        this.etat=etat;
        //this.affichage=affichage;
    }

    @Override
    public void run() {
        //super.run();
        //System.out.println("rentre dans la boucle \n");
        while(true){
            //System.out.println("debut de la boucle");
            System.out.println("move down");
            if(etat.getHauteur()<etat.hauteurFenetre - etat.hauteurRond) {
                etat.moveDown();
            }
            //affichage.repaint();
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println("la fin de la boucle");
        }
    }
}
