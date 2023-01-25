package Vue;

public class ThreadAfficheur extends Thread{
    Affichage affichage;

    public ThreadAfficheur(Affichage a){
        this.affichage=a;
    }

    @Override
    public void run() {
        while(true){
            //System.out.println("rentre dans le thread affichage");
            affichage.repaint();
            try {
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
