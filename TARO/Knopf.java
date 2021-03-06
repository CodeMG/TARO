import javax.swing.*;
import java.awt.*;

public class Knopf extends JButton{
    private double x,y,b,h;
    private Font font;
    private boolean markiert=false;
    public Knopf(String name, double x, double y, double b, double h, Font font, JComponent jc)    {
        super(name);
        setBounds(100,100,100,100);
        setForeground(Color.BLACK);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setVisible(true);
        this.x=x;
        this.y=y;
        this.b=b;
        this.h=h;
        this.font=font;
        jc.add(this); 
        skallieren(jc.getWidth(),jc.getHeight());     
    }

    public void skallieren(int frameBreite, int frameHoehe){
        setBounds((int)(frameBreite*x)-(int)(frameBreite*b)/2,(int)(frameHoehe*y),(int)(frameBreite*b),(int)(frameHoehe*h));
        setFont(font.deriveFont((float)(frameHoehe*h/2)));
    }   
    public void markieren(){
        setForeground(new Color(15, 115, 250));
        markiert=true;
    }
    public void entmarkieren(){
        setForeground(new Color(0, 0, 0));
        markiert=false;
    }
    public boolean istMarkiert(){
        return markiert;
    }
}
