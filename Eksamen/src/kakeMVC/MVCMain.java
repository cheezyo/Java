package kakeMVC;

import javax.swing.JFrame;



public class MVCMain extends JFrame {
    
	private Stemme stemmer;
    /** Creates new form MvcOeving */
    public MVCMain() {
        setTitle("Model-View-Controller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        stemmer = new Stemme(0,0);
        
        KnappePanel pnlKnapper = new KnappePanel(stemmer);
        
        pnlKnapper.setBorder(
           new javax.swing.border.TitledBorder("Controller"));
        GrafPanel pnlGraf = new GrafPanel();
        stemmer.addStemmeListener(pnlGraf);
        pnlGraf.setBorder(
           new javax.swing.border.TitledBorder("View #1"));
        TekstPanel pnlTekst = new TekstPanel();
        stemmer.addStemmeListener(pnlTekst);
        pnlTekst.setBorder(
                new javax.swing.border.TitledBorder("View #2"));
          
             add(pnlKnapper, java.awt.BorderLayout.NORTH);
             add(pnlGraf, java.awt.BorderLayout.WEST);
             add(pnlTekst, java.awt.BorderLayout.EAST);
             setVisible(true);
             setSize(400, 200);
         }
    public static void main (String args[]) {
        new MVCMain ();
    }
}
