import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.FontFormatException;
import java.io.IOException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Optionsmenue extends Hauptmenue implements ActionListener, KeyListener{
    private Font font;
    private static Knopf steuerung, fenstergroesse, lautstaerke, zurueckInsHauptmenue, zurueckInsOptionsmenue, zurueckZumSpiel; //Im Optionsmenü
    private static Knopf musikLauter, musikLeiser, soundLauter, soundLeiser, musikBalken, soundBalken, musikAn, soundAn, soundAnzahl, musikAnzahl;; //Lautstärkemenü
    private static Knopf vollbild, klein, mittel, gross; //Fenstergrößemenü
    private static Knopf links, rechts, oben, unten, angriff, benutzen, pause;
    private static boolean fullscreenAn=true;
    private static int fenstergroesseX=800;
    private static int fenstergroesseY=600;
    private static boolean musikIstAn=true;
    private static boolean soundIstAn=true;
    private static double musikBalkenPosition=0.5; //Position des Musiklautstärkebalkens
    private static double soundBalkenPosition=0.5; //Position des Soundlautstärkebalkens
    private static int soundLautstaerkeBegrenzung=10;
    private static int musikLautstaerkeBegrenzung=10;//Max 20, min 0
    private boolean fensterVeraendern=true;
    private Sound klicksound;
    public Optionsmenue(Fenster container){
        super(container);
        setBackground(Color.ORANGE);
        setLayout(null);
        setFocusable(true);
        fenstergroesseX=container.getFensterX();
        fenstergroesseY=container.getFensterY();

        InputStream fin = this.getClass().getResourceAsStream("burnstown dam.ttf");
        try {font = Font.createFont ( Font.PLAIN,fin).deriveFont(24f);}
        catch (FontFormatException e) {e.printStackTrace();} 
        catch (IOException e) {e.printStackTrace();}

        steuerung=new Knopf("Steuerung",           1.0/2.0, 2.0/6.0, 1.0/2.0, 1.0/6.0, font, this);
        steuerung.addActionListener(this);

        fenstergroesse=new Knopf("Fenstergröße", 1.0/2.0, 3.0/6.0, 1.0/1.0, 1.0/6.0, font, this);
        fenstergroesse.addActionListener(this);

        lautstaerke=new Knopf("Lautstärke",       1.0/2.0, 4.0/6.0, 1.0/2.0, 1.0/6.0, font, this);
        lautstaerke.addActionListener(this);

        zurueckInsHauptmenue=new Knopf("Zurück",               1.0/2.0, 5.0/6.0, 1.0/2.0, 1.0/6.0, font, this);        
        zurueckInsHauptmenue.addActionListener(this);

        klicksound=new Sound("fins__button.wav");
        setVisible(true);
        Hauptmenue.knoepfeEntfernen();
    }

    public Optionsmenue(){
        setBackground(Color.ORANGE);
        setLayout(null);
        setFocusable(true);
        fenstergroesseX=container.getFensterX();
        fenstergroesseY=container.getFensterY();

        InputStream fin = this.getClass().getResourceAsStream("burnstown dam.ttf");
        try {font = Font.createFont ( Font.PLAIN,fin).deriveFont(24f);}
        catch (FontFormatException e) {e.printStackTrace();} 
        catch (IOException e) {e.printStackTrace();}

        steuerung=new Knopf("Steuerung",           1.0/2.0, 2.0/6.0, 1.0/2.0, 1.0/6.0, font, this);
        steuerung.addActionListener(this);

        fenstergroesse=new Knopf("Fenstergröße", 1.0/2.0, 3.0/6.0, 1.0/1.0, 1.0/6.0, font, this);
        fenstergroesse.addActionListener(this);

        lautstaerke=new Knopf("Lautstärke",       1.0/2.0, 4.0/6.0, 1.0/2.0, 1.0/6.0, font, this);
        lautstaerke.addActionListener(this);

        zurueckZumSpiel=new Knopf("Zurück",               1.0/2.0, 5.0/6.0, 1.0/2.0, 1.0/6.0, font, this);        
        zurueckZumSpiel.addActionListener(this);

        klicksound=new Sound("fins__button.wav");
        setVisible(true);
        Hauptmenue.knoepfeEntfernen();
    }

    public void actionPerformed(ActionEvent e){ 
        if(soundIstAn==true){
            klicksound.start();
        }
        if(e.getSource()==steuerung){
            knoepfeEntfernen();            
            zurueckInsOptionsmenue=new Knopf("Zurück",1.0/2.0, 5.0/6.0, 1.0/2.0, 1.0/6.0, font, this);
            zurueckInsOptionsmenue.addActionListener(this);

            links=new Knopf("Links: " +Steuerung.getLinksTastenText(),           1.0/3.0, 1.0/6.0, 1.0/2.0, 1.0/8.0, font, this);
            links.addActionListener(this);
            links.addKeyListener(this);
            rechts=new Knopf("Rechts: " +Steuerung.getRechtsTastenText(),        1.0/3.0, 2.0/6.0, 1.0/2.0, 1.0/8.0, font, this);
            rechts.addActionListener(this);
            rechts.addKeyListener(this);
            oben=new Knopf("Oben: " +Steuerung.getObenTastenText(),              1.0/3.0, 3.0/6.0, 1.0/2.0, 1.0/8.0, font, this);
            oben.addActionListener(this);
            oben.addKeyListener(this);
            unten=new Knopf("Unten: " +Steuerung.getUntenTastenText(),           1.0/3.0, 4.0/6.0, 1.0/2.0, 1.0/8.0, font, this);
            unten.addActionListener(this);
            unten.addKeyListener(this);
            angriff=new Knopf("Angriff: " +Steuerung.getAngriffTastenText(),     2.0/3.0, 1.0/6.0, 1.0/2.0, 1.0/8.0, font, this);
            angriff.addActionListener(this);
            angriff.addKeyListener(this);
            benutzen=new Knopf("Benutzen: " +Steuerung.getBenutzenTastenText(),  2.0/3.0, 2.0/6.0, 1.0/2.0, 1.0/8.0, font, this);
            benutzen.addActionListener(this);
            benutzen.addKeyListener(this);
            pause=new Knopf("Pause: " +Steuerung.getPauseTastenText(),           2.0/3.0, 3.0/6.0, 1.0/2.0, 1.0/8.0, font, this);
            pause.addActionListener(this);
            pause.addKeyListener(this);
        }
        else if(e.getSource()==links){
            alleEntmarkieren();
            links.markieren();
        }
        else if(e.getSource()==rechts){
            alleEntmarkieren();
            rechts.markieren();
        }
        else if(e.getSource()==oben){
            alleEntmarkieren();
            oben.markieren();
        }
        else if(e.getSource()==unten){
            alleEntmarkieren();
            unten.markieren();
        }
        else if(e.getSource()==angriff){
            alleEntmarkieren();
            angriff.markieren();
        }
        else if(e.getSource()==benutzen){
            alleEntmarkieren();
            benutzen.markieren();
        }
        else if(e.getSource()==pause){
            alleEntmarkieren();
            pause.markieren();
        }
        //-------------------------------------------------

        else if(e.getSource()==fenstergroesse){
            knoepfeEntfernen();
            vollbild=new Knopf("Vollbild An/Aus", 1.0/2.0, 1.0/15.0, 1.0/2.0, 1.0/6.0, font, this);
            vollbild.addActionListener(this);             
            zurueckInsOptionsmenue=new Knopf("Zurück",1.0/2.0, 5.0/6.0, 1.0/2.0, 1.0/6.0, font, this);
            zurueckInsOptionsmenue.addActionListener(this);  
            klein=new Knopf("Klein",              1.0/2.0, 1.0/5.0,  1.0/2.0, 1.0/6.0, font, this);
            klein.addActionListener(this);
            mittel=new Knopf("Mittel",              1.0/2.0, 2.0/5.0,  1.0/2.0, 1.0/6.0, font, this);
            mittel.addActionListener(this);
            gross=new Knopf("Groß",              1.0/2.0, 3.0/5.0,  1.0/2.0, 1.0/6.0, font, this);
            gross.addActionListener(this);
            if(fullscreenAn==true){
                klein.setVisible(false);
                mittel.setVisible(false);
                gross.setVisible(false);
            }
        }
        else if(e.getSource()==vollbild){
            if(fullscreenAn==false){
                container.fullscreenAn();
                knoepfeEntfernen();      
                vollbild=new Knopf("Vollbild An/Aus", 1.0/2.0, 1.0/15.0, 1.0/2.0, 1.0/6.0, font, this);
                vollbild.addActionListener(this);
                zurueckInsOptionsmenue=new Knopf("Zurück",1.0/2.0, 5.0/6.0, 1.0/2.0, 1.0/6.0, font, this);
                zurueckInsOptionsmenue.addActionListener(this);                  
                fullscreenAn=true;
            }   
            else{
                container.fullscreenAus();
                knoepfeEntfernen();
                vollbild=new Knopf("Vollbild An/Aus", 1.0/2.0, 1.0/15.0, 1.0/2.0, 1.0/6.0, font, this);
                vollbild.addActionListener(this);
                zurueckInsOptionsmenue=new Knopf("Zurück",1.0/2.0, 5.0/6.0, 1.0/2.0, 1.0/6.0, font, this);
                zurueckInsOptionsmenue.addActionListener(this);
                klein.setVisible(true);
                mittel.setVisible(true);
                gross.setVisible(true);
                fullscreenAn=false;
            }            
        }
        else if(e.getSource()==klein){
            fenstergroesseX=512;
            fenstergroesseY=400;
            container.setFensterX(fenstergroesseX);
            container.setFensterY(fenstergroesseY);
        }
        else if(e.getSource()==mittel){
            fenstergroesseX=800;
            fenstergroesseY=600;
            container.setFensterX(fenstergroesseX);
            container.setFensterY(fenstergroesseY);               
        }
        else if(e.getSource()==gross){
            fenstergroesseX=1024;
            fenstergroesseY=800;
            container.setFensterX(fenstergroesseX);
            container.setFensterY(fenstergroesseY);
        }    
        else if(fensterVeraendern==false&&klein!=null&&mittel!=null&&gross!=null){
            klein.setVisible(false);
            mittel.setVisible(false);
            gross.setVisible(false);
        }

        //-------------------------------------------------
        else if(e.getSource()==lautstaerke){
            knoepfeEntfernen();
            if(musikIstAn==true){
                musikAn=new Knopf("Musik An",                  1.0/2.0, 1.0/100.0, 1.0/2.0, 1.0/6.0, font, this);
                musikAn.addActionListener(this);
                musikAn.setEnabled(false);
            }
            else{
                musikAn=new Knopf("Musik Aus",                  1.0/2.0, 1.0/100.0, 1.0/2.0, 1.0/6.0, font, this);
                musikAn.addActionListener(this);
            }
            if(soundIstAn==true){
                soundAn=new Knopf("Sound An",                  1.0/2.0, 1.0/1.95, 1.0/2.0, 1.0/6.0, font, this);
                soundAn.addActionListener(this);
            }
            else{
                soundAn=new Knopf("Sound Aus",                  1.0/2.0, 1.0/1.95, 1.0/2.0, 1.0/6.0, font, this);
                soundAn.addActionListener(this);
            }
            /*musikLauter=new Knopf("Lauter",               1.0/1.1, 1.0/10.0, 1.0/2.0, 1.0/6.0, font, this);
            musikLauter.addActionListener(this); 
            musikLeiser=new Knopf("Leiser",               1.0/10.0, 1.0/10.0, 1.0/2.0, 1.0/6.0, font, this);
            musikLeiser.addActionListener(this);
            soundLauter=new Knopf("Lauter",               1.0/1.1, 1.0/1.7, 1.0/2.0, 1.0/6.0, font, this);
            soundLauter.addActionListener(this);
            soundLeiser=new Knopf("Leiser",               1.0/10.0, 1.0/1.7, 1.0/2.0, 1.0/6.0, font, this);
            soundLeiser.addActionListener(this);*/
            zurueckInsOptionsmenue=new Knopf("Zurück",          1.0/2.0, 5.0/6.0, 1.0/2.0, 1.0/6.0, font, this);
            zurueckInsOptionsmenue.addActionListener(this);
            /*musikBalken=new Knopf("|", musikBalkenPosition,     1.0/10.0, 1.0/2.0, 1.0/6.0, font, this);
            musikBalken.setEnabled(false);
            soundBalken=new Knopf("|", soundBalkenPosition,     1.0/1.6, 1.0/2.0, 1.0/6.0, font, this);
            soundBalken.setEnabled(false);

            musikAnzahl=new Knopf(""+musikLautstaerkeBegrenzung, 1.0/2.0, 1.0/6.0, 1.0/2.0, 1.0/6.0, font, this);
            soundAnzahl=new Knopf(""+soundLautstaerkeBegrenzung, 1.0/2.0, 1.0/1.4, 1.0/2.0, 1.0/6.0, font, this);*/
        }
        else if(e.getSource()==musikAn){
            if(musikIstAn==true){
                musikAn.setVisible(false);
                musikAn=new Knopf("Musik Aus", 1.0/2.0, 1.0/100.0, 1.0/2.0, 1.0/6.0, font, this);
                musikAn.addActionListener(this);
                musikIstAn=false;
                Fenster.musikHalt();
                //Musik Aus
            }
            else{
                musikAn.setVisible(false);
                musikAn=new Knopf("Musik An", 1.0/2.0, 1.0/100.0, 1.0/2.0, 1.0/6.0, font, this);
                musikAn.addActionListener(this);
                musikIstAn=true;
                Fenster.musikWeiter("SM64-File Select.wav");
                //Musik An
            }
        }
        else if(e.getSource()==soundAn){
            if(soundIstAn==true){
                soundAn.setVisible(false);
                soundAn=new Knopf("Sound Aus", 1.0/2.0, 1.0/1.95, 1.0/2.0, 1.0/6.0, font, this);
                soundAn.addActionListener(this);
                soundIstAn=false;
                //Sound Aus
            }
            else{
                soundAn.setVisible(false);
                soundAn=new Knopf("Sound An", 1.0/2.0, 1.0/1.95, 1.0/2.0, 1.0/6.0, font, this);
                soundAn.addActionListener(this);
                soundIstAn=true;
                //Sound An
            }
        }
        else if(e.getSource()==musikLauter){
            musikLautstaerkebalkenVerschieben(true);
        }
        else if(e.getSource()==musikLeiser){
            musikLautstaerkebalkenVerschieben(false);
        }   
        else if(e.getSource()==soundLauter){
            soundLautstaerkebalkenVerschieben(true);
        }
        else if(e.getSource()==soundLeiser){
            soundLautstaerkebalkenVerschieben(false);
        }

        if(e.getSource()==zurueckInsOptionsmenue){
            container.remove(this);
            container.add(new Optionsmenue(container));
            container.revalidate();
            container.repaint();
        }
        else if(e.getSource()==zurueckInsHauptmenue){
            container.remove(this);
            container.add(new Hauptmenue(container));
            container.revalidate();
            container.repaint();

        }
        if(e.getSource()==zurueckZumSpiel){
            Fenster.optionsmenueSchliessen();
        }
    }

    public static void knoepfeEntfernen(){
        steuerung.setVisible(false);
        fenstergroesse.setVisible(false);
        lautstaerke.setVisible(false);
        zurueckInsHauptmenue.setVisible(false);

        if(vollbild!=null){
            vollbild.setVisible(false);
        }
        if(zurueckInsOptionsmenue!=null){
            zurueckInsOptionsmenue.setVisible(false);
        }
        if(klein!=null&&mittel!=null&&gross!=null){
            klein.setVisible(false);
            mittel.setVisible(false);
            gross.setVisible(false);
        }
        if(musikLauter!=null){
            musikLauter.setVisible(false);
            musikLeiser.setVisible(false);
            soundLauter.setVisible(false);
            soundLeiser.setVisible(false);
            musikAn.setVisible(false);
            soundAn.setVisible(false);
        }
    }

    public void musikLautstaerkebalkenVerschieben(boolean lauter){
        if(lauter==true&&musikLautstaerkeBegrenzung<20){
            musikAnzahl.setVisible(false);
            musikBalken.setVisible(false);
            musikBalkenPosition=musikBalkenPosition+0.03;
            musikBalken=new Knopf("|", musikBalkenPosition, 1.0/10.0, 1.0/2.0, 1.0/6.0, font, this);
            musikBalken.setEnabled(false);
            musikLautstaerkeBegrenzung++;

            musikAnzahl=new Knopf(""+musikLautstaerkeBegrenzung, 1.0/2.0, 1.0/6.0, 1.0/2.0, 1.0/6.0, font, this);
        }
        else if(lauter==false&&musikLautstaerkeBegrenzung>0){
            musikAnzahl.setVisible(false);
            musikBalken.setVisible(false);
            musikBalkenPosition=musikBalkenPosition-0.03;
            musikBalken=new Knopf("|", musikBalkenPosition, 1.0/10.0, 1.0/2.0, 1.0/6.0, font, this);
            musikBalken.setEnabled(false);
            musikLautstaerkeBegrenzung--;

            musikAnzahl=new Knopf(""+musikLautstaerkeBegrenzung, 1.0/2.0, 1.0/6.0, 1.0/2.0, 1.0/6.0, font, this);
        }
        if(musikLautstaerkeBegrenzung>20){
            musikLautstaerkeBegrenzung=19;
            musikBalkenPosition=musikBalkenPosition-0.03;
        }
        if(musikLautstaerkeBegrenzung<0){
            musikLautstaerkeBegrenzung=1;
            musikBalkenPosition=musikBalkenPosition+0.03;
        }
    }

    public void soundLautstaerkebalkenVerschieben(boolean lauter){
        if(lauter==true&&soundLautstaerkeBegrenzung<20){
            soundAnzahl.setVisible(false);
            soundBalken.setVisible(false);
            soundBalkenPosition=soundBalkenPosition+0.03;
            soundBalken=new Knopf("|", soundBalkenPosition, 1.0/1.6, 1.0/2.0, 1.0/6.0, font, this);
            soundBalken.setEnabled(false);
            soundLautstaerkeBegrenzung++;

            soundAnzahl=new Knopf(""+soundLautstaerkeBegrenzung, 1.0/2.0, 1.0/1.4, 1.0/2.0, 1.0/6.0, font, this);
        }
        else if(lauter==false&&soundLautstaerkeBegrenzung>0){
            soundAnzahl.setVisible(false);
            soundBalken.setVisible(false);
            soundBalkenPosition=soundBalkenPosition-0.03;
            soundBalken=new Knopf("|", soundBalkenPosition, 1.0/1.6, 1.0/2.0, 1.0/6.0, font, this);
            soundBalken.setEnabled(false);
            soundLautstaerkeBegrenzung--;

            soundAnzahl=new Knopf(""+soundLautstaerkeBegrenzung, 1.0/2.0, 1.0/1.4, 1.0/2.0, 1.0/6.0, font, this);
        }
        if(soundLautstaerkeBegrenzung>20){
            soundLautstaerkeBegrenzung=19;
            soundBalkenPosition=soundBalkenPosition-0.03;
        }
        if(soundLautstaerkeBegrenzung<0){
            soundLautstaerkeBegrenzung=1;
            soundBalkenPosition=soundBalkenPosition+0.03;
        }
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setPreferredSize(null);
        steuerung.skallieren(getWidth(), getHeight());
        fenstergroesse.skallieren(getWidth(), getHeight());
        lautstaerke.skallieren(getWidth(), getHeight());
        if(zurueckInsHauptmenue!=null){zurueckInsHauptmenue.skallieren(getWidth(), getHeight());}
        if(zurueckInsOptionsmenue!=null){zurueckInsOptionsmenue.skallieren(getWidth(), getHeight());}
        if(vollbild!=null){vollbild.skallieren(getWidth(), getHeight());}
        if(musikLauter!=null){musikLauter.skallieren(getWidth(), getHeight());}
        if(musikLeiser!=null){musikLeiser.skallieren(getWidth(), getHeight());}
        if(soundLauter!=null){soundLauter.skallieren(getWidth(), getHeight());}
        if(soundLeiser!=null){soundLeiser.skallieren(getWidth(), getHeight());}
        if(klein!=null){klein.skallieren(getWidth(), getHeight());}
        if(mittel!=null){mittel.skallieren(getWidth(), getHeight());}
        if(gross!=null){gross.skallieren(getWidth(), getHeight());} 
        if(zurueckZumSpiel!=null){zurueckZumSpiel.skallieren(getWidth(), getHeight());}
    }

    public static void tasteAendern(Knopf welche){
        welche.setForeground(new Color(115, 15, 250));
    }

    public static void alleEntmarkieren(){
        links.entmarkieren();
        rechts.entmarkieren();
        oben.entmarkieren();
        unten.entmarkieren();
        angriff.entmarkieren();
        benutzen.entmarkieren();
        pause.entmarkieren();
    }    

    public boolean istTasteBelegt(int taste){
        if(
        Steuerung.getLinksTaste()==taste||
        Steuerung.getRechtsTaste()==taste||
        Steuerung.getObenTaste()==taste||
        Steuerung.getUntenTaste()==taste||
        Steuerung.getAngriffTaste()==taste||
        Steuerung.getBenutzenTaste()==taste||
        Steuerung.getPauseTaste()==taste){
            return true;
        }
        else{
            return false;
        }
    }

    public void keyPressed(KeyEvent e){
        if(links.istMarkiert()){
            if(!istTasteBelegt(e.getKeyCode())){
                Steuerung.setLinksTasteZu(e.getKeyCode());
                links.setText("Links: "+Steuerung.getLinksTastenText());
            }
            links.entmarkieren();
        }
        else if(rechts.istMarkiert()){
            if(!istTasteBelegt(e.getKeyCode())){
                Steuerung.setRechtsTasteZu(e.getKeyCode());
                rechts.setText("Rechts: "+Steuerung.getRechtsTastenText());
            }
            rechts.entmarkieren();
        }
        else if(oben.istMarkiert()){
            if(!istTasteBelegt(e.getKeyCode())){
                Steuerung.setObenTasteZu(e.getKeyCode());
                oben.setText("Oben: "+Steuerung.getObenTastenText());
            }
            oben.entmarkieren();
        }
        else if(unten.istMarkiert()){
            if(!istTasteBelegt(e.getKeyCode())){
                Steuerung.setUntenTasteZu(e.getKeyCode());
                unten.setText("Unten: "+Steuerung.getUntenTastenText());
            }
            unten.entmarkieren();
        }
        else if(angriff.istMarkiert()){
            if(!istTasteBelegt(e.getKeyCode())){
                Steuerung.setAngriffTasteZu(e.getKeyCode());
                angriff.setText("Angriff: "+Steuerung.getAngriffTastenText());
            }
            angriff.entmarkieren();
        }
        else if(benutzen.istMarkiert()){
            if(!istTasteBelegt(e.getKeyCode())){
                Steuerung.setBenutzenTasteZu(e.getKeyCode());
                benutzen.setText("Benutzen: "+Steuerung.getBenutzenTastenText());
            }
            benutzen.entmarkieren();
        }
        else if(pause.istMarkiert()){
            if(!istTasteBelegt(e.getKeyCode())){
                Steuerung.setPauseTasteZu(e.getKeyCode());
                pause.setText("Pause: "+Steuerung.getPauseTastenText());
            }
            pause.entmarkieren();
        }
    }

    public static void einstellungenSpeichern(){
        try{
            FileOutputStream output=new FileOutputStream("einstellungen.opt");
            DataOutputStream dataout=new DataOutputStream(output);           
            try{
                dataout.writeInt(Steuerung.getLinksTaste());
                dataout.writeInt(Steuerung.getRechtsTaste());
                dataout.writeInt(Steuerung.getObenTaste());
                dataout.writeInt(Steuerung.getUntenTaste());
                dataout.writeInt(Steuerung.getAngriffTaste());
                dataout.writeInt(Steuerung.getBenutzenTaste());
                dataout.writeInt(Steuerung.getPauseTaste());
                dataout.writeInt(fenstergroesseX);
                dataout.writeInt(fenstergroesseY);
                dataout.writeBoolean(fullscreenAn);
                dataout.writeBoolean(musikIstAn);
                dataout.writeBoolean(soundIstAn);

            }catch(IOException e){e.printStackTrace();}
            try{
                output.close();
            }catch(IOException e1){}
        }catch(IOException e){e.printStackTrace();}
    }

    public static void einstellungenLaden(){
        try{
            FileInputStream iostream=new FileInputStream("einstellungen.opt");
            DataInputStream diostream=new DataInputStream(iostream);
            try{
                Steuerung.setLinksTasteZu(diostream.readInt());
                Steuerung.setRechtsTasteZu(diostream.readInt());
                Steuerung.setObenTasteZu(diostream.readInt());
                Steuerung.setUntenTasteZu(diostream.readInt());
                Steuerung.setAngriffTasteZu(diostream.readInt());
                Steuerung.setBenutzenTasteZu(diostream.readInt());
                Steuerung.setPauseTasteZu(diostream.readInt());

                fenstergroesseX = diostream.readInt();//fenstergroesseX;
                fenstergroesseY = diostream.readInt();//fenstergroesseY
                container.setFensterX(fenstergroesseX);
                container.setFensterY(fenstergroesseY);

                fullscreenAn = diostream.readBoolean();//fullscreenAn

                if(fullscreenAn){
                    container.fullscreenAn();
                }

                musikIstAn = diostream.readBoolean();//musikIstAn
                soundIstAn = diostream.readBoolean();//soundIstAn

            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        catch(FileNotFoundException e){einstellungenSpeichern();}
    }

    public static boolean soundAnAus(){
        return soundIstAn;
    }

    public static boolean musikAnAus(){
        return musikIstAn;
    }

    public void keyTyped(KeyEvent e){

    }

    public void keyReleased(KeyEvent e){

    }

}