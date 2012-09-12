package kake;

import javax.swing.JFrame;
public class MvcOeving extends JFrame {
    
	private StemmeOpptelling stemmer;
    /** Creates new form MvcOeving */
    public MvcOeving() {
        setTitle("Model-View-Controller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        stemmer = new StemmeOpptelling(0,0);
        KnappePanel pnlKnapper = new KnappePanel(stemmer);
        pnlKnapper.setBorder(
           new javax.swing.border.TitledBorder("Controller"));
        GrafPanel pnlGraf = new GrafPanel(stemmer);
        pnlGraf.setBorder(
           new javax.swing.border.TitledBorder("View #1"));
        TekstPanel pnlTekst = new TekstPanel(stemmer);
        pnlTekst.setBorder(
                new javax.swing.border.TitledBorder("View #2"));
          
             add(pnlKnapper, java.awt.BorderLayout.NORTH);
             add(pnlGraf, java.awt.BorderLayout.WEST);
             add(pnlTekst, java.awt.BorderLayout.EAST);
             setVisible(true);
             setSize(400, 200);
         }
    public static void main (String args[]) {
        new MvcOeving ();
    }
}