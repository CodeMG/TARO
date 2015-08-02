import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
public class Credits extends Hauptmenue implements ActionListener{
    private Knopf zurueck, christoph, tim, mehmet;
    private Font font;
    private Sound klicksound;
    public Credits(Fenster container){
        super(container);
        setBackground(Color.GREEN);
        setLayout(null);
        setFocusable(true);

        InputStream fin = this.getClass().getResourceAsStream("burnstown dam.ttf");
        try {font = Font.createFont ( Font.PLAIN,fin).deriveFont(24f);}
        catch (FontFormatException e) {e.printStackTrace();} 
        catch (IOException e) {e.printStackTrace();}

        zurueck=new Knopf("Zurück", 1.0/2.0, 5.0/6.0, 1.0/2.0, 1.0/6.0, font, this);
        zurueck.addActionListener(this);
        christoph = new Knopf("Christoph", 0.5, 0.1, 0.5, 0.25 , font, this);//No Knopf
        christoph.setEnabled(false);
        tim = new Knopf("Tim", 0.5, 0.3, 0.5, 0.25, font, this);
        tim.setEnabled(false);
        mehmet = new Knopf("Mehmet", 0.5, 0.5, 0.5, 0.25 , font, this);
        mehmet.setEnabled(false);
        

        klicksound=new Sound("fins__button.wav");

        setVisible(true);
        Hauptmenue.knoepfeEntfernen();
    }

    public void actionPerformed(ActionEvent e){
        klicksound.start();
        if(e.getSource()==zurueck){
            container.remove(this);
            container.add(new Hauptmenue(container));
            container.revalidate();
            container.repaint();
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setPreferredSize(null);
        christoph.skallieren(getWidth(), getHeight());
        tim.skallieren(getWidth(), getHeight());
        mehmet.skallieren(getWidth(), getHeight());
        zurueck.skallieren(getWidth(), getHeight());
    }

}