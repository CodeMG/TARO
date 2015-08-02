import java.util.*;
import java.awt.image.BufferedImage;

public class Mensch extends NPC{
    private GUITextFeld text;
    int cooldown;
    public Mensch(BufferedImage bild, int x,int y,GUITextFeld text){
        super(new Animation(bild,19,150),
            new Animation(bild,19,150),
            new Animation(bild,19,150),
            new Animation(bild,19,150),
            Bilder.getNPCMaske(),x,y,19,33);
        this.text = text;
    }

    public void positionBerechnen(ArrayList<Hindernis> hindernisse){
        super.positionBerechnen(hindernisse);
        cooldown-=25;
    }

    public void kollidiertMitSpieler(){

    }

    public void wirdAngegriffen(double x,double y,int schaden){
        if(cooldown<0){
            spieler.setText(text);
            Spielschleife.pausieren();
            cooldown=100;
        }
    }

}