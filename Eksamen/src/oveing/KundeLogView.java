/*
 * KundeLogView.java
 *
 * Created on 5. juni 2005, 21:49
 */

package oveing;

/**
 *
 * @author  Kjell Dirdal
 */
public class KundeLogView implements KundeListener{
    
    /** Creates a new instance of KundeLogView */
    public KundeLogView(KundeModell kReg ) {
        kReg.addKundeListener( this );
    }
    
    public void kundeEndret(KundeEvent kundeEvent) {
        javax.swing.JOptionPane.showMessageDialog(null, "KundeLogView: -- Kunde endret");
    }
    
    public void kundeFjernet(KundeEvent kundeEvent) {
        javax.swing.JOptionPane.showMessageDialog(null, "KundeLogView: -- Kunde fjernet");
    }
    
    public void kundeRegistrert(KundeEvent kundeEvent) {
        javax.swing.JOptionPane.showMessageDialog(null, "KundeLogView: -- Kunde registrert");
    }
    
}
