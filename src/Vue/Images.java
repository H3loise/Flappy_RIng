package Vue;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Images {
    ArrayList<BufferedImage> ImageOiseau;

    //Tableaux permettant d'acceder aux différentes images en fonction de l'état de l'oiseau
    public Images(){
        this.ImageOiseau = new ArrayList<>();
        for(int i=1;i<9;i++){
            ImageOiseau.add(ChargeImage("frame-"+i));
        }
    }

    //Fonction permettant de charger depuis le disque les images des oiseaux
    public static BufferedImage ChargeImage(String filename) {
        try {
            return ImageIO.read(new File("src/Images/" + filename + ".gif"));
        } catch (IOException io) {
            System.out.println(filename);
            throw new RuntimeException(io);
        }
    }
}
