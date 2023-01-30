package Vue;

import Modele.Etat;
import Modele.Oiseau;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class VueOiseau{
    ArrayList<Oiseau> oiseaux;
    Images images;
    Etat e;


    public VueOiseau(Images i){
        this.oiseaux=new ArrayList<>();
        Oiseau o = new Oiseau(e);
        o.start();
        oiseaux.add(o);
        images=i;
    }

    public void dessiner(Graphics g){
        for(int i=0;i< oiseaux.size();i++){
            //g.drawImage(images.ImageOiseau.get(e.o1.getEtat()-1),e.o1.getX(),50,100,100,null);
            g.drawImage(images.ImageOiseau.get(oiseaux.get(i).getEtat()-1),oiseaux.get(i).getX(),oiseaux.get(i).getHauteur(),100,100,null);
            oiseaux.get(i).setX(oiseaux.get(i).getX()-1);
            if(oiseaux.get(i).getX()<-100){
                oiseaux.get(i).stop();
                oiseaux.remove(0);
            }
            Random rn =new Random();
            int randomNum = ThreadLocalRandom.current().nextInt(0, 420);
            System.out.println("la valeur du random est  "+randomNum);
            if(randomNum==80){
                Oiseau o = new Oiseau(e);
                o.start();
                oiseaux.add(o);
            }

        }
    }

}
