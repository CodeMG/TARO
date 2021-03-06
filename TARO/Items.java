import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.*;
public abstract class Items{
    protected BufferedImage image,icon;
    protected String name;
    protected Spieler besitzer;
    public Items(BufferedImage image,BufferedImage icon,String name,Spieler spieler){
        this.image=image;
        this.icon=icon;
        this.name = name;
        besitzer = spieler;
    }

    public abstract void aktivieren(boolean aktivieren);
    
    public abstract void zeichnen(Graphics g,double zoomfaktor,JPanel panel);
    
    public BufferedImage getImage(){
        return image;
    }
    
    public BufferedImage getIcon(){
        return icon;
    }
    
    public Spieler getBesitzer(){
        return besitzer;
    }
    
    public void setBufferedImage(BufferedImage image){
        this.image = image;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
}