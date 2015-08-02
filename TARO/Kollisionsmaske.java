import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.Color;
import java.awt.Rectangle;

public class Kollisionsmaske{
    private double x,y,breite,hoehe;
    private BufferedImage maske;
    private Rectangle grobeKollisionsmaske;
    public Kollisionsmaske(double x, double y, BufferedImage maske)    {
        this.maske = maske;
        this.x = x;
        this.y = y;
        breite = maske.getWidth();
        hoehe = maske.getHeight();

        grobeKollisionsmaske = new Rectangle((int)x,(int)y,(int)breite,(int)hoehe);
    }

    public boolean kollidiert(Kollisionsmaske kollisionsObjekt, double xV, double yV){
        double xTmp = x;
        double yTmp = y;

        setX(x+xV);
        setY(y+yV);

        boolean rueckgabe = kollidiert(kollisionsObjekt);

        setX(xTmp);
        setY(yTmp);

        return rueckgabe;
    }

    public boolean kollidiert(Kollisionsmaske kollisionsObjekt){
        boolean ergebnis = false;
        if(grobeKollisionsmaske.intersects(kollisionsObjekt.getRectangle())){
            BufferedImage teilmaskeThis = getKollisionsAusschnitt(kollisionsObjekt);
            BufferedImage teilmaskeFremd = kollisionsObjekt.getKollisionsAusschnitt(this);

            for(int i=0; i<teilmaskeThis.getWidth() && !ergebnis; i++){
                for(int j=0; j<teilmaskeThis.getHeight() && !ergebnis; j++){
                    int rgb1 = teilmaskeThis.getRGB(i, j);
                    Color c1 = new Color(rgb1);
                    int test1 = c1.getRed();
                    int rgb2 = teilmaskeFremd.getRGB(i, j);
                    Color c2 = new Color(rgb2);
                    int test2 = c2.getRed();
                    if(c1.getRed()==255 && c2.getRed() ==255){
                        ergebnis=true;
                    }

                }
            }

        }
        return ergebnis;
    }

    public BufferedImage getKollisionsAusschnitt(Kollisionsmaske kollisionsObjekt){
        int xAusschnitt;

        if(x>=kollisionsObjekt.getX()){
            xAusschnitt = 0;
        }else{
            xAusschnitt = (int)(kollisionsObjekt.getX()-x);
        }

        int yAusschnitt;

        if(y>=kollisionsObjekt.getY()){
            yAusschnitt = 0;
        }else{
            yAusschnitt = (int)(kollisionsObjekt.getY()-y);
        }

        int bAusschnitt;
        {
            int x1 = (int)kollisionsObjekt.getX();
            if( x > x1){ x1 = (int)x;}

            int x2 = (int)(kollisionsObjekt.getX()+kollisionsObjekt.getBreite());
            if( x+breite < x2){ x2 = (int)(x+breite);}

            bAusschnitt = x2-x1;
        }

        int hAusschnitt;
        {
            int y1 = (int)kollisionsObjekt.getY();
            if( y > y1){ y1 = (int)y;}

            int y2 = (int)(kollisionsObjekt.getY()+kollisionsObjekt.getHoehe());
            if( y+hoehe < y2){ y2 = (int)(y+hoehe);}

            hAusschnitt = y2-y1;
        }

        return maske.getSubimage((int)xAusschnitt,(int)yAusschnitt,(int)bAusschnitt,(int)hAusschnitt);
    }

    public Rectangle getRectangle(){
        return grobeKollisionsmaske;
    }

    public void setX(double x){
        this.x = x;
        grobeKollisionsmaske.setLocation((int) x, (int) y);
    }

    public double getX(){
        return x;
    }

    public void setY(double y){
        this.y = y;        
        grobeKollisionsmaske.setLocation((int) x, (int) y);
    }

    public double getY(){
        return y;
    }

    public BufferedImage getMaske(){
        return maske;
    }

    public double getBreite(){
        return breite;
    }

    public double getHoehe(){
        return hoehe;
    }
}

